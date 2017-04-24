package desenvolvimento.nassau.trabalho001;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by paulo on 20/03/2017.
 */

public class LivroAdapter extends ArrayAdapter<Livro> {

    public LivroAdapter(Context context, List<Livro> data) {
        super(context, R.layout.item_livro, data);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Livro livro = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_livro, parent, false);
        }

        TextView txtLivro = (TextView) convertView.findViewById(R.id.txtTitulo);
        TextView txtAutor = (TextView) convertView.findViewById(R.id.txtAutor);
        TextView txtAno = (TextView) convertView.findViewById(R.id.txtAno);

        txtLivro.setText(livro.getTitulo());
        txtAutor.setText(livro.getAutor());
        txtAno.setText(String.valueOf(livro.getAno()));

        return convertView;
    }
}
