package steve.leroy.go4lunch.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionInflater;

import steve.leroy.go4lunch.R;
import steve.leroy.go4lunch.databinding.FragmentListViewBinding;

public class ListViewFragment extends Fragment {

    private FragmentListViewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListViewBinding.inflate( inflater, container, false );
        return binding.getRoot();

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        initTransition();
    }

    private void initTransition() {
        TransitionInflater inflater = TransitionInflater.from( requireContext() );
        setExitTransition( inflater.inflateTransition( R.transition.fade ) );
        setEnterTransition( inflater.inflateTransition( R.transition.slide_right ) );
    }
}