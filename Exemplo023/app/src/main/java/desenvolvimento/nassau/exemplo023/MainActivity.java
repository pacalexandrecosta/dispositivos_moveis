package desenvolvimento.nassau.exemplo023;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by paulo on 24/04/2017.
 */

public class MainActivity extends Activity {

    EditText edtNumeroIssue = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumeroIssue = (EditText) findViewById(R.id.edtNumeroIssue);
    }

    public void onBtnStartServiceClick(View v) {
        int numeroIssue = Integer.valueOf(edtNumeroIssue.getText().toString());
        Intent intencao = new Intent(this, MeuServico.class);
        intencao.putExtra("numeroIssue", numeroIssue);
        startService(intencao);
    }
}
