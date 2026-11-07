package com.example.zmieniacztla;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private static boolean czyWidoczne;
    private TextView tvText;
    private Button btnChangeText,btnChangeColor,btnChangeBg;
    private SwitchCompat switchNight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        czyWidoczne = true;

        tvText = findViewById(R.id.tvText);

        btnChangeText = findViewById(R.id.btnChangeText);
        btnChangeColor = findViewById(R.id.btnChangeColor);
        btnChangeBg = findViewById(R.id.btnChangeBg);

        switchNight = findViewById(R.id.switchNight);
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