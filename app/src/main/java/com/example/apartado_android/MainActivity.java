package com.example.apartado_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase database;


    private EditText calificacion;

    private Button envio;
    private TextView Question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();

        calificacion = findViewById(R.id.calificación);
        envio = findViewById(R.id.enviar);
        Question = findViewById(R.id.pregunta);

        envio.setOnClickListener(this);
    }

    public void send() {

        database.getReference().child("Preguntas").addListenerForSingleValueEvent(

                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        String r = calificacion.getText().toString().trim();
                        String idQuestion  = UUID.randomUUID().toString();
                        Pregunta pregunta = snapshot.getValue(Pregunta.class);

                        String preguntaActual = "PreguntaActual";

                        if(pregunta.getEstado() == preguntaActual){

                            Respuesta respuesta = new Respuesta(

                                    idQuestion,
                                    r

                            );
                            database.getReference().child(pregunta.getId()).child(idQuestion).setValue(respuesta);
                            calificacion.setText("");

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.enviar:

                send();

                break;
        }
    }
}