package alejandro.topweather;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

import static android.content.ContentValues.TAG;

/**
 * Created by Alex on 26/12/16.
 */

public class NotificacionsListenerService extends GcmListenerService {

    @Override
    public void onMessageReceived(String from, Bundle data) {

        String message = data.getString("message");
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_cloud_white_24dp)
                .setContentTitle("Recibido mensaje del servidor")
                .setContentText(message)
                .setContentInfo("4")
                .setTicker("¡Alerta!")
                //.addAction(R.drawable.ic_cloud_white_24dp, "4", pendingIntent)
                .setVibrate(new long[] {100, 250, 100, 500});
        notificationManager.notify(1, mBuilder.build());
    }
}
