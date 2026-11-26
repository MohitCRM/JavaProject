
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        LibraryItem book = new Book("001", "Java", "Author A");
        LibraryItem magazine = new Magazine("002", "Java", "Issue 1");
        LibraryItem referenceBook = new ReferenceBook("003", "Java", "Author B");

        Member student = new Student("001", "Student");
        Member staff = new Staff("002", "Staff");
        Member faculty = new Faculty("003", "Faculty");

        ArrayList<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(book);
        libraryItems.add(magazine);
        libraryItems.add(referenceBook);
        
        ArrayList<Member> members = new ArrayList<>();
        members.add(student);
        members.add(staff);
        members.add(faculty);

        for(LibraryItem item : libraryItems)
        {
            System.out.println(item.getID());
        }
        
        for(Member member : members)   
        {
            System.out.println(member.getMaxItems() + " " + member.getLoanPeriod() + " " + member.getID() + " " + member.getName());
        }
    }
}
