/*
 * This class holds data for part time employees
 */
public class PartTimeEmp extends Employee
{
	private int hours;
	private double hourlyRate;
	/**
	 * This constructor accepts as arguments the name, IDNum, and hourlyRate
	 */
	public PartTimeEmp(String name, String IDNum, double hourlyRate) 
	{
		super(name, IDNum);
		this.hourlyRate = hourlyRate;
	}
	/*
	 * This method returns the employee's monthly pay
	 */
	@Override
	public double getMonthlyPay() 
	{
		return hourlyRate * hours;
	}
	
	
	public void addToHours(int amount)
	{
		hours += amount;
	}
	/*
	 * This method returns the employee's employment status
	 */
	@Override
	public String getStatus() 
	{
		return "Part time employee";
	}
	/*
	 * This method deducts 10% tax from the monthly pay 
	 * and resets the hours to zero after the calculation
	 */
	@Override
	public double calculateMonthlyPay()
	{
		double thisPay = super.calculateMonthlyPay();
		hours = 0;
		return thisPay;
	}
}