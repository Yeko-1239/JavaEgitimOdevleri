package com.example.bitirmeprojesi.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.bitirmeprojesi.data.entity.Mutfak;
import com.example.bitirmeprojesi.databinding.FragmentAnasayfaBinding;
import com.example.bitirmeprojesi.ui.adapter.MutfakAdapter;
import com.example.bitirmeprojesi.ui.adapter.YemeklerAdapter;
import com.example.bitirmeprojesi.ui.viewmodel.AnasayfaViewModel;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AnasayfaFragment extends Fragment {

    private FragmentAnasayfaBinding binding;
    private AnasayfaViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false);
        binding.yemekRv.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        viewModel.yemekListesi.observe(getViewLifecycleOwner(),yemekListesi -> {
            YemeklerAdapter adapter = new YemeklerAdapter(yemekListesi,requireContext(),viewModel);
            binding.yemekRv.setAdapter(adapter);
        });


        binding.menuRv.setLayoutManager(
                new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));

        ArrayList<Mutfak> mutfakListesi = new ArrayList<>(Arrays.asList(
                new Mutfak(1, "Tatli", "tatli"),
                new Mutfak(2, "Tost", "tost"),
                new Mutfak(3, "Burger", "burger"),
                new Mutfak(4, "Pizza", "pizza")
        ));
        MutfakAdapter mutfakAdapter = new MutfakAdapter(mutfakListesi,requireContext());
        binding.menuRv.setAdapter(mutfakAdapter);




        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                viewModel.araYemek(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                viewModel.araYemek(newText);
                return true;
            }
        });

        return binding.getRoot();



    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(AnasayfaViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.yemekYukle();
    }
}