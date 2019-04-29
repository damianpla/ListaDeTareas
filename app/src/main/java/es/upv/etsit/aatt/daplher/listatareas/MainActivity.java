package es.upv.etsit.aatt.daplher.listatareas;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView titlepage, subtitlepage, endpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);
        endpage = findViewById(R.id.endpage);

        //importamos fuente
        Typeface MLight= Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");
        Typeface MMedium= Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");

        //fuentes personalizadas
        titlepage.setTypeface(MMedium);
        subtitlepage.setTypeface(MLight);
        endpage.setTypeface(MLight);
    }
}
