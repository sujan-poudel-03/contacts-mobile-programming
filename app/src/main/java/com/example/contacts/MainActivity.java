package com.example.contacts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Lifecycle";
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MainActivity: onCreate called");
        Toast.makeText(this, "MainActivity: onCreate called", Toast.LENGTH_SHORT).show();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText email_input = findViewById(R.id.emailInput);
        EditText password_input = findViewById(R.id.passwordInput);
        Button login_button = findViewById(R.id.loginButton);
        Button goToSecondActivityButton = findViewById(R.id.goToSecondActivityButton);
        Button goToEventsDemoButton = findViewById(R.id.goToEventsDemoButton);
        Button goToFragmentHostButton = findViewById(R.id.goToFragmentHostButton);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_input.getText().toString();
                String password = password_input.getText().toString();

                // Check email and password field are empty
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (email.equals("admin") && password.equals("admin")) {
                    // Login successful, navigate to the next activity called HomePage
                    Intent intent = new Intent(MainActivity.this, HomePage.class);

                    // Pass email input to next activity
                    intent.putExtra("email", email);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        goToSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String email = email_input.getText().toString();
                intent.putExtra("email", email);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        goToEventsDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventsDemoActivity.class);
                startActivity(intent);
            }
        });

        goToFragmentHostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentHostActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_profile) {
            Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.action_settings) {
            Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.action_help) {
            Toast.makeText(this, "Help selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (itemId == R.id.action_exit) {
            showSimpleDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // this is for a dialog
    private void showSimpleDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Exit Option Selected")
                .setMessage("You selected Exit. Continue?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    finishAffinity(); // This will close the entire app
                })
//                .setPositiveButton("Yes", (dialog, which) ->
//                        Toast.makeText(this, "Confirmed", Toast.LENGTH_SHORT).show())
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            if (data != null && data.hasExtra("reply")) {
                String reply = data.getStringExtra("reply");
                Toast.makeText(this, "Reply from SecondActivity: " + reply, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Log.d(TAG, "MainActivity: onStart called");
        Toast.makeText(this, "MainActivity: onStart called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "MainActivity: onResume called");
        Toast.makeText(this, "MainActivity: onResume called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "MainActivity: onPause called");
        Toast.makeText(this, "MainActivity: onPause called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onStop(){
        super.onStop();
        Log.d(TAG, "MainActivity: onStop called");
        Toast.makeText(this, "MainActivity: onStop called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy called");
        Toast.makeText(this, "MainActivity: onDestroy called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart called");
        Toast.makeText(this, "MainActivity: onRestart called", Toast.LENGTH_SHORT).show();
    }

}