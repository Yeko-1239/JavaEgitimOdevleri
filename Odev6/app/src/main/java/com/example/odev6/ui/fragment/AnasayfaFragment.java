package com.example.odev6.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev6.R;
import com.example.odev6.data.entity.Mutfak;
import com.example.odev6.data.entity.Restorant;
import com.example.odev6.databinding.FragmentAnasayfaBinding;
import com.example.odev6.ui.adapter.MutfakAdapter;
import com.example.odev6.ui.adapter.RestorantAdapter;

import java.util.ArrayList;


public class AnasayfaFragment extends Fragment {
private FragmentAnasayfaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false);
        binding.mutfakRv.setLayoutManager(
                new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));

        ArrayList<Mutfak> mutfakListesi = new ArrayList<>();
        Mutfak m1 = new Mutfak(1,"Tatlı","tatli");
        Mutfak m2 = new Mutfak(2,"Kebab","kebab");
        Mutfak m3 = new Mutfak(3,"Pizza","pizza");
        Mutfak m4 = new Mutfak(4,"Dondurma","dondurma");
        Mutfak m5 = new Mutfak(5,"Döner","doner");
        Mutfak m6 = new Mutfak(6,"Burger","burger");
        Mutfak m7 = new Mutfak(7,"Tost","tost");
        Mutfak m8 = new Mutfak(8,"Kahve","kahve");
        mutfakListesi.add(m1);
        mutfakListesi.add(m2);
        mutfakListesi.add(m3);
        mutfakListesi.add(m4);
        mutfakListesi.add(m5);
        mutfakListesi.add(m6);
        mutfakListesi.add(m7);
        mutfakListesi.add(m8);

        MutfakAdapter mutfakAdapter = new MutfakAdapter(mutfakListesi,requireContext());
        binding.mutfakRv.setAdapter(mutfakAdapter);


        binding.restorantRv.setLayoutManager(new LinearLayoutManager(requireContext()));
        ArrayList<Restorant> restorantListei = new ArrayList<>();
        Restorant r1 = new Restorant(1,"wafflerestorant","Abbas Waffle");
        Restorant r2 = new Restorant(2,"cigerrestorant","Dağkapı Cigercisi");
        Restorant r3 = new Restorant(3,"cigkofterestorant","Çiğköfteci Haci Siraç");
        restorantListei.add(r1);
        restorantListei.add(r2);
        restorantListei.add(r3);

        RestorantAdapter restorantAdapter = new RestorantAdapter(restorantListei,requireContext());
        binding.restorantRv.setAdapter(restorantAdapter);

        return binding.getRoot();

    }
}