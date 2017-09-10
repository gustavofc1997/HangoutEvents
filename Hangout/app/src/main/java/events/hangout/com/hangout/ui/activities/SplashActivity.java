package events.hangout.com.hangout.ui.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.pixplicity.easyprefs.library.Prefs;

import events.hangout.com.hangout.Utils.AppConstants;

public class SplashActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser == null)
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                else
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                // close splash activity
                finish();
            }
        }, 3000);

    }
}
