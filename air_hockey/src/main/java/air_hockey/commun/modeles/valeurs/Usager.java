package air_hockey.commun.modeles.valeurs;

import ca.ntro.app.models.ModelValue;

public class Usager implements ModelValue{

	private String id;
	private String user;
	
	public Usager() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}
