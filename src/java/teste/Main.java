/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dados.Dbase;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Filipe
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection c = Dbase.getConexao();
        System.out.println("chegouaqui");
    }
}
