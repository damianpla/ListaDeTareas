package es.upv.etsit.aatt.daplher.listatareas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditarTarea extends AppCompatActivity {

    EditText tituloTareas, descripcionTareas, fechaTareas;
    Button btnActualizar, btnEliminar;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_tarea);

        tituloTareas =findViewById(R.id.titulotareas);
        descripcionTareas =findViewById(R.id.descripciontarea);
        fechaTareas =findViewById(R.id.fechatareas);

        btnActualizar =findViewById(R.id.btnActualizar);
        btnEliminar =findViewById(R.id.btnEliminar);

        //coger valores anteriores
        tituloTareas.setText(getIntent().getStringExtra("titulotareas"));
        descripcionTareas.setText(getIntent().getStringExtra("descripciontareas"));
        fechaTareas.setText(getIntent().getStringExtra("fechatareas"));

        final String keyidTareas = getIntent().getStringExtra("idtareas");

        reference = FirebaseDatabase.getInstance().getReference().child("CajaTareas").
                child("Tareas" + keyidTareas);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(Task<Void> task) {
                        if (task.isSuccessful()){
                            Intent a = new Intent(EditarTarea.this,MainActivity.class);
                            startActivity(a);
                        }else{
                            Toast.makeText(getApplicationContext(),"¡Fail!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        // Funcionalidad de los botones

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("titulotareas").setValue(tituloTareas.getText().toString());
                        dataSnapshot.getRef().child("descripciontareas").setValue(descripcionTareas.getText().toString());
                        dataSnapshot.getRef().child("fechatareas").setValue(fechaTareas.getText().toString());
                        //dataSnapshot.getRef().child("idtearea").setValue(keyidTareas);
                        Intent a = new Intent(EditarTarea.this,MainActivity.class);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}
