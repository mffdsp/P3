public class Empregado {

    public String name;
    public String address;
    public String type;
    public double hour_salary;
    public double month_salary;
    public double comission;
    public int code;


        public void addName (String name){
            this.name = name;
        }
        public void addAdress (String address){
            this.address = address;
        }
        public void addType (String type){
            this.type = type;
        }
        public void addSalary ( int hour_salary, int month_salary){
            this.hour_salary = hour_salary;
            this.month_salary = month_salary;
        }
        public void addCode ( int code){
            this.code = code;
        }
        public void addComission ( double comission){
            this.comission = comission;
        }
        public void delete () {
            //this.name = name;
        }


}
