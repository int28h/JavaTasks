/**
 * Владелец графства Сортлэнд, граф Бабблсортер, решил познакомиться со своими подданными. 
 * Число жителей в графстве нечетно и составляет n, где n  может быть достаточно велико, 
 * поэтому граф решил ограничиться знакомством с тремя представителями народонаселения: 
 * с самым бедным жителем, с жителем, обладающим средним достатком, и с самым богатым жителем.
 * Согласно традициям Сортлэнда, считается, что житель обладает средним достатком, 
 * если при сортировке жителей по сумме денежных сбережений он оказывается ровно посередине. 
 * Известно, что каждый житель графства имеет уникальный идентификационный номер, 
 * значение которого расположено в границах от единицы до n. 
 * Информация о размере денежных накоплений жителей хранится в массиве M таким образом, 
 * что сумма денежных накоплений жителя, обладающего идентификационным номером i, содержится в ячейке M[i].
 * Помогите секретарю графа мистеру Свопу вычислить идентификационные номера жителей, 
 * которые будут приглашены на встречу с графом.
 * 
 * Формат входного файла
 * Первая строка входного файла содержит число жителей n(3 <= n <= 9999, n нечетно). Вторая строка содержит описание массива , состоящее из положительных вещественных чисел, разделенных пробелами. Гарантируется, что все элементы массива различны, а их значения имеют точность не более двух знаков после запятой и не превышают 10^6.
 * 
 * Формат выходного файла
 * В выходной файл выведите три целых положительных числа, разделенных пробелами — идентификационные номера беднейшего, среднего и самого богатого жителей Сортлэнда. 
 *
 * Пример
 * input
 * 5
 * 10.00 8.70 0.01 5.00 3.00
 * output
 * 3 4 1
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        Float[][] array = new Float[in.nextInt()][2];
		
        for(int i = 0; i < array.length; i++) {
        	for(int j = 0; j < 1; j++) {
        		array[i][j] = Float.valueOf(in.next());
        		array[i][j+1] = (float) (i + 1);
        	}
        }
        in.close();
		
        for(int j = 0; j < array.length; j++){
	            int i = j - 1;
	            while(i >= 0 && array[i][0] > array[i+1][0]) {
	                Float temp = array[i][0];
	                Float temp1 = array[i][1];
	                array[i][0] = array[i+1][0];
	                array[i][1] = array[i+1][1];
	                array[i+1][0] = temp;
	                array[i+1][1] = temp1;
	                i--;
	            }
        } 
        for(int i = 0; i < array.length; i++) {
        	for(int j = 0; j < 2; j++) {        		
        		System.out.print(array[i][j] + " ");
        	}
        	System.out.println();
        }
		
        float poorIndex = array[0][1];
        float averageIndex = array[array.length/2][1];
        float richIndex = array[array.length-1][1];
        System.out.print((int) poorIndex + " " + (int) averageIndex + " " + (int) richIndex);
		
        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintStream out = new PrintStream(fos);
        out.print((int)poorIndex + " " + (int)averageIndex + " " + (int)richIndex);
        out.close();
    }
}
