import java.util.Scanner'
public class RunEmployee{
	public static void main(String args[]) {
		class Employee{
			String name;

			public void setName(String Name){
				this.name = Name;
			}

			public String getName(){
				return this.name;
			}
		}//end of Employee class
		class FullTimeEmployee extends Employee{
			double monthlySalary;

			public void setMonthlySalary(double MonthlySalary){
				this.monthlySalary = MonthlySalary;
			}

			public double getMonthlySalary(){
				return this.monthlySalary;
			}
		}//end of FullTimeEmployee class

		class PartTimeEmployee extends Employment{
			double ratePerHour;
			int hoursWorked;
			double wage;

			public void setWage(double rpwork, int hwork ){
				this.ratePerHour = rpwork;
				this.hoursWorked = hwork;
				this.wage = rpwork*hwork;
			}
			public double getWage(){
				retuen this.wage;
			}
		}//end of partTimeEmployee class

		String name, employeeStatus;
		double monthlySalary, ratePerHour;
		int hoursWorked;

		Scanner scan = new Scanner(System.in);
		Employee emp = new Employee();
		FullTimeEmployee Ftemp = new FullTimeEmployee();
		PartTimeEmployee Ptemp = new PartTimeEmployee();

		System.out.println("Enter name: ");
		name = scan.nextLine();
		emp.setName(name);

		System.out.println("press F for Full Time or P for Part Time");
		employeeStatus = scan.next();

		if (employeeStatus.equalsIgnoreCase("f")){

			System.out.println("Enter monthly salary: ");
			monthlySalary = scan.nextDouble();
			FTemp.setMonthlySalary(monthlySalary);
			System.out.println("Name: "+ emp.getName());
			System.out.print("Monthly Salary: ");
			System.out.format(" %.2f", Ftemp.getMonthlySalary());
		}
		else if(employeeStatus.equlasIgnoreCase("p")){

			System.out.println("Enter rate per hour and no. of hours worked separated by space: ");
			System.out.println("Sample: 107.50 13");
			ratePerHour = scan.nextDouble();
			hoursWorked = scan.nextInt();
			Ptemp.setWage(ratePerHour,hoursWorked);
			System.out.println("Name: "+ emp.getName());
			System.out.print("wage:");
			System.out.format(" %.2f", PTemp.getWage());
		}

		else{
			System.out.println("Invalid Input!")
		}
	}

}