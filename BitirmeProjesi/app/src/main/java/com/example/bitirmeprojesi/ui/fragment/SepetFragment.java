package com.example.bitirmeprojesi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitirmeprojesi.databinding.FragmentSepetBinding;
import com.example.bitirmeprojesi.ui.adapter.SepetAdapter;
import com.example.bitirmeprojesi.ui.viewmodel.SepetViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SepetFragment extends Fragment {

    private FragmentSepetBinding binding;
    private SepetViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSepetBinding.inflate(inflater, container, false);

        binding.sepetRv.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.sepetListesi.observe(getViewLifecycleOwner(),sepetListesi -> {

            if (sepetListesi != null && sepetListesi.size() > 0) {
                SepetAdapter adapter = new SepetAdapter(sepetListesi,requireContext(),viewModel);
                binding.sepetRv.setAdapter(adapter);
                Log.e("Hata", "Sepet yükleme hatası:"+sepetListesi);


            } else {
                Log.e("Hata", "Sepet yükleme hatası:"+sepetListesi);
                binding.textViewYazi.setText("Sepet Boş Lütfen Ürün Ekleyin");
            }

        });

        return binding.getRoot();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SepetViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.sepetiYukle();
    }
}