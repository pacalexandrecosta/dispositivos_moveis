package desenvolvimento.nassau.exemplo029;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by paulo on 15/05/2017.
 */

public class InserirAnotacaoActivity
        extends Activity
        implements View.OnClickListener {

    Anotacao anotacaoUpdate = null;
    EditText edtTitulo = null;
    EditText edtDescricao = null;
    Button btnAcao = null;
    SQLiteDatabase dbEscrita = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserir_anotacao_activity);


        dbEscrita = new AppAnotacaoDbHelper(this).getWritableDatabase();

        edtTitulo = (EditText) findViewById(R.id.edtTitulo);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        btnAcao = (Button) findViewById(R.id.btnConfirmar);
        btnAcao.setOnClickListener(this);

        if (getIntent().getExtras() != null) // update
        {
            Bundle extras = getIntent().getExtras();
            anotacaoUpdate = (Anotacao) extras.getSerializable("anotacao");

            edtTitulo.setText(anotacaoUpdate.getTitulo());
            edtDescricao.setText(anotacaoUpdate.getDescricao());
        } else // insert
        {

        }


    }


    @Override
    public void onClick(View v) {

        long resultado = 0;
        if (anotacaoUpdate == null) {

            Anotacao anotacaoInsert = new Anotacao();
            anotacaoInsert.setTitulo(edtTitulo.getText().toString());
            anotacaoInsert.setDescricao(edtDescricao.getText().toString());
            anotacaoInsert.setDataAtualizacao(new Date());
            anotacaoInsert.setDataInsercao(new Date());

            resultado = desenvolvimento.nassau.exemplo029.Anotacao.insert(dbEscrita, anotacaoInsert);
            if (resultado > 0)
                Toast.makeText(this,
                        "Anotação inserida com sucesso",
                        Toast.LENGTH_SHORT).show();
        } else {

            String selection = AppAnotacaoContract.Anotacao._ID + "=?";
            String[] selectionArgs = {String.valueOf(anotacaoUpdate.getId())};

            anotacaoUpdate.setTitulo(edtTitulo.getText().toString());
            anotacaoUpdate.setDescricao(edtDescricao.getText().toString());
            anotacaoUpdate.setDataAtualizacao(new Date());

            resultado = desenvolvimento.nassau.exemplo029.Anotacao.update(dbEscrita, anotacaoUpdate);
            if (resultado > 0)
                Toast.makeText(this,
                        "Anotação atualizada com sucesso",
                        Toast.LENGTH_SHORT).show();

        }
        finish();


    }
}
