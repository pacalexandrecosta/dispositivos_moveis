package desenvolvimento.nassau.exemplo026;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by paulo on 27/04/2017.
 */

public class MainActivity extends Activity {
    EditText edtNumeroIssue = null;
    TextView txtTicket = null;
    ProgressBar pgbStatus = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumeroIssue = (EditText) findViewById(R.id.edtNumeroIssue);
        txtTicket = (TextView) findViewById(R.id.txtTicket);
        pgbStatus = (ProgressBar) findViewById(R.id.pgbStatus);
    }

    public void obBtnConsultarTicketClick(View v) {
        String numeroIssueStr = edtNumeroIssue.getText().toString();
        int numeroIssue = Integer.valueOf(numeroIssueStr);
        ConsultaTicket ticketAcessoATask = new ConsultaTicket();
        ticketAcessoATask.execute(new Integer(numeroIssue));

    }


    public class ConsultaTicket extends AsyncTask<Integer, Integer, JSONObject> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i(ConsultaTicket.class.getCanonicalName(), "1:onPreExecute");
            MainActivity.this.pgbStatus.setVisibility(View.VISIBLE);
        }


        @Override
        protected JSONObject doInBackground(Integer... params) {
            Log.i(ConsultaTicket.class.getCanonicalName(), "2:doInBackground");
            publishProgress(30,  50);
            JSONObject ticketJson = obterObjetoJson(params[0]);
            publishProgress(70, 90, 100);
            return ticketJson;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            for (int i = 0; i < values.length; i++)
                MainActivity.this.pgbStatus.setProgress(values[i]);
            Log.i(ConsultaTicket.class.getCanonicalName(), "3:onProgressUpdate");

        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            Log.i(ConsultaTicket.class.getCanonicalName(), "4:onProgressUpdate");
            MainActivity.this.txtTicket.setText(jsonObject.toString());
            MainActivity.this.pgbStatus.setVisibility(View.GONE);
        }

        private JSONObject obterObjetoJson(int numeroIssue) {
            JSONObject objeto = null;
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(getResources().getString(R.string.url_issue) + numeroIssue + ".json");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
                objeto = new JSONObject(buffer.toString()).getJSONObject("issue");
                reader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }
            return objeto;
        }
    }
}
