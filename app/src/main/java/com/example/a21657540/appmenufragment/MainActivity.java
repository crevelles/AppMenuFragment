package com.example.a21657540.appmenufragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.provider.Settings;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
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
//Cristobal
    ConstraintLayout cl;
    String mensajeFragmento1;
    String mensajeFragmento2;
    String mensaBTNsettings;
    String mensaSalirApp;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cl = (ConstraintLayout) findViewById(R.id.clContenedor);
        mensajeFragmento1 = (String)getResources().getString(R.string.dialogFragmento1);
        mensajeFragmento2 = (String)getResources().getString(R.string.dialogFragmento2);
        mensaBTNsettings  = (String)getResources().getString(R.string.mensaBTNsettings);
        mensaSalirApp = (String)getResources().getString(R.string.mensaSalirApp);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void visualizar(Fragment f){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.clContenedor, f);
        ft.commit();
    }

    private Dialog crearDialogo(String mensaje){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(mensaje);
        return builder.create();
    }

    private Dialog crearDialogoOpciones(){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
        dialogo.setTitle(mensaSalirApp);
        dialogo.setCancelable(false);
        dialogo.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                iniciarProgressDialogSpinner();
            }
        });
        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo.show();
        return dialogo.create();
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.menu1) {
            crearDialogo(mensajeFragmento1).show();
            Fragmento1 f = new Fragmento1();
            visualizar(f);
        } else if(item.getItemId()==R.id.menu2){
            crearDialogo(mensajeFragmento2).show();
            Fragmento2 f = new Fragmento2();
            visualizar(f);
        } else if(item.getItemId() == R.id.settings) {
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            mensaBTNsettings, Toast.LENGTH_SHORT);
            toast1.show();
        } else if(item.getItemId() == R.id.menu_salir) {
            crearDialogoOpciones();
        }
        return(true);
    }


    public void iniciarProgressDialogSpinner(){

        pd = new ProgressDialog(MainActivity.this);
        pd.setMessage("Saliendo");
        pd.setTitle("Finalizando");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show(); // Display Progress Dialog
        pd.setCancelable(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                pd.dismiss();
            }
        }).start();

    }

}






