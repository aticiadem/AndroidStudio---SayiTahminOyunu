package com.example.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SonucActivity extends AppCompatActivity {
    private ImageView imageViewSonuc;
    private TextView textViewSonuc;
    private Button buttonTekrarOyna;

    private Boolean sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        imageViewSonuc = findViewById(R.id.imageViewSonuc);
        textViewSonuc = findViewById(R.id.textViewSonuc);
        buttonTekrarOyna = findViewById(R.id.buttonTekrarOyna);

        sonuc = getIntent().getBooleanExtra("sonuc",false);
        ArrayList<Integer> dizi = getIntent().getExtras().getIntegerArrayList("dizi");


        if(sonuc){
            textViewSonuc.setText("Tebrikler! Kazandınız.");
            imageViewSonuc.setImageResource(R.drawable.mutlu_resim);
        }else{
            Integer deger = getIntent().getExtras().getInt("sayi");
            textViewSonuc.setText("Kaybettiniz! Sonuc: "+deger+"  Tahminler : "+dizi);
            imageViewSonuc.setImageResource(R.drawable.uzgun_resim);
        }

        buttonTekrarOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SonucActivity.this,TahminActivity.class));
                finish();
            }
        });
    }
}
