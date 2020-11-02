package entities;

public class Sports {
	private int sport_id;
	private String sport_name;
	
	
	public Sports(int sport_id, String sport_name) {
		this.sport_id = sport_id;
		this.sport_name = sport_name;
	}


	public int getSport_id() {
		return sport_id;
	}


	public void setSport_id(int sport_id) {
		this.sport_id = sport_id;
	}


	public String getSport_name() {
		return sport_name;
	}


	public void setSport_name(String sport_name) {
		this.sport_name = sport_name;
	}

}
