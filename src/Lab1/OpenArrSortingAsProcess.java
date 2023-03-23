package Lab1;

import java.io.*;
import java.util.Scanner;

public class OpenArrSortingAsProcess{
    public static void main(String[] args){
        String filePath = "out/artifacts/SystemSoftware_jar/SystemSoftware.jar";
        Scanner cin = new Scanner(System.in);

        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", filePath);
        processBuilder.redirectErrorStream(true);
        try {
            Process process = processBuilder.start();

            InputStream stdout = process.getInputStream();
            OutputStream stdin = process.getOutputStream();

            Scanner scan = new Scanner(stdout);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));

            System.out.println(scan.nextLine());

            String input = cin.next();
            writer.write(input);
            writer.flush();
            writer.close();

            System.out.println(scan.nextLine());

            for (int i = 0; i < Integer.parseInt(input); i++) {
                writer = new BufferedWriter(new OutputStreamWriter(stdin));
                input = cin.next();
                writer.write(input);
                writer.flush();
                writer.close();
            }

            while (scan.hasNextLine())
                System.out.println(scan.nextLine());

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
