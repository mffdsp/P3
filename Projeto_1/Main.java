import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Calendar;

public class Main {
    final int MAX = 100;


    public static void menuPrint()
    {
        System.out.println("Escolha uma ação\n1.Adcionar funcionário ao Sistema\n" +
                "2.Remover funcionário do Sistema\n3.Acessar informações de um funcio" +
                "nário\n4.Sair do" +
                " Sistema");
    }
    public static void setCode(int[] code) {
        for(int i = 0; i < 100; i++) {
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
    public static void codeRecover(String word, Empregado[] empregado, int[] usage){
        boolean achouum = false;
        for(int i = 0; i < 100; i++)
        {
            if(usage[i] == 1)
            {
                if(empregado[i].getName().toLowerCase().contains(word.toLowerCase()))
                {
                    if(achouum == false)
                    {
                        System.out.println("Lista de Funcionarios similares a busca:\n");
                        achouum = true;
                    }
                    System.out.println(">>>" +  empregado[i].getName() + " - " + empregado[i].getCode());
                }
            }
        }
        if(achouum == false)
        {
            System.out.println("Nenhum funcionario foi encontrado");
        }
    }
    public static void codeSearch(String code, Empregado[] empregado, int[] usage){
        boolean achouum = false;
        for(int i = 0; i < 100; i++)
        {
            if(usage[i] == 1)
            {
                if(code.equals( empregado[i].getCode()))
                {
                    achouum = true;
                    System.out.println("Funcionário encontrado!\n");
                    empregado[i].tabelinha();
                    break;
                }
            }

        }
        if(achouum == false)
        {
            System.out.println("\n\nNenhum funcionario foi encontrado");
        }
        System.out.println("\n\n");
    }

    public static void main(String[] args) {

        int[] codeused = new int[100];
        setCode(codeused);
        int codigo = 100;
        Scanner input = new Scanner(System.in);
        Empregado[] empregado = new Empregado[100];
        Calendar time = Calendar.getInstance();


        System.out.println("Data e Hora atual: " +time.getTime());


        boolean play = true;
        while(play) {
            menuPrint();
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
                    System.out.print("Insira o tipo de salario atribuido ao funcionário\n" +
                           "(hourly, salaried, commissioned)\n");
                    empregado[pos].setType(input.nextLine());
                    System.out.print("Insira o Salario do funcionário: "
                            + "\n");
                    empregado[pos].setSalary(input.nextDouble());
                    empregado[pos].setCode(Integer.toString(time.get(Calendar.YEAR)) + pos);
                    System.out.print("O funcionario esta associado ao Sindicato de sua categoria ?\n" +
                            "1 - SIM / 2 - NAO\n");
                    if(input.nextInt() == 1){
                        empregado[pos].setSindicaty(true);
                    } else empregado[pos].setSindicaty(false);
                    System.out.println("Registrado com sucesso\n\n\nCodigo de acesso = " + empregado[pos].getCode());
                    action = -1;
                    break;
                case 2:
                    //something
                case 3:
                    System.out.print("Digite a opcao para acessar informacoes:\n\n\n1 - Buscar por código " +
                            "2 - Recuperar código de funcionário por busca nominal\n");
                    int buscatipo = input.nextInt();
                    input.nextLine();
                    switch(buscatipo)
                    {
                        case 1:
                            System.out.println("Insira o código de registro: \n");
                            String busca = input.nextLine();
                            codeSearch(busca, empregado, codeused);
                            break;
                        case 2:
                            System.out.println("aaaInsira pelo menos uma parte do nome do funcionario \n");
                            String recuperar = input.nextLine();
                            codeRecover(recuperar, empregado, codeused);
                            break;
                    }
                case 4:
                    play = false;
                    System.out.println("Saindo do sistema, bom dia!");
                    break;
                default:
                    System.out.println("Comando invalido, tente novamente!");
            }
        }
    }
}
