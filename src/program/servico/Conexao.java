package program.servico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexao {
	
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	
	public Conexao(){
		url = "jdbc:postgresql://localhost:5432/bd_trabalho";
		usuario = "postgres";
		senha = "root";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão realida com sucesso");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int executaSQL(String sql) {
		
		try {
			Statement stm = con.createStatement();
			int res = stm.executeUpdate(sql);
			//con.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public void closeCon() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
