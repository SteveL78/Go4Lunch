package steve.leroy.go4lunch;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import steve.leroy.go4lunch.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate( getLayoutInflater() );
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        this.configureDrawerLayout();

        this.configureBottomNavigation();

    }


    // ---------------------
    // CONFIGURATION
    // ---------------------

    private void configureDrawerLayout() {
        binding.topAppBar.topAppBar.setNavigationOnClickListener( view ->
                binding.drawerLayout.open() );
    }


    private void configureBottomNavigation() {
        NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment );
        NavigationUI.setupWithNavController( binding.bottomNavigationMenu, navController );
    }

}