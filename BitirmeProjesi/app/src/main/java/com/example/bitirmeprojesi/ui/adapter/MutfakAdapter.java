package com.example.bitirmeprojesi.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitirmeprojesi.data.entity.Mutfak;
import com.example.bitirmeprojesi.databinding.CardTasarimBinding;
import com.example.bitirmeprojesi.ui.viewmodel.AnasayfaViewModel;

import java.util.List;

public class MutfakAdapter extends RecyclerView.Adapter<MutfakAdapter.CardTasarimTutucu> {

    private List<Mutfak> mutfakListesi;
    private Context mContext;
    private AnasayfaViewModel viewModel;

    public MutfakAdapter(List<Mutfak> mutfakListesi, Context mContext) {
        this.mutfakListesi = mutfakListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }



    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding tasarim;
        public CardTasarimTutucu(CardTasarimBinding tasarim){
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }
    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding =
                CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Mutfak mutfak = mutfakListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.imageViewMenu.setImageResource(mContext.getResources().getIdentifier(mutfak.getMutfak_resim(), "drawable", mContext.getPackageName()));
        t.textViewMenuAd.setText(mutfak.getMutfak_ad());
    }

    @Override
    public int getItemCount() {
        return mutfakListesi.size();
    }
}
