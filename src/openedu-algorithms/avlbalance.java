/**
 * АВЛ-дерево является сбалансированным в следующем смысле: для любой вершины высота 
 * ее левого поддерева отличается от высоты ее правого поддерева не больше, чем на единицу.
 *
 * Введем понятие баланса вершины: для вершины дерева V ее баланс B(V) равен 
 * разности высоты правого поддерева и высоты левого поддерева. 
 * Таким образом, свойство АВЛ-дерева, приведенное выше, можно сформулировать следующим образом: 
 * для любой ее вершины V выполняется следующее неравенство:
 * -1 <= B(V) <= 1
 *
 * Дано двоичное дерево поиска. Для каждой его вершины требуется определить ее баланс.
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
 * Для i-ой вершины в i-ой строке выведите одно число — баланс данной вершины.
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
 * 3
 * -1
 * 0
 * 0
 * 0
 * 0
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;
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
		while(x != null) {
			cmp = x.key - key;
			if(cmp == 0) {
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
		if(y == null) {
			root = newNode;
			System.out.println(key +  "корень");
		} else {
			if (cmp > 0) {
				y.left = newNode;
				System.out.println(key +  " левый для " + y.key);
			} else {
			y.right = newNode;
			System.out.println(key +  " правый для" + y.key);
			}
		}		
	}
	
	public static int height(Node node) {
        if(node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
	}
	
	public static int balance(Node x) {
	   	 Node leftSubtreeRoot = x.left, rightSubtreeRoot = x.right; 
	   	 int leftSubtreeHeight = 0, rightSubtreeHeight = 0;
	   	 if(leftSubtreeRoot != null) {
	   		leftSubtreeHeight = height(leftSubtreeRoot);
	   	 }
	   	 if (rightSubtreeRoot != null) {
	   		rightSubtreeHeight = height(rightSubtreeRoot);
	   	 }
	   	 return rightSubtreeHeight - leftSubtreeHeight;
	}
	
    public static void contLevelOrder(Node x, PrintStream out) {
        Queue<Node> queue = new LinkedList<> ();
        queue.add(x);
        while (!queue.isEmpty()) {   
        	if (queue.isEmpty() != true) {
            	x = queue.poll();
            }
        	
        	System.out.println("Обрабатывается " + x.key);
        	out.println(balance(x));
        	
            if (x.left != null) {
            	queue.add(x.left);
            	System.out.println("В очередь добавлен узел " + x.left.key);
            }
            
            if (x.right != null) {
	            queue.add(x.right);
	            System.out.println("В очередь добавлен узел " + x.right.key);
            }
        }
    }
	
	public static void main(String[] args) throws Exception { 
    	 Scanner in = new Scanner(new File("input.txt"));
    	 FileOutputStream fos = new FileOutputStream("output.txt");
    	 PrintStream out = new PrintStream(fos);
    	 
    	 //чтение данных из файла и запись их в массив
    	 int nodesCount = in.nextInt();    	 
    	 int[][] arrayNodes = new int[nodesCount][3];    	 
    	 for(int i = 0; i < nodesCount; i++) {
    		 for(int j = 0; j < 3; j++) {
    			 arrayNodes[i][j] = in.nextInt();    			 
    		 }
    	 }
    	 
    	 
    	 //создание дерева
    	 BinaryTree tree = new BinaryTree();
    	 for(int i = 0; i < nodesCount; i++) {
    		 tree.addNode(arrayNodes[i][0]);
    	 }
    	 
    	 //обход всех узлов и вычисление баланса для каждого
    	 Node x = tree.root;
    	 contLevelOrder(x, out);
    	 
    	 in.close();
    	 out.close();
    }
}

