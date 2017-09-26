package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbase {
    private Connection conexao;
    public Dbase() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        conexao = DriverManager.getConnection("jdbc:postgresql://localhost/Projeto", "postgres", "1234");
        System.out.println("testestes");
    }
    public Connection getConexao(){
        return this.conexao;
    }
    public void close(){
        System.out.println("Banco de dados fechado!");
    }
}

