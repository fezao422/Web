package teste;

import dados.Dbase;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection c = Dbase.getConnection();
        System.out.println("chegouaqui");
    }
}
