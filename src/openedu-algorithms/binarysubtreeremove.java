/**
 * Дано некоторое двоичное дерево поиска. Также даны запросы на удаление из него 
 * вершин, имеющих заданные ключи, причем вершины удаляются целиком 
 * вместе со своими поддеревьями. После каждого запроса на удаление выведите число 
 * оставшихся вершин в дереве.
 * 
 * В вершинах данного дерева записаны ключи — целые числа, по модулю не превышающие 10^9. 
 * Гарантируется, что данное дерево является двоичным деревом поиска, 
 * в частности, для каждой вершины дерева V выполняются следующие условия:
 * все ключи вершин из левого поддерева меньше ключа вершины V;
 * все ключи вершин из правого поддерева больше ключа вершины V.
 * 
 * Высота дерева не превосходит 25, таким образом, можно считать, что оно 
 * сбалансировано. 
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
 * В следующей строке находится число M (1 <= M <= 2*10^5) – число запросов 
 * на удаление. В следующей строке находятся M чисел, разделенных пробелами — ключи, 
 * вершины с которыми (вместе с их поддеревьями) необходимо удалить. 
 * Все эти числа не превосходят 10^9 по абсолютному значению. 
 * Вершина с таким ключом не обязана существовать в дереве — в этом случае 
 * дерево изменять не требуется. Гарантируется, что корень дерева никогда 
 * не будет удален. 
 * 
 * Формат выходного файла
 * Выведите M строк. На i-ой строке требуется вывести число вершин, 
 * оставшихся в дереве после выполнения i-го запроса на удаление. 
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
 * 4
 * 6 9 7 8
 * 
 * output.txt
 * 5
 * 4
 * 4
 * 1
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
				System.out.println(key +  "левый для " + y.key);
			} else {
			y.right = newNode;
			System.out.println(key +  "правый для" + y.key);
			}
		}		
	}
	
	public int removeSubtree(int key) {
		Node x = root, y = null;
		int cmp = 0;
		while(x != null) {
			cmp = x.key - key;
			if(cmp == 0) {
				break;
			} else {
				y = x;
				if (cmp < 0) {
					x = x.right;
				} else {
					x = x.left;
				}
			}
		}
		
		if (x == null) {
			System.out.println("Ничего не удалено");
            return 0;
		}
		
		int count = nodesCount(x);		
		System.out.println("удаляется " + x.key);	
		System.out.println("его поддерево " + count + " узлов");
		if(x.key > y.key) {
			y.right = null;
		} else {
			y.left = null;
		}
		x = null;
		return count;
	}
	
	public int nodesCount(Node node) {
		if ((node.left == null) && (node.right == null)) {
			return 1;
		}
		int left, right;
		
		if (node.left != null){
			left = nodesCount(node.left);
		} else {
			left = 0;
		}
		
		if (node.right != null){
			right = nodesCount(node.right); 
		} else {
			right = 0;
		}
		return left + right + 1;		
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
    	 
    	 int removesCount = in.nextInt();
    	 int[] arrayRemove = new int[removesCount];
    	 for(int i = 0; i < removesCount; i++) {
    		 arrayRemove[i] = in.nextInt(); 
    	 }
    	 
    	 //создание дерева
    	 BinaryTree tree = new BinaryTree();
    	 for(int i = 0; i < nodesCount; i++) {
    		 tree.addNode(arrayNodes[i][0]);
    	 }
    	 
    	 //удаление
    	 for(int i = 0; i < removesCount; i++) {     		 
    		 nodesCount -= tree.removeSubtree(arrayRemove[i]);
    		 System.out.println(nodesCount);
    		 out.println(nodesCount);
    	 }
    	 
    	 in.close();
    	 out.close();
    }
}
