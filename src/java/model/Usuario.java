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
    public Connection conn = null;
    public ResultSet rs;
    public PreparedStatement ps;

    public Usuario(){
    
    }
    
    public Usuario(String login, String senha){
        conn = Dbase.getConnection();
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario procura(String variavel) throws SQLException{
        Usuario user = null;
        //ResultSet rs;
        //PreparedStatement ps;
        
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
    
    public boolean gravar(Usuario user) throws SQLException{
        
        boolean ok = false;
        conn = Dbase.getConnection();
        String sql = "INSERT INTO usuario VALUES(null,?,?,?,?,?,?)";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(2, user.getNome());
            ps.setString(3, user.getLogin());
            ps.setString(4, user.getSenha());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getEndereco());
            ps.setString(7, user.getTelefone());
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
