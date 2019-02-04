package lry.dip.avatar;

public class Principale {
	
	public static int TAILLE_PLATEAU = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// j'ai mis 100 parceque merde
		
		Combattant orc = new Combattant(2, 1, 2, 78, 12);
		
		
		
		
		
		
		System.out.println("Stat orc : \n"
				+ "Force : \t"+orc.getForce()+"\n"
				+ "Precision : \t"+orc.getPrecision()+"\n"
				+ "vie : \t"+orc.getViePerso()+"\n"
				+ "etat : \t"+orc.isEtatPerso()+"\n"
				+ "stat arme : \t"+orc.getArme().getType()+"\t"+orc.getArme().getForce()+"\t"+orc.getArme().getPrecision()+"\n"
				+ "stat casque : \t"+orc.getCasque().getType()+"\t"+orc.getCasque().getProtection()+"\n"
				+ "stat bouclier : "+orc.getBouclier().getType()+"\t"+orc.getBouclier().getProtection()+"\n"
				);
		
		Villageois bucheron = new Villageois(25, 42);



		
		
		System.out.println("Stat bucheron : \n"
				+ "rapidite : \t"+bucheron.getRapidite()+"\n"
				+ "endurance : \t"+bucheron.getEndurance()+"\n"
				+ "vie : \t"+bucheron.getViePerso()+"\n"
				+ "etat : \t"+bucheron.isEtatPerso()+"\n\n\n"
				);
		
		
		while(bucheron.getViePerso() > 0) {
			
			for(int i = 0; i < TAILLE_PLATEAU; i++) {
				
				for(int j = 0; j < TAILLE_PLATEAU; j++) {
					
					System.out.print("| ");
					
					if(orc.getPosH() == j && orc.getPosL() == i) {
						System.out.print("1 ");
					} else if(bucheron.getPosH() == j + 1 && bucheron.getPosL() == i + 1){
						System.out.print("2 ");
					} else {
						System.out.print("  ");
					}
					
				}
				
				System.out.println("\n");
			}
					
			if(orc.adjacent(bucheron)) {
				bucheron.endurer(orc.taper(orc.getForce(), orc.getArme()));
				
				System.out.println("Vie Vie-llageois (lol) : "+bucheron.getViePerso());
				
				
				try {
					// pause d'1s
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				orc.deplacerVers(bucheron);
				
				System.out.println("Position H orc : "+orc.getPosH()+"\tPosition L orc : "+orc.getPosL()+"\nPosition H bucheron : "+bucheron.getPosH()+"\tPosition L bucheron : "+bucheron.getPosL());
				
				
				try {
					// pause d'20ms
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			bucheron.deplacer(orc);
			
			
		}
		
		System.out.println("Win pour la horde");
		
	}

}
