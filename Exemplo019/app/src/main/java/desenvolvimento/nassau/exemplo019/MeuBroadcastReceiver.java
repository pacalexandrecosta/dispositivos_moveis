package desenvolvimento.nassau.exemplo019;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by paulo on 10/04/2017.
 */

public class MeuBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "broadcast recebido" + intent.getExtras().getBoolean("state"), Toast.LENGTH_LONG).show();
    }
}
