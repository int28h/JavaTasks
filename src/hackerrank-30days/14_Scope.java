/**
 * Complete the Difference class by writing the following:
 * A class constructor that takes an array of integers as a parameter and saves it to the elements instance variable.
 * A computeDifference method that finds the maximum absolute difference between any 2 numbers 
 * in N and stores it in the maximumDifferece instance variable.
 */
class Difference {
  	private int[] elements;
  	public int maximumDifference;
	
	public Difference(int[] arr){
        this.elements = arr;
    }

    public void computeDifference(){
        int min = this.elements[0], max = this.elements[0];
        for(int i : this.elements){
            if(i > max) max = i;
            if(i < min) min = i;
        }
        this.maximumDifference = max - min;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}

	
