import java.util.Date;

public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestBDD test = new TestBDD("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/ma_base?autoReconnect=true&useSSL=false", "moi", "mdp");
			
//		test.insertData("chien", 12463245, new Date(), 40.23);
		
		test.deleteData();
		test.selectData();
		
		test.insertData("chien", 12463245, new Date(), 40.23);

		test.selectData();
		
		test.updateData("chien", "bon chien", 89765321, new Date(), 20.23);
		
		test.selectData();
		
	}

}
