package quizapp.volkova.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SimpleReceiver extends BroadcastReceiver {

    public static final String SIMPLE_ACTION = "quizapp.volkova.services.SIMPLE_ACTION";

    @Override
    public void onReceive(Context context, Intent intent) {

        long time = intent.getLongExtra(CountService.TIME, 0L);
        Toast.makeText(context, intent.getAction(), Toast.LENGTH_SHORT).show();
    }
}
