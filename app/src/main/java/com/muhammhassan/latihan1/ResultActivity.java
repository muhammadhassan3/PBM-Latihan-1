package com.muhammhassan.latihan1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.muhammhassan.latihan1.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {
    //Deklarasi viewBinding
    private ActivityResultBinding binding;

    //Deklarasikan key untuk alamat pengiriman data
    public static String EXTRA_NAMA = "ext_nama";
    public static String EXTRA_NIM = "ext_nim";
    public static String EXTRA_PANGGILAN = "ext_panggilan";
    public static String EXTRA_JENIS_KELAMIN = "ext_jenis_kelamin";
    public static String EXTRA_MATA_KULIAH = "ext_mata_kuliah";
    public static String EXTRA_NILAI_AKHIR = "ext_nilai_akhir";
    public static String EXTRA_KELAS = "ext_kelas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //inisiasi viewbinding
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        //menetapkan viewbinding untuk ditampilkan pada halaman ini
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Mendapatkan data yang dikirimkan
        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String NIM = getIntent().getStringExtra(EXTRA_NIM);
        String panggilan = getIntent().getStringExtra(EXTRA_PANGGILAN);
        String jenisKelamin = getIntent().getStringExtra(EXTRA_JENIS_KELAMIN);
        String mataKuliah = getIntent().getStringExtra(EXTRA_MATA_KULIAH);
        Double nilaiAkhir = getIntent().getDoubleExtra(EXTRA_NILAI_AKHIR, 0.0);
        String kelas = getIntent().getStringExtra(EXTRA_KELAS);

        //Menetapkan nilai setiap komponen TextView
        binding.tvNama.setText("Nama Mahasiswa : "+panggilan+" "+nama);
        binding.tvNIM.setText("NIM : "+NIM);
        binding.tvJenisKelamin.setText("Jenis Kelamin : "+jenisKelamin);
        binding.tvMataKuliah.setText("Mata Kuliah : "+mataKuliah);
        binding.tvNilaiAkhir.setText("Nilai Akhir : "+nilaiAkhir);
        binding.tvKelas.setText("Kelas : "+kelas);
        binding.tvGrade.setText("Grade : "+getGrade(nilaiAkhir));
    }

    //Menentukan grade berdasarkan parameter nilai Akhir
    String getGrade(double nilaiAkhir){
        String grade = "Grade Tidak valid";
        if(nilaiAkhir >80 && nilaiAkhir <= 100){
            grade = "A";
        }else if ( nilaiAkhir >=70 && nilaiAkhir <= 80){
            grade = "AB";
        } else if (nilaiAkhir >=60 && nilaiAkhir <  80) {
            grade = "B";
        } else if (nilaiAkhir >=50 && nilaiAkhir < 60){
            grade = "BC";
        } else if (nilaiAkhir >=40 && nilaiAkhir < 50) {
            grade = "C";
        }else if (nilaiAkhir >= 30 && nilaiAkhir < 40){
            grade = "D";
        }else if(nilaiAkhir >=0 && nilaiAkhir < 30){
            grade = "E";
        }

        return grade;
    }
}