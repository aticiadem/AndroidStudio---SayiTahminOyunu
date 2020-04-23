package com.example.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class TahminActivity extends AppCompatActivity {
    private TextView textViewKalanHak, textViewYardim;
    private EditText editTextGirdi;
    private Button buttonTahmin;

    private int rastgeleSayi;
    private int sayac = 5;

    ArrayList<Integer> dizi = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);

        textViewKalanHak = findViewById(R.id.textViewKalanHak);
        textViewYardim = findViewById(R.id.textViewYardim);
        editTextGirdi = findViewById(R.id.editTextGirdi);
        buttonTahmin = findViewById(R.id.buttonTahmin);

        Random r = new Random();
        rastgeleSayi = r.nextInt(101);
        Log.e("Rastgele Sayi: ", String.valueOf(rastgeleSayi));

        final Intent intent = new Intent(TahminActivity.this, SonucActivity.class);
        intent.putExtra("sayi",(int) rastgeleSayi);

        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sayac = sayac - 1;
                int tahmin = Integer.parseInt(editTextGirdi.getText().toString());

                if(tahmin == rastgeleSayi){
                    dizi.add(tahmin);
                    Intent i = new Intent(TahminActivity.this,SonucActivity.class);
                    i.putExtra("sonuc",true);
                    startActivity(i);
                    finish();
                    return;
                }
                if(tahmin > rastgeleSayi){
                    dizi.add(tahmin);
                    textViewYardim.setText("Azalt");
                    textViewKalanHak.setText("Kalan Hak : "+ sayac);
                }
                if(tahmin < rastgeleSayi){
                    dizi.add(tahmin);
                    textViewYardim.setText("Arttır");
                    textViewKalanHak.setText("Kalan Hak : "+ sayac);
                }
                if(sayac == 0){
                    Intent i = new Intent(TahminActivity.this,SonucActivity.class);
                    i.putExtra("sonuc",false);
                    startActivity(i);
                    startActivity(intent);
                    finish();
                }
                intent.putExtra("dizi",dizi);
                editTextGirdi.setText("");

            }
        });
    }
}
