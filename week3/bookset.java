import java.util.Scanner;
class Book
{
 private String name;
 private String author;
 private int price;
 private int numpages;

 public Book(String name, String author, int price, int numpages)
{
 this.name=name;
 this.author=author;
 this.price=price;
 this.numpages=numpages;
}
 public String getname()
{
 return name;
}
public String  getauthor()
{
 return author;
}
public int getprice()
{
 return price;
}
public int getnumpages()
{
 return numpages;
}
public void setname(String name)
{
 this.name=name;
}
public void setauthor(String author)
{
 this.author=author;
}
public void setprice(int price)
{
 this.price=price;
}
public void setnumpages(int numpages)
{
this.numpages=numpages;
}
public String tostring()
{
 String name, author, price, numPages;
 name = "Book name: " + this.name + "\n";
 author = "Author name: " + this.author + "\n";
 price = "Price: " + this.price + "\n";
 numPages = "Number of pages: " + this.numpages + "\n";
 return name + author + price + numpages;
}
}
public class bookset
{
public static void main(String []args)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the number of books:");
int n=sc.nextInt();
 sc.nextLine();
Book[] books=new Book[n];
for(int i=0;i<n; i++)
{
System.out.println("Book details:");
System.out.println("Book name:");
 String name=sc.nextLine();
System.out.println("Authors name:");
String author=sc.nextLine();
System.out.println("Book price:");
int price=sc.nextInt();
System.out.println("Number of pages:");
int numpages=sc.nextInt();
books[i]=new Book (name,author,price,numpages);
}
System.out.println("Details of all books:");
for(Book book:books)
{
 System.out.println(book);
}}
}
