package es.upv.etsit.aatt.daplher.listatareas;

import android.content.Intent;
import android.graphics.Typeface;
import android.provider.Telephony;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Random;

public class NuevaActividadTarea extends AppCompatActivity {

    TextView titlepage, anyadirtitulo, anyadirdescripcion, anyadirfecha;
    EditText titulotareas, descripciontareas,fechatareas;
    Button btnGuardarTarea, btnCancelar;
    DatabaseReference reference;
    Integer numeroTarea = new Random().nextInt();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_actividad_tarea);

        titlepage = findViewById(R.id.titlepage);

        anyadirtitulo = findViewById(R.id.anyadirtitulo);
        anyadirdescripcion = findViewById(R.id.anyadirdescripcion);
        anyadirfecha = findViewById(R.id.anyadirfecha);

        titulotareas = findViewById(R.id.titulotareas);
        descripciontareas = findViewById(R.id.descripciontarea);
        fechatareas = findViewById(R.id.fechatareas);

        btnCancelar = findViewById(R.id.btnCancelar);
        btnGuardarTarea = findViewById(R.id.btnGuardarTarea);

        btnGuardarTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //insertar datos en firebase
                reference = FirebaseDatabase.getInstance().getReference().child("CajaTareas").
                        child("Tareas" + numeroTarea);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        dataSnapshot.getRef().child("titulotareas").setValue(titulotareas.getText().toString());
                        dataSnapshot.getRef().child("descripciontareas").setValue(descripciontareas.getText().toString());
                        dataSnapshot.getRef().child("fechatareas").setValue(fechatareas.getText().toString());

                        Intent a = new Intent(NuevaActividadTarea.this,MainActivity.class);
                        startActivity(a);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //importar fuente
        Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/ML.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MM.ttf");

        //fuentes personalizadas
        titlepage.setTypeface(MMedium);

        anyadirtitulo.setTypeface(MLight);
        titulotareas.setTypeface(MMedium);

        anyadirdescripcion.setTypeface(MLight);
        descripciontareas.setTypeface(MMedium);

        anyadirfecha.setTypeface(MLight);
        fechatareas.setTypeface(MMedium);

        btnGuardarTarea.setTypeface(MMedium);
        btnCancelar.setTypeface(MLight);

    }
}
