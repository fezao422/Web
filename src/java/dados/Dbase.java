package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbase {
    
    private static Connection conexao = null;
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        if(conexao == null || conexao.isClosed()){
            conexao = criar();
        }
        return conexao;
    }
    
    private static Connection criar() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost/Projeto", "postgres", "1211");
    }
    
    public void close() throws SQLException{
        conexao.close();
        System.out.println("Banco de dados fechado!");
    }
}

