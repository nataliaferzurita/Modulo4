import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class Conexion_BDD {
	
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/world";
	
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
			String sql="select language from countrylanguage\r\n"
					+ "group by (Language)\r\n"
					+ ";\r\n"
				
			ResultSet rs= stmt.executeQuery(sql);
			
			int c=0;
			long CantH=0;
			
			while(rs.next()) {
				//int poblacion=rs.getInt("Population");
				String nombreString=rs.getString("Name");
				//String codigoPais=rs.getString("CountryCode");
				
				//System.out.println(" Codigo Pais:"+codigoPais);
				System.out.println(" Nombre:"+nombreString);
				//System.out.println(" Poblacion:"+poblacion);
				c++;
				//CantH=CantH+poblacion;
			}
			
			System.out.println("Contador:"+c);
			//System.out.println("Cantidad Total de Habitantes:"+CantH);
			
			rs.close();
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
