/**
 * Восстановите строку по её коду и беспрефиксному коду символов. 
 * 
 * В первой строке входного файла заданы два целых числа k и l через пробел — 
 * количество различных букв, встречающихся в строке, и размер получившейся 
 * закодированной строки, соответственно. В следующих k строках записаны коды букв 
 * в формате "letter: code". Ни один код не является префиксом другого. 
 * Буквы могут быть перечислены в любом порядке. В качестве букв могут встречаться 
 * лишь строчные буквы латинского алфавита; каждая из этих букв встречается в строке 
 * хотя бы один раз. Наконец, в последней строке записана закодированная строка. 
 * Исходная строка и коды всех букв непусты. Заданный код таков, что 
 * закодированная строка имеет минимальный возможный размер.
 * 
 * В первой строке выходного файла выведите строку s. 
 * Она должна состоять из строчных букв латинского алфавита. 
 * Гарантируется, что длина правильного ответа не превосходит 10^4 символов.
 * 
 * Пример
 * input
 * 1 1
 * a: 0
 * 0
 * output
 * a
 * 
 * input
 * 4 14
 * a: 0
 * b: 10
 * c: 110
 * d: 111
 * 01001100100111
 * output
 * abacabad
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HuffmanDecode {	
	private void run() {
		Scanner sc = new Scanner(System.in);
		int lettersCount = sc.nextInt();
		int stringLength = sc.nextInt();
		
		Map<String, Character> data = new HashMap<>();		
		for(int i = 0; i < lettersCount; i++) {
			String letter = sc.next();
			char value = letter.charAt(0);
			String key = sc.next();
			data.put(key, value);
		}
		String encodedString = sc.next();
		char[] encodedStringChArr = encodedString.toCharArray();
		
		String code = "";
		for(char ch : encodedStringChArr) {
			code += ch;
			if(data.containsKey(code)) {
				System.out.print(data.get(code));
				code = "";
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception { 
		new HuffmanDecode().run();
	}
}