package financeArgent;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Epargne_connect {
	
	static ArrayList<Epargne> epargneList = new ArrayList<Epargne>();  //Creat a new liste : epargneList

	public static void main(String[] args) {
		
		//Connection to Data Base : financeArgent 								
		System.out.println("connecting to mysql financeArgent");
		
		String url = "jdbc:mysql://localhost/financeArgent";	//if using apple device : loging/psw : 'root'
		String login = "root";
		String passwd = "root";
		
		Connection cn =null; 	
		Statement st =null;
		ResultSet res =null;
 
	
		try {

			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);		//connecting to database
			
			st = cn.createStatement();
			String sql = "SELECT * FROM epargne"  ;						
			
			res = st.executeQuery(sql);									//Store all the data from table 'epargne' to 'res'
			
			
			
			// Si r�cup donn�es alors �tapes 5 (parcours Resultset)
			System.out.println(res);
			// add to res the values from mysql while their is a new line
			while (res.next()) {
				System.out.println("-----------recup data from mysql------------------------");
				System.out.println(res.getString("NOMCOMPTE"));
				System.out.println(res.getDate("OUVERTURECOMPTE"));
				System.out.println(res.getFloat("SOLDE"));
				System.out.println(res.getFloat("TAUX"));
				System.out.println(res.getInt("PLAFOND"));
				System.out.println(res.getFloat("INTERETPREVISIONNELS"));
				
				 
				//create a new object 'e1' with parameters from constructor Epargne and add values from 'res'
				Epargne e1= new Epargne(res.getString("NOMCOMPTE"),res.getDate("OUVERTURECOMPTE"),res.getFloat("SOLDE"),res.getFloat("TAUX"),res.getInt("PLAFOND"),res.getFloat("INTERETPREVISIONNELS"));
						 
			
			     System.out.println(e1);				//add the values of the new 'e1' to  
			     epargneList.add(e1);
			}
			 
			
		} catch (ClassNotFoundException e) {			//error driver
			e.printStackTrace();	
		} catch (SQLException e) {						//error sql
			e.printStackTrace();
		}
		
		
		//print all the values from 'epargneList'
		for(Epargne monEpargne : epargneList) {
			System.out.println(monEpargne);
		}
	}
}
