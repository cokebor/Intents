package com.example.a1_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private int resu=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        if(intent.getExtras()!=null){
            String usuario=intent.getExtras().getString("usuario");
            String clave=intent.getExtras().getString("clave");
            Toast.makeText(this, "Usuario: "+usuario + " Clave: " + clave , Toast.LENGTH_LONG).show();
            int n1=intent.getExtras().getInt("numero1");
            int n2=intent.getExtras().getInt("numero2");
            resu=n1+n2;
        }
    }

    @Override
    public void finish() {
        Intent intent=new Intent();
        intent.putExtra("resu", this.resu);
        setResult(RESULT_OK,intent);
        super.finish();
    }
}