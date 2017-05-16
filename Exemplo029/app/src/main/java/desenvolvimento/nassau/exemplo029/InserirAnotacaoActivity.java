package desenvolvimento.nassau.exemplo029;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by paulo on 15/05/2017.
 */

public class InserirAnotacaoActivity extends Activity implements View.OnClickListener {
    int idAnotacao = 0;
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
            btnAcao.setText("Atualizar");
            idAnotacao = extras.getInt("id");
            edtTitulo.setText(extras.getString("titulo"));
            edtDescricao.setText(extras.getString("descricao"));
        } else // insert
        {
            btnAcao.setText("Inserir");
        }


    }

    @Override
    public void onClick(View v) {
        Anotacao mAnotacao = new Anotacao();
        mAnotacao.setTitulo(edtTitulo.getText().toString());
        mAnotacao.setDataAtualizacao(new Date());
        mAnotacao.setDataInsercao(new Date());


        mAnotacao.setDescricao(edtDescricao.getText().toString());
        if (idAnotacao == 0) {

            ContentValues tuplaInserir = new ContentValues();
            tuplaInserir.put(AppAnotacaoContract.AnotacaoContract.COLUNA_TITULO, mAnotacao.getTitulo());
            tuplaInserir.put(AppAnotacaoContract.AnotacaoContract.COLUNA_DESCRICAO, mAnotacao.getDescricao());
            tuplaInserir.put(AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_INSERCAO, mAnotacao.getDataInsercao().getTime());
            tuplaInserir.put(AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_ATUALIZACAO, mAnotacao.getDataAtualizacao().getTime());
            dbEscrita.insert(AppAnotacaoContract.AnotacaoContract.TABELA_NOME, null, tuplaInserir);
        } else {

            String selection = AppAnotacaoContract.AnotacaoContract._ID + "=?";
            String[] selectionArgs = {String.valueOf(idAnotacao)};

            ContentValues tuplaAtualizar = new ContentValues();
            tuplaAtualizar.put(AppAnotacaoContract.AnotacaoContract.COLUNA_TITULO, mAnotacao.getTitulo());
            tuplaAtualizar.put(AppAnotacaoContract.AnotacaoContract.COLUNA_DESCRICAO, mAnotacao.getDescricao());
            tuplaAtualizar.put(AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_ATUALIZACAO, mAnotacao.getDataAtualizacao().getTime());
            dbEscrita.update(AppAnotacaoContract.AnotacaoContract.TABELA_NOME, tuplaAtualizar, selection, selectionArgs);

        }
        finish();


    }
}
