package com.valverdesistemas.android3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//import com.example.recyclerview_actionview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;

    private RecyclerView RecyclerViewListaMacotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Asociar RecyclerView
        RecyclerViewListaMacotas = (RecyclerView) findViewById(R.id.rvMascotas);

        // LinearLayoutManager
        LinearLayoutManager LayoutManagwerMascotas = new LinearLayoutManager(this);
        LayoutManagwerMascotas.setOrientation(LinearLayoutManager.VERTICAL);

        // Asociar LayoutManagwer a RecyclerView
        RecyclerViewListaMacotas.setLayoutManager(LayoutManagwerMascotas);

        mascotas = new ArrayList<Mascota>();
        // Setear Mascotas
        mascotas.add(new Mascota(R.drawable.puppy1,"Toby",6));
        mascotas.add(new Mascota(R.drawable.puppy2,"Eva",4));
        mascotas.add(new Mascota(R.drawable.puppy3,"Coco",8));

        // Adaptador
        MascotaAdaptador adaptadorMascotas = new MascotaAdaptador(mascotas);

        // Setear adaptador
        RecyclerViewListaMacotas.setAdapter(adaptadorMascotas);

    }
    // action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            // intent Favoritos
            Intent intento = new Intent(this,FavoritosActivity.class);
            startActivity(intento);
        }
        return super.onOptionsItemSelected(item);
    }
}