/**
 * Read a string, S, and print its integer value; if S cannot be converted to an integer, print "Bad String".
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();        
        try {
            System.out.println(Integer.parseInt(s));
        } catch(Exception e) {
            System.out.println("Bad String");
        }
    }
}