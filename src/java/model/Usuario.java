package model;

import java.util.ArrayList;

/**
 *
 * @author flavi
 */
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

    public Usuario(){
    
    }
    
    public Usuario(int id){
       
    }
    
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public boolean setSenha(String antiga, String nova) {
        boolean alterada = false;
        if(this.senha.equals(antiga)){
            this.senha = nova;
            alterada = true;
        }            
        return alterada;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
}
