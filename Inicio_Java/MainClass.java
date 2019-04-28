import java.util.*;

public class MainClass {

    public static void main(String args[]){

//        Acc account = new Acc(); //Chamo uma instancia da classe
//
          Scanner in = new Scanner(System.in); //Scan
          Produto prod = new Produto();

          String brand = in.nextLine();
          double price = in.nextDouble();
          int inches = in.nextInt();
          prod.ProdutoM(brand, price, inches);

          System.out.println(prod.toString());
//        System.out.println("Nome inicial da variavel " + account.getName());
//
//        System.out.println("Entre com um novo nome");
//
//        account.setName(in.nextLine());
//        System.out.println("O Nome da variavel e " + account.getName());
//
//        for(int i = 0; i < 5; i++)
//        {
//            System.out.println("Adcione dinheiro");
//            account.addMoney(in.nextInt());
//            System.out.println("Dinheiro atual: " + account.getMoney() );
//        }

    }
}
