package com.muhammhassan.latihan1;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.muhammhassan.latihan1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnProses.setOnClickListener(v -> {
            String panggilan = getPanggilan();
            String nama = binding.edtNama.getText().toString().trim();
            String NIM = binding.edtNIM.getText().toString().trim();
            String kelas = binding.edtKelas.getText().toString().trim();
            String mataKuliah = binding.edtMatkul.getText().toString().trim();
            String UTS = binding.edtUTS.getText().toString().trim();
            String UAS = binding.edtUAS.getText().toString().trim();
            String lainLain = binding.edtLainLain.getText().toString().trim();

            double nilaiAkhir = getNilaiAkhir(Double.parseDouble(UTS), Double.parseDouble(UAS), Double.parseDouble(lainLain));

        });
    }

    String getPanggilan(){
        if(binding.radioGroup.getCheckedRadioButtonId() == binding.rbLakiLaki.getId()){
            return "Mas";
        }else return "Mba";
    }

    double getNilaiAkhir(double uts, double uas, double lainLain){
        return (uts * 0.3) + (uas * 0.4) + (lainLain * 0.3);
    }
}