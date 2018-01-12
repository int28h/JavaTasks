/*
Дан файл с логами переходов пользователей. Каждая строка состоит из 3 полей: время перехода (unix timestamp), ID пользователя, URL, на который перешел пользователь.

Напишите mapper с помощью Hadoop Streaming, печатающий URL из каждой строки.

Sample Input:

1448713968	user2	https://ru.wikipedia.org/
1448764519	user10	https://stepic.org/
1448713968	user5	http://google.com/
1448773411	user10	https://stepic.org/explore/courses
1448709864	user3	http://vk.com/

Sample Output:

https://ru.wikipedia.org/
https://stepic.org/
http://google.com/
https://stepic.org/explore/courses
http://vk.com/
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(final String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String s;
		
		while((s = br.readLine()) != null) {
			String[] current = s.split("\t");
            System.out.println(current[2]);
        }
	}
}