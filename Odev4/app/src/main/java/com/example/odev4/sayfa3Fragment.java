package com.example.odev4;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev4.databinding.FragmentSayfa2Binding;
import com.example.odev4.databinding.FragmentSayfa3Binding;

public class sayfa3Fragment extends Fragment {
    private FragmentSayfa3Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding =FragmentSayfa3Binding.inflate(inflater,container,false);
        binding.buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.aYolu);
            }
        });
        OnBackPressedCallback geriGel = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),geriGel);

        return binding.getRoot();
    }
}