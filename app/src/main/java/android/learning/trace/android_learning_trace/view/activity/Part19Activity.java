package android.learning.trace.android_learning_trace.view.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.learning.trace.android_learning_trace.R;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

//Notification message.

public class Part19Activity extends AppCompatActivity {

    private final int NID_1 = 0x1;
    private final int NID_2 = 0x2;
    private final int NID_3 = 0x3;
    private final int NID_4 = 0x4;
    private final int NID_5 = 0x5;
    private final String CHANNEL_ID = "Channel 2";
    private Button
            btnShowNotification1,
            btnShowNotification2,
            btnShowNotification3,
            btnShowNotification4,
            btnShowNotification5;
    private PendingIntent notificationPendingIntent;
    private NotificationChannel channel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part19);
        init();
    }

    private void init() {
        btnShowNotification1 = findViewById(R.id.btn_part19_notification_1);
        btnShowNotification2 = findViewById(R.id.btn_part19_notification_2);
        btnShowNotification3 = findViewById(R.id.btn_part19_notification_3);
        btnShowNotification4 = findViewById(R.id.btn_part19_notification_4);
        btnShowNotification5 = findViewById(R.id.btn_part19_notification_5);

        btnShowNotification1.setOnClickListener(v -> {
            showSmallNotification();
        });

        btnShowNotification2.setOnClickListener(v -> {
            showLargeNotification();
        });

        btnShowNotification3.setOnClickListener(v -> {
            showMultilineNotification();
        });

        btnShowNotification4.setOnClickListener(v -> {
            showProgressBarNotification();
        });

        btnShowNotification5.setOnClickListener(v -> {
            showCustomizedViewNotification();
        });
    }

    private void showCustomizedViewNotification() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);

        RemoteViews view = new RemoteViews(getPackageName(), R.layout.layout_p19_customized_view);


        Notification n =
                builder
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Customized View")
                        .setContentText("Content")
                        .setContent(view)
                        .setTicker("Player")
                        .build();
        NotificationManagerCompat nm = NotificationManagerCompat.from(this);
        nm.notify(NID_5, n);

    }

    private void showProgressBarNotification() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        Notification n =
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("ProgressBar")
                        .setContentText("Update")
                        .setOnlyAlertOnce(true)
                        .setProgress(100, 5, false)
                        .build();
        NotificationManagerCompat nm = NotificationManagerCompat.from(this);
        nm.notify(NID_4, n);

        new Thread(new Runnable() {
            @Override
            public void run() {
                int nProgress = 0;
                for (int progress = 0; progress <= 100; progress += 5) {
                    builder.setProgress(100, progress, false);
                    nm.notify(NID_4, builder.build());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                builder.setProgress(0, 0, false);
                builder.setContentText("Update successful.");
                nm.notify(NID_4, builder.build());
            }
        }).start();


    }

    private void showLargeNotification() {

        NotificationCompat.Builder builder1 = new NotificationCompat.Builder(this, CHANNEL_ID);


        Notification n1 =
                builder1
                        .setSmallIcon(R.mipmap.ic_android_robot)
                        .setContentTitle("Another test message.")
                        .setContentText("This is another text message")
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_android_robot))
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigLargeIcon(
                                        BitmapFactory.decodeResource(getResources(), R.mipmap.ic_android_robot))
                                .bigLargeIcon(null))
                        .build();


        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(NID_2, n1);


    }

    private void showMultilineNotification() {
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder2.setSmallIcon(R.mipmap.ic_android_robot).setContentTitle("Title").setContentText("Message");
        builder2.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_android_robot));
        NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
        style.setBigContentTitle("Big title");
        style.addLine("Line1");
        style.addLine("Line2");
        style.setSummaryText("Summary");
        builder2.setNumber(5);
        builder2.setStyle(style);
        Notification n2 = builder2.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(NID_3, n2);


    }

    private void showSmallNotification() {
        Intent activityIntent = new Intent(this, getClass());
        notificationPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        activityIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

        //Create the notification channel.
        createNotificationChannel();

        //Before API 11, use constructor to build the notification object.
        //Notification notification = new Notification();

        //After API 11, use builder to build the notification object.
        //Notification.Builder builder = new Notification.Builder(this);


        //V4 support package.
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        //Set notification attributes.
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("You have a new message.");
        builder.setContentText("Hello, this is a test message.");

        //Enable vibration.
        setChannelVibration(true, channel, new long[]{100});
        //Set auto cancel flag. It must be use with the PendingIntent together.
        builder.setAutoCancel(false);
        builder.setContentIntent(notificationPendingIntent);

        //Set on going notification.
        //builder.setOngoing(true);

        //Set ticker.
        builder.setTicker("New message");

        //Create notification.
        Notification n = builder.build();


        //Get notificationManager.
        NotificationManagerCompat nm = NotificationManagerCompat.from(this);
        //Another way to get the notification manager.
        NotificationManager nm1 = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //Send
        nm.notify(NID_1, n);

        Toast.makeText(this, "Notification 1 is send.", Toast.LENGTH_SHORT).show();
    }


    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Test 1";
            String description = "This is a test notification channel.";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void setChannelVibration(Boolean isVibrate, NotificationChannel channel, long[] pattern) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            channel.setVibrationPattern(pattern);
            channel.enableVibration(isVibrate);

        }


    }
}
