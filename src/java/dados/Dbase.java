package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Dbase {
    
    private static Connection conexao = null;
    
    public Dbase(){
 
        String url ="jdbc:postgresql://localhost/Projeto";
        String driver = "org.postgresql.Driver";
        String userName = "postgres";
        String password = "1211";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, userName, password);
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(
                     null,
                    "Erro no Banco de Dados!\n\nContate seu Administrador do Sistema!",
                    "Erro...",
                    JOptionPane.WARNING_MESSAGE
                );
                ex.printStackTrace();
            }   
    }
    
    public static Connection getConnection(){
        return conexao;
    }
    
    public static void closeConnection() {
        try                { 
            conexao.close(); 
        }
        catch(Exception e) { 
            e.printStackTrace(); 
        }
    }
}
