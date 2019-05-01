package es.upv.etsit.aatt.daplher.listatareas;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NuevaActividadTarea extends AppCompatActivity {

    TextView titlepage, anyadirtitulo, anyadirdescripcion, anyadirfecha;
    EditText titulotareas, descripciontareas,fechatareas;


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



    }
}
