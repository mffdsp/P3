import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Calendar;

public class Main {
    final int MAX = 100;


    private static void menuPrint()
    {
        System.out.println("\n\n>>>> Escolha uma ação:\n\n1.Adcionar funcionário ao Sistema\n" +
                "2.Remover funcionário do Sistema\n3.Acessar informações de um funcio" +
                "nário\n4.Modificar Informacoes de funcionario\n5.Sair do" +
                " Sistema");
    }
    private static void setCode(int[] code) {
        for(int i = 0; i < 100; i++) {
            code[i] = 0;
        }
    }
    private static int getPos(int[] code) {
        int i = 1;
        while(code[i] == 1) {
            i += 1;
        }
        code[i] = 1;
        return i;
    }

    private static int getIndex(String codigo){
        int i = 0;
        int index = 0;
        while(i < codigo.length() - 4 )
        {
            index += Math.pow(10,i) * Character.getNumericValue(codigo.charAt(i + 4));
            i += 1;
        }
        return index;
    }
    private static void rmvF(String codigo, int[] codeusage) {
        int index = getIndex(codigo);

        //encontra indice por codigo
        if(codeusage[index] == 1)
        {
            System.out.println("Removido com Sucesso");
            codeusage[index] = 0;//remove o carinha
        }else System.out.println("Codigo de acesso nao associado!");

    }
    private static void codeRecover(String word, Empregado[] empregado, int[] usage){
        boolean achouum = false;
        for(int i = 0; i < 100; i++)
        {
            if(usage[i] == 1)
            {
                if(empregado[i].getName().toLowerCase().contains(word.toLowerCase()))
                {
                    if(!achouum)
                    {
                        System.out.println("Lista de Funcionarios similares a busca:\n");
                        achouum = true;
                    }
                    System.out.println(">>>" +  empregado[i].getName() + " - " + empregado[i].getCode());
                }
            }
        }
        if(!achouum)
        {
            System.out.println("Nenhum funcionario foi encontrado");
        }
    }
    private static void codeSearch(String code, Empregado[] empregado, int[] usage){
        boolean achouum;
        achouum = false;
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
        if(!achouum)
        {
            System.out.println("\n\nNenhum funcionario foi encontrado");
        }
        System.out.println("\n\n");
    }

    public static void main(String[] args) {

        int sindqnt = 1;
        int[] codeused = new int[100];
        setCode(codeused);
        //int codigo = 100;
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
                    int pos = getPos(codeused) ;
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
                        empregado[pos].setSindicatyc("120" + sindqnt);
                        System.out.println("Usuario Associado ao Sindicato com Codigo sindical = " +
                                empregado[pos].getSindicatyc());
                        sindqnt += 1;
                    } else empregado[pos].setSindicaty(false);
                    System.out.println("Registrado com sucesso\n\n\nCodigo de acesso = " + empregado[pos].getCode() + "\n\n\n");
                    break;
                case 2:
                    System.out.println("Insira o código de registro: \n");
                    String buscadel = input.nextLine();
                    rmvF(buscadel, codeused);
                    break;
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
                            System.out.println("Insira pelo menos uma parte do nome do funcionario \n");
                            String recuperar = input.nextLine();
                            codeRecover(recuperar, empregado, codeused);
                            break;
                    }
                    break;
                case 4:
                   //modificar

                case 5:
                    play = false;
                    System.out.println("Saindo do sistema, bom dia!");
                    break;
                default:
                    System.out.println("Comando invalido, tente novamente!");
            }
        }
    }
}
