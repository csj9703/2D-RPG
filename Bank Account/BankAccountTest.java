import static org.junit.Assert.*;

import org.junit.Test;

public class BankAccountTest{
    
	// Testing deposit
	@Test
    public void test1(){
        BankAccount b = new BankAccount();
        assertEquals("Expected initial balance to be 0.0", 0.0, b.getBalance(), 0.0);
    }
    
	@Test
    public void test2() {
        BankAccount b = new BankAccount();
        b.deposit(10.25);
        assertEquals("Deposited 10.25.", 10.25, b.getBalance(), 0.0);
    }
    
	@Test
    public void test3() {
        BankAccount b = new BankAccount();
        b.deposit(10.25);
        b.deposit(21945.67);
        assertEquals("Deposited first 10.25 then 21945.67", 21955.92, b.getBalance(), 0.0);
    }
    
	@Test
    public void test4() {
        BankAccount b = new BankAccount();
        b.deposit(-10.25);
        assertEquals("Tried to deposit a negative amount", 0.00, b.getBalance(), 0.0);
    }
        
    // testing withdraw
	@Test
    public void test5() {
        BankAccount b = new BankAccount();
        b.deposit(500.00);
        b.withdraw(44.25);
        assertEquals("Withdrew 44.25 after depositing 500.00", 455.75, b.getBalance(), 0.0);
    }
    
	@Test
    public void test6() {
        BankAccount b = new BankAccount();
        b.deposit(399.99);
        b.withdraw(399.99);
        assertEquals("Withdrew 399.99 after depositing 399.99", 0.0, b.getBalance(), 0.0);
    }
    
	@Test
    public void test7() {
        BankAccount b = new BankAccount();
        b.deposit(5.00);
        b.withdraw(5.01);
        assertEquals("Withdrew 5.01 after depositing 5.00", 5.00, b.getBalance(), 0.0);
    }
    
    // testing transfer
	@Test
    public void test11() {
        BankAccount b = new BankAccount();
        b.deposit(12345.67);
        BankAccount b2 = new BankAccount();
        b.transfer(12.34, b2);
        assertEquals("After transfer, expected from account to go from balance 12345.67 to 12334.33", 12333.33, b.getBalance(), 0.0);
        assertEquals("After transfer, expected to account to go from balance 0.00 to 12.34", 12.34, b2.getBalance(), 0.0);
    }
    
	@Test
    public void test12() {
        BankAccount b = new BankAccount();
        b.deposit(12345.67);
        BankAccount b2 = new BankAccount();
        b.transfer(12345.67, b2);
        assertEquals("After transfer, expected from account to go from balance 12345.67 to 0.00", 0.0, b.getBalance(), 0.0);
        assertEquals("After transfer, expected to account to go from balance 0.00 to 12345.67", 12345.67, b2.getBalance(), 0.0);
    }
    
	@Test
    public void test13() {
        BankAccount b = new BankAccount();
        b.deposit(12345.67);
        BankAccount b2 = new BankAccount();
        b.transfer(12345.68, b2);
        assertEquals("Expected balance in from account unchanged (overdraft).", 12345.67, b.getBalance(), 0.0);
        assertEquals("Expected balance in to account unchanged (overdraft)", 0.00, b2.getBalance(), 0.0);
    }
}
