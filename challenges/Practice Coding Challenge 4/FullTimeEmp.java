/*
 * This class holds data for full time employees
 */
public class FullTimeEmp extends Employee
{
	private double salary;
	/**
	 * This constructor accepts as arguments the name, IDNum, and salary
	 */
	public FullTimeEmp(String name, String IDNum, double salary) 
	{
		super(name, IDNum);
		this.salary = salary;
	}
	/*
	 * This method returns the employee's monthly pay
	 */
	@Override
	public double getMonthlyPay() 
	{
		return salary / 12;
	}
	/*
	 * This method returns the employee's employment status
	 */
	@Override
	public String getStatus() 
	{
		return "Full time employee";
	}
	/*
	 * This is the setter method for salary
	 */
	public void setSalary(int amount)
	{
		salary = amount;
	}
}