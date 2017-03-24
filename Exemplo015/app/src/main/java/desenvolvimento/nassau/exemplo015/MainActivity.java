package desenvolvimento.nassau.exemplo015;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by paulo on 23/03/2017.
 */

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spnDias);

        String[] dados = getResources().getStringArray(R.array.arrayDias);
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dados);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String dadoSelecionado =
                parent.getItemAtPosition(position).toString();
        Log.i(MainActivity.class.getName(), "Novo Dado Selecionado" + dadoSelecionado);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.i(MainActivity.class.getName(), "Nenhum dado selecionado");
    }
}
