package pl.edu.uwr.pum.notificationsbasicsjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final String channelID = "channel_id";
    private final String channelName = "channel_name";
    private final int notificationId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(v -> {
            createNotification();
        });
    }

    private void createNotification() {
        String description = "powiadomienie";
        final int importance = NotificationManager.IMPORTANCE_DEFAULT;
        final NotificationChannel channel =
                new NotificationChannel(channelID, channelName, importance);
        channel.setDescription(description);

        NotificationManager notificationManager =
                getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle("Powiadomienie")
                .setContentText("Treść powiadomienia")
                .setStyle(
                        new NotificationCompat.BigTextStyle()
                                .bigText("Dalszy tekst powiadomienia")
                )
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationCompat = NotificationManagerCompat.from(this);
        notificationCompat.notify(notificationId, builder.build());

    }

}