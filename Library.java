import java.util.Scanner;

class LibraryClass {
    Scanner scanner = new Scanner(System.in);
    String[] availableBooks = new String[10];
    String[] issuedBooks = new String[10];

    public void addsBooks(String[] books, int size) {

        for (int i = 0; i < size; i++) {
            System.out.print("Book id " + (i + 1) + " || Name : ");
            books[i] = scanner.nextLine();
            availableBooks[i] = books[i];
        }
    }

    public void displayBooks(String[] books, int size) {
        System.out.println("Books that are present in the library : ");
        for (int i = 0; i < size; i++) {
            System.out.print("Book id " + (i + 1) + " || Name : ");
            System.out.println(availableBooks[i] + " ");
        }
        System.out.println();
    }

    public void searchBooks(String[] books, int num, String book_name) {
        boolean found = false;
        for (int i = 0; i < num; i++) {
            if (books[i].equalsIgnoreCase(book_name)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println(book_name + " is available in the library.");
        } else {
            System.out.println(book_name + " is not available in the library.");
        }
    }


    public void issuedbook(String[] books, int num, String book_name) {
        searchBooks(books,num,book_name);
        int issueindex = 0;
        for (int i = 0; i < num; i++) {
            if(books[i].equalsIgnoreCase(book_name)){
                issuedBooks[issueindex++]=book_name;
                availableBooks[i]=null;
            }
        }
        System.out.println("Available books after updating library : ");
        for(int i=0;i<num;i++){
            if(availableBooks[i] != null) {
                System.out.print("Book id " + (i + 1) + " || Name : ");
                System.out.println(availableBooks[i] + " ");
            }
        }
    }
}



public class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of books you want to store in the library : ");
        int num = scanner.nextInt();
        scanner.nextLine();
        String[] book = new String[num];
        LibraryClass obj1 = new LibraryClass();
        System.out.println("Enter book Name ");
        obj1.addsBooks(book, num);
        obj1.displayBooks(book, num);
        System.out.print("Enter the name of the book that you want to read = ");
        String search_book = scanner.nextLine();
        obj1.searchBooks(book, num, search_book);
        System.out.print("Name the book that you want to issue = ");
        String issue_book = scanner.nextLine();
        obj1.issuedbook(book, num, issue_book);
    }
}































