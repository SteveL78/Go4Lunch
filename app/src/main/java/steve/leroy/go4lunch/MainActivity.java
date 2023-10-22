package steve.leroy.go4lunch;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import steve.leroy.go4lunch.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private FirebaseAuth firebaseAuth;

    @Override
    public ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.configureDrawerLayout();

        this.configureBottomNavigation();

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            updateDrawerHeader(user);
        }

    }


    // ---------------------
    // CONFIGURATION
    // ---------------------

    private void configureDrawerLayout() {
        binding.topAppBar.topAppBar.setNavigationOnClickListener(view ->
                binding.drawerLayout.open());
    }


    private void configureBottomNavigation() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(binding.bottomNavigationMenu, navController);
    }


    private void updateDrawerHeader(FirebaseUser user) {
        View headerView = binding.navigationView.getHeaderView(0);
        ImageView userPhotoImageView = headerView.findViewById(R.id.header_navigation_user_photo);
        TextView userNameTextView = headerView.findViewById(R.id.main_activity_header_user_name);
        TextView userEmailTextView = headerView.findViewById(R.id.main_activity_header_user_email);

        if (user != null && user.getPhotoUrl() != null) {
            Glide.with(this)
                    .load(user.getPhotoUrl())
                    .apply(RequestOptions.circleCropTransform())
                    .into(userPhotoImageView);
        } else {
            userPhotoImageView.setImageResource(R.drawable.anon_user);
        }

        assert user != null;
        if (user.getDisplayName() != null && !user.getDisplayName().isEmpty()) {
            userNameTextView.setText(user.getDisplayName());
            userNameTextView.setVisibility(View.VISIBLE);
        } else {
            userNameTextView.setVisibility(View.GONE);
        }

        if (user.getEmail() != null && !user.getEmail().isEmpty()) {
            userEmailTextView.setText(user.getEmail());
            userEmailTextView.setVisibility(View.VISIBLE);
        } else {
            userEmailTextView.setVisibility(View.GONE);
        }
    }

}