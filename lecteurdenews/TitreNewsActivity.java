package com.dia.mous.lecteurdenews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class TitreNewsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_recycler);

        Toast.makeText(this,"Bonjour, bienvenu !", Toast.LENGTH_LONG).show();

        final RecyclerView rv = (RecyclerView)findViewById(R.id.list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MonAdapter());
    }

}