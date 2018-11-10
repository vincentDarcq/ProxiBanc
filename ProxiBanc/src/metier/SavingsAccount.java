package metier;


public class SavingsAccount extends Account {
	
public String numberAccount;
public Double balance;
public String creationDate;
	

	public SavingsAccount() {
		
	}
	
	public SavingsAccount(String numberAccount, Double balance, String creationDate) {
		this.numberAccount = numberAccount;
		this.balance = balance;
		this.creationDate = creationDate;
}
}