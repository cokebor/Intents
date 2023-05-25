package com.example.a1_intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnUno;
    private Button btnDos;
    private Button btnTres;

    private static final int REQUEST_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUno=(Button) findViewById(R.id.btnUno);
        btnDos=(Button) findViewById(R.id.btnDos);
        btnTres=(Button) findViewById(R.id.btnTres);

        btnUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ir a otra actividad", Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);
            }
        });

        btnDos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ir a otra actividad enviando datos", Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
                i.putExtra("usuario","juan");
                i.putExtra("clave","123");
                startActivity(i);
            }
        });

        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ir a otra actividad enviando datos y esperando resultados", Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
                i.putExtra("numero1",5);
                i.putExtra("numero2",10);
                startActivityForResult(i,REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("resu")) {
                int resu = data.getExtras().getInt("resu");
                Toast.makeText(this, "resu " + resu, Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onClick(View v){
        Intent intent=null;
        switch (v.getId()){
            case R.id.btnImagen:
                intent=new Intent("android.media.action.IMAGE_CAPTURE");
                break;
            case R.id.btnWeb:
                intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com.ar"));
                break;
            case R.id.btnCall:
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:" + "+543522650985"));
                break;
            case R.id.btnGps:
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:-31.418559,-64.190081"));
                break;
        }
        if(intent!=null) {
            startActivity(intent);
        }
    }
}