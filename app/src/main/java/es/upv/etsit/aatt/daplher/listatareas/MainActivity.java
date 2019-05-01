package es.upv.etsit.aatt.daplher.listatareas;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView titlepage, subtitlepage, endpage;
    Button btnAnyadirNueva;

    private DatabaseReference reference;
    RecyclerView nuestrastareas;
    ArrayList<MisTareas> list;
    AdaptadorTareas adaptadorTareas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);
        endpage = findViewById(R.id.endpage);

        btnAnyadirNueva =findViewById(R.id.btnAnyadirNueva);

        //importamos fuente
        Typeface MLight= Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");
        Typeface MMedium= Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");

        //fuentes personalizadas
        titlepage.setTypeface(MMedium);
        subtitlepage.setTypeface(MLight);
        endpage.setTypeface(MLight);

        btnAnyadirNueva.setTypeface(MLight);

        btnAnyadirNueva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,NuevaActividadTarea.class);
                startActivity(a);
            }
        });


        //trabajar con los datos
        nuestrastareas = findViewById(R.id.nuestrastareas);
        nuestrastareas.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MisTareas>();


        //recoger datos de firebase
        reference = FirebaseDatabase.getInstance().getReference();
        reference = reference.child("ListaTareas");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //escribir codigo para recuperar datos y reemplazar en el layout
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    MisTareas p= dataSnapshot1.getValue(MisTareas.class);
                    list.add(p);
                }
                adaptadorTareas = new AdaptadorTareas(MainActivity.this, list);
                nuestrastareas.setAdapter(adaptadorTareas);
                adaptadorTareas.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //codigo para caso de error
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
