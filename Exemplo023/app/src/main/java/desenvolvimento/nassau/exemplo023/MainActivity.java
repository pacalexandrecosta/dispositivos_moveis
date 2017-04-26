package desenvolvimento.nassau.exemplo023;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by paulo on 24/04/2017.
 */

public class MainActivity extends Activity {

    public final static String DADO_RECEBIDO = "desenvolvimento.nassau.exemplo023.DADO_RECEBIDO";

    EditText edtNumeroIssue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumeroIssue = (EditText) findViewById(R.id.edtNumeroIssue);
        registrarLocalBroadcastReceiver();
    }

    public void onBtnStartServiceClick(View v) {
        int numeroIssue = Integer.valueOf(edtNumeroIssue.getText().toString());
        Intent intencao = new Intent(this, MeuServico.class);
        intencao.putExtra("numeroIssue", numeroIssue);
        startService(intencao);
    }


    private void registrarLocalBroadcastReceiver() {
        BroadcastReceiver br = new MeuBroadcast();
        IntentFilter intencao = new IntentFilter(DADO_RECEBIDO);
        LocalBroadcastManager.getInstance(this).registerReceiver(br, intencao);
    }

    public class MeuBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String jsonStr = intent.getExtras().getString("ticket");
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                Toast.makeText(MainActivity.this, jsonObj.getString("id"), Toast.LENGTH_LONG).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


}
