public class Acc {
    private String name;
    private int money;

    public void Constructor(String accname){
        this.name = accname;
    }
    public void setName(String accname){
        this.name = accname;
    }
    public String getName(){
        return this.name;
    }
    public void addMoney(int money){
        this.money += money;
    }
    public int getMoney(){
        return this.money;
    }

}
