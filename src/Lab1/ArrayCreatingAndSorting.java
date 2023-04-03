package Lab1;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayCreatingAndSorting {
    private int[] array;

    private void showElements(String msg) {
        System.out.println(msg);
        for (int element : array)
            System.out.println(element);
    }

    class ArraySorting extends Thread {
        public void run() {
            Arrays.sort(array);
            showElements("Elements sorted in new thread:");
        }
    }

    public void go() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        try {

            array = new int[Integer.parseInt(scan.next())];

            System.out.println("Enter elements:");
            for(int i = 0; i < array.length; i ++) {
                array[i] = Integer.parseInt(scan.next());
            }

            ArraySorting arrSorting = new ArraySorting();
            arrSorting.start();

            showElements("Not sorted elements in main thread:");
        } catch (NumberFormatException nfEx) {
            System.out.println("You can enter only integer numbers!");
        }
    }

    public static void main(String[] args) {
        ArrayCreatingAndSorting a = new ArrayCreatingAndSorting();
        a.go();
    }
}
