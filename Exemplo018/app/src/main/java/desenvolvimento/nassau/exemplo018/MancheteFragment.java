package desenvolvimento.nassau.exemplo018;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by paulo on 28/03/2017.
 */

public class MancheteFragment extends Fragment implements AdapterView.OnItemClickListener {
    ListView lstNoticias = null;
    List<Noticia> noticias = null;
    ArrayAdapter<Noticia> adaptador = null;
    OnNoticiaSelectedListener noticiaSelectedListener = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noticiaSelectedListener = (OnNoticiaSelectedListener) getActivity();
        noticias = new Noticia().getNoticias();
        adaptador = new ArrayAdapter<Noticia>(getActivity(), R.layout.item_list_noticia, noticias);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manchete, container, false);
        lstNoticias = (ListView) v.findViewById(R.id.lstManchete);
        lstNoticias.setAdapter(adaptador);
        lstNoticias.setOnItemClickListener(this);
        return v;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        Noticia noticia = (Noticia)adaptador.getItem(position);
        noticiaSelectedListener.onNoticiaSelected(noticia);
    }
}
