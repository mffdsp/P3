public class Produto {

    protected String brand;
    protected double price;
    protected int inches;

    protected String newstring;

    public void ProdutoM(String brand, double price, int inches){
        this.brand = brand;
        this.price = price;
        this.inches = inches;
    }

    public String toString(){
        this.newstring = "Brand = " + brand +
                "\nPrice = " + this.price +
                "\nInches = " + this.inches;
        return this.newstring;
    }
}
