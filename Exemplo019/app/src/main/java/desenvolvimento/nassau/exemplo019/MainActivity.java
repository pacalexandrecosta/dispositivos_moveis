package desenvolvimento.nassau.exemplo019;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Telephony;
import android.util.Log;

import java.util.List;

/**
 * Created by paulo on 10/04/2017.
 */

public class MainActivity extends Activity {
    BroadcastReceiver br=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        br = new SMSBroadcastReceiver();
        IntentFilter filtro = new IntentFilter();
        filtro.addAction("android.provider.Telephony.SMS_RECEIVED");
        this.registerReceiver(br,filtro);
    }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            this.unregisterReceiver(br);
        }
}
