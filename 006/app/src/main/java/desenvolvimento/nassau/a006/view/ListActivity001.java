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

public class ListActivity001 extends android.app.Activity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_001);

        List<Aluno> alunos = new AlunoDAO().getAlunos();
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, R.layout.itemlist, alunos);

        ListView listVwMeses = (ListView) findViewById(R.id.listMeses);
        listVwMeses.setOnItemClickListener(this);
        listVwMeses.setAdapter(adapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ArrayAdapter<Aluno> adapter = (ArrayAdapter) parent.getAdapter();
        Aluno aluno = adapter.getItem(position);
        Toast.makeText(this, aluno.getNome(), Toast.LENGTH_SHORT).show();

    }

}
