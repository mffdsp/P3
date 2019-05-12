import java.util.Date;

public class Empregado {

    public String name;
    public String address;
    public String type;
    public double salary;
    public boolean sindicaty;
    public String code;
    public String sindicatyc;
    public double sindtax;
    public int paymode; //1 - correios, 2 - Maos, 3 - Conta bancaria.




    //----------------------------------------------------------------------

    //Bater ponto
    public Date entrada;
    public Date saida;

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    //----------------------------------------------------------------------


    //    public double hour_salary;
    //    public double month_salary;
    //    public double comission;
    //    verifica codigo



    //----------------------------------------------------------------------
    //set

    public void setPayMode (int paymode){
        this.paymode = paymode;
    }
    public void setName (String name){
        this.name = name;
    }
    public void setAdress (String address){
        this.address = address;
    }
    public void setType (String type){
        this.type = type;
    }
    public void setSalary ( double salary){
        this.salary = salary;
    }
    public void setCode ( String code){
        this.code = code;
    }

    public void setSindicaty(boolean sindicaty) {
        this.sindicaty = sindicaty;
    }
    public void setSindicatyc (String sindicatyc){
        this.sindicatyc = sindicatyc;
    }
    public void setSindtax (double tax){
        this.sindtax = tax;
    }

    //verifica se é sindicato
    public boolean isSindicaty() {
        return sindicaty;
    }

    public void delete () {
        //this.name = name;
    }
    //----------------------------------------------------------------------





    //----------------------------------------------------------------------
    //get

    public String getName() {
        return name;
    }
    public String getCode() {
        return this.code;
    }
    public String getSindicatyc (){
        return sindicatyc;
    }
    public String getAddress() {
        return address;
    }
    public String getType() {
        return type;
    }
    public double getSalary() {
        return salary;
    }
    public double getSindtax (){
        return this.sindtax;
    }
    public String getPayMode (){

        switch(this.paymode)
        {
            case 1:
                return "Correios";
            case 2:
                return "Chegue em maos";
            case 3:
                return "Conta bancaria";
        }
        return "ERROR";
    }
    //----------------------------------------------------------------------







    public void tabelinha(){

        System.out.println("---------------------------------------------------------\n" +
                "Funcionário = " + this.name + "\nEndereco = "
                + this.address + "\nTipo de salario aplicado (" + this.type
                + ") : Valor = RS " + this.salary +
                "\nMetodo de Recebimento = " + this.getPayMode() +
                "\nCódigo de Registo = " + this.code+ "\n---------------------------------------------------------\n");
    }

}
