package lry.dip.avatar;

public class Arme {
	
/*********************************** ATTRIBUTS ***********************************/
	
	private int type;
	private int force;
	private int precision;	
	
/********************************** CONSTRUCTEUR *********************************/
	
	protected Arme(int type) {
		super();
		this.type = type;
		
		switch(type) {
		case 1:
			this.force = 187;
			this.precision = 47;
			break;
		case 2:
			this.force = 169;
			this.precision = 4;
			break;
		case 3:
			this.force = 125;
			this.precision = 96;
		}
	}
	
/******************************* GETTERS / SETTERS *******************************/
	
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	

	
}
