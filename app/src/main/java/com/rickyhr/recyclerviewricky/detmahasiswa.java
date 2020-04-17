package com.rickyhr.recyclerviewricky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detmahasiswa extends AppCompatActivity {
public static String seNama;
private TextView nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detmahasiswa);
        nama = (TextView) findViewById(R.id.det_nama);
        String enama = getIntent().getStringExtra(seNama);
        nama.setText(enama);



    }
}
