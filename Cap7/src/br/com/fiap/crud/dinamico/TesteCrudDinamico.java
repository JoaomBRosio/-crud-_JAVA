package br.com.fiap.crud.dinamico;

import java.nio.file.ClosedDirectoryStreamException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TesteCrudDinamico {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/FIAP";
        String usuário = "postgres";
        String senha = "pg482";

        try (Connection conexao = DriverManager.getConnection(url, usuário, senha);
        		
            Scanner scanner = new Scanner(System.in)) {

            System.out.print("Digite o nome do produto: ");
            String nomeProduto = scanner.nextLine();

            System.out.print("Digite a data de validade (AAAA-MM-DD): ");
            String dataDeValidade = scanner.nextLine();

            System.out.print("Digite o valor do produto: ");
            String valorDoProduto = scanner.nextLine();

            PreparedStatement pstmt = conexao.prepareStatement("INSERT INTO t_produtos(nm_produto, dt_validade, vl_produto) VALUES (?, ?, ?)");
            
            pstmt.setString(1, nomeProduto);
            java.sql.Date dataSql = java.sql.Date.valueOf(dataDeValidade); 
            pstmt.setDate(2, dataSql);
            pstmt.setFloat(3, Float.parseFloat(valorDoProduto));
            System.out.println("Inserido com sucesso!!!");
            pstmt.executeUpdate();
            
            conexao.close();
            
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco");
            e.printStackTrace();
        }
    }
}


