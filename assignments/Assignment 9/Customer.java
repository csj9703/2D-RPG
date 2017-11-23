public class Customer {
	private String name;
	private int id;
	
	public Customer(String aName, int anID){
		super();
		name = aName;
		id = anID;
	}
	
	public Customer(Customer toCopy) {
		name = toCopy.name;
		id = toCopy.id;
	}
	
	public String toString() {
		return name;
	}
	
	public boolean equals(Customer otherCustomer){
		return name.equals(otherCustomer.name) && id == otherCustomer.id;
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public String getName(){
		return name;
	}
	
	public void setID(int aID) {
		id = aID;
	}
	
	public int getID() {
		return id;
	}
}