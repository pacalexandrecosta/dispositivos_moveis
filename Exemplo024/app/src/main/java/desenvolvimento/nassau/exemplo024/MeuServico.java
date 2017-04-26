package desenvolvimento.nassau.exemplo024;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by paulo on 24/04/2017.
 */

public class MeuServico extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startID) {


        Log.i(MeuServico.class.getCanonicalName(), "Antes Thread.Sleep");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(MeuServico.class.getCanonicalName(), "Após Thread.Sleep");
        return START_STICKY;
    }


    @Override
    public void onCreate() {
        Log.i(MeuServico.class.getCanonicalName(), "onCreate executado");
    }

    @Override
    public void onDestroy() {
        Log.i(MeuServico.class.getCanonicalName(), "onDestroy executado");
    }
}