package com.rickyhr.recyclerviewricky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ArrayList<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();
private RecyclerView recyclerView;
private MahasiswaAdapter mAdapter;
TextView tes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isiData();
        recyclerView = (RecyclerView) findViewById(R.id.recicler_view);
        mAdapter = new MahasiswaAdapter(mahasiswaList);
        RecyclerView.LayoutManager mLayoutman = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutman);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Mahasiswa mhs =mahasiswaList.get(position);
                Toast.makeText(getApplicationContext(),mhs.getNama()+"is select",Toast.LENGTH_SHORT).show();
                Intent detAct = new Intent(MainActivity.this,detmahasiswa.class);
                detAct.putExtra(detmahasiswa.seNama,"Nama :"+mhs.getNama()+"\n\n Nim :"+mhs.getNim()+"\n\n Nohp   :"+mhs.getNohp());
                startActivity(detAct);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }
    private void isiData(){
        mahasiswaList = new ArrayList<>();
        mahasiswaList.add(new Mahasiswa("Ricky Hariya","311710269","1234456789"));
        mahasiswaList.add(new Mahasiswa("Rita p","311710619","987654321"));
        mahasiswaList.add(new Mahasiswa("Ariandi Nugraha","1214230345","9876548765"));
        mahasiswaList.add(new Mahasiswa("Aham Siswana","1214378098","0987581234"));
    }
}
