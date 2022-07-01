package steve.leroy.go4lunch;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import steve.leroy.go4lunch.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        binding = ActivityMainBinding.inflate( getLayoutInflater() );
        setContentView( binding.getRoot() );

        setUpBottomNavigation();

    }

    private void setUpBottomNavigation() {
        NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment );
        NavigationUI.setupWithNavController( binding.bottomNavigationMenu, navController );
    }

}