package Model.bean;

/**
 *
 * @author adavilson
 */
public class Secretaria {

    int id_secretaria;
    String nome_secretaria;
    String cpf;
    String login_secretaria;
    int senha;

    public int getId_secretaria() {
        return id_secretaria;
    }

    public void setId_secretaria(int id_secretaria) {
        this.id_secretaria = id_secretaria;
    }

    public String getNome_secretaria() {
        return nome_secretaria;
    }

    public void setNome_secretaria(String nome_secretaria) {
        this.nome_secretaria = nome_secretaria;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin_secretaria() {
        return login_secretaria;
    }

    public void setLogin_secretaria(String login_secretaria) {
        this.login_secretaria = login_secretaria;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public Secretaria(String nome_secretaria, String cpf, String login_secretaria, int senha) {
        this.nome_secretaria = nome_secretaria;
        this.cpf = cpf;
        this.login_secretaria = login_secretaria;
        this.senha = senha;
    }

   
    @Override
    public String toString() {
        return "Secretaria{" + "id_secretaria=" + id_secretaria
                + ", nome_secretaria=" + nome_secretaria + ", cpf="
                + cpf + ", login_secretaria=" + login_secretaria
                + ", senha=" + senha + '}';
    }

}
