package com.arishenk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTCP {
    public static void main(String[] args) {
        try (
                ServerSocket s = new ServerSocket(1050)) {
                    Socket client = s.accept();
                    InputStream inStream = client.getInputStream();
                    OutputStream outStream = client.getOutputStream();
                    Scanner in = new Scanner(inStream);
                    PrintWriter out = new PrintWriter(outStream);
                    out.write("Hello");
                    out.flush();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
        }
    }
}
