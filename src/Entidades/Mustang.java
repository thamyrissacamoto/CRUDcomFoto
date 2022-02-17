package Entidades;

/**
 *
 * @author thamyris
 */
public class Mustang {

    private int id;
    private String nome;
    private String foto;

    public Mustang() {
    }

    public Mustang(int id, String nome, String foto) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
    }

    //gets e sets
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + foto;
    }
}//fim da classe

