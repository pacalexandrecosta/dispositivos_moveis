package desenvolvimento.nassau.a011;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

/**
 * Created by paulo on 17/03/2017.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTglPromocaoClick(View v) {
        ToggleButton toggle = (ToggleButton) v;

        RadioButton rdBtn = (RadioButton) findViewById(R.id.rdNao);
        rdBtn.setChecked(false);

        RadioButton rdEmail = (RadioButton) findViewById(R.id.rdEmail);
        rdEmail.setChecked(false);

        RadioButton rdTelefone = (RadioButton) findViewById(R.id.rdTelefone);
        rdTelefone.setChecked(false);
    }

    public void onBtnLimparClick(View v) {
        RadioGroup rdGroup = (RadioGroup) findViewById(R.id.rdgModo);
        int id = rdGroup.getCheckedRadioButtonId();

        RadioButton rdBtn = (RadioButton) findViewById(id);
        rdBtn.setChecked(false);

//        RadioButton rdBtn = (RadioButton) findViewById(R.id.rdNao);
//        rdBtn.setChecked(false);
//
//        RadioButton rdEmail = (RadioButton) findViewById(R.id.rdEmail);
//        rdEmail.setChecked(false);
//
//        RadioButton rdTelefone = (RadioButton) findViewById(R.id.rdTelefone);
//        rdTelefone.setChecked(false);


    }
}
