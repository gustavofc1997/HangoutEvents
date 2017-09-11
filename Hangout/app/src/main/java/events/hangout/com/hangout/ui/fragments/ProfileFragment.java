package events.hangout.com.hangout.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import events.hangout.com.hangout.R;
import events.hangout.com.hangout.Utils.CircleTransform;

/**
 * Created by Gustavo on 11/09/2017.
 */

public class ProfileFragment extends Fragment {
    private FirebaseAuth mAuth;
    @BindView(R.id.img_picture)
    ImageView mPicture;
    @BindView(R.id.lab_name)
    TextView mLabName;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    private void loadProfile() {
        FirebaseUser user = mAuth.getCurrentUser();
        mLabName.setText(user.getDisplayName());
        Picasso.with(getContext()).load(user.getPhotoUrl()).transform(new CircleTransform(Color.WHITE, 2.0f)).into(mPicture);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, rootView);
        mAuth = FirebaseAuth.getInstance();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadProfile();
    }
}
