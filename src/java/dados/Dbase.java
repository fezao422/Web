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
        String url ="jdbc:postgresql://localhost/";
        String dbName = "Projeto";
        String driver = "org.postgresql.Driver";
        String userName = "postgres";
        String password = "1211";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url + dbName, userName, password);
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
    /*
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
    }*/

