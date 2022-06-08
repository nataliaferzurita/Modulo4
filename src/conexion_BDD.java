
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion_BDD {
	static final String JDBC_DIRVER="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/world";
	static final String USER="root";
	static final String  PASS="154199jt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stm=null;
		
		
		
		try {
			Class.forName(JDBC_DIRVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		try {
			System.out.println("Connecting to database...");
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Creating statament...");
			stm=conn.createStatement();
	
			String sql="Select * from city";
			ResultSet rs=stm.executeQuery(sql);
			int c=0;
			while(rs.next()) {
				int population=rs.getInt("Population");
				String name=rs.getString("Name");
				String codeCountry=rs.getString("ID");
				System.out.println("Pais:"+name);
				System.out.print(", Codigo Pais:"+codeCountry);
				System.out.println(", Poblacion:"+population);
				c++;
			}
			System.out.println("Cantidad de Registro:"+c);
			rs.close();
			stm.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				if(stm!=null) {
					stm.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			try {
				if(conn!=null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
		}
		
	}

}
