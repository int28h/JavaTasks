/*
Формата ввода. 
Первая строка содержит натуральное число n.
Вторая строка содержит n целых неотрицательных чисел parent[0]...parentn[n-1]. 
Для каждого 0 <= i <= n-1, parent[i] — родитель вершины i; 
если parent[i] = -1, то i является корнем.
Гарантируется, что корень ровно один. Гарантируется, что данная последовательность задает дерево.

Формат вывода. 
Высота дерева. 

Sample Input:
10
9 7 5 5 2 9 9 9 2 -1
Sample Output:
4

Sample Input:
5
4 -1 4 1 1
Sample Output:
3

Sample Input:
5
-1 0 4 0 3
Sample Output:
4
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class TreeHeight {
	private List<Node> tree;
	private Node root;
	
	private static class Node {		
		Node parent;
		List<Node> children = new LinkedList<Node>();
		int key, parentKey;
		
		private Node(int key) {
			this.key = key;
		}
		
		public Node getParent() {
			return parent;
		}
		
		public int getKey() {
			return key;
		}
		
		private int getParentKey() {
			return parentKey;
		}
		
		public List<Node> getChildren(){
			return children;
		}
	}
	
	public TreeHeight() {
		this.tree = new LinkedList<>();
	}
	
	/**
	 * Получение корня дерева
	 * @return
	 */
	public Node getRoot() {
		return root;
	}
	
	/**
	 * Получение узла дерева по его ключу
	 * @param key
	 * @return
	 */
	public Node getByKey(int key) {
		Node x = null;
		for(Node n : tree) {
			if(n.getKey() == key) {
				x = n;
				break;
			}
		}
		return x;
	}
	
	/**
	 * Добавление узла в дерево
	 * @param key
	 * @param parentKey
	 */
	private void addNode(int key, int parentKey) {
		if(parentKey == -1) {
			this.root = new Node(key);
			tree.add(root);
			//System.out.println("Добавлен корень с ключом " + key);
		} else {		
			Node current = new Node(key);
			tree.add(current);
			current.parentKey = parentKey;			
			//System.out.println("Добавлен узел с ключом " + key);
		}
	}
	
	/**
	 * Установление связей между узлами
	 */
	private void setContacts() {
		for(Node n : tree) {
			if(n != root) {
				n.parent = getByKey(n.getParentKey());
				n.getParent().getChildren().add(n);
			}	
		}
	}
	
	/**
	 * Вывод данных о каждом из узлов дерева
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Node n : tree) {
			result.append("Узел с ключом " + n.getKey());
			
			if(n.getParent() != null) {
				result.append(", родитель - узел с ключом " + n.getParent().getKey());
			} else {
				result.append(", корневой узел");
			}
			
			if(!n.getChildren().isEmpty()) {
				result.append(", потомки - ");
				for(Node ch : n.getChildren()) {
					result.append(ch.getKey() + ", ");
				}
				result.append("\n");
			} else {
				result.append(", потомков нет" + "\n");
			}
		}		
		return result.toString();
	}	

	/**
	 * Получение высоты для заданного узла
	 * @param node
	 * @return
	 */
	public int getHeight(Node node) {		
		if(node == null) return 0;
		int childrenCount = node.children.size();
		ArrayList<Integer> heightes = new ArrayList<>();
		for(int i = 0; i < childrenCount; i++) {
			heightes.add(getHeight(node.getChildren().get(i)));
		}
		if(!heightes.isEmpty()) {
			return 1 + Collections.max(heightes);
		} else {
			return 1;
		}
	}
	
	public static void main(final String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		int nodesCount = in.nextInt();
		TreeHeight tree = new TreeHeight();
		
		Map<Integer, Integer> nodes = new HashMap<>();		
		for(int i = 0; i < nodesCount; i++) {
			nodes.put(i, in.nextInt()); //пара ключ + ключ родителя
		}
		//посмотреть на считанные данные
		//System.out.println(nodes.toString());		
		
		//проход по хешмапе, создание узлов
		for(Entry<Integer, Integer> m : nodes.entrySet()) {
			tree.addNode(m.getKey(), m.getValue());
		}
		//связывание узлов в дерево
		tree.setContacts();
		
		//посмотреть что получилось
		//System.out.println(tree.toString());
		
		System.out.println(tree.getHeight(tree.getRoot()));
	}
}