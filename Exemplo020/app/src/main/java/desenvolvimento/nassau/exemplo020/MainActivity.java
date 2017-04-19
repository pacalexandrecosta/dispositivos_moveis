package desenvolvimento.nassau.exemplo020;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.EditText;

/**
 * Created by paulo on 17/04/2017.
 */

public class MainActivity extends Activity {
    EditText edtNome = null;
    MeuReceiver mReceiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNome = (EditText) findViewById(R.id.edtNome);

        IntentFilter filtroIntencao = new IntentFilter(getResources().getString(R.string.intent_dado_enviado));
        mReceiver = new MeuReceiver();
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, filtroIntencao);
    }

    public void onEnviarClick(View v) {
        Intent intencao = new Intent(getResources().getString(R.string.intent_dado_enviado));
        intencao.putExtra("nome", edtNome.getText().toString());
        LocalBroadcastManager.getInstance(this).sendBroadcast(intencao);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
    }
}
