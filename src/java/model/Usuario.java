package model;

import dados.Dbase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Usuario {

    private int id;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String endereco;
    private String telefone;
    private String foto;
    private Connection conn = null;
    private Dbase db;
    private PreparedStatement ps;

    public Usuario() {

    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int id, String nome, String login, String senha, String email, String ende, String fone) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.endereco = ende;
        this.telefone = fone;
    }

    public boolean autentica(Usuario user) throws SQLException {

        boolean ok = false;
        Usuario resultado = null;
        
        db = new Dbase();
        conn = db.getConnection();
        String sql = "select login, senha from usuario";
        ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
                resultado = new Usuario(rs.getString("login"),rs.getString("senha"));
                if (resultado.login.equals(user.login) && resultado.senha.equals(user.senha)) {
                    ok = true;
                    break;
                }
         }
        conn.close();
        db.closeConnection();
        return ok;
        }
       
    public Usuario procura(String login, String email) throws SQLException {
        
        db = new Dbase();
        conn = db.getConnection();
        Usuario user = null;
        String sql = "select * from usuario;";
        ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            if (rs.getString("login").equals(login) || rs.getString("email").equals(email)) {
                
                user = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"),
                        rs.getString("email"), rs.getString("endereco"), rs.getString("telefone"));
                break;
            }
        }
        conn.close();
        db.closeConnection();
        return user;
    }

    public boolean gravar(Usuario user) throws SQLException {

        db = new Dbase();
        conn = db.getConnection();
        boolean ok = false;
        String sql = "insert into usuario(nome,login,senha,email,endereco,telefone) values(?,?,?,?,?,?);";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getSenha());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getEndereco());
            ps.setString(6, user.getTelefone());
            ps.execute();
            ok = true;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
        db.closeConnection();
        return ok;
    }

    public boolean setSenha(String antiga, String nova) {
        boolean alterada = false;
        if (this.senha.equals(antiga)) {
            this.senha = nova;
            alterada = true;
        }
        return alterada;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}