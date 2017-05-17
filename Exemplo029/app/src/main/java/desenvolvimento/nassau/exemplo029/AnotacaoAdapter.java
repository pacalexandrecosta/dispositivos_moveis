package desenvolvimento.nassau.exemplo029;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by paulo on 16/05/2017.
 */

public class AnotacaoAdapter
        extends ArrayAdapter<Anotacao> {

    private int resourceId = 0;

    public AnotacaoAdapter(Context context, int resource, List<Anotacao> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(resourceId, parent, false);
        }

        TextView edtTitulo = (TextView) convertView.findViewById(R.id.txtTitulo);
        TextView edtDescricao = (TextView) convertView.findViewById(R.id.txtDescricao);
        TextView txtDataAtualizacao = (TextView) convertView.findViewById(R.id.txtDataAtualizacao);

        Anotacao anotacao = (Anotacao) getItem(position);

        edtTitulo.setText(anotacao.getTitulo());
        edtDescricao.setText(anotacao.getDescricao());
        txtDataAtualizacao.setText(anotacao.getDataAtualizacao().toString());
        return convertView;
    }
}
