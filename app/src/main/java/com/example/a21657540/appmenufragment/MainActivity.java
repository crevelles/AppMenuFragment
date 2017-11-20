package com.example.a21657540.appmenufragment;

import android.app.Dialog;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cl = (ConstraintLayout) findViewById(R.id.clContenedor);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void visualizar(){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.clContenedor, new Fragmento1());
        ft.commit();
    }

    private Dialog crearDialogo(String mensaje){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(mensaje);
        return builder.create();
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.menu1) {
            crearDialogo("accedemos a fragmento 1").show();
            visualizar();
        } else if(item.getItemId()==R.id.menu2){
            crearDialogo("accedemos a fragmento 2").show();
            visualizar();
        } else if(item.getItemId() == R.id.settings) {
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Se ha pulsado el boton settings", Toast.LENGTH_SHORT);

            toast1.show();
        }
        return(true);
    }

}
