package desenvolvimento.nassau.a006.model;

/**
 * Created by paulo on 09/03/2017.
 */

public class Aluno {
    private int id;
    private String nome;
    private String email;

    public Aluno() {
    }

    public Aluno(int id, String nome, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
