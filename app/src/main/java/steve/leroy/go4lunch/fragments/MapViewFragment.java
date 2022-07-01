package steve.leroy.go4lunch.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import steve.leroy.go4lunch.databinding.FragmentViewMapBinding;

public class MapViewFragment extends Fragment {

    private FragmentViewMapBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentViewMapBinding.inflate( inflater, container, false );
        return binding.getRoot();
    }
}