package desenvolvimento.nassau.exemplo025;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import desenvolvimento.nassau.exemplo025.MeuServicoVinculado.LocalBinder;

/**
 * Created by paulo on 26/04/2017.
 */

public class MainActivity extends Activity implements ServiceConnection {

    private EditText edtNumero = null;
    private TextView txtStatusVinculacao = null;
    private boolean vinculado = false;
    private LocalBinder mBinder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumero = (EditText) findViewById(R.id.edtNumero);
        txtStatusVinculacao = (TextView) findViewById(R.id.txtStatusVinculacao);
        setVinculado(vinculado);
    }

    public void onBtnBindServiceClick(View v) {
        Intent intencao = new Intent(this, MeuServicoVinculado.class);
        bindService(intencao, this, Context.BIND_AUTO_CREATE);
    }

    public void onBtnRequestServiceClick(View v) {
        String numeroStr = edtNumero.getText().toString();
        int numero = Integer.valueOf(numeroStr);
        boolean resultado = mBinder.getService().eNumeroPar(numero);
        Toast.makeText(this, numero + " é par ?: " + resultado, Toast.LENGTH_LONG).show();
    }

    public void onBtnUnbindServiceClick(View v) {
        unbindService(this);
        setVinculado(false);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        setVinculado(true);
        mBinder = (LocalBinder) service;
    }


    @Override
    public void onServiceDisconnected(ComponentName name) {
        setVinculado(false);
    }


    public void setVinculado(boolean vinculado) {
        this.vinculado = vinculado;
        if (this.vinculado) {
            txtStatusVinculacao.setText("Serviço vinculado");
        }
        else {
            txtStatusVinculacao.setText("Serviço não vinculado");
        }
    }


}
