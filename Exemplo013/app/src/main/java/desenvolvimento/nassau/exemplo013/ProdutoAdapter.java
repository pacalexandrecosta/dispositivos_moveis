package desenvolvimento.nassau.exemplo013;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by paulo on 21/03/2017.
 */

public class ProdutoAdapter extends ArrayAdapter<Produto> {


    public ProdutoAdapter(Context contexto, List<Produto> produtos) {
        super(contexto, 0, produtos);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produto prod = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list_produto, parent, false);
        }

        TextView txtNome = (TextView)convertView.findViewById(R.id.txtNome);
        TextView txtDescricao = (TextView)convertView.findViewById(R.id.txtDescricao);
        TextView txtValorUnitario = (TextView)convertView.findViewById(R.id.txtValorUnit);

        txtNome.setText(prod.getNome());
        txtDescricao.setText(prod.getDescricao());
        txtValorUnitario.setText(String.valueOf(prod.getValorUnitario()));

        return convertView;
    }
}
