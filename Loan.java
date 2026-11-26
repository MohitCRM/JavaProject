public class Loan
{
    private int loanPeriod;
    private int borrowDay;
    private String memid;
    private String itemid;

    public Loan(String memid, int borrowDay, int loanPeriod, String itemid)
    {
        this.memid = memid;
        this.itemid = itemid;
        this.borrowDay = borrowDay;
        this.loanPeriod = loanPeriod;
    }

    public String getmemID()
    {
        return memid;
    }

    public String getitemID()
    {
        return itemid;
    }

    public int getBorrowDay()
    {
        return borrowDay;
    }

    public int getDueDay()
    {
        return borrowDay + loanPeriod;
    }

    public int getFine(int currentDay, int fineRate)
    {
        int daysLate = currentDay - getDueDay();
        if (daysLate <= 0)
        {
            return 0;
        }
        return daysLate * fineRate;
    }
}
