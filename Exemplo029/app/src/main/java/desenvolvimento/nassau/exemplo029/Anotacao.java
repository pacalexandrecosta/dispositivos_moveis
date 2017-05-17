package desenvolvimento.nassau.exemplo029;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by paulo on 15/05/2017.
 */

public class Anotacao implements Serializable {
    private int id;
    private String titulo;
    private String descricao;
    private Date dataInsercao;
    private Date dataAtualizacao;

    public Anotacao() {
    }

    public Anotacao(int id, String titulo, String descricao, Date dataInsercao, Date dataAtualizacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInsercao = dataInsercao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public void setDataInsercao(long dataInsercao) {
        this.dataInsercao = new Date(dataInsercao);
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public void setDataAtualizacao(long dataAtualizacao) {
        this.dataAtualizacao = new Date(dataAtualizacao);
    }

    public static int delete(SQLiteDatabase db, Anotacao anotacao) {
        String selection = AppAnotacaoContract.AnotacaoContract._ID + "=?";
        String[] selectionArgs = {String.valueOf(anotacao.getId())};

        return db.delete(AppAnotacaoContract.AnotacaoContract.TABELA_NOME, selection, selectionArgs);
    }

    public static long insert(SQLiteDatabase db, Anotacao anotacao) {
        ContentValues tuplaInserir = new ContentValues();
        tuplaInserir.put(AppAnotacaoContract.AnotacaoContract.COLUNA_TITULO, anotacao.getTitulo());
        tuplaInserir.put(AppAnotacaoContract.AnotacaoContract.COLUNA_DESCRICAO, anotacao.getDescricao());
        tuplaInserir.put(AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_INSERCAO, anotacao.getDataInsercao().getTime());
        tuplaInserir.put(AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_ATUALIZACAO, anotacao.getDataAtualizacao().getTime());
        return db.insert(AppAnotacaoContract.AnotacaoContract.TABELA_NOME, null, tuplaInserir);
    }

    public static int update(SQLiteDatabase db, Anotacao anotacao) {
        String selection = AppAnotacaoContract.AnotacaoContract._ID + "=?";
        String[] selectionArgs = {String.valueOf(anotacao.getId())};

        ContentValues tuplaAtualizar = new ContentValues();
        tuplaAtualizar.put(AppAnotacaoContract.AnotacaoContract.COLUNA_TITULO, anotacao.getTitulo());
        tuplaAtualizar.put(AppAnotacaoContract.AnotacaoContract.COLUNA_DESCRICAO, anotacao.getDescricao());
        tuplaAtualizar.put(AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_ATUALIZACAO, anotacao.getDataAtualizacao().getTime());
        return db.update(AppAnotacaoContract.AnotacaoContract.TABELA_NOME, tuplaAtualizar, selection, selectionArgs);
    }

    public static Anotacao getAnotacaoById(SQLiteDatabase db, int id) {
        Anotacao anotacao = null;
        String tabelaNome = AppAnotacaoContract.AnotacaoContract.TABELA_NOME;
        String[] colunas = new String[]{AppAnotacaoContract.AnotacaoContract._ID,
                AppAnotacaoContract.AnotacaoContract.COLUNA_TITULO,
                AppAnotacaoContract.AnotacaoContract.COLUNA_DESCRICAO,
                AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_INSERCAO,
                AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_ATUALIZACAO};
        String filtro = AppAnotacaoContract.AnotacaoContract._ID + "=?";
        String[] filtroArgs = {String.valueOf(id)};
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor mCursor = db.query(tabelaNome, colunas, filtro, filtroArgs, groupBy, having, orderBy);

        if (mCursor.getCount() > 0) {

            while (mCursor.moveToNext()) {
                anotacao = new Anotacao();
                int colIdIndex = mCursor.getColumnIndex(AppAnotacaoContract.AnotacaoContract._ID);
                int colTituloIndex = mCursor.getColumnIndex(AppAnotacaoContract.AnotacaoContract.COLUNA_TITULO);
                int colDescricaoIndex = mCursor.getColumnIndex(AppAnotacaoContract.AnotacaoContract.COLUNA_DESCRICAO);
                int colDataInsercaoIndex = mCursor.getColumnIndex(AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_INSERCAO);
                int colDataAtualizacaoIndex = mCursor.getColumnIndex(AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_ATUALIZACAO);

                anotacao.setId(mCursor.getInt(colIdIndex));
                anotacao.setTitulo(mCursor.getString(colTituloIndex));
                anotacao.setDescricao(mCursor.getString(colDescricaoIndex));
                anotacao.setDataInsercao(mCursor.getLong(colDataInsercaoIndex));
                anotacao.setDataAtualizacao(mCursor.getLong(colDataAtualizacaoIndex));

            }
        }
        mCursor.close();

        return anotacao;
    }

    public static List<Anotacao> getAnotacao(SQLiteDatabase db) {
        List<Anotacao> anotacoes = new ArrayList<Anotacao>();
        String tabelaNome = AppAnotacaoContract.AnotacaoContract.TABELA_NOME;
        String[] colunas = new String[]{AppAnotacaoContract.AnotacaoContract._ID,
                AppAnotacaoContract.AnotacaoContract.COLUNA_TITULO,
                AppAnotacaoContract.AnotacaoContract.COLUNA_DESCRICAO,
                AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_INSERCAO,
                AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_ATUALIZACAO};
        String filtro = null;
        String[] filtroArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor mCursor = db.query(tabelaNome, colunas, filtro, filtroArgs, groupBy, having, orderBy);


        while (mCursor.moveToNext()) {
            Anotacao anotacao = new Anotacao();

            int colIdIndex = mCursor.getColumnIndex(AppAnotacaoContract.AnotacaoContract._ID);
            int colTituloIndex = mCursor.getColumnIndex(AppAnotacaoContract.AnotacaoContract.COLUNA_TITULO);
            int colDescricaoIndex = mCursor.getColumnIndex(AppAnotacaoContract.AnotacaoContract.COLUNA_DESCRICAO);
            int colDataInsercaoIndex = mCursor.getColumnIndex(AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_INSERCAO);
            int colDataAtualizacaoIndex = mCursor.getColumnIndex(AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_ATUALIZACAO);

            anotacao.setId(mCursor.getInt(colIdIndex));
            anotacao.setTitulo(mCursor.getString(colTituloIndex));
            anotacao.setDescricao(mCursor.getString(colDescricaoIndex));
            anotacao.setDataInsercao(mCursor.getLong(colDataInsercaoIndex));
            anotacao.setDataAtualizacao(mCursor.getLong(colDataAtualizacaoIndex));
            anotacoes.add(anotacao);
        }

        mCursor.close();


        return anotacoes;
    }


}
