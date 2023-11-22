package com.example.odev6.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odev6.data.entity.Mutfak;
import com.example.odev6.databinding.CardTasarimBinding;

import java.util.List;

public class MutfakAdapter extends RecyclerView.Adapter<MutfakAdapter.CardTasarimTutucu> {
private List<Mutfak> mutfakListesi;
private Context mContext;


    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu(CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    public MutfakAdapter(List<Mutfak> mutfakListesi,Context mContext){
        this.mutfakListesi =mutfakListesi;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       CardTasarimBinding binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent,false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Mutfak mutfak =mutfakListesi.get(position);
        CardTasarimBinding t = holder.tasarim;
        t.imageViewMutfak.setImageResource(mContext.getResources()
                .getIdentifier(mutfak.getMutfak_resim(),"drawable",mContext.getPackageName()));
        t.cardViewMutfak.setText(mutfak.getMutfak_ad());
    }

    @Override
    public int getItemCount() {
        return mutfakListesi.size();
    }

}
