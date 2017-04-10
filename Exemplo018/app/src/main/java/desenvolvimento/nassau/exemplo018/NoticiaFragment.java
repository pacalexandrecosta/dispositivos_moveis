package desenvolvimento.nassau.exemplo018;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by paulo on 28/03/2017.
 */

public class NoticiaFragment extends Fragment {
    Noticia noticia = null;
    TextView txtManchete = null;
    TextView txtConteudo = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle parametros = getArguments();
        if (parametros != null) {
            int id = parametros.getInt("id_noticia");
            noticia = new Noticia().getNoticiaById(id);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_noticia, container, false);

        txtManchete = (TextView) v.findViewById(R.id.txtManchete);
        txtConteudo = (TextView) v.findViewById(R.id.txtConteudo);
        setNoticia(this.noticia);

        return v;
    }

    public void setNoticia(Noticia not) {
        this.noticia = not;
        if (this.noticia != null) {
            txtManchete.setText(this.noticia.getManchete());
            txtConteudo.setText(this.noticia.getConteudo());
        }
    }
}
