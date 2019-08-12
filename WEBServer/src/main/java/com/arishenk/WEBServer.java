package com.arishenk;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

@SpringBootApplication // автоконфигурирование, обозначение точки входа
public class WEBServer {

    public static void main(String[] args) {
        SpringApplication.run(WEBServer.class);
    }

    @Bean // компонент контекста Spring
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            try (ServerSocket s = new ServerSocket(1050)) {
                while (true) {
                    Socket client = s.accept();

                    new Thread(() -> {
                        try {
                            InputStream inStream = client.getInputStream();
                            OutputStream outStream = client.getOutputStream();

                            Scanner in = new Scanner(inStream);
                            PrintWriter out = new PrintWriter(outStream);
                            String inputStr = in.nextLine();
                            String[] requestedLine = inputStr.split(" ");
                            String[] url = requestedLine[1].split("/");
                            String str = formedResponseString(repository, url);

                            out.write(str);
                            System.out.println(str);
                            out.flush();

                            client.close();

                        } catch (IOException error) {
                            System.err.println(error.getMessage());
                        }
                    }).start();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        };
    }

    private static String formedResponseString(UserRepository repository, String[] url) throws IOException {
        String str = "HTTP/1.0 200 OK\nContent-Type: text/html\nContent-Length: ";
        StringBuilder html = new StringBuilder();
        if (url.length == 2)
            switch (url[1]) {
                case "get_users": {
                    html.append("[");
                    for (User user : repository.findAll()) {
                        System.out.println(user.getName());
                        ObjectMapper mapper = new ObjectMapper();
                        String usr =mapper.writeValueAsString(user);
                        html.append(usr);
                        html.append(",");
                    }
                    html.deleteCharAt(html.length() - 1);
                    html.append("]");

                }
                break;
                case "main.html":
                    html.append(readFile(url[1]));
                    break;
                    default:
                        html.append(readFile("notFound.html"));
                        break;
            }

        if (url.length == 3)
            switch (url[1]) {
            case "get_user":
                Integer id = Integer.parseInt(url[2]);
                User user = repository.findById(id).get();
                ObjectMapper mapper = new ObjectMapper();
                String usr =mapper.writeValueAsString(user);
                html.append(usr);
                break;
            case "index.html":
                html.append(readFile(url[1]));
                break;
                case "remove_user":
                    System.out.println(url[2]);
                    repository.delete(repository.findById(Integer.parseInt(url[2])).get());
                    break;
            default:
                html.append(readFile("notFound.html"));
                break;
        }
            str += html.length() + "\n\n" + html;
            return str;
    }

    private static StringBuilder readFile(String fileName) throws IOException {
        StringBuilder html = new StringBuilder();
        FileReader fr = new FileReader("src/main/resources/" + fileName);
        Scanner inFile = new Scanner(fr);
        while (inFile.hasNextLine()) {
            html.append(inFile.nextLine());
        }
        fr.close();
        return html;
    }
}