package desenvolvimento.nassau.trabalho001;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by paulo on 20/03/2017.
 */

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actitivy_main);
        ListView listViewLivros = (ListView) findViewById(R.id.listLivros);
        LivroAdapter adapter = new LivroAdapter(this, new Livro().getLivros());
        listViewLivros.setAdapter(adapter);
        listViewLivros.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Livro livro = (Livro) parent.getItemAtPosition(position);
        Uri uri = Uri.parse("http://www.google.com/#q=" + livro.getTitulo());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
