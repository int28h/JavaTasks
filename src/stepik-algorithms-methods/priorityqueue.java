/**
 * Первая строка входа содержит число операций 1 <= n <= 10^5.
 * Каждая из последующих n строк задают операцию одного из
 * следующих двух типов:
 * Insert x, где 0 <= x <= 10^9 — целое число;
 * ExtractMax.
 * 
 * Первая операция добавляет число x в очередь с приоритетами,
 * вторая — извлекает максимальное число и выводит его.
 * 
 * Sample Input:
 * 6
 * Insert 200
 * Insert 10
 * ExtractMax
 * Insert 5
 * Insert 500
 * ExtractMax
 * 
 * Sample Output:
 * 200
 * 500
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PriorQueue {
    private int heapSize = 0;
    private List<Integer> heap = new LinkedList<Integer>();

    private void run() {
        Scanner sc = new Scanner(System.in);
        int commandsCount = sc.nextInt();
        commandsCount++;
        String[] commands = new String[commandsCount];
        for (int i = 0; i < commandsCount; i++) {
            commands[i] = sc.nextLine();
        }

        for (String command : commands) {
            if (command.startsWith("Insert")) {
                String[] commandSplit = command.split(" ");
                add(Integer.parseInt(commandSplit[1]));
            } else if (command.startsWith("ExtractMax")) {
                System.out.println(getMax());
            }
        }
    }

    private int getMax() {
        int result = heap.get(0);
        heapSize--;
        heap.set(0, heap.get(heapSize));
        heap.remove(heapSize);
        heapify(0);
        return result;
    }

    private void heapify(int i) {
        int leftChild;
        int rightChild;
        int largestChild;

        for (; ; ) {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            if (leftChild < heapSize && heap.get(leftChild) > heap.get(largestChild)) {
                largestChild = leftChild;
            }

            if (rightChild < heapSize && heap.get(rightChild) > heap.get(largestChild)) {
                largestChild = rightChild;
            }

            if (largestChild == i) {
                break;
            }

            int temp = heap.get(i);
            heap.set(i, heap.get(largestChild));
            heap.set(largestChild, temp);
            i = largestChild;
        }
    }

    private void add(int x) {
        heap.add(x);
        heapSize++;
        int i = heapSize - 1;
        int parent = (i - 1) / 2;
        while (i > 0 && heap.get(parent) < heap.get(i)) {
            int temp = heap.get(i);
            heap.set(i, heap.get(parent));
            heap.set(parent, temp);

            i = parent;
            parent = (i - 1) / 2;
        }
    }

    public static void main(String[] args) throws Exception {
        new PriorQueue().run();
    }
}