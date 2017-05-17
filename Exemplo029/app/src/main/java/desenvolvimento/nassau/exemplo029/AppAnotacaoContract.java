package desenvolvimento.nassau.exemplo029;

import android.provider.BaseColumns;

/**
 * Created by paulo on 15/05/2017.
 */

public final class AppAnotacaoContract {
        private AppAnotacaoContract() {
    }

    public static class AnotacaoContract implements BaseColumns {
        public static final String TABELA_NOME="anotacao";
        public static final String COLUNA_TITULO ="titulo";
        public static final String COLUNA_DESCRICAO ="descricao";
        public static final String COLUNA_DATA_INSERCAO ="dataInsercao";
        public static final String COLUNA_DATA_ATUALIZACAO ="dataAtualizacao";
    }
}
