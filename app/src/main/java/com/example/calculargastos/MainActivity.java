package com.example.calculargastos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtValor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void botaoGastos(View view) {

        txtValor = findViewById(R.id.txtValor);

        gasto g = new gasto();
        g.gastos = txtValor.getText().toString();

        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    AppDataBase db = Room.databaseBuilder(getApplicationContext(),
                            AppDataBase.class, "gastos").build();

                    gastoDAO dao = db.gastoDAO();

                    dao.insert(g);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("Salvo com sucesso");
                            builder.create().show();
                        }
                    });

                }
            }).start();


        } catch (Exception ex){
            ex.printStackTrace();
        }


    }

    public void carregar(View view) {
        LinearLayout layoutResultado = findViewById(R.id.layoutResultado);
        layoutResultado.removeAllViews();

        new Thread(new Runnable() {
            @Override
            public void run() {
                AppDataBase db = Room.databaseBuilder(getApplicationContext(),
                        AppDataBase.class, "gastos").build();

                gastoDAO dao = db.gastoDAO();

               List<gasto> gastos = dao.listar();

               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       for (gasto g: gastos){
                           TextView t = new TextView(MainActivity.this);
                           t.setText(g.gastos);

                           layoutResultado.addView(t);
                       }
                   }
               });
            }
        }).start();


    }
}