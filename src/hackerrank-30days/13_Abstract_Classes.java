/**
 * Given a Book class and a Solution class, write a MyBook class that does the following:
 * Inherits from Book
 *
 * Has a parameterized constructor taking these parameters:
 * - string title
 * - string author
 * - int price
 * 
 * Implements the Book class' abstract display() method so it prints these lines:
 * Title: a space, and then the current instance's title.
 * Author: a space, and then the current instance's author.
 * Price: a space, and then the current instance's price.
 */
import java.util.*;

abstract class Book {
    String title;
    String author;
    
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    abstract void display();
}

class MyBook extends Book {
    int price;
    
    MyBook(String title, String author, int price){
        super(title, author);
        this.price = price;
    }
    
    public void display(){
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);
    }
}

public class Solution {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        Book book = new MyBook(title, author, price);
        book.display();
    }
}
