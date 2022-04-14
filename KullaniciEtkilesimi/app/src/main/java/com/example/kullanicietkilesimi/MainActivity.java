package com.example.kullanicietkilesimi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kullanicietkilesimi.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding tasarim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());
        
        
        tasarim.buttonToast.setOnClickListener(view -> {
            Toast.makeText(this, "Merhaba", Toast.LENGTH_SHORT).show();
        });
        
        tasarim.buttonSnackbar.setOnClickListener(view -> {
            Snackbar.make(view,"silmek istiyor musun ?",Snackbar.LENGTH_SHORT)
                    .setAction("Evet",view1 -> {
                        Snackbar.make(view1,"Silindi!!",Snackbar.LENGTH_SHORT)
                                .setTextColor(Color.BLUE)
                                .setBackgroundTint(Color.WHITE)
                                .show();
                    })
                    .setActionTextColor(Color.RED)
                    .setTextColor(Color.BLUE)
                    .setBackgroundTint(Color.WHITE)
                    .show();
        });
        
        tasarim.buttonAlert.setOnClickListener(view -> {
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle("Başlık");
            ad.setMessage("İçerik");

            ad.setPositiveButton("Tamam",(d,i) -> {
                // d -> dialog interface , button itself
                Toast.makeText(this, "Tamam seçildi", Toast.LENGTH_SHORT).show();
            });
            ad.setNegativeButton("Iptal",(d,i) -> {
                Toast.makeText(this, "İptal seçildi", Toast.LENGTH_SHORT).show();
            });

            ad.create().show();
        });
    }
}