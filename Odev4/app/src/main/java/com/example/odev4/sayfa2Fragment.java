package com.example.odev4;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev4.databinding.FragmentSayfa1Binding;
import com.example.odev4.databinding.FragmentSayfa2Binding;

public class sayfa2Fragment extends Fragment {

    private FragmentSayfa2Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding =FragmentSayfa2Binding.inflate(inflater,container,false);
        binding.buttonA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.a2Yolu);
            }
        });
        OnBackPressedCallback geriGel = new OnBackPressedCallback(false) {
            @Override
            public void handleOnBackPressed() {

            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),geriGel);

        return binding.getRoot();
    }
}