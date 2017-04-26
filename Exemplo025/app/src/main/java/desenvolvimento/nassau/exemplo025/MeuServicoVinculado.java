package desenvolvimento.nassau.exemplo025;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by paulo on 26/04/2017.
 */

public class MeuServicoVinculado extends android.app.Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new LocalBinder();
    }
    @Override
    public void onCreate() {
        Log.i(MeuServicoVinculado.class.getCanonicalName(), "onCreate executado");
    }
    @Override
    public void onDestroy() {
        Log.i(MeuServicoVinculado.class.getCanonicalName(), "onDestroy executado");
    }
    public boolean eNumeroPar(int i) {
        return i % 2 == 0;
    }


    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public MeuServicoVinculado getService() {
            return MeuServicoVinculado.this;
        }
    }





}
