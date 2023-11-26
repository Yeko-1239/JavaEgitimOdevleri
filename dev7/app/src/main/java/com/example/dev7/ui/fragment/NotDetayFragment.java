package com.example.dev7.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dev7.R;
import com.example.dev7.data.entity.Notlar;
import com.example.dev7.databinding.FragmentNotDetayBinding;
import com.example.dev7.ui.viewmodel.NotDetayViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NotDetayFragment extends Fragment {
    private FragmentNotDetayBinding binding;
    private NotDetayViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNotDetayBinding.inflate(inflater, container, false);
        NotDetayFragmentArgs bundle = NotDetayFragmentArgs.fromBundle(getArguments());
        Notlar gelenNot = bundle.getNot();

        binding.editTextBaslik.setText(gelenNot.getNot_baslik());
        binding.editTextNot.setText(gelenNot.getNot());

        binding.buttonGuncelle.setOnClickListener(v -> {
            String not_baslik = binding.editTextBaslik.getText().toString();
            String not = binding.editTextNot.getText().toString();

            Calendar calendar = Calendar.getInstance();
            Date simdi = calendar.getTime(); // Şu anki zaman
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            String not_tarih = dateFormat.format(simdi);

            viewModel.guncelle(gelenNot.getNot_id(),not_baslik,not,not_tarih);
        });

        return binding.getRoot();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(NotDetayViewModel.class);
    }
}