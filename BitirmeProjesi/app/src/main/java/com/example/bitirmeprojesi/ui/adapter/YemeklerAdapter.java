package com.example.bitirmeprojesi.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.bitirmeprojesi.data.entity.Yemekler;

import com.example.bitirmeprojesi.databinding.YemekCardTasarimBinding;
import com.example.bitirmeprojesi.ui.fragment.AnasayfaFragmentDirections;
import com.example.bitirmeprojesi.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class YemeklerAdapter extends RecyclerView.Adapter<YemeklerAdapter.YemekCardTasarimTutucu> {

    private List<Yemekler> yemeklerListesi;
    private Context mContext;
    private AnasayfaViewModel viewModel;


    public YemeklerAdapter() {
    }

    public YemeklerAdapter(List<Yemekler> yemeklerListesi, Context mContext, AnasayfaViewModel viewModel) {
        this.yemeklerListesi = yemeklerListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    public class YemekCardTasarimTutucu extends RecyclerView.ViewHolder{
        private YemekCardTasarimBinding tasarim;
        public YemekCardTasarimTutucu(YemekCardTasarimBinding tasarim){
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public YemekCardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        YemekCardTasarimBinding binding = YemekCardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new YemekCardTasarimTutucu(binding);    }

    @Override
    public void onBindViewHolder(@NonNull YemekCardTasarimTutucu holder, int position) {
        Yemekler yemek = yemeklerListesi.get(position);
        YemekCardTasarimBinding t = holder.tasarim;

        String resimYolu = "http://kasimadalan.pe.hu/yemekler/resimler/" + yemek.getYemek_resim_adi();
        Glide.with(mContext).load(resimYolu).override(300, 450).into(t.imageViewYemek);

       t.textViewYemekAd.setText(yemek.getYemek_adi());
       t.textViewYemekFiyat.setText(String.valueOf(yemek.getYemek_fiyat() + " ₺"));
       t.imageViewSepet.setOnClickListener(v -> {
           Snackbar.make(v,yemek.getYemek_adi()+"Sepete Eklensin mi",Snackbar.LENGTH_LONG)
                   .setAction("EVET",v1 -> {
                       Snackbar.make(v1, "Ekleme Başarılı-->"+yemek.getYemek_adi()+"-"+yemek.getYemek_resim_adi()+"-"+yemek.getYemek_fiyat()+"-"+ 1+"-"+"yekbun-demir" , Snackbar. LENGTH_SHORT).show();
                       viewModel.kaydet(yemek.getYemek_adi(),yemek.getYemek_resim_adi(),yemek.getYemek_fiyat(), 1,"yekbun-demir");

                   })
                   .show();
       });

       t.cardViewYemek.setOnClickListener(v -> {
           AnasayfaFragmentDirections.DetayGecis gecis = AnasayfaFragmentDirections.detayGecis(yemek);
           Navigation.findNavController(v).navigate(gecis);
       });
    }

    @Override
    public int getItemCount() {

        return yemeklerListesi.size();
    }


}
