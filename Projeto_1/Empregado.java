public class Empregado {

    public String name;
    public String address;
    public String type;
    public double salary;
//    public double hour_salary;
//    public double month_salary;
//    public double comission;
    public String code;

    //verifica codigo


    //set
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

    public void delete () {
        //this.name = name;
    }


    public void tabelinha(){
        System.out.println("Funcionário: " + this.name + "\nEndereco = "
        + this.address + "\nTipo de salario aplicado: " + this.type
        + "Valor = RS " + this.salary +
                "\nCódigo de Registo : " + this.code);
    }
    //get
    public String getName() {
        return name;
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
}
