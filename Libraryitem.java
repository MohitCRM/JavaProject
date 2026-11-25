
public class LibraryItem
{
    private final String ID;
    private final String title;


    LibraryItem(String ID, String title)
    {
        this.ID = ID;
        this.title = title;
    }

    String getID()
    {
        return ID;
    }

    String getTitle()
    {   
        return title;
    }


}

class Book extends LibraryItem implements Borrowable
{
    private final String author;
    
    Book(String ID, String title, String author)
    {
        super(ID,title);
        this.author = author;
    }

    @Override
    public int getFineRate()
    {
        return 2;
    }
}

class Magazine extends LibraryItem implements Borrowable
{
    private final String issue;
    
    Magazine(String ID, String title, String issue)
    {
        super(ID,title);
        this.issue = issue;
    }

    @Override
    public int getFineRate()
    {
        return 1;
    }
}

class ReferenceBook extends LibraryItem
{
    private final String author;
    
    ReferenceBook(String ID, String title, String author)
    {
        super(ID,title);
        this.author = author;
    }
}