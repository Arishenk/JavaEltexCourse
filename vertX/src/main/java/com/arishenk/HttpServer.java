package com.arishenk;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication // автоконфигурирование, обозначение точки входа
public class HttpServer {

    public static void main(String[] args) {
        SpringApplication.run(HttpServer.class);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40)); // количество обработчиков
            vertx.createHttpServer().requestHandler(request -> {
                System.out.println(request.uri() + request.uri().split("/").length); // что было вызвано
                StringBuilder html = new StringBuilder();
                String[] url = request.uri().split("/");
                if (url.length == 2)
                    switch (url[1]) {
                        case "get_users": {
                            html.append("[");
                            for (User user : repository.findAll()) {
                                System.out.println(user.getName());
                                ObjectMapper mapper = new ObjectMapper();
                                String usr = null;
                                try {
                                    usr = mapper.writeValueAsString(user);
                                    html.append(usr);
                                    html.append(",");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            html.deleteCharAt(html.length() - 1);
                            html.append("]");

                        }
                        break;
                        default:
                            try {
                                html.append(readFile("notFound.html"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                    }

                if (url.length == 3)
                    switch (url[1]) {
                        case "get_user":
                            Integer id = Integer.parseInt(url[2]);
                            User user = repository.findById(id).get();
                            ObjectMapper mapper = new ObjectMapper();
                            String usr = null;
                            try {
                                usr = mapper.writeValueAsString(user);
                                html.append(usr);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "remove_user":
                            System.out.println(url[2]);
                            repository.delete(repository.findById(Integer.parseInt(url[2])).get());
                            break;
                        default:
                            try {
                                html.append(readFile("notFound.html"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                request.response()
                        .putHeader("Content-Type", "application/json")
                        .end(html.toString()); // завершение и отправка данных
            }).listen(8081);
        };
    }

    private static String readFile(String fileName) throws IOException {
        String str = "HTTP/1.0 200 OK\nContent-Type: text/html\nContent-Length: ";
        StringBuilder html = new StringBuilder();
        FileReader fr = new FileReader("src/main/resources/" + fileName);
        Scanner inFile = new Scanner(fr);
        while (inFile.hasNextLine()) {
            html.append(inFile.nextLine());
        }
        str += html.length() + "\n\n" + html;
        fr.close();
        return str;
    }
}