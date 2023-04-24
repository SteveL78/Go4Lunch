package steve.leroy.go4lunch.authentication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.core.splashscreen.SplashScreen;

import com.facebook.FacebookSdk;
import com.firebase.ui.auth.AuthMethodPickerLayout;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import steve.leroy.go4lunch.BaseActivity;
import steve.leroy.go4lunch.MainActivity;
import steve.leroy.go4lunch.R;
import steve.leroy.go4lunch.databinding.ActivitySignInBinding;

public class SignInActivity extends BaseActivity<ActivitySignInBinding> {

    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            this::onSignInResult
    );


    @Override
    public ActivitySignInBinding getViewBinding() {
        return ActivitySignInBinding.inflate( getLayoutInflater() );
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen( this );
        super.onCreate( savedInstanceState );

        FacebookSdk.setClientToken( String.valueOf( com.firebase.ui.auth.R.string.facebook_application_id ) );

        setupListeners();
    }


    private void setupListeners() {
        binding.signInButton.setOnClickListener( view -> displaySignInButtons() );
    }


    private void displaySignInButtons() {
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.TwitterBuilder().build(),
                new AuthUI.IdpConfig.EmailBuilder().build() );

        // Create custom layout
        AuthMethodPickerLayout customLayout = new AuthMethodPickerLayout
                .Builder( R.layout.authentication_layout )
                .setGoogleButtonId( R.id.google_auth_btn )
                .setFacebookButtonId( R.id.fb_auth_btn )
                .setTwitterButtonId( R.id.twitter_auth_btn )
                .setEmailButtonId( R.id.email_auth_btn ).build();

        // Create and launch sign-in intent
        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setTheme( R.style.LoginTheme )
                .setAuthMethodPickerLayout( customLayout )
                .setAvailableProviders( providers )
                .setIsSmartLockEnabled( false, true )
                .build();

        signInLauncher.launch( signInIntent );
    }


    private void onSignInResult(FirebaseAuthUIAuthenticationResult result) {
        IdpResponse response = result.getIdpResponse();
        if (result.getResultCode() == RESULT_OK) {
            // Successfully signed in
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            startMainActivity();
            showSnackBar( getString( R.string.connection_succeed ) );
            // ...
        } else { // ERRORS

            // Show snack bar with a message
            if (response == null) {
                showSnackBar( getString( R.string.error_authentication_canceled ) );
            } else if (response.getError() != null) {
                if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                    showSnackBar( getString( R.string.error_no_internet ) );
                } else if (response.getError().getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                    showSnackBar( getString( R.string.error_unknown_error ) );
                }
            }
        }
    }


    private void startMainActivity() {
        startActivity( new Intent( this, MainActivity.class ) );
    }


    // Show Snack Bar with a message
    private void showSnackBar(String message) {
        Snackbar.make( binding.activitySignInCoordinatorLayout, message, Snackbar.LENGTH_SHORT ).show();
    }
}