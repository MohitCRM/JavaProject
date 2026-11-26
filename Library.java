import java.util.Map;
import java.util.TreeMap;

public class Library
{
    private int currentDay = 0;
    private final Map<String, LibraryItem> items = new TreeMap<>();
    private final Map<String, Loan> loans = new TreeMap<>();
    private final Map<String, Member> members = new TreeMap<>();

    public void addBook(String id, String title, String author)
    {
        items.put(id, new Book(id, title, author));
        System.out.println("OK");
    }

    public void addMagazine(String id, String title, String issue)
    {
        items.put(id, new Magazine(id, title, issue));
        System.out.println("OK");
    }

    public void addReference(String id, String title, String author)
    {
        items.put(id, new ReferenceBook(id, title, author));
        System.out.println("OK");
    }

    public void addMember(String id, String name, String type)
    {
        switch (type)
        {
            case "STUDENT":
                members.put(id, new Student(id, name));
                break;
            case "STAFF":
                members.put(id, new Staff(id, name));
                break;
            case "FACULTY":
                members.put(id, new Faculty(id, name));
                break;
        }
        System.out.println("OK");
    }

    public void borrow(String memid, String itemid)
    {
        if (!members.containsKey(memid))
        {
            System.out.println("ERROR member " + memid + " not found");
            return;
        }

        if (!items.containsKey(itemid))
        {
            System.out.println("ERROR item " + itemid + " not found");
            return;
        }

        Member member = members.get(memid);
        LibraryItem item = items.get(itemid);

        long memberLoanCount = 0;
        for (Loan l : loans.values())
        {
            if (l.getmemID().equals(memid))
            {
                memberLoanCount++;
            }
        }

        if (memberLoanCount >= member.getMaxItems())
        {
            System.out.println("ERROR " + memid + " has reached the limit of " + member.getMaxItems());
            return;
        }

        if (loans.containsKey(itemid))
        {
            System.out.println("ERROR " + itemid + " is on loan");
            return;
        }

        if (!(item instanceof Borrowable))
        {
            System.out.println("ERROR " + itemid + " cannot be borrowed");
            return;
        }

        int dueDay = currentDay + member.getLoanPeriod();
        loans.put(itemid, new Loan(memid, currentDay, member.getLoanPeriod(), itemid));
        System.out.println("OK due on day " + dueDay);
    }

    public void returnItem(String itemid)
    {
        if (!loans.containsKey(itemid))
        {
            System.out.println("ERROR " + itemid + " is not on loan");
            return;
        }

        Loan loan = loans.remove(itemid);
        LibraryItem item = items.get(itemid);
        int fine = 0;
        if (item instanceof Borrowable)
        {
            Borrowable b = (Borrowable) item;
            fine = loan.getFine(currentDay, b.getFineRate());
        }
        System.out.println("OK fine " + fine);
    }

    public void advance(int days)
    {
        currentDay += days;
        System.out.println("OK today is day " + currentDay);
    }

    public void inventory()
    {
        if (items.isEmpty())
        {
            System.out.println("NONE");
            return;
        }

        for (Map.Entry<String, LibraryItem> e : items.entrySet())
        {
            LibraryItem item = e.getValue();
            String status = "AVAILABLE";

            if ("REFERENCE".equals(item.getType()))
            {
                status = "NOT_BORROWABLE";
            }

            if (loans.containsKey(item.getID()))
            {
                Loan loan = loans.get(item.getID());
                String memid = loan.getmemID();
                status = "ON_LOAN|" + memid;
            }

            System.out.println(e.getKey() + "|" + item.getType() + "|" + status);
        }
    }
}
