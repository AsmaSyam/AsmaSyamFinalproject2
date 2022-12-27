package com.example.asmasyamfinalproject.Class;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.asmasyamfinalproject.R;

public class MyJobService extends JobService {

    public static final String ChannelId = "channel1";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){


            NotificationChannel channel = new NotificationChannel(ChannelId , "channelName"
                    , NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext() ,ChannelId );

        Intent intent = new Intent(getBaseContext() , MyJobService.class);
        PendingIntent pi = PendingIntent.getActivity(MyJobService.this ,  0 , intent , PendingIntent.FLAG_MUTABLE);

        builder.setSmallIcon(R.drawable._a4130c1c186f0f470b1827855886c9f);
        builder.setContentTitle("puzzle Game");
        builder.setContentText("The puzzle game has not been opened for 24 hours");
        builder.addAction(R.drawable._a4130c1c186f0f470b1827855886c9f , "Open" , pi);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MyJobService.this);
        managerCompat.notify(1 , builder.build());
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {

        return false;
    }
}
