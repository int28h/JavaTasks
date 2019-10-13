/**
 * Высотой дерева называется максимальное число вершин дерева в цепочке, начинающейся в корне дерева,
 * заканчивающейся в одном из его листьев, и не содержащей никакую вершину дважды.
 * 
 * Так, высота дерева, состоящего из единственной вершины, равна единице.
 * Высота пустого дерева (да, бывает и такое!) равна нулю.
 * 
 * Дано двоичное дерево поиска.
 * В вершинах этого дерева записаны ключи — целые числа, по модулю не превышающие 10^9.
 * 
 * Для каждой вершины дерева V выполняется следующее условие:
 * все ключи вершин из левого поддерева меньше ключа вершины V;
 * все ключи вершин из правого поддерева больше ключа вершины V.
 * 
 * Найдите высоту данного дерева.
 * 
 * Формат входного файла
 * Входной файл содержит описание двоичного дерева.
 * В первой строке файла находится число N (0 <= N <= 2*10^5) — число вершин в дереве.
 * В последующих строках файла находятся описания вершин дерева.
 * В (i+1)-ой строке файла (1 <= i <= N) находится описание i-ой вершины,
 * состоящее из трех чисел K[i], L[i], R[i], разделенных пробелами — ключа в i-ой вершине (|K[i]| <= 10^9),
 * номера левого ребенка i-ой вершины (i < L[i] <= N или L[i] = 0, если левого ребенка нет)
 * и номера правого ребенка i-ой вершины (i < R[i] <= N или R[i] = 0, если правого ребенка нет).
 * Все ключи различны. Гарантируется, что данное дерево является деревом поиска.
 * 
 * Формат выходного файла
 * Выведите одно целое число — высоту дерева.
 * 
 * Пример
 * input.txt
 * 6
 * -2 0 2
 * 8 4 3
 * 9 0 0
 * 3 6 5
 * 6 0 0
 * 0 0 0
 * 
 * output.txt
 * 4
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BinaryTree {
    private static class Node {
        Node left, right;
        int key;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    public void addNode(int key) {
        Node x = root, y = null;
        int cmp = 0;
        while (x != null) {
            cmp = x.key - key;
            if (cmp == 0) {
                return;
            } else {
                y = x;
                if (cmp < 0) {
                    x = x.right;
                } else {
                    x = x.left;
                }
            }
        }
        Node newNode = new Node(key);
        if (y == null) {
            root = newNode;
            System.out.println(key + "корень");
        } else {
            if (cmp > 0) {
                y.left = newNode;
                System.out.println(key + " левый для " + y.key);
            } else {
                y.right = newNode;
                System.out.println(key + " правый для" + y.key);
            }
        }
    }

    public static int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("input.txt"));
        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintStream out = new PrintStream(fos);

        int height = 0;

        //чтение данных из файла и запись их в массив
        int stringsCount = in.nextInt();
        if (stringsCount == 0) {
            out.println(0);
        }

        int[][] array = new int[stringsCount][3];

        for (int i = 0; i < stringsCount; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = in.nextInt();
            }
        }

        //создание дерева
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < stringsCount; i++) {
            tree.addNode(array[i][0]);
        }

        height = height(tree.root);
        if (height != 0) out.println(height);

        in.close();
        out.close();
    }
}
