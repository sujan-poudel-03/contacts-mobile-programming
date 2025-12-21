package com.example.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "SecondActivity: onCreate called");
        Toast.makeText(this, "SecondActivity: onCreate called", Toast.LENGTH_SHORT).show();

        TextView textView = findViewById(R.id.textView);
        EditText replyEditText = findViewById(R.id.replyEditText);
        Button sendReplyButton = findViewById(R.id.sendReplyButton);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("email")) {
            String email = intent.getStringExtra("email");
            textView.setText("Welcome: " + email);
        }

        sendReplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reply = replyEditText.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("reply", reply);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Log.d(TAG, "SecondActivity: onStart called");
        Toast.makeText(this, "SecondActivity: onStart called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "SecondActivity: onResume called");
        Toast.makeText(this, "SecondActivity: onResume called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "SecondActivity: onPause called");
        Toast.makeText(this, "SecondActivity: onPause called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onStop(){
        super.onStop();
        Log.d(TAG, "SecondActivity: onStop called");
        Toast.makeText(this, "SecondActivity: onStop called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "SecondActivity: onDestroy called");
        Toast.makeText(this, "SecondActivity: onDestroy called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "SecondActivity: onRestart called");
        Toast.makeText(this, "SecondActivity: onRestart called", Toast.LENGTH_SHORT).show();
    }
}