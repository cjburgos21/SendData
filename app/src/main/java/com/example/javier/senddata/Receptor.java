package com.example.javier.senddata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Receptor extends AppCompatActivity {
    TextView receivedText;
    Button homeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptor);

    Intent callingIntent = getIntent();
    String intentAction = callingIntent.getAction();
    String intentType = callingIntent.getType();

    if(Intent.ACTION_SEND.equals(intentAction)&& intentType!=null){
        if(intentType.equals("text/plain")){
            handleReceivedText(callingIntent);
        }

    }

    homeScreen=(Button)findViewById(R.id.gotoFstScreenBtn);
    homeScreen.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View v){
            Intent fstScreenIntent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(fstScreenIntent);
        }

        });

    }

    private void handleReceivedText(Intent intent){
    receivedText = (TextView)findViewById(R.id.textReceived);
    String intentText = intent.getStringExtra(Intent.EXTRA_TEXT);

    if(receivedText != null){
        receivedText.setText(intentText);
    }

    }
}

