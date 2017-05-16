package desenvolvimento.nassau.exemplo029;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

/**
 * Created by paulo on 15/05/2017.
 */

public class Anotacao {
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

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
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

    public static int update(SQLiteDatabase db, Anotacao antigo, Anotacao novo) {
        String selection = AppAnotacaoContract.AnotacaoContract._ID + "=?";
        String[] selectionArgs = {String.valueOf(antigo.getId())};

        ContentValues tuplaAtualizar = new ContentValues();
        tuplaAtualizar.put(AppAnotacaoContract.AnotacaoContract.COLUNA_TITULO, novo.getTitulo());
        tuplaAtualizar.put(AppAnotacaoContract.AnotacaoContract.COLUNA_DESCRICAO, novo.getDescricao());
        tuplaAtualizar.put(AppAnotacaoContract.AnotacaoContract.COLUNA_DATA_ATUALIZACAO, novo.getDataAtualizacao().getTime());
        return db.update(AppAnotacaoContract.AnotacaoContract.TABELA_NOME, tuplaAtualizar, selection, selectionArgs);
    }


}
