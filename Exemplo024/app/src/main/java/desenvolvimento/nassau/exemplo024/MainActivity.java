package desenvolvimento.nassau.exemplo024;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by paulo on 24/04/2017.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnStartServiceClick(View v) {
        Intent intencao = new Intent(this, MeuServico.class);
        PendingIntent intencaoPendente = PendingIntent.getService(this,0,intencao,0);
        try {
            intencaoPendente.send();
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
//        startService(intencao);
    }

    public void onBtnStopServiceClick(View v)
    {
        Intent intencao = new Intent(this, MeuServico.class);
        stopService(intencao);
    }
}
