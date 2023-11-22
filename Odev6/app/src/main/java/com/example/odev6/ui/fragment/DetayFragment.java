package com.example.odev6.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev6.R;
import com.example.odev6.databinding.FragmentAnasayfaBinding;
import com.example.odev6.databinding.FragmentDetayBinding;


public class DetayFragment extends Fragment {
private FragmentDetayBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetayBinding.inflate(inflater, container, false);
        return binding.getRoot();
}
}