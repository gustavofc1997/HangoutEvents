package events.hangout.com.hangout.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import events.hangout.com.hangout.R;
import events.hangout.com.hangout.ui.fragments.ProfileFragment;

/**
 * Created by Gustavo on 7/09/2017.
 */

public class HomeActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {
    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNav;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        mBottomNav.setOnNavigationItemSelectedListener(this);
        mBottomNav.setSelectedItemId(R.id.id);
    }


    public void switchToFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment f = null;
        switch (item.getItemId()) {
            case R.id.id:
                f = ProfileFragment.newInstance();
                break;
        }
        switchToFragment(f);
        return false;
    }

}
