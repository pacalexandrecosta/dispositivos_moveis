package desenvolvimento.nassau.exemplo021;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by paulo on 18/04/2017.
 */

public class PacoteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(PacoteReceiver.class.getName(), "Broadcast recebido na aplicação Exemplo021");
        Log.i(PacoteReceiver.class.getName(), "Nome :  "+intent.getExtras().getString("nome"));
        abortBroadcast();
    }
}
