package desenvolvimento.nassau.exemplo029;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import desenvolvimento.nassau.exemplo029.AppAnotacaoContract.Anotacao;

/**
 * Created by paulo on 15/05/2017.
 */

public class AppAnotacaoDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AppAnotacao.db";

    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + Anotacao.TABELA_NOME + " (" +
                    Anotacao._ID + " INTEGER PRIMARY KEY," +
                    Anotacao.COLUNA_TITULO + " TEXT NOT NULL," +
                    Anotacao.COLUNA_DESCRICAO + " TEXT NOT NULL," +
                    Anotacao.COLUNA_DATA_INSERCAO + " LONG NOT NULL," +
                    Anotacao.COLUNA_DATA_ATUALIZACAO + " LONG NOT NULL);";

    private static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + Anotacao.TABELA_NOME;


    public AppAnotacaoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL(SQL_DELETE_TABLE);
       // db.execSQL(SQL_CREATE_TABLE);
    }
}
