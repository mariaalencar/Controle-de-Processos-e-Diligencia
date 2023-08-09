package Model.bean;

public class Escritorio {

    int id_escritorio;
    String nome_advocacia;
    String telefone;
    String endereco;
    long id_secretaria;

    public Escritorio(int id_escritorio, String nome_advocacia, String telefone, String endereco) {
        this.id_escritorio = id_escritorio;
        this.nome_advocacia = nome_advocacia;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    public Escritorio(int id_escritorio, String nome_advocacia, String telefone, String endereco, long id_secretaria) {
        this.id_escritorio = id_escritorio;
        this.nome_advocacia = nome_advocacia;
        this.telefone = telefone;
        this.endereco = endereco;
        this.id_secretaria = id_secretaria;
    }

    public int getId_escritorio() {
        return id_escritorio;
    }

    public void setId_escritorio(int id_escritorio) {
        this.id_escritorio = id_escritorio;
    }

    public String getNome_advocacia() {
        return nome_advocacia;
    }

    public void setNome_advocacia(String nome_advocacia) {
        this.nome_advocacia = nome_advocacia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getId_secretaria() {
        return id_secretaria;
    }

    public void setId_secretaria(long id_secretaria) {
        this.id_secretaria = id_secretaria;
    }

    @Override
    public String toString() {
        return "Escritorio{" + "id_escritorio=" + id_escritorio + ", nome_advocacia=" + nome_advocacia + ", telefone=" + telefone + ", endereco=" + endereco + ", id_secretaria=" + id_secretaria + '}';
    }

}
