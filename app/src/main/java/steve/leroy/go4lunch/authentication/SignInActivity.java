package steve.leroy.go4lunch.authentication;

import android.os.Bundle;

import steve.leroy.go4lunch.BaseActivity;
import steve.leroy.go4lunch.databinding.ActivitySignInBinding;

public class SignInActivity extends BaseActivity<ActivitySignInBinding> {

    @Override
    public ActivitySignInBinding getViewBinding() {
        return ActivitySignInBinding.inflate( getLayoutInflater() );
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );


    }
}