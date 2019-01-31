package lry.dip.design;

import java.util.Scanner;

public class Principale {
	
	public static Connect conn = new Connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/base_convertisseur?autoReconnect=true&useSSL=false", "user_convertisseur", "rtlry");


	public static void main(String[] args) {
		
		DIP_Interface dip = new DIP_Interface(650, 200, true, "Convertisseur");
		
	}

}
