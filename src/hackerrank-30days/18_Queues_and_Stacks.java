/**
 * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backwards and forwards. Can you determine if a given string, s, 
 * is a palindrome?
 */
public class Solution {
    private Stack<Character> stack = new Stack<>();
    private Queue<Character> queue = new ArrayDeque<>();
    
    public void pushCharacter(char ch){
        this.stack.push(ch);
    }
	
	public char popCharacter(){
        return this.stack.pop();
    }
    
    public void enqueueCharacter(char ch){
        this.queue.add(ch);
    }
    
     public char dequeueCharacter() {
        return this.queue.poll();
    }

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Solution p = new Solution();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;                
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is " 
                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}