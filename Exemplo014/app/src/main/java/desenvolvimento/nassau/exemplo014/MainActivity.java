package desenvolvimento.nassau.exemplo014;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import desenvolvimento.nassau.exemplo014.R;

/**
 * Created by paulo on 23/03/2017.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid);
        String[] dados = getResources().getStringArray(R.array.arrayAlunos);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dados);
        gridView.setAdapter(adaptador);

    }
}

