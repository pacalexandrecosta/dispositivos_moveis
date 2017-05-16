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

/**
 * Created by paulo on 15/05/2017.
 */

public class ListAnotacaoActivity extends Activity {

    private ListView listAnotacoes = null;
    private FloatingActionButton fabAddAnotacao = null;
    private SimpleCursorAdapter mAdapter = null;
    private String[] colunasDe = new String[]{AppAnotacaoContract.AnotacaoContract.COLUNA_TITULO,
            AppAnotacaoContract.AnotacaoContract.COLUNA_DESCRICAO,
            AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_ATUALIZACAO};
    private int[] colunasPara = new int[]{R.id.txtTitulo, R.id.txtDescricao, R.id.txtDataAtualizacao};
    private AppAnotacaoDbHelper dbHelper = null;

    SQLiteDatabase dbLeitura = null;
    SQLiteDatabase dbEscrita = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_anotacao_activity);
        mAdapter = new SimpleCursorAdapter(this, R.layout.anotacao_item_list, null, colunasDe, colunasPara, 0);
        listAnotacoes = (ListView) findViewById(R.id.lstAnotacoes);
        listAnotacoes.setAdapter(mAdapter);

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

        listAnotacoes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListAnotacaoActivity.this);


                // 2. Chain together various setter methods to set the dialog characteristics
                builder = builder.setMessage("Deseja apagar esta anotação?")
                        .setTitle("Atenção").setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i(ListAnotacaoActivity.class.getCanonicalName(), "Long Click no item da Lista");

                                Cursor mCursor = mAdapter.getCursor();
                                mCursor.moveToPosition(position);

                                int idAnotacao = mCursor.getInt(0);

                                String selection = AppAnotacaoContract.AnotacaoContract._ID + "=?";
                                String[] selectionArgs = {String.valueOf(idAnotacao)};

                                dbEscrita.delete(AppAnotacaoContract.AnotacaoContract.TABELA_NOME, selection, selectionArgs);

                            }
                        });

                // 3. Get the AlertDialog from create()
                AlertDialog dialog = builder.create();
                dialog.show();
                return false;
            }
        });

        listAnotacoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(ListAnotacaoActivity.this, InserirAnotacaoActivity.class);

                Cursor mCursor = mAdapter.getCursor();
                mCursor.moveToPosition(position);

                int idAnotacao=mCursor.getInt(0);
                String titulo =mCursor.getString(1);
                String descricao =mCursor.getString(2);

                mIntent.putExtra("id", idAnotacao);
                mIntent.putExtra("titulo", titulo);
                mIntent.putExtra("descricao", descricao);


                ListAnotacaoActivity.this.startActivity(mIntent);
            }
        });


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

    private class AnotacaoAsyncTask extends AsyncTask<Void, Double, Cursor> {

        @Override
        protected Cursor doInBackground(Void... params) {
            String tabelaNome = AppAnotacaoContract.AnotacaoContract.TABELA_NOME;
            String[] colunas = new String[]{AppAnotacaoContract.AnotacaoContract._ID,
                    AppAnotacaoContract.AnotacaoContract.COLUNA_TITULO,
                    AppAnotacaoContract.AnotacaoContract.COLUNA_DESCRICAO,
                    //AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_INSERCAO,
                    "date(" + AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_INSERCAO + "/1000,'unixepoch','localtime')",
                    AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_ATUALIZACAO};
            String filtro = null;
            String[] filtroArgs = null;
            String groupBy = null;
            String having = null;
            String orderBy = null;

            Cursor mCursor = dbLeitura.query(tabelaNome, colunas, filtro, filtroArgs, groupBy, having, orderBy);


            return mCursor;
        }

        @Override
        protected void onProgressUpdate(Double... values) {
            super.onProgressUpdate(values);
            Log.i(ListAnotacaoActivity.class.getCanonicalName(), "Porcentagem " + values[0] * 100 + "%");
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);
            ListAnotacaoActivity.this.mAdapter.swapCursor(cursor);
        }
    }


}
