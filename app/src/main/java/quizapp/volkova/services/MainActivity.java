package quizapp.volkova.services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startbtn;
    private Button stopbtn;
    private Button sendbtn;
    private SimpleReceiver simpleReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startbtn = findViewById(R.id.button_start);
        stopbtn = findViewById(R.id.button_stop);
        sendbtn = findViewById(R.id.button_broadcast);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CountService.class);
                startService(intent);
            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CountService.class);
                stopService(intent);
            }
        });

        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendBroadcast(new Intent(SimpleReceiver.SIMPLE_ACTION));
            }
        });

        simpleReceiver = new SimpleReceiver();
        //intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        intentFilter = new IntentFilter(SimpleReceiver.SIMPLE_ACTION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(simpleReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(simpleReceiver);
    }
}