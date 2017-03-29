package desenvolvimento.nassau.exemplo018;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.usage.ConfigurationStats;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

/**
 * Created by paulo on 28/03/2017.
 */

public class MainActivity extends Activity
        implements OnNoticiaSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragManager = getFragmentManager();
        FragmentTransaction fragTransaction = fragManager.beginTransaction();

        getFragmentManager().executePendingTransactions();
        Fragment fragmentById = fragManager.
                findFragmentById(R.id.fragment_manchetes_container);
        if (fragmentById != null) {
            fragTransaction.remove(fragmentById);
        }


        if (findViewById(R.id.fragment_manchetes_container) != null) {
            MancheteFragment mancheteFrag = new MancheteFragment();
            fragTransaction.add(R.id.fragment_manchetes_container, mancheteFrag);

        }
        fragTransaction.commit();
    }

    @Override
    public void onNoticiaSelected(Noticia noticia) {
        if (findViewById(R.id.fragment_manchetes_container) != null) {
            Bundle parametros = new Bundle();
            parametros.putInt("id_noticia", noticia.getId());
            NoticiaFragment noticiaFrag = new NoticiaFragment();
            noticiaFrag.setArguments(parametros);

            FragmentManager fragManager = getFragmentManager();
            FragmentTransaction fragTransaction = fragManager.beginTransaction();

            fragTransaction.replace(R.id.fragment_manchetes_container, noticiaFrag);
            fragTransaction.addToBackStack(null);
            fragTransaction.commit();

        } else {
            FragmentManager fragManager = getFragmentManager();
            NoticiaFragment noticiaFrag = (NoticiaFragment)
                    fragManager.findFragmentById(R.id.fragNoticia);
            noticiaFrag.setNoticia(noticia);
        }
    }
}
