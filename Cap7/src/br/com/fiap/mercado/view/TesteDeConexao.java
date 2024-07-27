package br.com.fiap.mercado.view;

import java.sql.Connection; // permite conectar no banco
import java.sql.DriverManager; // configura o driver de acesso
import java.sql.SQLException; // trata erros 

public class TesteDeConexao {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/FIAP";
        String usuário = "postgres";
        String senha = "pg482";

        try {
        	// fazendo a conexão chamando as variaveis ja definidas
            Connection conexao = DriverManager.getConnection(url, usuário, senha);
            System.out.println("Conexão com o bd PgSQL funfou");
            
            conexao.close(); // fechando conexao
            
            // tratando erro de conexão 
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao PostgreSQL: " + e.getMessage());
            e.printStackTrace();
    }
    }
    
}
