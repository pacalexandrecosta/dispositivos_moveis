package desenvolvimento.nassau.exemplo020;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by paulo on 17/04/2017.
 */

public class MeuReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(MeuReceiver.class.getName(), "Broadcast recebido" + intent.getExtras().getString("nome"));
    }
}
