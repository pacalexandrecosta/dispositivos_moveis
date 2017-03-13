package desenvolvimento.nassau.a006.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import desenvolvimento.nassau.a006.R;

/**
 * Created by paulo on 10/03/2017.
 */

public class MenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_weight);
    }

    public void onBtnClick(View v) {
        switch (v.getId()) {
            case R.id.btnLinearLayout:
                startActivity(new Intent(this, LinearActivity.class));
                break;
            case R.id.btnRelativeLayout:
                startActivity(new Intent(this, RelativeActivity.class));
                break;
            default:
                break;
        }

    }
}
