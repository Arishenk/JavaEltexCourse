package com.arishenk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTCP {
    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 1050)) {
            InputStream inStream = s.getInputStream();
            OutputStream outStream = s.getOutputStream();
            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
                out.write(line);
                out.flush();
                System.out.flush();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
