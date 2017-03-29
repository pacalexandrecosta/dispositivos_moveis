package desenvolvimento.nassau.exemplo018;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulo on 28/03/2017.
 */

public class Noticia {
    private int id;
    private String manchete;
    private String conteudo;

    public Noticia() {
    }

    public Noticia(int id, String manchete, String conteudo) {
        this.id = id;
        this.manchete = manchete;
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManchete() {
        return manchete;
    }

    public void setManchete(String manchete) {
        this.manchete = manchete;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return manchete;
    }

    public List<Noticia> getNoticias() {
        List<Noticia> noticias = new ArrayList<Noticia>();
        noticias.add(new Noticia(1, "Morre fulano", "Fulano morreu"));
        noticias.add(new Noticia(2, "Futebol vence", "Goleada no clásico..."));
        noticias.add(new Noticia(3, "Sicrano nasce", "Sicrano nasceu"));
        noticias.add(new Noticia(4, "Preço da gasolina subiu", "O preço da gasolina tá uma beleza ó...."));
        return noticias;
    }

    public Noticia getNoticiaById(int id) {
        Noticia noticia = null;

        for (Noticia not : getNoticias()) {
            if (not.getId() == id) {
                noticia = not;
                break;
            }
        }

        return noticia;
    }
}
