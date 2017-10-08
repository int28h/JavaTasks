/**
 * Реализуйте работу стека. Для каждой операции изъятия элемента выведите ее результат.
 * 
 * На вход программе подаются строки, содержащие команды. Каждая строка содержит одну команду. Команда — это либо "+ N", либо "−". 
 * Команда "+ N" означает добавление в стек числа , по модулю не превышающего 10^9. 
 * Команда "−" означает изъятие элемента из стека. Гарантируется, что не происходит извлечения из пустого стека. 
 * Гарантируется, что размер стека в процессе выполнения команд не превысит 10^6 элементов.
 * 
 * Формат входного файла
 * В первой строке входного файла содержится M (1 <= M <= 10^6) - число команд. Каждая последующая строка исходного файла содержит ровно одну команду.
 * 
 * Формат выходного файла
 * Выведите числа, которые удаляются из стека с помощью команды "−", по одному в каждой строке. Числа нужно выводить в том порядке, в котором они были извлечены из стека. Гарантируется, что изъятий из пустого стека не производится. 
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {	
	private static int[] array = new int[1000000];  
	private static int top = 0;
	 
	private static boolean isEmpty() {
		if (top == 0) return true;
		return false;
	}
	
    private static void add(int[] array, int number) throws Exception {
    	if (top == array.length) {
    		throw new Exception ("Overflow");
    	} else {
    		top++;
    		array[top] = number;
    	}
    }
    
    private static void remove(int[] array, PrintStream out) throws Exception {
    	if (isEmpty()) {
    		throw new Exception ("Underflow");
    	} else {
    		out.println(array[top]);
    		top--;    		
    	}
    }

	public static void main(String[] args) throws Exception { 
    	 Scanner in = new Scanner(new File("input.txt"));
    	 FileOutputStream fos = new FileOutputStream("output.txt");
    	 PrintStream out = new PrintStream(fos);    	 
    	 
    	 int commandsCount = in.nextInt();
    	 
    	 for(int i = 0; i <= commandsCount; i++) {
    		 String command = new String();
    		 command = in.nextLine();
    		 if (command.startsWith("+")) {
    			 command = command.substring(2, command.length());
    			 int number = Integer.parseInt(command);
    			 add(array, number);
     		 } else if(command.startsWith("-")) {
     			 remove(array, out);     			 
     		 }
    	 }
    	 in.close();
    	 out.close();
    }
}

