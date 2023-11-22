package com.example.odev6.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odev6.data.entity.Mutfak;
import com.example.odev6.data.entity.Restorant;
import com.example.odev6.databinding.CardTasarimBinding;

import java.util.List;

public class RestorantAdapter extends RecyclerView.Adapter<RestorantAdapter.CardTasarimTutucuOne> {
    private List<Restorant> restorantListesi;
    private Context rContext;


    public class CardTasarimTutucuOne extends RecyclerView.ViewHolder {
        public CardTasarimBinding rtasarim;

        public CardTasarimTutucuOne(CardTasarimBinding rtasarim) {
            super(rtasarim.getRoot());
            this.rtasarim = rtasarim;
        }
    }

    public RestorantAdapter(List<Restorant> restorantListesi,Context rContext){
        this.restorantListesi = restorantListesi;
        this.rContext = rContext;
    }

    @NonNull
    @Override
    public CardTasarimTutucuOne onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding = CardTasarimBinding.inflate(LayoutInflater.from(rContext), parent,false);
        return new RestorantAdapter.CardTasarimTutucuOne(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucuOne holder, int position) {
        Restorant restorant =restorantListesi.get(position);
        CardTasarimBinding r = holder.rtasarim;
        r.imageViewRestorant.setImageResource(rContext.getResources()
                .getIdentifier(restorant.getRestorant_resim(),"drawable",rContext.getPackageName()));
        r.textViewRestorantAd.setText(restorant.getRestorant_ad());
    }

    @Override
    public int getItemCount() {
        return restorantListesi.size();

    }

}
