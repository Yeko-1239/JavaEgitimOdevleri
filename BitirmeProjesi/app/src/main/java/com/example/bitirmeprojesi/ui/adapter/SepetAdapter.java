package com.example.bitirmeprojesi.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bitirmeprojesi.data.entity.Sepet;

import com.example.bitirmeprojesi.databinding.SepetCardTasarimBinding;
import com.example.bitirmeprojesi.ui.viewmodel.SepetViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class SepetAdapter extends RecyclerView.Adapter<SepetAdapter.SepetCardTasarimTutucu> {

    private List<Sepet> sepetListesi;
    private Context mContext;
    private SepetViewModel viewModel;


    public SepetAdapter() {
    }

    public SepetAdapter(List<Sepet> sepetListesi, Context mContext, SepetViewModel viewModel) {
        this.sepetListesi = sepetListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    public class SepetCardTasarimTutucu extends RecyclerView.ViewHolder{
        private SepetCardTasarimBinding tasarim;
        public SepetCardTasarimTutucu(SepetCardTasarimBinding tasarim){
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public SepetAdapter.SepetCardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        SepetCardTasarimBinding binding = SepetCardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new SepetAdapter.SepetCardTasarimTutucu(binding);    }

    @Override
    public void onBindViewHolder(@NonNull SepetCardTasarimTutucu holder, int position) {
        Sepet sepet = sepetListesi.get(position);
        SepetCardTasarimBinding t = holder.tasarim;

        String resimYolu = "http://kasimadalan.pe.hu/yemekler/resimler/" + sepet.getYemek_resim_adi();
        Glide.with(mContext).load(resimYolu).override(350, 350).into(t.imageViewSepetResim);

        t.textViewSepetYemekAd.setText(sepet.getYemek_adi());
        t.textViewSepetYemekFiyat.setText(String.valueOf(sepet.getYemek_fiyat() + " ₺"));
        t.editTextSepetAdet.setText(sepet.getYemek_siparis_adet());
        final int[] adet = {Integer.parseInt(sepet.getYemek_siparis_adet())};
        t.imageViewArti.setOnClickListener(v -> {
          int aadet =  adet[0]++;
            int yemekfiyat = Integer.parseInt(sepet.getYemek_fiyat())* aadet;
            t.editTextSepetAdet.setText(String.valueOf(aadet));
            viewModel.guncelle(sepet.getSepet_yemek_id(),sepet.getYemek_adi(),sepet.getYemek_resim_adi(),String.valueOf(yemekfiyat),String.valueOf(aadet),"yekbun-demir");
        });
        t.imageViewEksi.setOnClickListener(v -> {
            int aadet =  adet[0]--;
            int yemekfiyat = Integer.parseInt(sepet.getYemek_fiyat())* aadet;
            t.editTextSepetAdet.setText(String.valueOf(aadet));
            viewModel.guncelle(sepet.getSepet_yemek_id(),sepet.getYemek_adi(),sepet.getYemek_resim_adi(),String.valueOf(yemekfiyat),String.valueOf(aadet),"yekbun-demir");
        });

        t.imageViewSepetSil.setOnClickListener(v -> {
            Snackbar.make(v, sepet.getYemek_adi() +" adlı ürün sepetinizden silinsin mi?",Snackbar.LENGTH_SHORT)
                    .setAction("EVET",v1 -> {
                        viewModel.sepettencikar(sepet.getSepet_yemek_id(),sepet.getKullanici_adi());
                    })
                    .show();
        });
    }


    @Override
    public int getItemCount() {
        return sepetListesi != null ? sepetListesi.size() : 0;
    }

}
