package com.payroll;

public class Calender {
	
	 static int Ahora = 15;
	 static int Aminuto = 20;
	 static int Adia = 1;
	 static int Ames = 6;
	 static int Aano = 2019;
	 static int DAYSGONE = 0;
	 
	
	 public static String valueToString(int value) {
		 if(value < 10) {
			 return "0" + value;
		 }
		 else return Integer.toString(value);
	 }
	 
	 public static void passHour() {
		 
		 int auxiliandinho = Ahora;
		 
		 Ahora = (Ahora + 1) % 24;
	     if(Ahora == 0 && auxiliandinho == 23)
	     {
	         //PAY_DAY = true;
	         timeChange();
	     }
	 }
     
	 public static void timeChange(){
	        DAYSGONE += 1;
	        
	        int aux = Adia;

	        if(Adia == 30 && Ames == 12)
	        {
	            Aano += 1;
	            //PAY_DAY = true;
	        }
	        Adia = Adia%30 + 1;

	        if(aux == 30 && Adia == 1)
	        {
	            Ames = (Ames%12 + 1);
	            //PAY_DAY = true;
	        }
	        //findVALIDPAYDAY();
	    }

}
