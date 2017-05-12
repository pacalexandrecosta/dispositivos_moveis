package desenvolvimento.nassau.exemplo027;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.UserDictionary;
import android.provider.CalendarContract.Calendars;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulo on 02/05/2017.
 */

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) throws SecurityException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregarContatos();
    }

    public void carregarContatos() {
        EditText txtFiltro = (EditText) findViewById(R.id.txtFiltro);

        ListView lstPessoas = (ListView) findViewById(R.id.lstPessoas);
        List<String> nomes = new ArrayList<String>();
        ContentResolver resolver = getContentResolver();

        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String[] projection = new String[]{ContactsContract.Contacts.DISPLAY_NAME};

        String selection = ContactsContract.Contacts.DISPLAY_NAME + " like ?";
        String[] selectionArgs = new String[]{"%" + txtFiltro.getText().toString() + "%"};

        String sortOrder = ContactsContract.Contacts.DISPLAY_NAME + " ASC";

        Cursor cursor = resolver.query(uri, projection, selection, selectionArgs, sortOrder);

        while (cursor.moveToNext()) {
            int indiceColuna = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            nomes.add(cursor.getString(indiceColuna));
        }
        cursor.close();


        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);
        lstPessoas.setAdapter(adaptador);

        Log.i(MainActivity.class.getCanonicalName(), "URI-->" + uri.toString());
    }

    public void onBtnFiltrarClick(View v) {
        carregarContatos();
    }

    public void onBtnAddContactClick(View v) {

    }
}
