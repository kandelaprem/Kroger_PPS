package kroger;
import java.sql.*;
public class Krog_DB {

	  // JDBC driver name and database URL
	//   static final String JDBC_DRIVER = "com.oracle.jdbc.Driver";  
	   static final String DB_URL="jdbc:oracle:thin:@u060epd82.kroger.com:1521/expdev2";

	   //  Database credentials
	   static final String USER = "trexone_ro";
	   static final String PASS = "trexone_ro";

	   public static void main(String[] args) throws SQLException{
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("oracle.jdbc.driver.OracleDriver");

		     
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		    
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * from patient;";
		      ResultSet rs = stmt.executeQuery(sql);

		      while (rs.next()) {
	                System.out.println("Record values: " + rs.getString(1));
	            }     
		     
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		         se.printStackTrace();
		   }catch(Exception e){
		          e.printStackTrace();
		   
		   }
		   
		}
		}

	
