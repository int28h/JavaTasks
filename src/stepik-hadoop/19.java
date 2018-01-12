/*
Напишите reducer, реализующий объединение двух файлов (Join) по id пользователя. Первый файл содержит 2 поля через табуляцию: id пользователя и запрос в поисковой системе. Второй файл содержит id пользователя и URL, на который перешел пользователь в поисковой системе. 

Mapper передает данные в reducer в виде key / value, где key - id пользователя, value состоит из 2 частей: маркер файла-источника (query или url) и запрос или URL. 

Каждая строка на выходе reducer должна содержать 3 поля, разделенных табуляцией: id пользователя, запрос, URL.

Sample Input:

user1	query:гугл
user1	url:google.ru
user2	query:стэпик
user2	query:стэпик курсы
user2	url:stepic.org
user2	url:stepic.org/explore/courses
user3	query:вконтакте

Sample Output:

user1	гугл	google.ru
user2	стэпик	stepic.org
user2	стэпик	stepic.org/explore/courses
user2	стэпик курсы	stepic.org
user2	стэпик курсы	stepic.org/explore/courses
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(final String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String s, lastUser = null;	
		List<String> queries = new LinkedList<>();
		List<String> urls = new LinkedList<>();
		
		while((s = br.readLine()) != null) {			
			String[] current = s.split("\t");
			String[] currentData = current[1].split(":");
			
			if(!current[0].equals(lastUser) && lastUser != null) {
				for(String entryQ : queries) {
					for(String entryU : urls) {
						System.out.println(lastUser + "\t" + entryQ + "\t" + entryU);
					}
				}
				queries.clear();
				urls.clear();
			}
			
			if(currentData[0].equals("query")) {
				queries.add(currentData[1]);
                lastUser = current[0];
			} else {
				urls.add(currentData[1]);
                lastUser = current[0];
			}
		}
		
		for(String entryQ : queries) {
			for(String entryU : urls) {
				System.out.println(lastUser + "\t" + entryQ + "\t" + entryU);
			}
		}
	}
}
