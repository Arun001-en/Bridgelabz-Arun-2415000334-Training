abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    public String getItemId(){ return itemId; }
    public void setItemId(String i){ this.itemId = i; }
    public String getTitle(){ return title; }
    public void setTitle(String t){ this.title = t; }
    public String getAuthor(){ return author; }
    public void setAuthor(String a){ this.author = a; }
    public String getItemDetails(){ return itemId+" "+title+" "+author; }
    public abstract int getLoanDuration();
}
interface Reservable {
    void reserveItem(String user);
    boolean checkAvailability();
}
class Book extends LibraryItem implements Reservable {
    @Override
    public int getLoanDuration(){ return 21; }
    private boolean available = true;
    @Override
    public void reserveItem(String user){ if(available) available=false; }
    @Override
    public boolean checkAvailability(){ return available; }
}
class Magazine extends LibraryItem {
    @Override
    public int getLoanDuration(){ return 7; }
}
class DVD extends LibraryItem {
    @Override
    public int getLoanDuration(){ return 14; }
}
public class LibraryMain {
    public static void main(String[] args){
        LibraryItem[] arr = new LibraryItem[3];
        Book b = new Book(); b.setItemId("B1"); b.setTitle("Java"); b.setAuthor("A");
        Magazine m = new Magazine(); m.setItemId("M1"); m.setTitle("Tech"); m.setAuthor("B");
        DVD d = new DVD(); d.setItemId("D1"); d.setTitle("Movie"); d.setAuthor("C");
        arr[0]=b; arr[1]=m; arr[2]=d;
        for(LibraryItem i: arr) System.out.println(i.getItemDetails()+" Loan days: "+i.getLoanDuration());
        System.out.println("Book available: "+((Book)b).checkAvailability());
        ((Book)b).reserveItem("User1");
        System.out.println("Book available after reserve: "+((Book)b).checkAvailability());
    }
}
