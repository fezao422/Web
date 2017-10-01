package model;

public class Postagem {
    private int id;
    private int usuario_id;
    private String titulo;
    private String texto;
    private String imagem;

    public Postagem(){
        
    }
    
    public Postagem(int id){
        
    }
    
    public int getId() {
        return id;
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
}
