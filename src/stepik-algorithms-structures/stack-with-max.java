/*
Стек — абстрактная структура данных, поддерживающая операции push и pop.
Несложно реализовать стек так, чтобы обе эти операции работали за константное время. 
В данной задача ваша цель — расшить интерфейс стека так, чтобы он дополнительно поддерживал операцию max
и при этом чтобы время работы всех операций по-прежнему было константным.

Формат ввода. 
Первая строка содержит число запросов q. Каждая из последующих q строк задает запрос в одном из следующих
форматов: push v, pop, или max.

Формат вывода. 
Для каждого запроса max выведите (в отдельной строке) текущий максимум на стеке. 

Sample Input 1:
5
push 2
push 1
max
pop
max
Sample Output 1:
2
2

Sample Input 2:
5
push 1
push 2
max
pop
max
Sample Output 2:
2
1

Sample Input 3:
10
push 2
push 3
push 9
push 7
push 2
max
max
max
pop
max 
Sample Output 3:
9
9
9
9
*/
import java.util.Scanner;
import java.util.Stack;

public class StackWithMax {		
	public static void main(final String[] args) throws Exception {
		Scanner in = new Scanner(System.in);		
		int requestCount = in.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> maxStack = new Stack<>();
		
		for (int i = 0; i <= requestCount; i++) {
            String request = in.nextLine();
            if(request.contains("push")) {
                stack.push(Integer.parseInt(request.split(" ")[1]));
                if (maxStack.isEmpty() || maxStack.peek() < stack.peek()) {
                    maxStack.push(stack.peek());
                } else {
                	maxStack.push(maxStack.peek());
                }
            } else if (request.equals("max")) {
                System.out.println(maxStack.peek());
            } else if (request.equals("pop")) {
                stack.pop();
                maxStack.pop();
            }
        }
	}
}
