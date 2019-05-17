import java.sql.SQLOutput;
import java.time.DayOfWeek;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class Main {
	final int MAX = 1000;


	    //TIME

	private static int Ahora = 15;
	private static int Aminuto = 20;
	private static int Adia = 26;
	private static int Ames = 11;
	private static int Aano = 2019;

	    //TIME

	   	//Banco de dados

	private static String[] DATAname = new String[1000];
	private static String[] DATAaddress = new String[1000];
	private static String[] DATAtype = new String[1000];
	private static double[] DATAsalary = new double[1000];
	private static boolean[] DATAsindicaty = new boolean[1000];
	private static String[] DATAcode = new String[1000];
	private static String[] DATAsindicatyc = new String[1000];
	private static double[] DATAsindtax = new double[1000] ;
	private static int[] DATApaymode = new int[1000]; 
	private static int[] DATAworktime = new int[1000]; 
	    	//entrada
	private static int[] Ehora = new int[1000];
	private static int[] Eminuto = new int[1000];
	private static int[] Esegundo = new int[1000];
	    	//saida
	private static int[] Shora = new int[1000];
	private static int[] Sminuto = new int[1000];
	private static int[] Ssegundo = new int[1000];
	    	//Date
	private static String[] Etime = new String[1000];
	private static String[] Stime = new String[1000];

	    //Banco de dados


	//UNDONE REDONE

	//O MESMO DE CIMA



	    //Senha de acesso
	private static void pedirSenha(int valor)
	{
		Scanner input = new Scanner(System.in);

		if(valor == 1)
		{
			System.out.println("\n\nDigite a senha de acesso:\n");
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



	private static void baterPonto(int[] codeused, String codinho){

		int index = getIndex(codinho);
		Scanner input = new Scanner(System.in);
		Calendar time = Calendar.getInstance();

		if(codeused[index] == 1)
		{
			System.out.println("Bem Vindo - " + DATAname[index] + "\n" );
			while(true)
			{
				System.out.println("\n1 - Registrar Entrada / 2 - Registrar Saida");
				int type = input.nextInt();
				if(type == 1)
				{
					System.out.println("Hora de Chegada = " + Ahora + ":" + Aminuto);
					Etime[index] = Ahora + ":" + Aminuto;
					break;
				}if(type == 2) {
					System.out.println("Hora de Saida = " + Ahora + ":" + Aminuto);
					Stime[index] = Ahora + ":" + Aminuto;
					
					break;
				}else System.out.println("Valor incorreto, tente novamente!\n");
			}
			System.out.println("\nPonto batido com sucesso");

		} else System.out.println("\nCodigo incorreto , Saindo do Sistema!\n");

	}



	private static void menuPrint()
	{
		System.out.println(Adia + " / " + Ames + " / " + Aano + "\n" + Ahora + ":" + Aminuto );
		System.out.println("\n\n>>>> Escolha uma ação:\n\n1.Adcionar funcionário ao Sistema\n" +
			"2.Remover funcionário do Sistema\n3.Acessar informações de um funcio" +
			"nário\n4.Modificar Informacoes de funcionario\n5.Listar todos os funcionarios cadastrados" +
			"\n6.Rodar folha de pagamento\n"+
			"7.Passar Hora\n" + "8.Passar o dia\n" +
			"9.Sair do Sistema\n");
	}

	private static void setCode(int[] code) {
		for(int i = 0; i < 1000; i++) {
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

	private static void showAll(int[] usage) {
		boolean achouum = false;

		for(int i = 1; i < 1000; i++)
		{
			if(usage[i] == 1)
			{
				if(!achouum)
				{
					System.out.println("\n\nLista de Funcionarios :\n" + "----------------------------------" +
						"-----------------------\n");
					achouum = true;
				}
				System.out.println("> " +  DATAname[i] + " - " + DATAcode[i]);
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

	    private static void codeRecover(String word, int[] usage){
	    	boolean achouum = false;
	    	for(int i = 0; i < 1000; i++)
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
	    		"Funcionário = " + DATAname[index] + "\nEndereco = "
	    		+ DATAaddress[index] + "\nTipo de salario aplicado (" + DATAtype[index]
	    		+ ") : Valor = RS " + DATAsalary[index] +
	    		"\nMetodo de Recebimento = " + DATApaymode[index] +	
	    		"\nCódigo de Registo = " + DATAcode[index] + "\n\n---------------------------------------------------------\n");

	    }

	    private static void codeSearch(String code, int[] usage){
	    	boolean achouum;
	    	achouum = false;
	    	for(int i = 0; i < 1000; i++)
	    	{
	    		if(usage[i] == 1)
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

	    private static int funcModify(String codigo, int[] usage, int sindqnt){
	    	Scanner input = new Scanner(System.in);
	    	int index = getIndex(codigo);
	    	boolean bk = false;
	    	if(usage[index] == 1)
	    	{
	    		while(!bk) {
	    			System.out.println("\nOpcoes de modificacao:\n1.Modificar nome\n2.Modificar endereco\n" +
	    				"3.Modificar tipo de pagamento\n4.Modificar Valor de pagamento\n" +
	    				"5.Modificar Associacao sindical\n6.Modificar Taxa sindical\n7.Modificar metodo de recebimento" +
	    				"\n8.Voltar para mainMenu");
	    			int sw = input.nextInt();
	    			input.nextLine();
	    			switch (sw) {
	    				case 1:
	    				System.out.print("Insira o nome do funcionário: ");
	    				DATAname[index] = input.nextLine();
	    				break;
	    				case 2:
	    				System.out.print("Insira o Endereco do funcionário: ");
	    				DATAaddress[index] = input.nextLine();
	    				break;
	    				case 3:
	    				System.out.print("Insira o tipo de salario atribuido ao funcionário\n" +
	    					"(Horario, Mensal, Comissionado)\n");
	    				DATAtype[index] = input.nextLine();
	    				break;
	    				case 4:
	    				System.out.print("Insira o Salario do funcionário: "
	    					+ "\n");
	    				DATAsalary[index] = input.nextDouble();
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
	    				break;
	    				case 6:
	    				System.out.print("Insira a taxa sindical: ");
	    				DATAsindtax[index] = input.nextDouble();
	    				break;
	    				case 7:
	    				System.out.print("Insira o Metodo de pagamento\n" +
	    					"1 - Correios / 2 - Cheque / 3 - Deposito bancario\n");
	    				DATApaymode[index] = input.nextInt();
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

	    public static void timeChange(){
	    	int aux = Adia;

	    	if(Adia == 30 && Ames == 12)
	        {
	            Aano += 1;
	        }
	        Adia = Adia%30 + 1;

	        if(aux == 30 && Adia == 1)
	        {
	        	Ames = (Ames%12 + 1);
	        }
	    }


	    public static void main(String[] args) {

	    	//mclear();
	    	int sindqnt = 1;
	    	boolean usar = true;
	    	int[] codeused = new int[1000];

	    	setCode(codeused);
	        //int codigo = 100;
	    	Scanner input = new Scanner(System.in);
	    	Calendar time = Calendar.getInstance();


	    	//DEFINIR HORINHA
	    	System.out.println("Tempo inicial: " + Ahora%24 + ":" + Aminuto%60)	;
	    	//DEFINIR HORINHA
	    	
	        //INICIO
	    	while(usar == true) {

	        	//mclear();
	            //INICIO

	    		int adm = 0;
	    		System.out.println("\nSelecione o Tipo de acao: \n" +
	    			"1 - Administrar Sistema / 2 - Bater ponto\n");
	    		adm = input.nextInt();
	    		pedirSenha(adm);


	            //INCIO

	    		boolean play = true;
	    		while (play) {

	                if (adm == 1) { //se for adm
	                	menuPrint();
	                	int action = input.nextInt();
	                	input.nextLine();
	                	switch (action) {

	                		case 1:
	                		int pos = getPos(codeused);

	                		System.out.print("Insira o nome do funcionário: ");
	                		DATAname[pos] = input.nextLine();

	                		System.out.print("Insira o Endereco do funcionário: ");
	                		DATAaddress[pos] = input.nextLine();

	                		System.out.print("Insira o tipo de salario atribuido ao funcionário\n" +
	                			"(Horario, Mensal, Comissionado)\n");
	                		DATAtype[pos] = input.nextLine();

	                		System.out.print("Insira o Metodo de pagamento\n" +
	                			"1 - Correios / 2 - Cheque / 3 - Deposito bancario\n");
	                		DATApaymode[pos] = input.nextInt();

	                		System.out.print("Insira o Salario do funcionário: "
	                			+ "\n");
	                		DATAsalary[pos] = input.nextDouble();
	                		DATAcode[pos] = Integer.toString(time.get(Calendar.YEAR)) + pos ;

	                		System.out.print("O funcionario esta associado ao Sindicato de sua categoria ?\n" +
	                			"1 - SIM / 2 - NAO\n");
	                		if (input.nextInt() == 1) {
	                			DATAsindicaty[pos] = true;
	                			DATAsindicatyc[pos] = "120" + sindqnt;
	                			System.out.println("Usuario Associado ao Sindicato com Codigo sindical = " +
	                				DATAsindicatyc[pos]);
	                			sindqnt += 1;
	                		} else DATAsindicaty[pos] = false;

	                		System.out.println("Registrado com sucesso\n\n\nCodigo de acesso = " + DATAcode[pos] + "\n");
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

	                		switch (buscatipo) {
	                			case 1:
	                			System.out.println("Insira o código de registro: \n");
	                			String busca = input.nextLine();
	                			codeSearch(busca, codeused);
	                			break;
	                			case 2:
	                			System.out.println("Insira pelo menos uma parte do nome do funcionario \n");
	                			String recuperar = input.nextLine();
	                			codeRecover(recuperar, codeused);
	                			break;
	                		}
	                		break;

	                		case 4:
	                            //modificar
	                		System.out.println("Insira o código de registro: \n");
	                		String codif = input.nextLine();

	                		sindqnt = funcModify(codif, codeused, sindqnt);
	                		break;

	                		case 5:
	                		showAll(codeused);
	                		break;

	                		case 6:

	                		if (time.get(Calendar.DAY_OF_WEEK) == 6) {
	                                //something to pay;
	                		}
	                            //rodarFolha(codeused, empregado);
	                		break;

	                		case 7:
	                		int auxiliandinho = Ahora;
	                		Ahora = (Ahora + 1)%24;	
	                		if(Ahora == 0 && auxiliandinho == 23)
	                		{
	                			timeChange();
	                		}
	                		System.out.println("Hora aumentada em 1hr\nHora atual = " + Ahora + ":" + Aminuto );
	                		break;

	                		case 8:

	                		int aux = Adia;
	                		timeChange();
	               
	                		System.out.println("Dia aumentado em 1 = " + Adia + " / " + Ames + " / " + Aano);
	                		break;

	                		case 9:
	                		play = false;
	                		System.out.println("Saindo do sistema, bom dia!");
	                		break;

	                		default:
	                		System.out.println("Comando invalido, tente novamente!");
	                	}
	                } else if (adm == 2) {
	                    //BAter ponto, etc;
	                    input.nextLine(); //getchar
	                    System.out.println("Insira seu codigo de acesso");
	                    String codinho = input.nextLine();
	                    baterPonto(codeused, codinho);
	                    break;
	                } else {
	                	System.out.println("Comando invalido, tente novamente!");
	                	play = false;
	                }
	            }
	        }
	    }
	}

	    //Rodar folha de pagamento;
	    //Para horistas, se for sexta
	    //Para mensal, Se for ultimo dia util do mes
	    //Para comissionados, comissao%porvenda

	//    private static void rodarFolha(int[] codeused, Empregado[] empregado){
	//
	//        for(int i = 1; i < 100; i++)
	//        {
	//            if(codeused[i] == 1)
	//            {
	//               if(empregado[i].getPayMode().equals("Horario"))
	//               {
	//
	//               }
	//
	//            }
	//        }
	//
	//    }
