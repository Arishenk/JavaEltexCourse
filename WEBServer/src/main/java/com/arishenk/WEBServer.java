package com.arishenk;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class WEBServer {
    public static void main(String[] args) {
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
                        String[] inputMass = inputStr.split(" ");
                        String fileName = inputMass[1].substring(1);

                        if (!fileName.equals("index.html"))
                            fileName = "notFound.html";

                        String str = "HTTP/1.0 200 OK\nContent-Type: text/html\nContent.Length: ";
                        StringBuilder html = new StringBuilder();
                        try {
                            FileReader fr = new FileReader("src/main/resources/" + fileName);
                            Scanner inFile = new Scanner(fr);
                            while (inFile.hasNextLine()) {
                                html.append(inFile.nextLine());
                            }

                            fr.close();

                        } catch (IOException error) {
                            System.err.println(error.getMessage());
                        }

                        str += html.length() + "\n\n" + html;
                        out.write(str);
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
    }
}
