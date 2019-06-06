package m.google.androidcornershop.splash;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import m.google.androidcornershop.login.LoginActivity;
import m.google.androidcornershop.R;
import m.google.androidcornershop.root.App;

public class ScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);



        SystemClock.sleep(5000);
        Intent loginIntent= new Intent(ScreenActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }
}
