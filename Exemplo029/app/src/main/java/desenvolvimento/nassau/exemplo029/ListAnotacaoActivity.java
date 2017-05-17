package desenvolvimento.nassau.exemplo029;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;

/**
 * Created by paulo on 15/05/2017.
 */

public class ListAnotacaoActivity
        extends Activity
        implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    private ListView listAnotacoes = null;
    private FloatingActionButton fabAddAnotacao = null;
    private AnotacaoAdapter mAdapter = null;
    private AppAnotacaoDbHelper dbHelper = null;
    private Anotacao anotacaoDelete = null;
    SQLiteDatabase dbLeitura = null;
    SQLiteDatabase dbEscrita = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_anotacao_activity);

        listAnotacoes = (ListView) findViewById(R.id.lstAnotacoes);
        dbHelper = new AppAnotacaoDbHelper(this);

        dbLeitura = dbHelper.getReadableDatabase();
        dbEscrita = dbHelper.getWritableDatabase();

        fabAddAnotacao = (FloatingActionButton) findViewById(R.id.fabAddAnotacao);
        fabAddAnotacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(ListAnotacaoActivity.this, InserirAnotacaoActivity.class);
                ListAnotacaoActivity.this.startActivity(mIntent);
            }
        });

        listAnotacoes.setOnItemClickListener(this);
        listAnotacoes.setOnItemLongClickListener(this);
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        new AnotacaoAsyncTask().execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {
        Intent mIntent = new Intent(ListAnotacaoActivity.this, InserirAnotacaoActivity.class);
        Anotacao anotacaoSelecionada = (Anotacao) mAdapter.getItem(position);
        mIntent.putExtra("anotacao", anotacaoSelecionada);
        ListAnotacaoActivity.this.startActivity(mIntent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent,
                                   View view,
                                   int position,
                                   long id) {
        anotacaoDelete = (Anotacao) parent.getItemAtPosition(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(ListAnotacaoActivity.this);
        builder = builder.setMessage("Deseja apagar esta anotação?")
                .setTitle("Atenção").setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(ListAnotacaoActivity.class.getCanonicalName(), "Long Click no item da Lista");
                        Anotacao.delete(dbEscrita, anotacaoDelete);
                        new AnotacaoAsyncTask().execute();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
        return false;
    }


    private class AnotacaoAsyncTask extends AsyncTask<Void, Double, List<Anotacao>> {
        @Override
        protected List<Anotacao> doInBackground(Void... params) {
            return Anotacao.getAnotacao(dbLeitura);
        }

        @Override
        protected void onProgressUpdate(Double... values) {
            super.onProgressUpdate(values);
            Log.i(ListAnotacaoActivity.class.getCanonicalName(),
                    "Porcentagem " + values[0] * 100 + "%");
        }

        @Override
        protected void onPostExecute(List<Anotacao> anotacoes) {
            super.onPostExecute(anotacoes);

            mAdapter = new AnotacaoAdapter(
                    ListAnotacaoActivity.this,
                    R.layout.anotacao_item_list,
                    anotacoes);
            listAnotacoes.setAdapter(mAdapter);
        }
    }
}
