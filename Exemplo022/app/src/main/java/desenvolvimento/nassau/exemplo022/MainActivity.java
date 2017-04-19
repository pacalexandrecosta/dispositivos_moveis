package desenvolvimento.nassau.exemplo022;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import desenvolvimento.nassau.exemplo022.R;

/**
 * Created by paulo on 18/04/2017.
 */

public class MainActivity extends Activity {

    EditText edtNome = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNome = (EditText)findViewById(R.id.edtNome);
    }

    public void onBtnEnviarBroadcastClick(View v)
    {
        Intent intencao = new Intent("desenvolvimento.nassau.PACOTE_RECEBIDO");
        intencao.putExtra("nome", edtNome.getText().toString());
        sendBroadcast(intencao);
    }
}
