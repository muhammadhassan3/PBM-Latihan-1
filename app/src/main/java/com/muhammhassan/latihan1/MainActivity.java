package com.muhammhassan.latihan1;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.muhammhassan.latihan1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //deklarasi viewbinding
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //inisiasi viewbinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //menetapkan viewbinding untuk ditampilkan pada halaman ini
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //menambahkan aksi klik pada tombol proses
        binding.btnProses.setOnClickListener(v -> {
            //memuat nilai yang ada pada komponen view
            String panggilan = getPanggilan();
            String nama = binding.edtNama.getText().toString().trim();
            String NIM = binding.edtNIM.getText().toString().trim();
            String kelas = binding.edtKelas.getText().toString().trim();
            String mataKuliah = binding.edtMatkul.getText().toString().trim();
            String UTS = binding.edtUTS.getText().toString().trim();
            String UAS = binding.edtUAS.getText().toString().trim();
            String lainLain = binding.edtLainLain.getText().toString().trim();

            //mendapatkan nilai akhir
            double nilaiAkhir = getNilaiAkhir(Double.parseDouble(UTS), Double.parseDouble(UAS), Double.parseDouble(lainLain));

            //membuat objek intent
            Intent intent = new Intent(this, ResultActivity.class);
            //menetapkan data yang akan dikirimkan berdasarkan key yang ada pada halaman result
            intent.putExtra(ResultActivity.EXTRA_NAMA, nama);
            intent.putExtra(ResultActivity.EXTRA_NIM, NIM);
            intent.putExtra(ResultActivity.EXTRA_PANGGILAN, panggilan);
            intent.putExtra(ResultActivity.EXTRA_KELAS, kelas);
            intent.putExtra(ResultActivity.EXTRA_MATA_KULIAH, mataKuliah);
            intent.putExtra(ResultActivity.EXTRA_NILAI_AKHIR, nilaiAkhir);
            intent.putExtra(ResultActivity.EXTRA_JENIS_KELAMIN, getJenisKelamin());

            //menjalankan halaman result
            startActivity(intent);
        });
    }

    //mendapatkan nama panggilan berdasarkan radio button yang dipilih
    String getPanggilan() {
        if (binding.radioGroup.getCheckedRadioButtonId() == binding.rbLakiLaki.getId()) {
            return "Mas";
        } else return "Mba";
    }

    //mendapatkan nilai radio butotn yang dipilih
    String getJenisKelamin() {
        if (binding.radioGroup.getCheckedRadioButtonId() == binding.rbLakiLaki.getId()) {
            return "Laki Laki";
        } else return "Perempuan";
    }

    //menghitung nilai akhir
    double getNilaiAkhir(double uts, double uas, double lainLain) {
        return (uts * 0.3) + (uas * 0.4) + (lainLain * 0.3);
    }
}