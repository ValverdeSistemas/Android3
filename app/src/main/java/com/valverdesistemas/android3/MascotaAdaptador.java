package com.valverdesistemas.android3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;


class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> Mascotas;


    // set mascotas
    public MascotaAdaptador(ArrayList<Mascota> Mascotas) {
        this.Mascotas = Mascotas;
    }

    // carga  cardview
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // asociar reclyclerView: infla el layout que va a reciclar cardview_mascota
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        //  layout a reciclar cardview_mascota inflate, se pasa al constructor MascotaViewHolder para obtener cada View y se devuelve
        return new MascotaViewHolder(v) ;
    }

    // cada elemento asociacio a un view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder MascotaViewHolder, int position) {
        final Mascota mascota = Mascotas.get(position);
        // viewholders
        MascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        MascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        MascotaViewHolder.tvTotalCV.setText(Integer.toString(mascota.getRating()));

        // actualizar el rating
        final TextView tvTotalCV_nuevoValor;
        tvTotalCV_nuevoValor   = (TextView) MascotaViewHolder.tvTotalCV;
        // llama a Rating
        MascotaViewHolder.btnAddCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Incrementa rating
                mascota.setRating(mascota.getRating()+1);
                // Mensaje
                Snackbar.make(v,mascota.getNombre() + " tiene un nuevo rating de " + Integer.toString(mascota.getRating()),Snackbar.LENGTH_SHORT).show();
                tvTotalCV_nuevoValor.setText(Integer.toString(mascota.getRating()));
            }
        });


    }


    // Contador de lista
    @Override
    public int getItemCount() {
        return Mascotas.size();
    }


    // Clase static
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private  ImageView imgFotoCV;
        private ImageView btnAddCV;
        private  TextView tvNombreCV;
        private  TextView tvTotalCV;
        private ImageView btnTotalCV;

        // Constructor
        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoCV    = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            btnAddCV    = (ImageView) itemView.findViewById(R.id.btnAddCV);
            tvNombreCV  = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTotalCV   = (TextView) itemView.findViewById(R.id.tvTotalCV);
            btnTotalCV  = (ImageView) itemView.findViewById(R.id.btnTotalCV);

        }
    }


}
