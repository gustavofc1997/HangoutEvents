package events.hangout.com.hangout.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import events.hangout.com.hangout.R;
import events.hangout.com.hangout.Utils.AppConstants;

/**
 * Created by Gustavo on 7/09/2017.
 */

public class PreferencesActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private String mUserId;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser mFirebaseUser;

    @OnClick(R.id.btn_continue)
    void Continue() {
        startActivity(new Intent(PreferencesActivity.this, HomeActivity.class));
        finish();
    }


    private void savePreferences(){
        mDatabase.child(AppConstants.TABLE_PREFS).child(mUserId).child(AppConstants.LIKES).push().child(AppConstants.NAME).setValue();

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        ButterKnife.bind(this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mUserId = mFirebaseUser.getUid();

    }
}
