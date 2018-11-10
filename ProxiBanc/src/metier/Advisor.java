package metier;

import java.util.ArrayList;
import java.util.List;

import presentation.Interaction;

public class Advisor {

	public String id;
	public List<Customer> customers;
	public List<Customer> customersFollow;
		/**
		 *Constructeur par défaut*
		 */
		public Advisor() {
			Interaction interaction = new Interaction();
			interaction.display("Bonjour, Veuillez saisir votre nom : ");
			this.id = interaction.readData();
			this.customersFollow= new ArrayList<>();
			this.customers = new ArrayList<>();

				}
		 
		/**
		 *Constructeur d'initialisation
		 */
		public Advisor(String id) {
			this.id=id; 
			this.customersFollow= new ArrayList<>();
			this.customers = new ArrayList<>();

		}

		
		@Override
		public String toString() {
			return this.id;
		}
	}