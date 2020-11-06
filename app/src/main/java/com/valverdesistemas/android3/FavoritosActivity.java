package com.valverdesistemas.android3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

//import com.example.recyclerview_actionview.R;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;

    private RecyclerView RecyclerViewListaMacotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        // Retroceso activacion
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mascotas = new ArrayList<Mascota>();

        // Setear Mascotas
        mascotas.add(new Mascota(R.drawable.puppy1,"Toby",6));
        mascotas.add(new Mascota(R.drawable.puppy2,"Eva",4));
        mascotas.add(new Mascota(R.drawable.puppy3,"Coco",8));


        // Asociar RecyclerView
        RecyclerViewListaMacotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager LayoutManagerMascotas = new LinearLayoutManager(this);
        LayoutManagerMascotas.setOrientation(LinearLayoutManager.VERTICAL);

        // Llamado al Layout
        RecyclerViewListaMacotas.setLayoutManager(LayoutManagerMascotas);

        // Creacion del objeto
        MascotaAdaptador adaptadorMascotas = new MascotaAdaptador(mascotas);

        // Set adapatador
        RecyclerViewListaMacotas.setAdapter(adaptadorMascotas);

    }

    // Retroceso
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(FavoritosActivity.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
