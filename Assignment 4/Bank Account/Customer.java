/**
 * This is the customer class
 * for the banking application
 * @author Nathaly Verwaal
 */
public class Customer 
{
	private String name;
	private int id;
	
	public Customer(String aName, int anID)
	{
		name = aName;
		id = anID;
	}
	
	public Customer(Customer toCopy) 
	{
		name = toCopy.name;
		id = toCopy.id;
	}
	
	public boolean equals(Customer otherCustomer)
	{
		return name.equals(otherCustomer.name) && id == otherCustomer.id;
	}
	
	public void setName(String aName) 
	{
		name = aName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getID() 
	{
		return id;
	}
}