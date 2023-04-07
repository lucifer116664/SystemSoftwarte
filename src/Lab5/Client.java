package Lab5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        try(Socket socket = new Socket("127.0.0.1", 8888);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.print("Enter first number: ");
            writer.write(cin.next());
            writer.newLine();
            writer.flush();

            System.out.print("Enter sign: ");
            writer.write(cin.next());
            writer.newLine();
            writer.flush();

            System.out.print("Enter second number: ");
            writer.write(cin.next());
            writer.newLine();
            writer.flush();

            String result = reader.readLine();
            if(!result.equals("ERROR"))
                System.out.println("Result: " + result);
            else
                System.out.println("ERROR: You have entered wrong sign!!!");
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
