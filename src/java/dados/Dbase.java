package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Dbase {

    public Connection conn = null;

    public Dbase() {

        String url = "jdbc:postgresql://localhost/Projeto";
        String driver = "org.postgresql.Driver";
        String userName = "postgres";
        String password = "1234";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro no Banco de Dados!\n\nContate seu Administrador do Sistema!",
                    "Erro...",
                    JOptionPane.WARNING_MESSAGE
            );
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
