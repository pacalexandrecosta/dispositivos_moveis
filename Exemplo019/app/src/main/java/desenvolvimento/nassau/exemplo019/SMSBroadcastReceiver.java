package desenvolvimento.nassau.exemplo019;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by paulo on 10/04/2017.
 */

public class SMSBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Recebi um sms!", Toast.LENGTH_SHORT).show();
    }
}
