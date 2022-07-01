package steve.leroy.go4lunch.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import steve.leroy.go4lunch.databinding.FragmentWorkmatesBinding;

public class WorkmatesFragment extends Fragment {

    private FragmentWorkmatesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWorkmatesBinding.inflate( inflater, container, false );
        return binding.getRoot();
    }
}