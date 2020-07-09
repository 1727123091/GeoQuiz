package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnVerdadero;
    private Button btnFalso;
    private Button btnsiguiente;
    private Button btnanterior;

    private TextView txtPregunta;

    private Pregunta[] preguntas={
            new Pregunta(R.string.pregunta_1, true),
            new Pregunta(R.string.pregunta_2, true),
            new Pregunta(R.string.pregunta_3, true),
            new Pregunta(R.string.pregunta_4, true),
           new Pregunta(R.string.pregunta_5, false),


    };

    private Pregunta[] mPreguntas= new Pregunta[5];
    int actual =0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVerdadero=(Button)findViewById(R.id.btn_verdadero);
        btnFalso=(Button)findViewById(R.id.btn_falso);
        btnanterior=findViewById(R.id.btn_anterior);
        btnsiguiente=findViewById(R.id.btn_siguiente);
        txtPregunta=findViewById(R.id.txt_preguntas);

        //Pregunta p0= preguntas[0];
        //txtPregunta.setText(p0.getTextoId());

        setText();

        btnVerdadero.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                /*boolean respuesta= preguntas[actual].isRespuesta();
                if(respuesta){
                    Toast.makeText(MainActivity.this,"Correcto",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Incorrecto",Toast.LENGTH_SHORT).show();
                }*/
                verificarRespuesta(true);
            }
        });

        btnFalso.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                verificarRespuesta(false);
            }
        });


        btnsiguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View view){
                actual=(actual+1)% preguntas.length;
                setText();

            }
        });

        btnanterior.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View view){
                actual=(actual-1)% preguntas.length;
                setText();

            }
        });


    }
    void setText(){
        txtPregunta.setText(preguntas[actual].getTextoId());
    }
    void verificarRespuesta(boolean result){
        boolean respuesta= preguntas[actual].isRespuesta();

        if(respuesta==result){
            Toast.makeText(MainActivity.this,"Correcto",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,"Incorrecto",Toast.LENGTH_SHORT).show();
        }
    }
}