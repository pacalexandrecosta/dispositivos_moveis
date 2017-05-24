package desenvolvimento.nassau.exemplo030;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by paulo on 22/05/2017.
 */
public class ResultadoActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView txtMsg = (TextView) findViewById(R.id.txtMsg);
        Bundle dados = getIntent().getExtras();
        if (dados != null) {
            NotificationManager mNotificationManager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);
            mNotificationManager.cancel(0);

            String opcao = dados.getString("opcao");
            switch (opcao) {
                case "sim":
                    txtMsg.setText("Você respondeu sim");
                    break;
                case "talvez":
                    txtMsg.setText("Você respondeu talvez");
                    break;
                case "nao":
                    txtMsg.setText("Você respondeu não");
                    break;
                default:
                    break;
            }
        }
    }
}
