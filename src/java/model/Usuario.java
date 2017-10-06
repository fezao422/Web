package model;

import dados.Dbase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String endereco;
    private String telefone;
    private String foto;
    private ArrayList<Postagem> postagens;
    public static Connection conn = null;
    public static ResultSet rs;
    public static PreparedStatement ps;

    public Usuario(){
    
    }
    
    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    public static boolean autentica(Usuario user) throws SQLException{
        boolean ok = false;
        Usuario dentro = procura(user.login);
        if(dentro != null && dentro.senha.equals(user.senha)){
            ok = true;
        }
        return ok;
    }
    
    public static Usuario procura(String variavel) throws SQLException{
        Usuario user = null;
        
        ps = conn.prepareStatement("SELECT * FROM usuario");
        rs = ps.executeQuery();
        while(rs.next()){
            if(rs.getString("usuario").equals(variavel) || rs.getString("email").equals(variavel)){
                user = new Usuario(rs.getString("login"), rs.getString("senha"));
                break;
            }
        }
        return user;
    }
    
    public boolean gravar() throws SQLException{
        
        boolean ok = false;
        conn = Dbase.getConnection();
        String sql = "INSERT INTO usuario(nome,login,senha,email,endereco,telefone) VALUES(?,?,?,?,?,?);";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, this.getNome());
            ps.setString(2, this.getLogin());
            ps.setString(3, this.getSenha());
            ps.setString(4, this.getEmail());
            ps.setString(5, this.getEndereco());
            ps.setString(6, this.getTelefone());
            ps.execute();
            ok = true;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
        return ok;
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

    public boolean setSenha(String antiga, String nova) {
        boolean alterada = false;
        if(this.senha.equals(antiga)){
            this.senha = nova;
            alterada = true;
        }            
        return alterada;
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
