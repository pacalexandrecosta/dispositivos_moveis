package desenvolvimento.nassau.trabalho001;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulo on 20/03/2017.
 */

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;

    public Livro() {
    }

    public Livro(int id, String titulo, String autor, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Livro> getLivros() {
        List<Livro> livros = new ArrayList<Livro>();
        livros.add(new Livro(1, "Banco de dados", "Adalberto", 2000));
        livros.add(new Livro(2, "Redes", "Bruno",2001));
        livros.add(new Livro(3, "Algoritmos", "Carlos", 2002));
        livros.add(new Livro(4, "Java", "Diego",2000));
        return livros;
    }
}
