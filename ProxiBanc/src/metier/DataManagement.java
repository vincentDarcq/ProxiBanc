package metier;

import java.util.ArrayList;

import metier.Advisor;
import metier.Customer;
import persistence.Data;
import presentation.Interaction;

/**
 * Classe qui gère les méthodes principales d'opération de l'utilisateur *
 */
public class DataManagement {

	
	Interaction interaction = new Interaction();
	Data data = new Data();
	public Advisor advisor = new Advisor();
	public boolean running = true;
	public Customer customer = new Customer(); 
	public CurrentAccount currentAccount= new CurrentAccount();
	public SavingsAccount savingsAccount= new SavingsAccount();
	public Card card = new Card();

	/**
	 *Constructeur par défaut.
	 */
	public DataManagement() {
			}

	/**
	 *Cette méthode démarre le programme 
	 *Elle ouvre le menu princiapl de l'application*/
	public void start() {
		this.data.loadTestData();
		while (this.running) { 
			this.interaction.mainMenu();
			this.manageMainMenu();				
			}
		} 	
	/**
	 * Cette méthode donne à l'utilisateur la possibilité 
	 * d'effectuer les opérations:
	 *- lecture des données client, 
	 *- réaliser un transfert
	 *- réaliser une simulation de crédit 
	 *- quitter le menu
	 */
	public void customerFile() {
		String userInput2 = this.interaction.readData();
		if (userInput2.equals("1")) {
			this.readCustomer();
		}
		else if (userInput2.equals("2")) {
			this.makeTransfer();
		}
		else if (userInput2.equals("3")) {
			this.creditSimulation();
		}
		else if (userInput2.equals("4")) {
			this.exitProxibanque();
		}
		else {
				this.interaction.display("Erreur : veuillez renseigner le chiffre correspondant à l'action que vous souhaitez");
			}
	}
	/**Cette méthode donne à l'utilisateur la possibilité 
	 * de choisir l'opération qu'il veut réaliser sur le dossier 
	 * d'un client*/
	public void manageCustomer() {
		String userInput1 = this.interaction.readData();
		if (userInput1.equals("1")) {
			this.interaction.display("Pour le client " + this.customer.lastname + " " + this.customer.firstname + " : ");
			this.interaction.customerFileMenu();
			this.customerFile();
		}
		else if (userInput1.equals("2")) {
			this.modifyCustomer();
		}
		else if (userInput1.equals("3")) {
			this.deleteCustomer();
		}
		else if (userInput1.equals("4")) {
			this.selectCustomer();
		}
		else if (userInput1.equals("5")) {
			this.exitProxibanque();
		}
		else {
				this.interaction.display("Erreur : veuillez renseigner le chiffre correspondant à l'action que vous souhaitez");
			}
	}	
	/**Cette méthode donne à l'utilisateur le choix entre
	 * créer un client
	 * selectionner un client
	 * quitter l'application
	 */
	
	public void manageMainMenu() {
		String userInput = this.interaction.readData();	
		if (userInput.equals("1")) {
			this.createCustomer();
		}
		else if (userInput.equals("2")) {
			this.selectCustomer();
		}
		else if (userInput.equals("3")) {
			this.exitProxibanque();
		}
		else {
				this.interaction.display("Erreur : veuillez renseigner le chiffre correspondant à l'action que vous souhaitez");
	}
	}	
	/**
	 * Cette méthode quitte l'application
	 */
	private void exitProxibanque() {
		this.running = false;
	}
	
	/**
	 * Cette méthode créee un dossier nouveau client
	 */
	public void createCustomer() {
		Interaction interaction = new Interaction();
		interaction.display("Saisir le nom du client");
		this.customer.lastname= interaction.readData();
		interaction.display("Saisir le prénom du client");
		this.customer.firstname = interaction.readData();
		interaction.display("Saisir l'adresse du client");
		this.customer.adress = interaction.readData();
		interaction.display("Saisir le code postal du client");
		this.customer.postalCode = Integer.parseInt(interaction.readData());
		interaction.display("Saisir la ville du client");
		this.customer.city = interaction.readData();
		interaction.display("Saisir le téléphone du client");
		this.customer.tel = interaction.readData();
		interaction.display("Saisir le numéro de compte courant du client");
		this.currentAccount.numberAccount = interaction.readData();
		interaction.display("Le client a t-il un compte d'épargne"); 
			if(interaction.readData().equals("oui")) {
				interaction.display("Saisir le numéro de compte épargne du client");
				this.savingsAccount.numberAccount = interaction.readData();
				} 
		interaction.display("Saisir le type de carte du client");
		this.card.type = interaction.readData();
		this.advisor.customers.add(customer);
		System.out.println("Voici les données du nouveaut client : \n\t" + this.customer);  
	} 
	
	/**
	 * Cette méthode modifie le dossier d'un client
	 */
	public void modifyCustomer () {
		this.interaction.display("Pour le client " + this.customer.lastname + " " + this.customer.firstname + " : ");
        this.interaction.modifyCustomerMenu();
        String userInput = " ";
        while (!userInput.equals("Exit")) {
        	this.interaction.display("Quelle action souhaitez-vous réaliser? ");
        	userInput = this.interaction.readData();
            if (userInput.equals("1")) {
                this.interaction.display("Veuillez renseigner le nouveau nom : ");
                this.customer.lastname=interaction.readData();
            }
            else if (userInput.equals("2")) {
                this.interaction.display("Veuillez renseigner le nouveau prénom : ");
                this.customer.firstname=interaction.readData();
            }
            else if (userInput.equals("3")) {
                this.interaction.display("Veuillez renseigner la nouvelle adresse : ");
                this.customer.adress=interaction.readData();
            }
            else if (userInput.equals("4")) {
                this.interaction.display("Veuillez renseigner le nouveau code postal : ");
                this.customer.postalCode=Integer.parseInt(interaction.readData());
            }
            else if (userInput.equals("5")) {
                this.interaction.display("Veuillez renseigner le nouveau pays : ");
                this.customer.city=interaction.readData();
            }
            else if (userInput.equals("6")) {
                this.interaction.display("Veuillez renseigner le nouveau numéro de téléphone : ");
                this.customer.tel=interaction.readData();
            }
            else {
                this.interaction.display("Erreur : veuillez renseigner le chiffre correspondant à l'action que vous souhaitez.");
            }
        }
        if (userInput.equals("7")) {
                this.exitProxibanque();
        }
        
        this.interaction.display("Voici les nouvelles données : ");
        this.interaction.display(this.customer.lastname + " " + this.customer.firstname + " " + this.customer.adress + " "
                                    + this.customer.postalCode + " " + this.customer.city + " " + this.customer.tel);
	}	
	/**
	 * Cette méthode affiche les données d'un client
	 */
	public void readCustomer() {
		this.interaction.display(" Voici le dossier de votre client : ");
		this.interaction.display(this.customer.lastname + " " + this.customer.firstname + " " + this.customer.adress + " "
									+ this.customer.postalCode + " " + this.customer.city + " " + this.customer.tel );
	}  
	/**
	 * Cette méthode permet de supprimer un dossier client
	 */
	public void deleteCustomer() {
		
		for (int i=0; i < this.data.agencies.get(0).advisors.get(0).customers.size(); i++) {
			if (this.data.agencies.get(0).advisors.get(0).customers.size() == 0) {
				this.interaction.display("Impossible de supprimer un client car la liste est vide. \n  Retour au menu principal");
				this.manageMainMenu();	
			}
			else if (this.data.agencies.get(0).advisors.get(0).customers.get(0).lastname.equals(customer.lastname) && this.data.agencies.get(0).advisors.get(0).customers.get(0).lastname.equals(customer.firstname)) {
				this.data.agencies.get(0).advisors.get(0).customers.remove(i);
			}
			this.interaction.display("Voici la nouvelle liste de vos clients \n  " +this.data.agencies.get(0).advisors.get(0).customers);
		}
	}
	/**
	 * 
	 */
	public void addCard() {
		this.interaction.display("Voulez vous rajouter une carte bancaire? \n\t 1. Oui. \n\t 2. Non. ");
		String userInput = this.interaction.readData();
		if (this.customer.cardExist()) {
			if (userInput.equals("1")) {
				this.interaction.display("Quelle carte souhaiter vous ajouter? \n\t 1. Visa Electron. \n\t 2. Visa Premier.");
				String userInput1 = this.interaction.readData();
				if (userInput1.equals("1")) {
					this.customer.card = new Card("Visa Electron");
					this.interaction.display("Votre client " + this.customer.lastname + " " +
							this.customer.firstname + " a maintenant une carte " + this.customer.card.type + ".");
				}
				if (userInput1.equals("2")) {
					this.customer.card = new Card("Visa Premier");
					this.interaction.display("Votre client " + this.customer.lastname + " " +
							this.customer.firstname + " a maintenant une carte " + this.customer.card.type + ".");
				}
			}
		}
		else {
			this.interaction.display("Erreur : impossible de créer une nouvelle carte, le client en pessède déjà une.");
		}
	}
	/**
	 * 
	 */
	public void transfer(Account a, Account b, int amount) {
		this.interaction.display("Le virement de " + amount + "a été réaliser du  " + a + "vers " + b + ".");
		a.balance -= amount;
		b.balance += amount;
		System.out.println("Le solde du " + a + " est de " + a.balance + "€." +
								"Le solde du " + b + " est de " + b.balance + "€.");
	}
	
	public void makeTransfer() {
		if (this.customer.currentAccount != null && this.customer.savingsAccount != null) {
			this.interaction.display("Pour réaliser un virement, veuillez choisir le compte débiteur :"
					+ " \n\t 1. Compte courant. \n\t 2. Compte épargne. ");
			String userInput = this.interaction.readData();
			String message = "Quel montant souhaitez-vous transférer (en €) ?";
			if (userInput.equals("1")) {
				this.interaction.display(message);
				String userInputAmount = this.interaction.readData();
				int transferAmount = Integer.parseInt(userInputAmount); 
				double currentBalance = this.customer.currentAccount.balance;
				double balanceAfterTransfer = currentBalance - transferAmount;
				if (balanceAfterTransfer > Constants.OVERDRAFT_CURRENT) {
					this.transfer(this.customer.currentAccount, this.customer.savingsAccount, transferAmount);
				}
				else {
					while (balanceAfterTransfer > Constants.OVERDRAFT_CURRENT) {
						this.interaction.display("Les fonds ne sont pas suffisants pour réaliser le virement" );
						this.interaction.display(message);
					}
				}
			}
			else if (userInput.equals("2")) {
				this.interaction.display(message);
				String userInputAmount = this.interaction.readData();
				int transferAmount = Integer.parseInt(userInputAmount); 
				double currentBalance = this.customer.savingsAccount.balance;
				double balanceAfterTransfer = currentBalance - transferAmount;
				if (balanceAfterTransfer > Constants.OVERDRAFT_CURRENT) {
					this.transfer(this.customer.savingsAccount, this.customer.currentAccount, transferAmount);
				}
				else {
					while (balanceAfterTransfer > Constants.OVERDRAFT_CURRENT) {
						this.interaction.display("Les fonds ne sont pas suffisants pour réaliser le virement" );
						this.interaction.display(message);
					}
				}
			}
			else {
				this.interaction.display("Erreur : Veuillez renseigner 1 ou 2.");
			}
		}
		else {
			this.interaction.display("Erreur : Le client ne possède qu'un seul compte.");
		}
	}

	/**
	 * 
	 */
	public void creditSimulation() {
		this.interaction.display("Quelle simulation de crédit souhaitez-vous faire : \n\t 1. Crédit de consommation. \n\t 2. Crédit immobilier."
								+ "\n\t 3. Exit vers menu principal.");
		String userInput = this.interaction.readData();
		if (userInput.equals("1")) {
		this.interaction.display("Le client " + this.customer.lastname + " " + this.customer.firstname +
									" peut obtenir un crédit consommation de " + 4*this.customer.savingsAccount.balance + "€ a un taux de "
									+ Constants.RATE_CONSO +"%.");
		}
		else if (userInput.equals("2")) {
			this.interaction.display("Le client " + this.customer.lastname + " " + this.customer.firstname +
					" peut obtenir un crédit immobilier de " + 7*this.customer.savingsAccount.balance + "€ a un taux de "
					+ Constants.RATE_IMMO +"%.");
		}
		else {
			this.manageMainMenu();
		} 
	}
	
	/** Méthode qui sélectionne un client
	 */
public void selectCustomer() {
	 Advisor advisor1 = new Advisor ("Lila Durand");
	    advisor1.customers = new ArrayList<>();
	    Customer customer1 = new Customer("Jain", "Lahaine", "44 rue des Platanes",69001,
	    		"Lyon", "0169589632", new CurrentAccount("123656965632", 1630.00, "02/06/15"),new SavingsAccount("Pas de compte Epargne", null, null), new Card("visa Electron")); 
	    advisor1.customers.add(customer1);
	    Customer customer2 = new Customer("Jean", "Aimarre","56 avenue des Tilleuls",
	    		91600,"Savigny-sur-orge","0685947520", new CurrentAccount("036598741236", 1220.00,"30/11/16"), new SavingsAccount("895674253698", 2500.00, "25/09/17"), new Card("Pas de carte"));
	    advisor1.customers.add(customer2);
	    Customer customer3 = new Customer("Jean", "Peuplu", "38 rue des Plantes",75001, "Paris",
	    		"0655982365", new CurrentAccount("023659874545", 4600.00, "14/05/17"),new SavingsAccount("Pas de compte Epargne", null, null), new Card("visa Electron"));
	    advisor1.customers.add(customer3);
	    Customer customer4 = new Customer("Salah", "Malekoum", "67 avenue Boucicot", 75012,
	    		"Paris", "0185692365", new CurrentAccount("236585142365", -1200.00, "06/10/17"),new SavingsAccount("Pas de compte Epargne", null, null), new Card("visa Electron"));
	    advisor1.customers.add(customer4);
	    Customer customer5 = new Customer("Jain", "Faim", "98 avenue du Maine", 75014,
	    		"Paris", "0625456985", new CurrentAccount("456985231025", -500.00, "01/05/16"), new SavingsAccount("Pas de compte Epargne", null, null), new Card("visa premier")); 
	    advisor1.customers.add(customer5);
	    Customer customer6 = new Customer("Lucie", "Cruz", "45 rue du Temple", 75014,
	    		"Paris", "0125369814", new CurrentAccount("458236598745", 230.00, "02/10/16"), new SavingsAccount("698574123514", 600.00, "03/05/15"), new Card("visa Electron")); 
	    advisor1.customers.add(customer6);
		this.interaction.display("Veuillez choisir un client : /n");
		for (int i=0; i < advisor1.customers.size(); i++) {
			this.interaction.display(i + " - " + advisor1.customers.get(i).firstname + " " + advisor1.customers.get(i).lastname);
		} 
		String userInput = this.interaction.readData();
		this.customer = advisor.customers.get(Integer.parseInt(userInput));
		this.interaction.manageCustomerMenu();
		this.interaction.display("Pour le client " + this.customer.lastname + " " + this.customer.firstname + " : ");
		this.manageCustomer();
	}
}