import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Auto_shop {

	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/auto_shop";
	
	static final String USER="root";
	static final String PASS="154199jt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		Statement stmt=null;
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			System.out.println("Conectando a la base de datos...");
			connection=DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Creando sentencia...");
			
			
			stmt=connection.createStatement();
			
			String sql="create table Departaments (\r\n"+
			"	Id INT NOT NULL AUTO_INCREMENT,\r\n"+
			"	Name VARCHAR(25) NOT NULL,\r\n"+
			"	PRIMARY KEY(Id));\r\n"
			;
			
			
			stmt.executeUpdate(sql);
			
			sql="INSERT INTO Departaments \r\n"+
			"	VALUES \r\n"+
			"	(1,'HR'),\r\n"+
			"	(2,'Sales'),\r\n"+
			"	(3,'Tech');\r\n"
			
			;
			stmt.executeUpdate(sql);
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
				try {
					if(stmt!=null) {
						stmt.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
					try {
						if(connection!=null) {
						connection.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
			
		}
		
	

	}


}
