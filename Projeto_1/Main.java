import java.util.Scanner;
import java.util.Calendar;

public class Main {

    public static void setCode(int[] code) {
        for(int i : code) {
            code[i] = 0;
        }
    }
    public static int getPos(int[] code) {
        int i = 0;
        while(code[i] == 1) {
            i += 1;
        }
        code[i] = 1;
        return i;
    }
    public static void main(String[] args) {

        int[] codeused = new int[100];
        setCode(codeused);
        int codigo = 100;
        Scanner input = new Scanner(System.in);
        Empregado[] empregado = new Empregado[100];
        Calendar time = Calendar.getInstance();



        System.out.println("Data e Hora atual: " +time.getTime());

        System.out.println("Escolha uma ação\n1.Adcionar funcionário ao Sistema\n" +
                "2.Remover funcionário do Sistema\n3.Acessar informações de um funcio" +
                "nário\n4.Sair do" +
                " Sistema");


        while(true) {
            int action = input.nextInt();
            input.nextLine();

            switch (action) {
                case 1:
                    int pos = getPos(codeused);
                    empregado[pos] = new Empregado();
                    System.out.print("Insira o nome do funcionário: ");
                    empregado[pos].setName(input.nextLine());
                    System.out.print("Insira o Endereco do funcionário: ");
                    empregado[pos].setAdress(input.nextLine());
                    System.out.print("Insira o tipo de salario atribuido ao funcionário\n"
                            + empregado[pos].getName() + "(hourly, salaried, commissioned)");
                    empregado[pos].setType(input.nextLine());
                    System.out.print("Insira o Salario do funcionário: " + empregado[pos].getName()
                            + "\n");
                    empregado[pos].setSalary(input.nextDouble());
                    empregado[pos].setCode(Integer.toString(time.get(Calendar.YEAR)) + pos);
                    System.out.print("Registrado com sucesso\n\n\n");
                    System.out.print("Dados atuais\n\n\n");
                    empregado[pos].tabelinha();
                    action = -1;
                    break;
            }
        }
    }
}
