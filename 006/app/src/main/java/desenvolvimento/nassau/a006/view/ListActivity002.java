package desenvolvimento.nassau.a006.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import desenvolvimento.nassau.a006.R;
import desenvolvimento.nassau.a006.dao.AlunoDAO;
import desenvolvimento.nassau.a006.model.Aluno;

public class ListActivity002 extends android.app.Activity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_001);

        String[] meses = getResources().getStringArray(R.array.arrayMeses);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, meses);

        ListView listVwAlunos = (ListView) findViewById(R.id.listMeses);
        listVwAlunos.setOnItemClickListener(this);
        listVwAlunos.setAdapter(adapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ArrayAdapter<String> adapter = (ArrayAdapter) parent.getAdapter();
        String mes= adapter.getItem(position);
        Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();

    }

}
