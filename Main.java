import java.util.*;

public class Main
{
    

    public static void main(String[] args)
    {

        Map<String,LibraryItem> items = new TreeMap<>();
        Map<String,Member> loans = new TreeMap<>();

        Scanner sc = new Scanner(System.in);

        String[] p = sc.nextLine().trim().split("|");

        String cmd = p[0];

        switch(cmd)
        {
            case "ADD_BOOK":
                String Id = p[1];
                String title = p[2];
                String author = [3];

                items.put(Id,new Book(Id,title,author));
                System.out.println("OK");
                break;

                case "ADD_MAGAZINE":
                String Id = p[1];
                String title = p[2];
                String issue = [3];

                items.put(Id,new Magazine(Id,title,issue));
                System.out.printn("OK");
                break;

                case "ADD_REFERENCE":
                String Id = p[1];
                String title = p[2];
                String author = [3];

                items.put(Id,new ReferenceBook(Id,title,author));
                System.out.prinln("OK");
                break;

                case "INVENTORY":
                    for(Map.Entry<String,LibraryItem> e : items.entrySet())
                    {
                        LibraryItem item = e.getValue();
                        String status = "AVAILABLE";

                        if(item.getType() == "REFERENCE")
                        {
                            status = "NOT_BORROWABLE";
                        }

                        if(loans.containsKey(item.getId()))
                        {
                            String memid = loans.get(item.getId());
                            status = "ON_LOAN|"+ memid;
                        }

                        System.out.println(e.getKey() + "|" + item.getType() + "|" + status)
                    }
        }
    }
}
