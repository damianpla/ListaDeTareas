package es.upv.etsit.aatt.daplher.listatareas;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorTareas extends RecyclerView.Adapter <AdaptadorTareas.MyViewHolder> {

    Context context;
    ArrayList <MisTareas> misTareas;

    public AdaptadorTareas(Context c, ArrayList <MisTareas> p){
        context = c;
        misTareas = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tareas, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.titulotareas.setText(misTareas.get(i).getTitulotareas());
        myViewHolder.descripciontareas.setText(misTareas.get(i).getDescripciontareas());
        myViewHolder.fechatareas.setText(misTareas.get(i).getFechatareas());

        final  String getTituloTareas = misTareas.get(i).getTitulotareas();
        final  String getDescripcionTareas = misTareas.get(i).getDescripciontareas();
        final  String getFechaTareas = misTareas.get(i).getFechatareas();
        final  String getIdTareas = misTareas.get(i).getIdtareas();

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aa = new Intent(context,EditarTarea.class);
                aa.putExtra("titulotareas",getTituloTareas);
                aa.putExtra("descripciontareas",getDescripcionTareas);
                aa.putExtra("fechatareas",getFechaTareas);
                aa.putExtra("idtareas", getIdTareas);
                context.startActivity(aa);
            }
        });

    }

    @Override
    public int getItemCount() {
        return misTareas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulotareas,descripciontareas, fechatareas, idtareas;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titulotareas = (TextView) itemView.findViewById(R.id.titulotareas);
            descripciontareas = (TextView) itemView.findViewById(R.id.descripciontareas);
            fechatareas = (TextView) itemView.findViewById(R.id.fechatareas);
        }
    }

}
