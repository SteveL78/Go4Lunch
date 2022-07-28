package steve.leroy.go4lunch.authentication;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.core.splashscreen.SplashScreen;

import steve.leroy.go4lunch.BaseActivity;
import steve.leroy.go4lunch.databinding.ActivitySignInBinding;

public class SignInActivity extends BaseActivity<ActivitySignInBinding> {

    @Override
    public ActivitySignInBinding getViewBinding() {
        return ActivitySignInBinding.inflate( getLayoutInflater() );
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen( this );

        super.onCreate( savedInstanceState );

        //Hide StatusBar
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );

    }
}