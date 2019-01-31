import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cesar {

	private String 	msgCode;
	private String 	msgDecode;
	private int		cle;
	
	// Getters / Setters
	public String getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	public String getMsgDecode() {
		return msgDecode;
	}
	public void setMsgDecode(String msgDecode) {
		this.msgDecode = msgDecode;
	}
	public int getCle() {
		return cle;
	}
	public void setCle(int cle) {
		this.cle = cle;
	}
	

	
	public Cesar(String msgCode, String msgDecode, int cle) {
		super();
		this.msgCode = msgCode;
		this.msgDecode = msgDecode;
		this.cle = cle;
	}
	
	public void coder_Cesar(String motCoder) {
		
		// Création d'un arrayList d'entier pour le code ASCII de chaque caractères
		ArrayList<Integer> tab_char = new ArrayList<>();
		
		// Permet de recréer une chaine de carractère à partir d'un tableau de charactere
		StringBuilder msgcode = new StringBuilder();
		
		// transfert le code ASCII de chaque caractères de la chaine dans un tableau 
		for (char c : (motCoder.toCharArray())) {
			tab_char.add((int)c);
		}
		
		// parcour le tableau de code ASCII
		for(int i = 0; i < tab_char.size(); i++) {
			
			// récupère la futur valeur en fonction de la cle de cryptage
			int code = tab_char.get(i) + getCle();
			
			// si c'est un minuscule ...
			if(tab_char.get(i) >= 97 && tab_char.get(i) <= 122) {
				// si la nouvelle valeur dépasse le code max des minuscule
				if(code > 122 ) {
					// on reviens à  la valeur minimal plus la différence (121 + 5 = 126; 126 - 122 = 4; 97 + 4 = 101)
					tab_char.set(i, 97 + (code - 122)-1);
				} else {
					// sinon on remplace juste la valeur par la nouvelle valeur 
					tab_char.set(i, code);
				}
			// sinon si c'est une majuscule ...
			} else if(tab_char.get(i) >= 65 && tab_char.get(i) <= 90) {
				// idem que cu au dessus mais avec le code des majuscules
				if(code > 90 ) {
					tab_char.set(i, 65 + (code - 90));
				} else {
					tab_char.set(i, code);
				}
			// sinon ...			
			} else {
				tab_char.set(i, code);
			}
			
		}
		
		for(int c : tab_char) {
			msgcode.append((char)c);
		}
		
		 try {
			BufferedWriter text_code_cesar = new BufferedWriter(new FileWriter(new File("C:\\Users\\rt\\code_cesar.txt")));
			System.out.println("test écriture fichier "+msgcode.toString());
			text_code_cesar.write(msgcode.toString());
			text_code_cesar.newLine();
			System.out.println(getCle());
			text_code_cesar.write(String.valueOf(getCle()));
			text_code_cesar.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Je crois que t'as merdé mec");
			e.printStackTrace();
		}
		
				
		System.out.println(msgcode.toString());
		setMsgCode(msgcode.toString());
		
	}
	
	// Booonnn baaa ... c'est pareil qu'au dessus mais en soustrayant la cle pour récupérer la version non codée
	public void decoder_Cesar(String motCoder) {
		ArrayList<Integer> tab_char = new ArrayList<>();
		StringBuilder msgDecode = new StringBuilder();
		int code;
		
		if(motCoder == null) {
			// Lecture du fichier d'encodage
			try {
				
				// instanciation d'un fichier relire à mon fichier d'encodage
				File mon_fichier = new File("C:\\Users\\rt\\code_cesar.txt");

				// Instanciation d'un fichier lisible
				BufferedReader text_decode_cesar = new BufferedReader(new FileReader(mon_fichier));
			
				
				try {	
				// si mon fichier n'est pas vide
					if(mon_fichier.length() > 0) {
						
						// Récupration du texte encodé
						motCoder = text_decode_cesar.readLine();
						System.out.println("motCoder : "+motCoder);
						
						// lecture de la ligne suivante
						String line = text_decode_cesar.readLine();
						System.out.println("test lecture fichier "+line);
			
					
						// Si elle n'est pas vide ...
						if(line != null) {
							// Récupération de la cle de décryptage
							setCle(Integer.parseInt(line));
							System.out.println("cle : "+getCle());
						}
						
					}
				
					text_decode_cesar.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// récupération des caractères du string dans un tableau de caratères
				for (char c : (motCoder.toCharArray())) {
					tab_char.add((int)c);
				}
				
				for(int i = 0; i < tab_char.size(); i++) {
					
					code = tab_char.get(i) - getCle();
					if(tab_char.get(i) >= 97 && tab_char.get(i) <= 122) {
						if(code < 97 ) {
							tab_char.set(i, 122 - (97 - code)+1);
						} else {
							tab_char.set(i, code);
						}
					} else if(tab_char.get(i) - getCle() >= 65 && tab_char.get(i) - getCle() <= 90) {
						if(code < 65 ) {
							tab_char.set(i, 90 - (65 - code));
						} else {
							tab_char.set(i, code);
						}
									
					} else {
						tab_char.set(i, code);
					}
					
				}
					
					
					
					for(int c : tab_char) {
						msgDecode.append((char)c);
					}
					
							
					System.out.println(msgDecode.toString());
					setMsgDecode("Mot décrypté : "+msgDecode.toString());
				
			// si le fichier code_cesar.txt est inexistant : retourne un erreur
			} catch (FileNotFoundException e) {				
				System.out.println("Et baaa bravo ! T'as pas de fichier mec");
			}
		}
	}

}
