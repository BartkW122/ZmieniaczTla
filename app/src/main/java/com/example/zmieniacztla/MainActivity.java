package com.example.zmieniacztla;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private String[] texts = {"text1","text2","text3","text3"};
    private static boolean czyWidoczne;
    private static TextView tvText;
    private Button btnChangeText,btnChangeColor,btnChangeBg;
    private SwitchCompat switchNight;

    private static int aktualnyIndexKoloru = 0;
    private static int aktualnyIndexTextu = 0;
    private static int[] tablicaKolorow={R.color.text_color,R.color.text_opt2,R.color.text_opt3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        czyWidoczne = true;

        tvText = findViewById(R.id.tvText);
        tvText.setText(texts[aktualnyIndexTextu]);

        btnChangeText = findViewById(R.id.btnChangeText);
        btnChangeColor = findViewById(R.id.btnChangeColor);
        btnChangeBg = findViewById(R.id.btnChangeBg);

        btnChangeColor.setOnClickListener(v->{
            if(aktualnyIndexKoloru < tablicaKolorow.length-1) {
                aktualnyIndexKoloru++;
            }else {
                aktualnyIndexKoloru = 0;
            }
            tvText.setTextColor(ContextCompat.getColor(MainActivity.this, tablicaKolorow[aktualnyIndexKoloru]));
        });

        btnChangeText.setOnClickListener(v->{
            if(aktualnyIndexTextu < 2) {
                aktualnyIndexTextu++;
            }else {
                aktualnyIndexTextu = 0;
            }
            System.out.println(aktualnyIndexTextu);
            tvText.setText(texts[aktualnyIndexTextu]);
        });

        switchNight = findViewById(R.id.switchNight);

        switchNight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
        System.out.println("Create:"+czyWidoczne);
    }

    @Override
    protected void onStart() {
        super.onStart();
        czyWidoczne = true;
        int l = 0;
        while (czyWidoczne && l<10) {
            l++;
            if(czyWidoczne) {
//                zmiananTlaAutomatycznie();
            }
        }
        System.out.println("Start:"+czyWidoczne);
    }

    @Override
    protected void onStop() {
        super.onStop();
        czyWidoczne = false;
        System.out.println("Stop:"+czyWidoczne);
    }

    private static  void zmianaKoloruTesktu(){
        if(aktualnyIndexKoloru<tablicaKolorow.length-1) {
            aktualnyIndexKoloru++;
            System.out.println(aktualnyIndexKoloru);
            tvText.setTextColor(tablicaKolorow[aktualnyIndexKoloru]);
        }else {
            aktualnyIndexKoloru = 0;
            System.out.println(aktualnyIndexKoloru);
            tvText.setTextColor(tablicaKolorow[aktualnyIndexKoloru]);
        }
    }

    //Do zrobienia
    private static  void  zmiananTlaAutomatycznie(){
        try {
            Thread.sleep(3000);
            System.out.println(czyWidoczne);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}