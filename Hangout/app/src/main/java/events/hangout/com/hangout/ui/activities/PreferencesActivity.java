package events.hangout.com.hangout.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import events.hangout.com.hangout.R;

/**
 * Created by Gustavo on 7/09/2017.
 */

public class PreferencesActivity extends AppCompatActivity {

    @OnClick(R.id.btn_continue)
    void Continue() {
        startActivity(new Intent(PreferencesActivity.this, HomeActivity.class));
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        ButterKnife.bind(this);
    }
}
