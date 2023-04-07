package Lab5;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Client has connected");
            int a = Integer.parseInt(reader.readLine());
            String sign = reader.readLine();
            int b = Integer.parseInt(reader.readLine());

            switch (sign) {
                case "+" -> writer.write(String.valueOf(a + b));
                case "-" -> writer.write(String.valueOf(a - b));
                case "*" -> writer.write(String.valueOf(a * b));
                case "/" -> writer.write(String.valueOf(a / b));
                default -> writer.write("ERROR");
            }
            writer.newLine();
            writer.flush();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
