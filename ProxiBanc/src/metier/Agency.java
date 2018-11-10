package metier;

import java.util.ArrayList;
import java.util.List;

/** * La classe Agency caractérise une agence.
 * */
public class Agency {

	public String id;
	public String creationDate;
	public List<Advisor> advisors;
	public Director director;
		
	/**Constructeur d'initialisation de la classe Agency
	 * @param id
	 * @param creationDate
	 */
	public Agency(String id, String creationDate) {
		this.id=id; 
		this.creationDate = creationDate;
		this.advisors = new ArrayList<>();
		Advisor advisor1 = new Advisor("William");
		Advisor advisor2 = new Advisor("Pierro");
		this.advisors.add(advisor1);
		this.advisors.add(advisor2);
	}


	@Override
	public String toString() {
		return this.id;
	}

}