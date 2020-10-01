package com.chandra.uts_18415003_mahadityachandras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtnpm, edtnama, edtmatkul, edttgs, edtuts, edtuas;

    Button btnnilai;
    TextView txtNilai, Grade, Keterangan, Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtnpm = (EditText) findViewById(R.id.edtnpm);
        edtnama = (EditText) findViewById(R.id.edtnama);
        edtmatkul = (EditText) findViewById(R.id.edtmatkul);
        edttgs = (EditText) findViewById(R.id.tgs);
        edtuts = (EditText) findViewById(R.id.uts);
        edtuas = (EditText) findViewById(R.id.uas);
        Grade = (TextView)findViewById(R.id.grade);
        Hasil  = (TextView) findViewById(R.id.hasil);
        txtNilai  = (TextView) findViewById(R.id.totalnilai);
        Keterangan  = (TextView) findViewById(R.id.keterangan);
        btnnilai = (Button) findViewById(R.id.btnnilai);


        btnnilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNPM = edtnpm.getText().toString();
                String strNama = edtnama.getText().toString();
                String strMatkul = edtmatkul.getText().toString();
                String strGrade = Grade.getText().toString();
                String tugas = edttgs.getText().toString().trim();
                String uts = edtuts.getText().toString().trim();
                String uas = edtuas.getText().toString().trim();


                double T = Double.parseDouble(tugas);
                double U = Double.parseDouble(uts);
                double UAS = Double.parseDouble(uas);
                double Nilai = (0.3 * T) + (0.3 * U) + (0.4 * UAS);


                if (Nilai >= 80&&Nilai<=100) {
                    strGrade = "A";
                } else if (Nilai >= 70&&Nilai<=80) {
                    strGrade = "B";
                } else if (Nilai >= 60&&Nilai<=70) {
                    strGrade = "C";
                } else if (Nilai >= 50&&Nilai<=60) {
                    strGrade = "D";
                } else {
                    strGrade = "E";
                }

                txtNilai.setText("NPM : " +strNPM + "\n" + "NAMA : " +strNama + "\n" + "MATA KULIAH : " + strMatkul + "\n"   + "GRADE : " + strGrade + "\n" + "TOTAL NILAI : " + Nilai );

                if (Nilai >= 60) {
                    Keterangan.setText("KETERANGAN : LULUS");
                } else {
                    Keterangan.setText("KETERANGAN : TIDAK LULUS");
                }
            }
        });

    }
}