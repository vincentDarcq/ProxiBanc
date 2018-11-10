package metier;


public class Customer {

	public String lastname;
	public String firstname;
	public String adress;
	public int postalCode;
	public String city;
	public String tel;
	public CurrentAccount currentAccount;
	public SavingsAccount savingsAccount;
	public Card card;
	 
		
			/**
			 * Constructeur par défaut
			 */
			public Customer () {
				
			}
			/**
			 * Constructeur d'initialisation prenant 
			 * lastname, firstname et adress du client en paramètres.
			 */
			public Customer(String lastname, String firstname, String adress,
					int postalCode, String city, String tel, CurrentAccount currentAccount, SavingsAccount savingsAccount, Card card) {
			this.lastname = lastname;
			this.firstname = firstname;
			this.adress = adress;
			this.postalCode = postalCode;
			this.city = city;
			this.tel= tel;

		}
			@Override
			public String toString() {
				return ("\n" + this.firstname + " " + this.lastname + " " + this.adress + " " + this.postalCode + " " 
			+ this.city + " " + this.tel + " " + this.currentAccount + " " + this.savingsAccount + " " + this.card);	
				}		

			public boolean cardExist() {
				if (this.card !=null) {
					return true;
				}
				else {
					return false;
				}
			}
		} 