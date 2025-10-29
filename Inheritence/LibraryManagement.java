package Inheritance;


class Boook{
	String title;
	int publicationYear ;
	Boook(String title,int publicationYear){
		this.title = title;
		this.publicationYear = publicationYear;
	}
	
}

class Author extends Boook{
	String authorName ;
	String bio ;
	Author(String title,int publicationYear,String authorName, String bio){
		super(title,publicationYear);
		this.authorName = authorName;
		this.bio = bio;
	}
	void displayInfo() {
		System.out.println(title + " is written by "+ authorName + "(" + bio + ")" +" in year "+ publicationYear );
	}
}

public class LibraryManagement {

	public static void main(String[] args) {
		Author authorObj = new Author("Wings of fire",1990,"APJ Abdul kalam","Missile man of India");
		authorObj.displayInfo();
	}

}