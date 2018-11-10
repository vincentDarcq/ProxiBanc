package persistence;

import java.util.ArrayList;
import java.util.List;
import metier.Advisor;
import metier.Agency;
import metier.Card;
import metier.CurrentAccount;
import metier.Customer;
import metier.Director;
import metier.SavingsAccount;


public class Data {

	public List<Agency> agencies;
	
	/**
	 * Méthode entrant des valeurs pour réaliser un test sur l'application
	 */
	public void loadTestData() {
		this.agencies = new ArrayList<>();
		Agency agency = new Agency ("01254" , "12/10/1999");
	    this.agencies.add(agency);
	    Director director = new Director("dd");
	    agency.director = director; agency.id = "agence Proxi";
	    agency.advisors = new ArrayList<>();	   
	    Advisor advisor1 = new Advisor ("Lila Durand");
	    advisor1.customers = new ArrayList<>();
	    agency.advisors.add(advisor1);
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
	    Advisor advisor2 = new Advisor ("Louis Seize");
	    agency.advisors.add(advisor2);
	    Advisor advisor3 = new Advisor ("Tom Tom");
	    agency.advisors.add(advisor3); 
	    Advisor advisor4 = new Advisor ("Franck Reich");
	    agency.advisors.add(advisor4);
	    System.out.println(advisor1);
	    System.out.println(advisor1.customers);
	    	}
	} 