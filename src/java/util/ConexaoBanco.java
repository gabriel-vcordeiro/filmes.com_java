package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBanco {
    // Dados para a conexão com o banco

    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String BANCO = "tarefaCrud";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String STRINGCONEXAO = "jdbc:mysql://localhost:3306/";

    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(STRINGCONEXAO
                    + BANCO, USUARIO, SENHA);
            return con;
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Driver MySqlnão foi encontrado " + e.getMessage());
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar "
                    + "com a base de dados"
                    + e.getMessage());
        }
    }

    public static void fechaConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
                System.out.println("Fechada a conexãocom o banco de dados.");
            }
        } catch (Exception e) {
            System.out.println(
                    "Não foi possível fechara conexão com o banco de dados " + e.getMessage());
        }
    }

    public static void fechaConexao(Connection con, PreparedStatement stmt) {
        try {
            if (con != null) {
                fechaConexao(con);
            }
            if (stmt != null) {
                stmt.close();
                System.out.println("Statement fechado com sucesso");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível fechar o statement " + e.getMessage());
        }
    }

    public static void fechaConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
        try {
            if (con != null || stmt != null) {
                fechaConexao(con, stmt);
            }
            if (rs != null) {
                rs.close();
                System.out.println("ResultSet fechado com sucesso");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível fechar o ResultSet " + e.getMessage());
}
}
}
