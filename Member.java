

abstract public class Member
{
    private final String ID;
    private final String name;

    Member(String ID, String name)
    {
        this.ID = ID;
        this.name = name;
    }

    public abstract int getMaxItems();
    public abstract int getLoanPeriod();
}

class Student extends Member
{
    private int maxitems;
    private int loanperiod;

    Student(String ID, String name)
    {
        super(ID,name);
        this.maxitems = 3;
        this.loanperiod = 14;
    }

    @Override
    public int getMaxItems()
    {
        return maxitems;
    }

    @Override
    public int getLoanPeriod()
    {
        return loanperiod;
    }
}

class Staff extends Member
{
    private int maxitems;
    private int loanperiod;

    Staff(String ID, String name)
    {
        super(ID,name);
        this.maxitems = 4;
        this.loanperiod = 30;
    }

    @Override
    public int getMaxItems()
    {
        return maxitems;
    }

    @Override
    public int getLoanPeriod()
    {
        return loanperiod;
    }
}

class Faculty extends Member
{
    private int maxitems;
    private int loanperiod;

    Faculty(String ID, String name)
    {
        super(ID, name);
        this.maxitems = 5;
        this.loanperiod = 30;
    }

    @Override
    public int getMaxItems()
    {
        return maxitems;
    }

    @Override
    public int getLoanPeriod()
    {
        return loanperiod;
    }
}

