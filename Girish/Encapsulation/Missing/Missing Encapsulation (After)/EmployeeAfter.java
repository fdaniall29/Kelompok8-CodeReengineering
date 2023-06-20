
public class Employee {

    public String name;
    public String gender;
    public int age;
    public double salary;
    
    public double salaryIncrease (double amount){
        if(this.salary > 0){
            this.salary += amount*0.8;
        }else if(this.salary > 500){
            this.salary += amount*0.6;
        }else{
            this.salary += amount*0.4;
        }
        return salary;
    }
   
    public void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Gender: " + this.gender);
        System.out.println("Age: " + this.age);
        System.out.println("Salary: " + this.salary);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
   
    
}
