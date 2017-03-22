package desenvolvimento.nassau.exemplo013;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

/**
 * Created by paulo on 21/03/2017.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Produto> produtos = new Produto().getProdutos();
        ProdutoAdapter adaptador = new ProdutoAdapter(this, produtos);
        ListView listProdutos = (ListView) findViewById(R.id.lstProdutos);
        listProdutos.setAdapter(adaptador);
    }
}
