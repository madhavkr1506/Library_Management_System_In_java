import java.util.*;
class Project{
    ArrayList<String> list1 = new ArrayList<>();
    HashMap<String, String> map1 = new HashMap<>();
    public void function1(String book_name,String author_name){
        map1.put(book_name,author_name);
    }
    public void function2(String book_name){
        String author = map1.remove(book_name);
        if(author != null){
            list1.add(book_name + " by " + author);
        }
        else{
            System.out.println("Book is not present in the library.");
        }
    }
    public void function3(){
        for(Map.Entry<String,String> e : map1.entrySet()){
            System.out.println("Book Name : " + e.getKey() + " || Author Name :  " + e.getValue());
        }
    }
    public void function4(String book_name){
        for(String book : list1){
            if(book.startsWith(book_name)){
                String author = book.split(" by ")[1];
                function1(book_name,author);
                return;
            }
        }
    }
}
public class PracticeProjectLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Project p1 = new Project();
        p1.function1("Ramayana","Valmiki");
        p1.function1("Ramcharitmanas","Tulsidas");
        p1.function3();
        p1.function2("Ramayana");
        System.out.println("Library status after book issue : ");
        p1.function3();
        System.out.println("Library status after book return : ");
        p1.function4("Ramayana");
        p1.function3();
    }
}




