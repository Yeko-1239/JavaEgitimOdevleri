package com.example.dev7.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev7.data.entity.Notlar;
import com.example.dev7.databinding.CardTasarimBinding;
import com.example.dev7.ui.fragment.AnasayfaFragmentDirections;
import com.example.dev7.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class NotlarAdapter extends RecyclerView.Adapter<NotlarAdapter.CardTasarimTutucu> {
    private List<Notlar> notlarListesi;
    private Context mContext;
    private AnasayfaViewModel viewModel;

    public NotlarAdapter(List<Notlar> notlarListesi, Context mContext, AnasayfaViewModel viewModel) {
        this.notlarListesi = notlarListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu(CardTasarimBinding tasarim) {
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
        Notlar not = notlarListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.textViewBaslik.setText(not.getNot_baslik());
        t.textViewTarih.setText(not.getNot_tarih());

        t.imageViewSil.setOnClickListener(v -> {
            Snackbar.make(v,not.getNot_baslik()+" silinsin mi?",Snackbar.LENGTH_SHORT)
                    .setAction("EVET",v1 -> {
                        viewModel.sil(not.getNot_id());
                    })
                    .show();
        });

        t.cardViewSatir.setOnClickListener(v -> {
            AnasayfaFragmentDirections.NotDetayGecis gecis = AnasayfaFragmentDirections.notDetayGecis(not);
            Navigation.findNavController(v).navigate(gecis);
        });
    }

    @Override
    public int getItemCount() {

        return notlarListesi.size();
    }
}
