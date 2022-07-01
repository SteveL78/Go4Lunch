package steve.leroy.go4lunch.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

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
}