package Lab3;

import java.util.*;

public class QueueApp {
    private final LinkedList<Long> queue = new LinkedList<>();

    public void isTheQueueEmpty() {
        if(queue.isEmpty()) System.out.println("The queue is empty");
        else System.out.println("The queue contains elements");
    }

    public void putCommonElements() {
        queue.clear();
        for (long i = 1000000000; i <= 1000000024;i++)
            queue.add(i);
        System.out.println("Common values were added to the queue");
    }

    public void addElement() {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter value to put to the queue:\t");
        try {
            queue.add(cin.nextLong());
            System.out.println("New element was added");
        } catch (InputMismatchException ex) {
            System.out.println("You can add to the queue only integer numbers!");
        }
    }

    public void removeElement() {
        queue.remove();
        System.out.println("Element was successfully removed");
    }

    public void showElement() {
        System.out.println("The first element is " + queue.element());
    }

    public void swapElements() {
        long buffer = queue.element();
        queue.set(0, queue.getLast());
        queue.set(queue.size() - 1, buffer);
        System.out.println("First and last elements values were successfully swapped");
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        QueueApp queueApp = new QueueApp();
        String choise = "";
        while(!choise.equals("0")) {
            System.out.println("\tMENU:\n1 - Check if the queue is empty\n2 - Add common elements\n3 - Add new element");
            System.out.println("4 - Remove first element\n5 - Show first element\n6 - Swap first and last elements values\n0 - Quit");
            choise = cin.next();
            switch (choise) {
                case "1" -> queueApp.isTheQueueEmpty();
                case "2" -> queueApp.putCommonElements();
                case "3" -> queueApp.addElement();
                case "4" -> queueApp.removeElement();
                case "5" -> queueApp.showElement();
                case "6" -> queueApp.swapElements();
                case "0" -> System.out.println("Good bye!!!");
                default -> System.out.println("You have entered wrong menu item!");
            }
        }
    }
}
