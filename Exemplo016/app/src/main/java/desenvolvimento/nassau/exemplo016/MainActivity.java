package desenvolvimento.nassau.exemplo016;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

/**
 * Created by paulo on 24/03/2017.
 */

public class MainActivity extends Activity {

    private RecyclerView mRecyclerView = null;
    private RecyclerView.Adapter mAdapter = null;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,1));

        // specify an adapter (see also next example)

        ArrayList<String> personagens = new ArrayList<String>();
        for (String personagem : getResources().getStringArray(R.array.arrayPersonagens))
            personagens.add(personagem);
        mAdapter = new PersonagemAdaptador(this, personagens);


        mRecyclerView.setAdapter(mAdapter);


    }
}
