package br.com.fiap.crud.estatico;

import java.sql.Connection; // permite conectar no banco
import java.sql.DriverManager; // configura o driver de acesso
import java.sql.ResultSet; 
import java.sql.SQLException; // trata erros 
import java.sql.Statement; 

public class TesteCrudStatico {

	public static void main(String[] args){
		String url = "jdbc:postgresql://localhost:5432/FIAP";
        String usuário = "postgres";
        String senha = "pg482";
        
        try {
			// fazendo a conexão chamando as variaveis ja definidas
		    Connection conexao = DriverManager.getConnection(url, usuário, senha);
		    System.out.println("Conexão com o bd PgSQL funfou");
		    
		    Statement stmt = conexao.createStatement();
		    stmt.executeUpdate("INSERT INTO t_produtos(nm_produto, dt_validade, vl_produto)	VALUES ('Uva', '03/07/2024', 12.80)");
		    
		    String sqlUpdate = "UPDATE t_produtos SET vl_produto = 13 where cd_produto = 1";
		    stmt.executeUpdate(sqlUpdate);
		    
		    ResultSet result = stmt.executeQuery("SELECT * FROM t_produtos");
	    
		    while (result.next()) {
		    	
		    	System.out.println(result.getInt("cd_produto") + " " +
		    						result.getString("nm_produto") + " " +
		    						result.getDouble("vl_produto") + " " +
		    						result.getDate("dt_validade") );
		    }
		    
		    conexao.close();
		    
        }catch (SQLException e){
        	System.err.println("Não foi possivel conectar no banco");
        	e.printStackTrace();
        }
	}
}
