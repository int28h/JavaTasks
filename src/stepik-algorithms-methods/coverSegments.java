/**
 * По данным n отрезкам необходимо найти множество точек минимального размера, для которого каждый из отрезков
 * содержит хотя бы одну из точек.
 * 
 * В первой строке дано число 1 <= n <= 100 отрезков.
 * Каждая из последующих n строк содержит по два числа 0 <= l <= r <= 10^9, задающих начало и конец отрезка.
 * Выведите оптимальное число m точек и сами m точек. Если таких множеств точек несколько, выведите любое из них.
 * 
 * Пример
 * input
 * 3
 * 1 3
 * 2 5
 * 3 6
 * output
 * 1
 * 3
 * 
 * input
 * 4
 * 4 7
 * 1 3
 * 2 5
 * 5 6
 * output
 * 2
 * 3 6
 */

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void insertionSort(int[][] data, int count) {
        for (int j = 0; j < count; j++) {
            int i = j - 1;
            while (i >= 0 && data[i][2] > data[i + 1][2]) {
                int temp0 = data[i][0];
                int temp1 = data[i][1];
                int temp2 = data[i][2];
                data[i][0] = data[i + 1][0];
                data[i][1] = data[i + 1][1];
                data[i][2] = data[i + 1][2];
                data[i + 1][0] = temp0;
                data[i + 1][1] = temp1;
                data[i + 1][2] = temp2;
                if (i != 0) {
                    if (data[i - 1][2] == data[i][2]) {
                        System.out.println("Нашлись две одинаковые точки с ключом " + data[i][2]);
                        if (data[i - 1][1] > data[i][1]) {
                            System.out.println("Они в неправильном порядке; они поменяются местами");
                            temp0 = data[i - 1][0];
                            temp1 = data[i - 1][1];
                            temp2 = data[i - 1][2];
                            data[i - 1][0] = data[i][0];
                            data[i - 1][1] = data[i][1];
                            data[i - 1][2] = data[i][2];
                            data[i][0] = temp0;
                            data[i][1] = temp1;
                            data[i][2] = temp2;
                        }
                    }
                }
                i--;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int strings = sc.nextInt();
        int count = strings * 2;
        int currentString = 0;
        int[][] data = new int[count][3];

        //заполнение массива
        //[i][0] - номер отрезка 
        //[i][1] - начало или конец отрезка; 0 начало, 1 конец 
        //[i][2] - точка
        for (int i = 0; i < count; i++) {
            if (currentString % 2 == 0) {
                data[i][0] = currentString / 2 + 1;
                data[i][1] = 0;
            } else {
                data[i][0] = currentString / 2 + 1;
                data[i][1] = 1;
            }
            data[i][2] = sc.nextInt();
            currentString++;
        }

        insertionSort(data, count);

        Stack<Integer> stack = new Stack<Integer>();
        boolean[] isSegmentCovered = new boolean[strings];
        StringBuilder answer = new StringBuilder();
        int answersCount = 0;
        for (int i = 0; i < count; i++) {
            //System.out.println("Обрабатывается точка " + data[i][2] + " из отрезка " + data[i][0]);
            //if(data[i][0] == 0) continue;
            if (data[i][1] == 0) {
                //System.out.println("Эта точка является началом отрезка " + data[i][0]);
                stack.push(data[i][0]);
                //System.out.println("В стек помещен отрезок " + data[i][0]);
            } else {
                //System.out.println("Эта точка является концом отрезка " +  + data[i][0]);
                if (!isSegmentCovered[data[i][0] - 1]) {
                    //System.out.println("Данный отрезок еще не покрыт");
                    answersCount++;
                    answer.append(data[i][2] + " ");
                    while (!stack.isEmpty()) {
                        int cur = stack.pop();
                        isSegmentCovered[cur - 1] = true;
                        //System.out.println("Отрезок "+ cur + " покрыт");
                    }
                } else {
                    //System.out.println("Данный отрезок уже покрыт");
                }
            }
        }
        System.out.println(answersCount);
        System.out.println(answer);
    }
}
