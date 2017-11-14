/*
 * The Employee class is a abstract class that holds 
 * the name and IDNum, classes representing a employee
 * should inherit from this class
 */
public abstract class Employee 
{
	private String name;
	private String IDNum;
	/*
	 * This constructor accepts the strings, 
	 * name and IDNum as parameters
	 * @param name The name of the employee
	 * @param IDNum The id number of the employee
	 */
	public Employee(String name, String IDNum)
	{
		this.name = name;
		this.IDNum = IDNum;
	}
	/*
	 * This is the getter method for IDNum, returns IDNum
	 */
	public String getIDNum()
	{
		return IDNum;
	}
	/*
	 * This is the getter method for name, returns name
	 */
	public String getName()
	{
		return name;
	}
	/*
	 * This method deducts 10% tax from the monthly pay 
	 * and returns the result
	 */
	public double calculateMonthlyPay()
	{
		return getMonthlyPay() * 0.9;
	}
	/*
	 * This method returns a string which contains 
	 * all the employee's information
	 */
	public String toStr()
	{
		return "IDNum: " + IDNum + " Name: " + name + " MonthlyPay: " 
	    + calculateMonthlyPay() + " Status: " + getStatus();
	}
	/*
	 * This abstract method does nothing and must
	 * be overridden in a subclass
	 */
	public abstract double getMonthlyPay();
	/*
	 * This abstract method does nothing and must
	 * be overridden in a subclass
	 */
	public abstract String getStatus();
}