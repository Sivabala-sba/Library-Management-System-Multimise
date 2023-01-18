import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;

public class LibraryManagementSystem {
    static ArrayList<String> books = new ArrayList<String>();

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        do{
            System.out.println("1. Insert books");
            System.out.println("2. Issue a book");
            System.out.println("3. Deposit a book");
            System.out.println("4. Check availability of a book");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = scan.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter the number of books to insert: ");
                    int numBooks = scan.nextInt();
                    scan.nextLine();

                    for(int i=0; i<numBooks; i++){
                        System.out.println("Enter the name of book: ");
                        String book = scan.nextLine();
                        books.add(book);
                    }
                    System.out.println("Books inserted successfully");
                    break;

                case 2:
                    System.out.println("Enter the name of the book to issue: ");
                    //String issueBook = scan.nextLine();
                    String issueBook = null;
                    try {
                        issueBook = input.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if(books.contains(issueBook)){
                        books.remove(issueBook);
                        System.out.println("Book issued successfully");
                    }
                    else{
                        System.out.println("Sorry, the book is not available in the library");
                    }
                    break;

                case 3:
                    System.out.println("Enter the name of the book to deposit: ");
                    //String depositBook = scan.nextLine();
                    String depositBook = null;
                    try {
                        depositBook = input.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    books.add(depositBook);
                    System.out.println("Book deposited successfully");
                    break;

                case 4:
                    System.out.println("Enter the name of the book to check availability: ");
                    //String availBook = scan.nextLine();
                    String availBook = null;
                    try {
                        availBook = input.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if(books.contains(availBook)){
                        System.out.println("Yes, the book is available in the library");
                    }
                    else{
                        System.out.println("No, the book is not available in the library");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice, please enter a valid choice");
                    break;
            }
        }
        while(choice != 5);
        scan.close();
    }
}
