package desenvolvimento.nassau.exemplo030;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import java.util.Date;


/**
 * Created by paulo on 22/05/2017.
 */

public class MainActivity extends Activity {

    private static final String KEY_TEXT_REPLY = "key_text_reply";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onBtnNotificacaoClick(View v) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this);
        mBuilder.setContentTitle("Meu titulo");
        mBuilder.setContentText("Meu texto" + new Date().toString());
        mBuilder.setSmallIcon(R.drawable.ic_priority_high_black_24dp);
        mBuilder.setAutoCancel(true);

        Notification mNotification = mBuilder.build();
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mNotification);
    }

    public void onBtnGerarNotificacaoClick(View v) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this);
        mBuilder.setContentTitle("Meu titulo");
        mBuilder.setContentText("Meu texto" + new Date().toString());
        mBuilder.setSmallIcon(R.drawable.ic_priority_high_black_24dp);

        Intent mIntent = new Intent(MainActivity.this, ResultadoActivity.class);
        PendingIntent mPendingIntent = PendingIntent.getActivity(MainActivity.this, 0, mIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(mPendingIntent);
        mBuilder.setAutoCancel(true);

        Notification mNotification = mBuilder.build();
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mNotification);
    }


    public void onBtnNotificacaoCustomizadaClick(View v) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(MainActivity.this);
        mBuilder.setSmallIcon(R.drawable.ic_priority_high_black_24dp);

        RemoteViews contentView =
                new RemoteViews(getPackageName(), R.layout.notification_customizada);
        contentView.setImageViewResource(R.id.image, R.drawable.ic_priority_high_black_24dp);
        contentView.setTextViewText(R.id.title, "Título Customizado");
        contentView.setTextColor(R.id.title, Color.BLACK);

        contentView.setTextViewText(R.id.text, "Texto Customzado");
        contentView.setTextColor(R.id.text, Color.BLACK);
        mBuilder.setContent(contentView);

        Intent mIntent = new Intent(MainActivity.this, ResultadoActivity.class);
        PendingIntent mPendingIntent = PendingIntent.getActivity(
                MainActivity.this,
                0,
                mIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(mPendingIntent);
        mBuilder.setAutoCancel(true);

        Notification mNotification = mBuilder.build();
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mNotification);
    }

    public void onBtnNotificacaoAcaoClick(View v) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this);
        mBuilder.setContentTitle("Meu titulo");
        mBuilder.setContentText("Meu texto " + new Date().toString());
        mBuilder.setSmallIcon(R.drawable.ic_priority_high_black_24dp);

        Intent intentSim = new Intent(this, ResultadoActivity.class);
        intentSim.putExtra("opcao", "sim");
        PendingIntent pendingIntentSim = PendingIntent.getActivity(this, 1, intentSim, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intentNao = new Intent(this, ResultadoActivity.class);
        intentNao.putExtra("opcao", "nao");
        PendingIntent pendingIntentNao = PendingIntent.getActivity(this, 2, intentNao, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intentTalvez = new Intent(this, ResultadoActivity.class);
        intentTalvez.putExtra("opcao", "talvez");
        PendingIntent pendingIntentTalvez = PendingIntent.getActivity(this, 3, intentTalvez, PendingIntent.FLAG_UPDATE_CURRENT);


        mBuilder.setAutoCancel(true);

        mBuilder.addAction(R.drawable.ic_done_black_24dp, "Sim", pendingIntentSim);
        mBuilder.addAction(R.drawable.ic_cancel_black_24dp, "Não", pendingIntentNao);
        mBuilder.addAction(R.drawable.ic_warning_black_24dp, "Talvez", pendingIntentTalvez);

        Notification mNotification = mBuilder.build();
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mNotification);
    }
}

