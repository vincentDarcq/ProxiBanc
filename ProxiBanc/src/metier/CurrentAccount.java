package metier;


public class CurrentAccount extends Account {
	
	public String numberAccount;
	public Double balance;
	public String creationDate;
	
	public CurrentAccount() {
		
	} 
	
	public CurrentAccount(String numberAccount, double balance,String creationDate) {
		this.numberAccount = numberAccount;
		this.balance = balance;
		this.creationDate = creationDate;
	}
}
  