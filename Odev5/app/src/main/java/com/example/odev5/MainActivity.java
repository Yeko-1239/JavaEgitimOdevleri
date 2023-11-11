package com.example.odev5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.odev5.databinding.ActivityMainBinding;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonSayi0.setOnClickListener(view->{
            String alinanVeri = binding.Ekran.getText().toString();
            alinanVeri += "0";
            binding.Ekran.setText(alinanVeri);
        });
        binding.buttonSayi1.setOnClickListener(view->{
            String alinanVeri = binding.Ekran.getText().toString();
            alinanVeri += "1";
            binding.Ekran.setText(alinanVeri);
        });
        binding.buttonSayi2.setOnClickListener(view->{
            String alinanVeri = binding.Ekran.getText().toString();
            alinanVeri += "2";
            binding.Ekran.setText(alinanVeri);
        });
        binding.buttonSayi3.setOnClickListener(view->{
            String alinanVeri = binding.Ekran.getText().toString();
            alinanVeri += "3";
            binding.Ekran.setText(alinanVeri);
        });
        binding.buttonSayi4.setOnClickListener(view->{
            String alinanVeri = binding.Ekran.getText().toString();
            alinanVeri += "4";
            binding.Ekran.setText(alinanVeri);
        });
        binding.buttonSayi5.setOnClickListener(view->{
            String alinanVeri = binding.Ekran.getText().toString();
            alinanVeri += "5";
            binding.Ekran.setText(alinanVeri);
        });binding.buttonSayi6.setOnClickListener(view->{
            String alinanVeri = binding.Ekran.getText().toString();
            alinanVeri += "6";
            binding.Ekran.setText(alinanVeri);
        });
        binding.buttonSayi7.setOnClickListener(view->{
            String alinanVeri = binding.Ekran.getText().toString();
            alinanVeri += "1";
            binding.Ekran.setText(alinanVeri);
        });
        binding.buttonSayi8.setOnClickListener(view->{
            String alinanVeri = binding.Ekran.getText().toString();
            alinanVeri += "8";
            binding.Ekran.setText(alinanVeri);
        });
        binding.buttonSayi9.setOnClickListener(view->{
            String alinanVeri = binding.Ekran.getText().toString();
            alinanVeri += "9";
            binding.Ekran.setText(alinanVeri);
        });
        binding.buttonTopla.setOnClickListener(view->{
            String alinanVeri = binding.Ekran.getText().toString();
            alinanVeri += "+";
            binding.Ekran.setText(alinanVeri);
        });
        binding.buttonVirgul.setOnClickListener(view->{
            String alinanVeri = binding.Ekran.getText().toString();
            alinanVeri += ".";
            binding.Ekran.setText(alinanVeri);
        });

        binding.buttonTemizle.setOnClickListener(view->{
            binding.Ekran.setText("");
        });

        binding.buttonSayiEsittir.setOnClickListener(view->{
            String alinanVeri = binding.Ekran.getText().toString();
            String[] sayilar = alinanVeri.split("\\+");

            double toplam = 0;
            for (String sayi : sayilar){
                toplam += Double.parseDouble(sayi);
            }

            binding.Ekran.setText(String.valueOf(toplam));
            //Log.e("Sonuc", String.valueOf(toplam));

        });

    }
}