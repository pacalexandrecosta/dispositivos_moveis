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
        Bundle dados = intent.getExtras();
        int numeroIssue = dados.getInt("numeroIssue");

        Log.i(MeuServico.class.getCanonicalName(), "Antes Thread.Sleep");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(MeuServico.class.getCanonicalName(), "Após Thread.Sleep");
        return START_STICKY;
    }

//    private JSONObject obterObjetoJson(int numeroIssue) {
//        JSONObject objeto = null;
//        HttpURLConnection connection = null;
//        BufferedReader reader = null;
//        try {
//            URL url = new URL(getResources().getString(R.string.url_issue) + numeroIssue + ".json");
//            connection = (HttpURLConnection) url.openConnection();
//            connection.connect();
//
//            InputStream stream = connection.getInputStream();
//            reader = new BufferedReader(new InputStreamReader(stream));
//
//            StringBuffer buffer = new StringBuffer();
//            String line = "";
//
//            while ((line = reader.readLine()) != null) {
//                buffer.append(line + "\n");
//                Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)
//
//            }
//            objeto = new JSONObject(buffer.toString()).getJSONObject("issue");
//            reader.close();
//            Thread.sleep(30000);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            connection.disconnect();
//        }
//        return objeto;
//    }

}