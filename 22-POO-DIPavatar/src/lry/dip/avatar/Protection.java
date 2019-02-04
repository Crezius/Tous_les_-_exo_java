package lry.dip.avatar;

public class Protection {

/*********************************** ATTRIBUTS ***********************************/
	
	private int type;
	private int protection;
	
/********************************** CONSTRUCTEUR *********************************/
	
	protected Protection(int type) {
		super();
		this.type = type;
		
		switch(type) {
		case 1:
			this.protection = 89;
			break;
		case 2:
			this.protection = 41;
			break;
		case 3:
			this.protection = 4569;
		}
	}
	

	
/******************************* GETTERS / SETTERS *******************************/

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getProtection() {
		return protection;
	}
	public void setProtection(int protection) {
		this.protection = protection;
	}

}
