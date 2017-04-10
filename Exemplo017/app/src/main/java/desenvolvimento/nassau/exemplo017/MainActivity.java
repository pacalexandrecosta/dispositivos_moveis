package desenvolvimento.nassau.exemplo017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by paulo on 24/03/2017.
 */

public class MainActivity extends Activity {

    ArrayAdapter<String> adaptador = null;
    EditText novoConvidado = null;
    ListView listConvidados = null;
    ArrayList<String> convidados = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            convidados = (ArrayList<String>)
                    savedInstanceState.getSerializable("convidados");
        } else {
            convidados = new ArrayList<String>();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        novoConvidado = (EditText) findViewById(R.id.txtNome);
        listConvidados = (ListView) findViewById(R.id.lstConvidados);
        adaptador = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, convidados);
        listConvidados.setAdapter(adaptador);
    }

    public void onBntAdicionarClick(View v) {
        String nome = novoConvidado.getText().toString();
        adaptador.add(nome);
        novoConvidado.setText("");
        adaptador.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("convidados", convidados);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(MainActivity.class.getName(), "isFinishing"+isFinishing());
    }

    @Override
    protected void onDestroy() {
        super.onPause();
        Log.i(MainActivity.class.getName(), "on Destroy isFinishing"+isFinishing());
    }
}
