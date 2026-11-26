import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine())
        {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] p = line.split("\\|");
            String cmd = p[0];

            switch (cmd)
            {
                case "ADD_BOOK":
                    library.addBook(p[1], p[2], p[3]);
                    break;

                case "ADD_MAGAZINE":
                    library.addMagazine(p[1], p[2], p[3]);
                    break;

                case "ADD_REFERENCE":
                    library.addReference(p[1], p[2], p[3]);
                    break;

                case "ADD_MEMBER":
                    library.addMember(p[1], p[2], p[3]);
                    break;

                case "BORROW":
                    library.borrow(p[1], p[2]);
                    break;

                case "RETURN":
                    library.returnItem(p[1]);
                    break;

                case "ADVANCE":
                    library.advance(Integer.parseInt(p[1]));
                    break;

                case "INVENTORY":
                    library.inventory();
                    break;
            }
        }
    }
}
