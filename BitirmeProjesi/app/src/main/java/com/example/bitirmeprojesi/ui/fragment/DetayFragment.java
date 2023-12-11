package com.example.bitirmeprojesi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.example.bitirmeprojesi.R;
import com.example.bitirmeprojesi.data.entity.Mutfak;
import com.example.bitirmeprojesi.data.entity.Yemekler;
import com.example.bitirmeprojesi.databinding.FragmentDetayBinding;
import com.example.bitirmeprojesi.ui.adapter.MutfakAdapter;
import com.example.bitirmeprojesi.ui.viewmodel.DetayViewModel;

import java.util.ArrayList;
import java.util.Arrays;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class DetayFragment extends Fragment {
private FragmentDetayBinding binding;
private DetayViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetayBinding.inflate(inflater, container, false);
        DetayFragmentArgs bundle = DetayFragmentArgs.fromBundle(getArguments());

        binding.imageViewBack.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.detayAnasayfaGecis);
        });

        Yemekler gelenYemek = bundle.getYemek();
        binding.textViewDetay.setText(gelenYemek.getYemek_adi());

        String resimYolu = "http://kasimadalan.pe.hu/yemekler/resimler/" + gelenYemek.getYemek_resim_adi();
        Glide.with(this).load(resimYolu).override(600, 600).into(binding.imageViewDetayYemek);

        binding.textViewDetayYemekAd.setText(gelenYemek.getYemek_adi());
        binding.textViewDetayYemekFiyat.setText(String.valueOf(gelenYemek.getYemek_fiyat() + " ₺"));
        final int[] adet = {1};
        binding.imageViewArti.setOnClickListener(v -> {
            if (adet[0]>=0){
                int aadet =  adet[0]++;
                int yemekfiyat = gelenYemek.getYemek_fiyat()*aadet;
                binding.editTextDetayAdet.setText(String.valueOf(aadet));
                binding.textViewDetayYemekFiyat.setText(String.valueOf(yemekfiyat + " ₺"));
            }
        });
        binding.imageViewEksi.setOnClickListener(v -> {
            if (adet[0]>=0){
                int aadet =  adet[0]--;
                int yemekfiyat = gelenYemek.getYemek_fiyat()*aadet;
                binding.editTextDetayAdet.setText(String.valueOf(aadet));
                binding.textViewDetayYemekFiyat.setText(String.valueOf(yemekfiyat + " ₺"));
            }
        });

        binding.buttonDetaySepet.setOnClickListener(v -> {
            int yadet= Integer.parseInt(binding.editTextDetayAdet.getText().toString());
            int yfiyat = gelenYemek.getYemek_fiyat()*yadet;
            viewModel.kaydet(gelenYemek.getYemek_adi(),gelenYemek.getYemek_resim_adi(),yfiyat, yadet,"yekbun-demir");
            Toast.makeText(DetayFragment.this.getContext(), "Ekleme Başarılı", Toast.LENGTH_SHORT).show();

        });

        binding.mDetayRv.setLayoutManager(
                new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        ArrayList<Mutfak> mutfakListesi = new ArrayList<>(Arrays.asList(
                new Mutfak(1, "Tatli", "tatli"),
                new Mutfak(2, "Tost", "tost"),
                new Mutfak(3, "Burger", "burger"),
                new Mutfak(4, "Pizza", "pizza")
        ));
        MutfakAdapter mutfakAdapter = new MutfakAdapter(mutfakListesi,requireContext());
        binding.mDetayRv.setAdapter(mutfakAdapter);


        return binding.getRoot();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DetayViewModel.class);
    }
}