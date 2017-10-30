package model;

import dados.Dbase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Postagem {
    private int id;
    private int usuario_id;
    private String titulo;
    private String texto;
    private String imagem;
    private Connection conn = null;
    private Dbase db;
    private PreparedStatement ps;

    public Postagem(){
        
    }
    public Postagem(int id, int usuario_id, String titulo, String texto, String imagem){
        this.id = id;
        this.usuario_id = usuario_id;
        this.titulo = titulo;
        this.texto = texto;
        this.imagem = imagem;
    }
    
    public boolean apagar(int idPostagem) throws SQLException{//apaga post
        boolean ok = false;
        db = new Dbase();
        conn = db.getConnection();
        String sql = ("delete from postagem where id = ?;");
        
        try {
            ps= conn.prepareStatement(sql);
            ps.setInt(1, idPostagem);
            ps.execute();
            ok = true;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Postagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
        db.closeConnection();
        return ok;
    }
    
    public boolean gravar() throws SQLException{//grava o post no banco de dados
        boolean ok = false;
        db = new Dbase();
        conn = db.getConnection();
        String sql = "insert into postagem(usuario_id,titulo,texto,imagem) values (?,?,?,?);";
        
        try {
            ps= conn.prepareStatement(sql);
            ps.setInt(1, this.getUsuario_id());
            ps.setString(2, this.getTitulo());
            ps.setString(3, this.getTexto());
            ps.setString(4, this.getImagem());
            ps.execute();
            ok = true;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Postagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
        db.closeConnection();
        return ok;
    }
    
    public ArrayList<Postagem> pesquisa(String termo) throws SQLException{ // faz um array list das postagens no banco
        ResultSet rs;
        ArrayList<Postagem> obj = new ArrayList();
        db = new Dbase();
        conn = db.getConnection();
        String sql = ("select * from postagem where titulo like ?;");
        ps = conn.prepareStatement(sql);
        ps.setString(1, "%"+termo+"%");
        rs = ps.executeQuery();
        while(rs.next()){
            obj.add(new Postagem(rs.getInt("id"),rs.getInt("usuario_id"),rs.getString("titulo"),rs.getString("texto"),rs.getString("imagem")));
        }
        ps.close();
        conn.close();
        db.closeConnection();
        return obj;
    }
    
    public ArrayList<Postagem> postUser(int usuario_id) throws SQLException{//pega todas as postagens referentes ao usuario que entrou
        ResultSet rs;
        ArrayList<Postagem> obj = new ArrayList();
        db = new Dbase();
        conn = db.getConnection();
        String sql = ("select * from postagem where usuario_id = ?;");
        ps = conn.prepareStatement(sql);
        ps.setInt(1, usuario_id);
        rs = ps.executeQuery();
        while(rs.next()){
            obj.add(new Postagem(rs.getInt("id"),rs.getInt("usuario_id"),rs.getString("titulo"),rs.getString("texto"),rs.getString("imagem")));
        }
        ps.close();
        conn.close();
        db.closeConnection();
        return obj;        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
