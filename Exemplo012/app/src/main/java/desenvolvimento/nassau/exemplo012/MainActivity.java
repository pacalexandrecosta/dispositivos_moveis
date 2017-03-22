package desenvolvimento.nassau.exemplo012;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import desenvolvimento.nassau.exemplo012.R;

/**
 * Created by paulo on 21/03/2017.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        String[] meses = getResources().getStringArray(R.array.arrayMeses);
        ListView lstMeses = (ListView)findViewById(R.id.lstMeses);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.item_list_italico, meses);
        lstMeses.setAdapter(adaptador);
    }
}
