/**
 * Первая строка содержит количество предметов 1 <= n <= 10^3 и
 * вместимость рюкзака 0 <= W <= 2*10^6.
 * Каждая из следующих n строк задаёт стоимость 0 <= c[i] <= 2*10^6
 * и объём 0 <= w[i] <= 2*10^6 предмета (n, W, c[i], w[i] — целые числа).
 * Выведите максимальную стоимость _частей_ предметов (от каждого предмета
 * можно отделить любую часть, стоимость и объём при этом пропорционально уменьшатся),
 * помещающихся в данный рюкзак, с точностью не менее трёх знаков после запятой.
 * 
 * Пример
 * input
 * 3 50
 * 60 20
 * 100 50
 * 120 30
 * output
 * 180.000
 */

import java.util.Scanner;

public class Main {
    public static void insertionSort(double[][] array) {
        for (int j = 0; j < array.length; j++) {
            int i = j - 1;
            while (i >= 0 && array[i][2] > array[i + 1][2]) {
                double temp = array[i][0];
                double temp1 = array[i][1];
                double temp2 = array[i][2];
                array[i][0] = array[i + 1][0];
                array[i][1] = array[i + 1][1];
                array[i][2] = array[i + 1][2];
                array[i + 1][0] = temp;
                array[i + 1][1] = temp1;
                array[i + 1][2] = temp2;
                i--;
            }
        }
    }

    public static double knapsack(double[][] array, double backpackCapacity) {
        double sum = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (backpackCapacity > array[i][1]) {
                sum += array[i][0];
                backpackCapacity -= array[i][1];
            } else {
                sum += backpackCapacity / array[i][1] * array[i][0];
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int thingsCount = sc.nextInt();
        double backpackCapacity = sc.nextDouble();
        double[][] data = new double[thingsCount][3]; //здесь получаемые из ввода данные

        for (int i = 0; i < thingsCount; i++) {
            for (int j = 0; j < 2; j++) {
                data[i][j] = sc.nextDouble();
            }
            data[i][2] = data[i][0] / data[i][1]; //здесь отношения с[i]/w[i]
        }

        insertionSort(data);

        double sum = knapsack(data, backpackCapacity);

        System.out.printf("%.3f", sum);
    }
}

