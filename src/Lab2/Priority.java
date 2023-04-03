package Lab2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Priority {

    private static final ArrayList<Integer> pairNumbers = new ArrayList<>();
    private static int sum = 0;
    public static void main(String[] args) throws InterruptedException {
        GetEvenNumbers getEvenNumbers = new GetEvenNumbers();
        AddEvenNumbers addEvenNumbers = new AddEvenNumbers();

        getEvenNumbers.setPriority(Thread.MAX_PRIORITY);
        addEvenNumbers.setPriority(Thread.MIN_PRIORITY);

        getEvenNumbers.start();

        getEvenNumbers.join();

        addEvenNumbers.start();
    }

    static class GetEvenNumbers extends Thread{
        @Override
        public void run() {
            Scanner cin = new Scanner(System.in);

            try {
                System.out.print("Enter minimal number:\t");
                final int min = cin.nextInt();
                System.out.print("Enter maximum number:\t");
                final int max = cin.nextInt();

                for(int i = min; i <= max; i++) {
                    if(i % 2 == 0)
                        pairNumbers.add(i);
                }
            } catch (InputMismatchException ex) {
                System.out.println("ERROR: You can enter only integer numbers!");
            }
        }
    }

    static class AddEvenNumbers extends Thread {
        @Override
        public void run() {
            for(int element : pairNumbers) {
                sum += element;
            }
            System.out.println("The sum = " + sum);

        }
    }
}
