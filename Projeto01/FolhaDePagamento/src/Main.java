import java.util.*;
import java.util.concurrent.* ;

//Reindent Lines

public class Empresa {

    private static Scanner getEnter =  new Scanner(System.in);
    private static long SLEEPTIME = 0L;
    private static int MAX = 1000;
    private static boolean PAY_DAY = true;
    private static int VALIDPAYDAY = 0;
    private static int DAYSGONE = 0;
    private static String DIAU;

    //TIME
    private static int Ahora = 15;
    private static int Aminuto = 20;
    private static int Adia = 1;
    private static int Ames = 6;
    private static int Aano = 2019;
    private static String[] Asemana = new String[7];
    //TIME

    //Banco de dados
    private static int[] WorkDays = new int[1000]; //recebe de 2 em 2 semanas
    private static int[] codeused = new int[1000];
    private static String[] DATAname = new String[1000];
    private static double[] DATAhrpay = new double[1000];
    private static int[] DATAagendaday = new int[1000];
    private static int[] DATAcomissao = new int[1000];
    private static String[] DATAagendaweek = new String[1000];
    private static String[] DATAaddress = new String[1000];
    private static double[] DATAsalary = new double[1000];
    private static boolean[] DATAsindicaty = new boolean[1000];
    private static String[] DATAcode = new String[1000];
    private static String[] DATAsindicatyc = new String[1000];
    private static double[] DATAsindtax = new double[1000] ;
    private static String[] DATApaymode = new String[1000];
    private static int[] DATAworktime = new int[1000];
    private static String[] DATAtype = new String[1000];
    private static int[] horashj = new int[1000];
    private static int[] horassmes = new int[1000];

    //entrada
    private static int[] Ehora = new int[1000];
    private static int[] Eminuto = new int[1000];
    private static int[] Esegundo = new int[1000];
    //saida
    private static int[] Shora = new int[1000];
    private static int[] Sminuto = new int[1000];
    private static int[] Ssegundo = new int[1000];
    //Date
    private static int[] Etime = new int[1000];
    private static int[] Stime = new int[1000];

    //Banco de dados

    //AGENDAS
    private static String[] AGENDAS = new String[1000];
    private static int AGENDAbool[] = new int[1000];
    private static int AGENDAdia[] = new int[1000];
    private static int AGENDAmes[] = new int[1000];
    private static String AGENDAweek[] = new String[1000];
    private static String AGENDAtype[] = new String[1000];
    private static int AGENDA_INDEX = 4;


    //UNDO REDO

    private static int[][] horashjSAVE = new int[1000][1000];
    private static int[][] horasmesSAVE = new int[1000][1000];
    private static int[][] indexSAVE = new int[1000][1000];
    private static int[][] codeusedSAVE = new int[1000][1000];
    private static String[][] DATAnameSAVE = new String[1000][1000];
    private static int[][] DATAagendadaySAVE = new int[1000][1000];
    private static String[][] DATAagendaweekSAVE = new String[1000][1000];
    private static String[][] DATAaddressSAVE = new String[1000][1000];
    private static double[][] DATAsalarySAVE = new double[1000][1000];
    private static boolean[][] DATAsindicatySAVE = new boolean[1000][1000];
    private static String[][] DATAcodeSAVE = new String[1000][1000];
    private static String[][] DATAsindicatycSAVE = new String[1000][1000];
    private static double[][] DATAsindtaxSAVE = new double[1000][1000] ;
    private static String[][] DATApaymodeSAVE = new String[1000][1000];
    private static int[][] DATAworktimeSAVE = new int[1000][1000];
    private static String[][] DATAtypeSAVE = new String[1000][1000];
    private static int[][] AGENDAboolSAVE = new int[1000][1000];
    private static boolean[] PAYDAYSAVE = new boolean[1000];



    private static void setComissao(){
        for(int i = 0; i < MAX; i++)
        {
            DATAcomissao[i] = 15;
        }
    }
    private static void findVALIDPAYDAY(){
        int day = DAYSGONE ;
        while(day % 30 != 0){
            day += 1;
        }
        int value = day - 1;
        if(Asemana[day%7] == "Domingo")
        {
            value -= 1;

        }
        DIAU = Asemana[value%7];

    }
    //UNDE REDO
    private static int UNDACTIONS = 0;
    private static int SAVEINDEX = 1;

    private static void clearScreen(int time)throws InterruptedException {
        dormindinho(0);
        //System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void dormindinho(int x)throws InterruptedException{
        TimeUnit time = TimeUnit.SECONDS;
        time.sleep(x);
    }

    private static void saveState(){
        int i = 1;
        //System.out.println("saved");
        SAVEINDEX += 1;
        PAYDAYSAVE[SAVEINDEX] = PAY_DAY;
        for(int j = 1; j < 1000; j++){

            horasmesSAVE[SAVEINDEX][i] = horassmes[j];
            horashjSAVE[SAVEINDEX][i] = horashj[j];
            codeusedSAVE[SAVEINDEX][i] = codeused[j];
            DATAnameSAVE[SAVEINDEX][i] = DATAname[j];
            DATAagendaweekSAVE[SAVEINDEX][i] = DATAagendaweek[j];
            DATAaddressSAVE[SAVEINDEX][i] = DATAaddress[j];
            DATAsindicatySAVE[SAVEINDEX][i] = DATAsindicaty[j];
            DATAsalarySAVE[SAVEINDEX][i] =  DATAsalary[j];
            DATAcodeSAVE[SAVEINDEX][i] = DATAcode[j];
            DATAsindicatycSAVE[SAVEINDEX][i] = DATAsindicatyc[j];
            DATAsindtaxSAVE[SAVEINDEX][i] = DATAsindtax[j];
            DATAworktimeSAVE[SAVEINDEX][i] = DATAworktime[j];
            DATAtypeSAVE[SAVEINDEX][i] =  DATAtype[j];
            i += 1;
        }
        //AGENDAboolSAVE[SAVEINDEX] = AGENDAbool[indexSAVE[SAVEINDEX]];
    }

    private static void undo(){
        int j = 1;
        if(SAVEINDEX == 2)
        {
            System.out.println("Sem açao para desfazer (Empty Stack)");
        }else
        {
            SAVEINDEX -= 1;
            UNDACTIONS += 1;
            System.out.println("Ultima Acao desfeita com sucesso!");

            PAY_DAY = PAYDAYSAVE[SAVEINDEX];
            for(int i = 1; i < 1000; i++)
            {
                horassmes[i] = horasmesSAVE[SAVEINDEX][j];
                horashj[i] = horashjSAVE[SAVEINDEX][j];
                DATAname[i] = DATAnameSAVE[SAVEINDEX][j];
                DATAagendaweek[i] = DATAagendaweekSAVE[SAVEINDEX][j];
                DATAaddress[i] = DATAaddressSAVE[SAVEINDEX][j];
                DATAsindicaty[i] = DATAsindicatySAVE[SAVEINDEX][j];
                DATAsalary[i] = DATAsalarySAVE[SAVEINDEX][j];
                DATAcode[i] = DATAcodeSAVE[SAVEINDEX][j];
                DATAsindicatyc[i] = DATAsindicatycSAVE[SAVEINDEX][j];
                DATAsindtax[i] = DATAsindtaxSAVE[SAVEINDEX][j];
                DATAworktime[i] =  DATAworktimeSAVE[SAVEINDEX][j];
                DATAtype[i] = DATAtypeSAVE[SAVEINDEX][j];
                codeused[i] = codeusedSAVE[SAVEINDEX][j];
                j += 1;
            }

            //AGENDAbool[indexSAVE[SAVEINDEX]] = AGENDAboolSAVE[SAVEINDEX];
        }
    }
    private static int REDOACTIONS = 0;
    private static void redo(){
        int j = 1;
        if(UNDACTIONS == 0)
        {
            System.out.println("Sem açao disponivel para refazer");
        }else{

            REDOACTIONS += 1;
            UNDACTIONS -= 1;
            SAVEINDEX += 1;
            PAY_DAY = PAYDAYSAVE[SAVEINDEX];
            System.out.println("Ultima Acao Refeita com sucesso! ");
            for(int i = 1; i < 1000; i++)
            {
                horassmes[i] = horasmesSAVE[SAVEINDEX][j];
                horashj[i] = horashjSAVE[SAVEINDEX][j];
                DATAname[i] = DATAnameSAVE[SAVEINDEX][j];
                DATAagendaweek[i] = DATAagendaweekSAVE[SAVEINDEX][j];
                DATAaddress[i] = DATAaddressSAVE[SAVEINDEX][j];
                DATAsindicaty[i] = DATAsindicatySAVE[SAVEINDEX][j];
                DATAsalary[i] = DATAsalarySAVE[SAVEINDEX][j];
                DATAcode[i] = DATAcodeSAVE[SAVEINDEX][j];
                DATAsindicatyc[i] = DATAsindicatycSAVE[SAVEINDEX][j];
                DATAsindtax[i] = DATAsindtaxSAVE[SAVEINDEX][j];
                DATAworktime[i] =  DATAworktimeSAVE[SAVEINDEX][j];
                DATAtype[i] = DATAtypeSAVE[SAVEINDEX][j];
                codeused[i] = codeusedSAVE[SAVEINDEX][j];
                j += 1;
            }

            //AGENDAbool[indexSAVE[SAVEINDEX]] = AGENDAboolSAVE[SAVEINDEX];
        }

    }
    private static void setAGENDA(){
        for(int i = 0; i <100; i++)
        {
            AGENDAbool[i] = 0;
            AGENDAdia[i] = 0;
        }
    }

    private static void setDATAtype(){
        for(int i = 0; i < MAX; i++){
            DATAtype[i] = "nothing";
        }
    }
    private static String selectDayOfWeek(){
        int value = -1;
        Scanner hi = new Scanner(System.in);

        System.out.println("Selecione um dia da semana:");
        System.out.println("1.Domingo");
        System.out.println("2.Segunda-Feira");
        System.out.println("3.Terca-Feira");
        System.out.println("4.Quarta-Feira");
        System.out.println("5.Quinta-Feira");
        System.out.println("6.Sexta-Feira");
        System.out.println("7.Sabado");
        value = hi.nextInt();
        switch(value){
            case 1:
                return "Domingo";
            case 2:
                return "Segunda-Feira";
            case 3:
                return "Terca-Feira";
            case 4:
                return "Quarta-Feira";
            case 5:
                return "Quinta-Feira";
            case 6:
                return "Sexta-Feira";
            case 7:
                return "Sabado";
        }
        return "aaaa";
    }
    private static String selectAGENDA(){
        for(int i = 0; i < MAX; i++)
        {
            if(AGENDAbool[i] == 1)
            {
                System.out.print((i) + "- " + AGENDAS[i] + " / " + AGENDAtype[i].toLowerCase());
                if(AGENDAtype[i].toLowerCase().equals("mensal")) {
                    System.out.print(" / dia " + AGENDAdia[i]);
                    System.out.println(" (" + AGENDAtype[i] + " " + AGENDAdia[i] + ") ");

                } else if(AGENDAtype[i].toLowerCase().equals("semanal")) {
                    System.out.print(" / " + AGENDAweek[i]);
                    System.out.println(" (" + AGENDAtype[i] + " 1 " + AGENDAweek[i] + ") ");
                } else if(AGENDAtype[i].toLowerCase().equals("bi-semanal")){
                    System.out.print(" / " + AGENDAweek[i]);
                    System.out.println(" (" + AGENDAtype[i] + " 1 " + AGENDAweek[i] + ") ");

                }

            }
        }
        return "aaa";
    }

    private static void createAGENDA(){
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome customizado para a Nova Agenda:");
        AGENDAS[AGENDA_INDEX] = input.nextLine();

        System.out.println("Digite o tipo de pagamento\n 1.Semanal / 2.Mensal / 3.Bi-semanal");
        int tipinho = input.nextInt();
        if(tipinho == 1){
            AGENDAtype[AGENDA_INDEX] = "Semanal";
        }
        if(tipinho == 2){
            AGENDAtype[AGENDA_INDEX] = "Mensal";
        }
        if(tipinho == 3){
            AGENDAtype[AGENDA_INDEX] = "Bi-semanal";
        }
        if(AGENDAtype[AGENDA_INDEX].toLowerCase().equals("semanal")){
            //System.out.println("Digite o Dia da semana de pagamento: ");
            AGENDAweek[AGENDA_INDEX] = selectDayOfWeek();
        } else if(AGENDAtype[AGENDA_INDEX].toLowerCase().equals("mensal")){
            System.out.println("Digite o novo dia de pagamento: ");
            AGENDAdia[AGENDA_INDEX] = input.nextInt();
        } else if(AGENDAtype[AGENDA_INDEX].toLowerCase().equals("bi-semanal")){
            //System.out.println("Digite o Dia da semana de pagamento: ");
            AGENDAweek[AGENDA_INDEX] = selectDayOfWeek();
        }
        System.out.println("Criado com sucesso!");
        AGENDAbool[AGENDA_INDEX] = 1;
        AGENDA_INDEX += 1;
    }
    //UNDONE REDONE

    //O MESMO DE CIMA
    //Senha de acesso

    private static void pedirSenha(int valor)
    {
        Scanner input = new Scanner(System.in);

        if(valor == 1)
        {
            System.out.println("\nDigite a senha de acesso:");
            while(true)
            {
                String senha = "admin";

                String senhapedida = input.nextLine();
                if(senha.equals(senhapedida))
                {
                    System.out.println("\nSenha Correta, entrando no Sistema:");
                    break;
                }else System.out.println("\nSenha incorreta, Tente novamente");
            }
        }else return;

    }
    //Senha de acesso

    private static void setDays(){
        Asemana[0] = "Segunda-Feira";
        Asemana[1] = "Terca-Feira";
        Asemana[2] = "Quarta-Feira";
        Asemana[3] = "Quinta-Feira";
        Asemana[4] = "Sexta-Feira";
        Asemana[5] = "Sabado";
        Asemana[6] = "Domingo";

    }

    private static void baterPonto(int[] codeuseda, String codinho){

        int index = getIndex(codinho);
        Scanner input = new Scanner(System.in);
        Calendar time = Calendar.getInstance();

        if(codeused[index] == 1)
        {
            System.out.println("Bem Vindo - " + DATAname[index] + "\n" );
            while(true)
            {
                System.out.println("\n1 - Registrar Entrada* / 2 - Registrar Saida*");
                int type = input.nextInt();
                if(type == 1)
                {
                    System.out.println("Hora de Chegada = " + Ahora + ":" + Aminuto);
                    Etime[index] = Ahora;
                    break;
                }if(type == 2) {
                System.out.println("Hora de Saida = " + Ahora + ":" + Aminuto);
                Stime[index] = Ahora;
                int workedtime = Math.abs(Stime[index] - Etime[index]);
                horashj[index] = workedtime;
                horassmes[index] += workedtime;
                System.out.println("\n-------------------------------------");
                System.out.println("Nome do empregado = "+  DATAname[index]);
                System.out.println("Horas trabalhadas hoje = " + workedtime);
                System.out.println("Horas acumuladas no mes = " + horassmes[index]);

                System.out.print("Horas extras = " );
                if(workedtime > 8)
                {
                    int extras = workedtime - 8;
                    DATAsalary[index] += 8 * DATAhrpay[index] + extras * DATAhrpay[index]*1.5;
                    System.out.println(extras + "hrs");
                } else {
                    DATAsalary[index] += workedtime * DATAhrpay[index];
                    System.out.println("0hrs");
                }
                System.out.println("Salario somado = " +  DATAsalary[index] + "RS");
                System.out.println("\nENTRADA " + Etime[index] + "hrs         SAIDA " + Stime[index] + "hrs");
                System.out.println("-------------------------------------");
                break;
            }else System.out.println("Valor incorreto, tente novamente!\n");
            }
            System.out.println("\nPonto de " + DATAname[index] + " batido com sucesso");

        } else System.out.println("\nCodigo incorreto , Saindo do Sistema!\n");

    }


    private static boolean isSexta()
    {
        boolean sexta = false;
        System.out.println("Hoje e sexta-feira?");
        Scanner input = new Scanner(System.in);
        System.out.println("1 - SIM / 2 - NAO");
        int valor = input.nextInt();
        if(valor == 1) {
            sexta = true;
        } else sexta = false;
        return sexta;
    }

    private static boolean VALID_DAY = false;

    private static boolean searchAGENDA(int index){

        int i = 0;
        double salary = 0;
        boolean pagandinho = false;
        if(!DATAtype[index].equals("nothing")){
            while(i < MAX){
                if(AGENDAtype[i] != null){
                    if(DATAtype[index].equals(AGENDAS[i]) && AGENDAtype[i].equals("Semanal") && AGENDAweek[i].equals(Asemana[DAYSGONE % 7])){
                        salary = DATAsalary[index];
                        if(DATAsindicaty[index]){
                            System.out.println("- Taxa sindical descontada! // Valor = " + DATAsindtax[index] + " RS");
                            salary -= DATAsindtax[index];
                        }
                        System.out.println("- " + DATAname[index] + "\n- Pago via " + DATApaymode[index] + "\n- Valor = " + salary + "RS\n- Tipo: " + DATAtype[index]);
                        System.out.print("-------\n");
                        pagandinho = true;
                    }
                    else if(DATAtype[index].equals(AGENDAS[i]) &&
                            (AGENDAS[i].equals("Mensal") && Asemana[DAYSGONE %7].equals(DIAU)) ||
                            (!AGENDAS[i].equals("Mensal") && AGENDAdia[i] == Adia)){
                        salary = DATAsalary[index];
                        if(DATAsindicaty[index]){
                            System.out.println("- Taxa sindical descontada! // Valor = " + DATAsindtax[index] + " RS");
                            salary -= DATAsindtax[index];
                        }
                        System.out.println("- " + DATAname[index] + "\n- Pago via " + DATApaymode[index] + "\n- Valor = " + DATAsalary[index] + "RS\n- Tipo: " + DATAtype[index]);
                        System.out.print("-------\n");
                        pagandinho = true;
                    }
                    else if(DATAtype[index].equals(AGENDAS[i]) &&
                            AGENDAtype[i].equals("Bi-semanal") && AGENDAweek[i].equals(Asemana[DAYSGONE % 7]) && WorkDays[index] >= 9){
                        WorkDays[index] = 0;
                        salary = DATAsalary[index];
                        if(DATAsindicaty[index]){
                            System.out.println("- Taxa sindical descontada! // Valor = " + DATAsindtax[index] + " RS");
                            salary -= DATAsindtax[index];
                        }
                        System.out.println("- " + DATAname[index] + "\n- Pago via " + DATApaymode[index] + "\n- Valor = " + DATAsalary[index] + "RS\n- Tipo: " + DATAtype[index]);
                        System.out.print("-------\n");
                        pagandinho = true;
                    }
                }
                i += 1;
            }
        }
        return pagandinho;
    }

    private static void rodarFolha(int[] codeuseda){

        boolean pagandinho = false;
        VALID_DAY = true;
        double salary = 0;
        if(PAY_DAY)
        {
            //sexta = isSexta();
            System.out.println("Lista de funcionarios pagos:\n");
            for(int i = 1; i < MAX; i++)
            {
                if(codeused[i] == 1){
                    salary = DATAsalary[i];
                }

                if(codeused[i] == 1 && DATAtype[i].equals("Horario") && Asemana[DAYSGONE %7].equals("Sexta-Feira"))
                {

                    if(DATAsindicaty[i]){
                        System.out.println("- Taxa sindical descontada! // Valor = " + DATAsindtax[i] + " RS");
                        salary -= DATAsindtax[i];
                    }

                    System.out.println("- " + DATAname[i] + "\n- Pago via " + DATApaymode[i] + "\n- Valor = " + salary + " RS\n- Tipo: Horario");
                    System.out.print("-------\n");

                    pagandinho = true;

                }
                else if (codeused[i] == 1 && DATAtype[i].equals("Mensal") && Adia == 30 && Asemana[DAYSGONE %7].equals(DIAU))
                {
                    if(DATAsindicaty[i]){
                        System.out.println("- Taxa sindical descontada! // Valor = " + DATAsindtax[i] + " RS");
                        salary -= DATAsindtax[i];
                    }
                    System.out.println("- " + DATAname[i] + "\n- Pago via " + DATApaymode[i] + "\n- Valor = " + salary + " RS\n- Tipo: Mensal");
                    System.out.print("-------\n");
                    VALID_DAY = false;
                    pagandinho = true;
                }
                else if (codeused[i] == 1 && DATAtype[i].equals("Comissionado") && Asemana[DAYSGONE %7].equals("Sexta-Feira") && WorkDays[i] >= 9)
                {
                    WorkDays[i] = 0;
                    if(DATAsindicaty[i]){
                        System.out.println("- Taxa sindical descontada! // Valor = " + DATAsindtax[i] + " RS");
                        salary -= DATAsindtax[i];
                    }
                    System.out.println("- " + DATAname[i] + "\n- Pago via " + DATApaymode[i] + "\n- Valor = " + salary + " RS\n- Tipo: Comissionado, percentual de venda incluso!");
                    System.out.print("-------\n");
                    pagandinho = true;
                }
                else if(codeused[i] == 1 && !DATAtype[i].equals("nothing")){
                    pagandinho = searchAGENDA(i);
                }
            }
            if(pagandinho)
            {
                System.out.println("Pagamento realizado com sucesso!\n\n");
            }else System.out.println("Nenhum funcionario recebe no dia atual!\n\n");

        } else{
            System.out.println("Pagamento de hoje ja realizado!");
        }
        PAY_DAY = false;

    }
    private static void hourPrint(){
        System.out.println("  -------------  ");
        System.out.println("  "+ Adia + " / " + Ames + " / " + Aano + "\n" + "  " + Ahora + ":" + Aminuto);
        System.out.println("  "+ Asemana[DAYSGONE % 7]);
        System.out.println("  -------------  ");
    }
    private static void menuPrint(){
        hourPrint();
        System.out.println("\n\n>>>> Escolha uma ação:\n\n1.Adcionar funcionário ao Sistema*\n" +
                "2.Remover funcionário do Sistema*\n3.Acessar informações de um funcio" +
                "nário*\n4.Modificar Informacoes de funcionario*\n5.Listar todos os funcionarios cadastrados" +
                "\n6.Rodar folha de pagamento*\n"+
                "7.Criar nova agenda de pagamento*\n8.Passar Hora\n" + "9.Passar o dia\n" + "10.Undo*\n" + "11.Redo*\n" +
                "0.Sair do Sistema\n");
        System.out.println("UNDO_STACK = " + (SAVEINDEX - 2) + "      REDO_STACK = " + UNDACTIONS);
    }

    private static void setCode(int[] code) {
        for(int i = 0; i < MAX; i++) {
            code[i] = 0;
            DATAsindicaty[i] = false;
        }
    }

    private static void pc(int[] code) {
        for(int i = 0; i < MAX; i++) {
            System.out.println(code[i] + " ");
        }
    }

    private static int getPos(int[] code) {
        int i = 1;
        while(code[i] == 1) {
            i += 1;
        }
        return i;
    }

    private static void showAll(int[] usage) {
        boolean achouum = false;

        for(int i = 1; i < MAX; i++)
        {
            if(codeused[i] == 1)
            {
                if(!achouum)
                {
                    System.out.println("\n                  Lista de Funcionarios \n" + "----------------------------------" +
                            "-----------------------\n");
                    achouum = true;
                }
                System.out.println("> " +  DATAname[i] + " - " + DATAcode[i] +  " - " + DATAsalary[i] + "RS");
            }
        }
        if(!achouum)
        {
            System.out.println("\n\nNenhum funcionario registrado!\n\n");
        } else System.out.println("\n---------------------------------------------------------\n");
    }

    private static int getIndex(String codigo){
        int i = 0;
        int index = 0;
        //2019265
        int pt = codigo.length() - 5;
        while(i < codigo.length() - 4 )
        {
            index += Math.pow(10, pt - i) * Character.getNumericValue(codigo.charAt(i + 4));
            i += 1;
        }
        return index;
    }

    private static void rmvF(String codigo, int[] codeusagae) {
        int index = getIndex(codigo);
        //encontra indice por codigo
        if(codeused[index] == 1)
        {
            System.out.println("Removido com Sucesso");
            codeused[index] = 0;//remove o carinha
            saveState();

        }else System.out.println("Codigo de acesso nao associado!");

    }

    private static void codeRecover(String word, int[] usage){
        boolean achouum = false;
        for(int i = 0; i < MAX; i++)
        {
            if(usage[i] == 1)
            {
                if(DATAname[i].toLowerCase().contains(word.toLowerCase()))
                {
                    if(!achouum)
                    {
                        System.out.println("Lista de Funcionarios similares a busca:\n");
                        achouum = true;
                    }
                    System.out.println("> " +  DATAname[i] + " - " + DATAcode[i]);
                }
            }
        }
        if(!achouum)
        {
            System.out.println("Nenhum funcionario foi encontrado");
        }
    }

    private static void tabelinha(int index){

        System.out.println("---------------------------------------------------------\n\n" +
                "Nome do funcionario = " + DATAname[index] + "\nCódigo de Registo = " + DATAcode[index] + "\nEndereco = "
                + DATAaddress[index] + "\n" + "Agenda atual = " + DATAtype[index] +
                "\nSalario atual = RS " + DATAsalary[index] +
                "\nMetodo de Recebimento = " + DATApaymode[index] + "\nAssociado a sindicato = " + DATAsindicaty[index] +
                "\nHoras Trabalhadas no mes atual = " + horassmes[index] + " Hrs");

        System.out.println("\n\n---------------------------------------------------------\n");
    }

    private static void codeSearch(String code, int[] usage){
        boolean achouum;
        achouum = false;
        for(int i = 0; i < MAX; i++)
        {
            if(codeused[i] == 1)
            {
                if(code.equals(DATAcode[i]))
                {
                    achouum = true;
                    System.out.println("Funcionário encontrado!\n");
                    tabelinha(i);
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

    private static void diautil(){
        if(Adia >= 28 && Asemana[DAYSGONE % 7].equals("Sexta-Feira") || (Adia == 30 &&
                !Asemana[DAYSGONE % 7].equals("Domingo") && !Asemana[DAYSGONE % 7].equals("Sabado"))){
            VALID_DAY = true;
        }
    }
    private static int funcModify(String codigo, int[] usage, int sindqnt){

        Scanner input = new Scanner(System.in);
        int index = getIndex(codigo);
        boolean bk = false;
        if(codeused[index] == 1)
        {
            while(!bk) {
                System.out.println("\nOpcoes de modificacao:\n1.Modificar nome*\n2.Modificar endereco*\n" +
                        "3.Modificar Agenda de pagamento*\n4.Modificar Valor de pagamento*\n" +
                        "5.Modificar Associacao sindical*\n6.Modificar Taxa sindical*\n7.Modificar metodo de recebimento*" +
                        "\n8.Voltar para mainMenu");
                int sw = input.nextInt();
                input.nextLine();
                switch (sw) {
                    case 1:
                        System.out.print("Insira o nome do funcionário: ");
                        DATAname[index] = input.nextLine();
                        saveState();
                        break;
                    case 2:
                        System.out.print("Insira o Endereco do funcionário: ");
                        DATAaddress[index] = input.nextLine();
                        saveState();
                        break;

                    case 3:
                        System.out.println("Insira o tipo de salario atribuido ao funcionário\n" +
                                "de acordo com as opçoes abaixo:\n1- Horario (Padrao)\n2- Mensal (Padrao)\n" +
                                "3- Comissionado (Padrao)");
                        selectAGENDA();
                        int value = input.nextInt();
                        if(value == 1){DATAtype[index] = "Horario";}
                        if(value == 2){DATAtype[index]  = "Mensal";}
                        if(value == 3){DATAtype[index]  = "Comissionado";}
                        if(value >= 4)
                        {
                            DATAtype[index] = AGENDAS[value];
                            DATAagendaday[index] = AGENDAdia[value];
                            DATAagendaweek[index] = AGENDAweek[value];
                        }
                        System.out.println("Alterado com sucesso!");
                        saveState();
                        break;

                    case 4:
                        System.out.print("Insira o Salario do funcionário: "
                                + "\n");
                        DATAsalary[index] = input.nextDouble();
                        saveState();
                        break;
                    case 5:
                        System.out.print("O funcionario esta associado ao Sindicato de sua categoria ?\n" +
                                "1 - SIM / 2 - NAO\n");
                        if(!DATAsindicaty[index])
                        {
                            if(input.nextInt() == 1){
                                DATAsindicaty[index] = true;
                                DATAsindicatyc[index] = "120" + sindqnt;
                                System.out.println("Usuario Associado ao Sindicato com Codigo sindical = " +
                                        DATAsindicatyc[index]);
                                sindqnt += 1;
                            } else DATAsindicaty[index] = false;
                        }
                        saveState();
                        break;
                    case 6:
                        System.out.print("Insira a taxa sindical: ");
                        DATAsindtax[index] = input.nextDouble();
                        saveState();
                        break;
                    case 7:
                        System.out.print("Insira o Metodo de pagamento\n" +
                                "1 - Correios / 2 - Cheque / 3 - Deposito bancario\n");
                        int aux = input.nextInt();
                        if(aux == 1)
                        {
                            DATApaymode[index] = "Correios";
                        } else if(aux == 2) {
                            DATApaymode[index] = "Cheque";
                        } else DATApaymode[index] = "Deposito bancario";
                        saveState();
                        break;
                    case 8:
                        bk = true;
                        break;
                    default:
                        System.out.print("Comando invalido: ");
                        break;
                }
            }
        }
        else System.out.println("\n\nNenhum funcionario foi encontrado");
        return sindqnt;
    }

    public static void mclear(){

        int i = 0;
        while(i < 580)
        {
            System.out.println("\n");
            i += 1;
        }
    }

    private static void Clearmes(){

        for(int j = 0;  j < 1000; j++)
        {
            horassmes[j] = 0;
        }
    }
    private static void Cleardia(){

        for(int j = 0;  j < 1000; j++)
        {
            horashj[j] = 0;
        }
    }
    public static void timeChange(){
        DAYSGONE += 1;
        Cleardia();
        for(int i = 0; i < 1000; i++){
            if(codeused[i] == 1){
                WorkDays[i] += 1;
            }
        }
        int aux = Adia;

        if(Adia == 30 && Ames == 12)
        {
            Aano += 1;
            PAY_DAY = true;
        }
        Adia = Adia%30 + 1;

        if(aux == 30 && Adia == 1)
        {
            Ames = (Ames%12 + 1);
            Clearmes();
            PAY_DAY = true;
        }
        findVALIDPAYDAY();
    }

    public static void addFake(int codeusage[]){

        Calendar time = Calendar.getInstance();

        for(int i = 1; i < 251; i++){
            codeusage[i] = 1;
            DATAaddress[i] = "Exemple";
            DATApaymode[i] = "Correios";
            DATAtype[i] = "Horario";
            DATAsalary[i] = 972.1;
            DATAname[i] = "mateus" + i;
            DATAcode[i] = Integer.toString(time.get(Calendar.YEAR)) + i ;
        }

    }
    public static void welcomeScr(){
        System.out.println("--------------------------------------------------------");
        System.out.println("------               Bem vindo!                    -----");
        System.out.println("------                                             -----");
        System.out.println("------            Instrucoes de Uso:               -----");
        System.out.println("------                                             -----");
        System.out.println("------  + Siga os comandos com precisao            -----");
        System.out.println("------  + Comandos '*' simbolizam os obrigatorios  -----");
        System.out.println("------  + Datas/Horas sao fantasiosas              -----");
        System.out.println("------  + Undo/Redo validos para toda acao*        -----");
        System.out.println("------  + Senha inicial - 'admin'                  -----");
        System.out.println("------  + Duvidas - mffsp@ic.ufal.br               -----");
        System.out.println("------                                             -----");
        System.out.println("--------------------------------------------------------");

    }
    private static void pressENTER(){
        System.out.print("Press ENTER to continue...\n");
        getEnter.nextLine();
    }
    public static void main(String[] args) throws InterruptedException{
        AGENDAS[1] = "Horario";
        AGENDAS[2] = "Mensal";
        AGENDAS[2] = "Comissionado";
        clearScreen(0);
        setCode(codeused);
        setDays();
        //mclear();
        int sindqnt = 1;
        boolean usar = true;
        setDATAtype();
        //int codigo = 100;
        Scanner input = new Scanner(System.in);
        Calendar time = Calendar.getInstance();


        //DEFINIR HORINHA
        System.out.println("Tempo inicial: " + Ahora%24 + ":" + Aminuto%60) ;
        //DEFINIR HORINHA

        //INICIO
        // setAGENDA();
        // createAGENDA();
        // createAGENDA();
        // selectAGENDA();
        //searchAGENDA();
        saveState();
        while(usar == true) {
            welcomeScr();
            //mclear();
            //INICIO

            int adm = 0;
            System.out.print("\nSelecione o Tipo de acao: \n" +
                    "1 - Administrar Sistema / 2 - Bater ponto ou Lançar venda*");
            adm = input.nextInt();
            pedirSenha(adm);


            //INCIO
            boolean deusajude = false;

            clearScreen(2);


            boolean play = true;
            while (play) {

                //addFake(codeused);

                if (adm == 1) { //se for adm
                    menuPrint();
                    int action = input.nextInt();
                    input.nextLine();
                    switch (action) {

                        case 1:
                            clearScreen(0);
                            System.out.println("-------- ADICIONAR FUNCIONARIO --------\n");
                            int pos = getPos(codeused);
                            codeused[pos] = 1;

                            System.out.print("Insira o nome do funcionário: ");
                            DATAname[pos] = input.nextLine();

                            System.out.print("Insira o Endereco do funcionário: ");
                            DATAaddress[pos] = input.nextLine();

                            System.out.print("Insira o tipo de salario atribuido ao funcionário\n" +
                                    "1 - Horario / 2 - Mensal / 3 - Comissionado -> ");
                            int tipoaux = input.nextInt();
                            if(tipoaux == 1){
                                DATAtype[pos] = "Horario";
                            }else if(tipoaux == 2){
                                DATAtype[pos] = "Mensal";
                            }else if(tipoaux == 3){
                                DATAtype[pos] = "Comissionado";
                            }
                            System.out.print("Insira o Metodo de pagamento\n" +
                                    "1 - Correios / 2 - Cheque / 3 - Deposito bancario -> ");
                            int auxx = input.nextInt();
                            if(auxx == 1)
                            {
                                DATApaymode[pos] = "Correios";
                            } else if(auxx == 2) {
                                DATApaymode[pos] = "Cheque";
                            } else DATApaymode[pos] = "Deposito bancario";

                            System.out.print("Insira o salario do funcionário: ");
                            double valorzinho = input.nextDouble();
                            if(DATAtype[pos].equals("Horario"))
                            {
                                DATAhrpay[pos] = valorzinho;
                                DATAsalary[pos] = 0;
                            }
                            else {
                                DATAsalary[pos] = valorzinho;
                            }
                            DATAcode[pos] = Integer.toString(time.get(Calendar.YEAR)) + pos ;

                            System.out.print("O funcionario esta associado ao Sindicato de sua categoria?\n" +
                                    "1 - SIM / 2 - NAO -> ");

                            if (input.nextInt() == 1) {
                                System.out.print("\n---------------------------------------------------------\n");
                                clearScreen(1);

                                DATAsindicaty[pos] = true;
                                DATAsindicatyc[pos] = "1010" + pos;
                                DATAsindtax[pos] = DATAsalary[pos] * 0.10;
                                System.out.print("Usuario Associado ao Sindicato com Codigo sindical = " +
                                        DATAsindicatyc[pos] + "\nTaxa inicial = ");
                                System.out.printf("%.2fRS - 10%% do salario (Horistas sao, inicialmente, isentos)\n", DATAsindtax[pos]);

                            } else {
                                DATAsindicaty[pos] = false;
                                System.out.print("\n---------------------------------------------------------\n");
                            }

                            System.out.println("Codigo de acesso = " + DATAcode[pos] + "\nRegistrado com sucesso!" +
                                    "\n---------------------------------------------------------\n\n");
                            saveState();
                            pressENTER();
                            break;

                        case 2:
                            System.out.println("-------- REMOVER FUNCIONARIO --------\n");
                            System.out.println("Insira o código de registro: ");
                            String buscadel = input.nextLine();
                            rmvF(buscadel, codeused);
                            pressENTER();
                            break;
                        //something
                        case 3:
                            System.out.println("-------- INFORMACOES DE FUNCIONARIO --------\n");
                            System.out.print("Digite a opcao para acessar informacoes:\n\n\n1 - Buscar por código " +
                                    "\n2 - Recuperar código de funcionário por busca nominal\n");
                            int buscatipo = input.nextInt();
                            input.nextLine();

                            switch (buscatipo) {
                                case 1:
                                    System.out.println("Insira o código de registro: ");
                                    String busca = input.nextLine();
                                    clearScreen(0);
                                    codeSearch(busca, codeused);
                                    break;
                                case 2:
                                    System.out.println("Insira pelo menos uma parte do nome do funcionario \n");
                                    String recuperar = input.nextLine();
                                    codeRecover(recuperar, codeused);
                                    break;
                            }
                            pressENTER();
                            break;

                        case 4:
                            //modificar
                            System.out.println("-------- EDITAR DADOS --------\n");
                            System.out.println("Insira o código de registro: \n");
                            String codif = input.nextLine();

                            sindqnt = funcModify(codif, codeused, sindqnt);
                            break;

                        case 5:
                            System.out.println("-------- LISTAR FUNCIONARIOS --------\n");
                            clearScreen(0);
                            //hourPrint();
                            showAll(codeused);
                            pressENTER();
                            break;

                        case 6:
                            System.out.println("-------- RODAR FOLHA DE PAGAMENTO --------\n");
                            clearScreen(0);
                            rodarFolha(codeused);
                            saveState();
                            pressENTER();
                            //rodarFolha(codeused, empregado);
                            break;

                        case 7:
                            System.out.println("-------- CRIAR AGENDA DE PAGAMENTO --------\n");
                            clearScreen(0);
                            createAGENDA();
                            pressENTER();
                            break;

                        case 8:
                            diautil();
                            int auxiliandinho = Ahora;
                            Ahora = (Ahora + 1)%24;
                            if(Ahora == 0 && auxiliandinho == 23)
                            {
                                PAY_DAY = true;
                                timeChange();
                            }
                            System.out.println("Hora aumentada em 1hr\nHora atual = " + Ahora + ":" + Aminuto );
                            clearScreen(2);
                            break;

                        case 9:
                            diautil();
                            PAY_DAY = true;
                            int aux = Adia;
                            timeChange();
                            System.out.println("Dia aumentado em 1 = " + Adia + " / " + Ames + " / " + Aano);
                            clearScreen(2);
                            break;

                        // case "w":
                        // System.out.println("MAYBE");
                        // break;
                        case 10:
                            clearScreen(0);
                            undo();
                            pressENTER();
                            break;
                        case 11:
                            clearScreen(0);
                            redo();
                            pressENTER();
                            break;
                        case 0:
                            play = false;
                            System.out.println("Saindo do sistema, bom dia!");
                            clearScreen(2);
                            break;

                        default:
                            System.out.println("Comando invalido, tente novamente!");
                            clearScreen(2);
                    }
                } else if (adm == 2) {
                    //BAter ponto, etc;

                    int action_f = 0;
                    System.out.println("\n\n>>>> Escolha uma ação:\n\n1.Lancar cartao de ponto\n2.Lancar resultado de venda\n3.Lancar taxa de servico sindical");
                    action_f = input.nextInt();
                    input.nextLine();
                    switch(action_f)
                    {

                        case 1:
                            //getchar
                            System.out.println("-------- BATER PONTO --------\n");
                            System.out.print("Insira seu codigo de acesso: ");
                            String codinho = input.nextLine();
                            baterPonto(codeused, codinho);
                            saveState();
                            pressENTER();
                            break;
                        case 2:
                            System.out.println("-------- LANCAR VENDA --------\n");
                            int lugarzinho = 0;
                            while(true) {

                                System.out.print("Insira um codigo de acesso valido: ");
                                String coisinhu = input.nextLine();
                                lugarzinho = getIndex(coisinhu);
                                if (codeused[lugarzinho] == 1) {
                                    break;
                                }
                            }
                            System.out.print("Insira o valor da venda: ");
                            double valor = input.nextDouble();
                            System.out.print("Insira o dia em que a venda foi efetuada: ");
                            int sellday = input.nextInt();
                            System.out.println("Percentual de venda atual = 15%\n" +
                                    "Valor adicionado em conta com sucesso!");
                            DATAsalary[lugarzinho] += valor * DATAcomissao[lugarzinho]/100;
                            System.out.println("\n-------------------------------------");;
                            System.out.println("Nome do empregado = "+  DATAname[lugarzinho]);
                            System.out.println("Valor de venda = " + valor + "RS");
                            System.out.println("Salario atualizado = " + DATAsalary[lugarzinho] + "RS");
                            System.out.println("Data de venda = " + sellday + "/" + Ames + "/" + Aano);
                            System.out.println("-------------------------------------");
                            saveState();
                            pressENTER();
                            clearScreen(2);
                            break;
                        case 3:
                            //getchar
                            int vvv = 0;
                            System.out.println("-------- LANCAR TAXA SINDICAL --------\n");
                            while(true)
                            {
                                System.out.print("Insira seu codigo de acesso sindical: ");
                                String codinhovvv = input.nextLine();
                                vvv = getIndex(codinhovvv);
                                if(DATAsindicaty[vvv])
                                {
                                    break;
                                }
                                else System.out.println("Codigo nao associado ao sindicato, tente novamente!");
                            }

                            System.out.print("Insira o valor da taxa prestada: ");
                            double valorvvv = input.nextDouble();


                            DATAsalary[vvv] -= valorvvv;
                            System.out.println("\n-------------------------------------");
                            System.out.println("Nome do empregado = " + DATAname[vvv]);
                            System.out.println("Valor de Taxa = " + valorvvv + "RS");
                            System.out.println("Salario atualizado = " + DATAsalary[vvv] + "RS");
                            System.out.println("Data do servico = " + Adia + "/" + Ames + "/" + Aano);
                            System.out.println("-------------------------------------");
                            saveState();
                            pressENTER();
                            break;
                    }
                    break;
                } else {
                    System.out.println("Comando invalido, tente novamente!");
                    clearScreen(2);
                    play = false;
                }
            }
        }
    }
}
//
