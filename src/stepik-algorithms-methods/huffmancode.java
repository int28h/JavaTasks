//реализация из курса https://stepik.org/course/217/syllabus

/**
 * По данной непустой строке s длины не более 10^4, состоящей из строчных букв
 * латинского алфавита, постройте оптимальный беспрефиксный код.
 * В первой строке выведите количество различных букв k, встречающихся в строке,
 * и размер получившейся закодированной строки. В следующих k строках запишите
 * коды букв в формате "letter: code".
 * В последней строке выведите закодированную строку.
 * 
 * Пример
 * input
 * a
 * output
 * 1 1
 * a: 0
 * 0
 * 
 * input
 * abacabad
 * output
 * 4 14
 * a: 0
 * b: 10
 * c: 110
 * d: 111
 * 01001100100111
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanCode {
    class Node implements Comparable<Node> {
        final int sum;
        String code;

        void buildCode(String code) {
            this.code = code;
        }

        public Node(int sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }
    }

    class InternalNode extends Node {
        Node left;
        Node right;

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }
    }

    class LeafNode extends Node {
        char symbol;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }

        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        Map<Character, Node> charNodes = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            LeafNode node = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), node);
            priorityQueue.add(node);
        }
        int sum = 0;
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            priorityQueue.add(new InternalNode(first, second));
        }
        if (count.size() == 1) {
            sum = s.length();
        }
        System.out.println(count.size() + " " + sum);
        Node root = priorityQueue.poll();
        if (count.size() == 1) {
            root.buildCode("0");
        } else {
            root.buildCode("");
        }
        String encodedString = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            encodedString += charNodes.get(c).code;
        }
        System.out.println(encodedString);
    }

    public static void main(String[] args) throws Exception {
        new HuffmanCode().run();
    }
}
