package com.example.week14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.week14.auth.FirebaseManager;

public class MainActivity extends AppCompatActivity {

    private EditText emailText;
    private EditText passwordText;
    private FirebaseManager firebaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        firebaseManager = new FirebaseManager(this);
    }

    public void showSecret() { findViewById(R.id.secretButton).setVisibility(View.VISIBLE);}

    public void hideSecret() { findViewById(R.id.secretButton).setVisibility(View.INVISIBLE);}

    public void signIn(View view) {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        if (email.length() > 0 && password.length() > 0) {
            firebaseManager.signIn(email, password, this);
        }
    }

    public void signUp(View view) {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        if (email.length() > 0 && password.length() > 0) {
            firebaseManager.signUp(email, password);
        }
    }

    public void signOut(View view) { firebaseManager.signOut(); }

    public void goToSecondPage(View view) {
        Intent intent = new Intent(getApplicationContext(), SecondPage.class);

        startActivity(intent);
    }
}
