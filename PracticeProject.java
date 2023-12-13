import java.sql.Struct;
import java.util.Scanner;
class SchoolLibrary{
    Scanner scanner = new Scanner(System.in);
    String[] availableBooks = new String[100];
    String[] issuedBooks = new String[100];

    public void addBooks(String[] books,int num){
        for(int i=0;i<num;i++){
            System.out.print("Book id "+(i+1)+" || Name : ");
            books[i] = scanner.nextLine();
            availableBooks[i] = books[i];
        }
    }
    public void displayBooks(String[] books,int num){
        for(int i=0;i<num;i++){
            System.out.print("Book id " + (i + 1) + " || Name : ");
            System.out.println(availableBooks[i] + " ");
        }
        System.out.println();
    }
    public void searchBook(String[] books,int num,String book_name){
        boolean find=false;
        for(int i=0;i<num;i++){
            if(books[i].equalsIgnoreCase(book_name)){
                System.out.print("Book id "+(i+1)+" || Name : ");
                find = true;
                break;
            }
        }
        if(find){
            System.out.println(book_name + " is available in the library");
        }
        else{
            System.out.println(book_name + " is not available in the library");
        }
    }

    public void issuedBooks(String[] books,int num,String issue_book){
        searchBook(books,num,issue_book);
        int issueIndex=0;
        for(int i=0;i<num;i++){
            if(books[i].equalsIgnoreCase(issue_book)){
                issuedBooks[issueIndex++]=issue_book;
                availableBooks[i] = null;
            }
        }
        for(int i=0;i<num;i++){
            if(availableBooks[i] != null){
                System.out.print("Book id "+(i+1)+" || Name : ");
                System.out.println(availableBooks[i] + " ");
            }
        }

    }

}
public class PracticeProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SchoolLibrary object1 = new SchoolLibrary();
        int num = 0;
        System.out.println("****************   WELCOME TO THE LIBRARY   *****************");
        while(true){
        System.out.println("Your action : ");
        System.out.println("1. Add book\n2. Display books\n3. Search book\n4. Issued book");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (choice){
                case 1 :
                    System.out.print("Enter number of book that you want to add or store in your library = ");
                    num = scanner.nextInt();
                    scanner.nextLine();
                    String[] book = new String[num];
                    System.out.println("Name all the book that you want to add/store in your library : ");
                    object1.addBooks(book,num);
                    break;
                case 2 :
                    System.out.println("Dispaly all the books which is available in the library");
                    object1.displayBooks(object1.availableBooks,num);
                    break;
                case 3 :
                    System.out.print("Name the book that you wish to read = ");
                    String book_name = scanner.nextLine();
                    object1.searchBook(object1.availableBooks,num,book_name);
                    break;
                case 4 :
                    System.out.print("Name the book that you want to issue from library = ");
                    String issue_book = scanner.nextLine();
                    object1.issuedBooks(object1.availableBooks,num,issue_book);
                    break;
                default :
                    System.exit(0);
            }
        }

    }
}
