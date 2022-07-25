package com.example.appcalcink.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appcalcink.R;
import com.example.appcalcink.data.Data;
import com.example.appcalcink.model.Wall;
import com.google.gson.Gson;

public class Form extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();
    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        data = new Data(this);


        this.mViewHolder.button_back = findViewById(R.id.button_back);
        this.mViewHolder.button_add = findViewById(R.id.button_add);
        this.mViewHolder.form_wall_altura = findViewById(R.id.form_wall_altura);
        this.mViewHolder.form_wall_largura = findViewById(R.id.form_wall_largura);
        this.mViewHolder.forma_wall_portas = findViewById(R.id.form_wall_portas);
        this.mViewHolder.form_wall_janelas = findViewById(R.id.form_wall_janelas);

        this.mViewHolder.button_back.setOnClickListener(this);
        this.mViewHolder.button_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_back) {
            Intent intent = new Intent();

            setResult(RESULT_CANCELED, intent);
            this.finish();
        }
        else if (view.getId() == R.id.button_add) {
            Double altura = Double.parseDouble(this.mViewHolder.form_wall_altura.getText().toString());
            Double largura = Double.parseDouble(this.mViewHolder.form_wall_largura.getText().toString());
            Integer portas = Integer.parseInt(this.mViewHolder.forma_wall_portas.getText().toString());
            Integer janelas = Integer.parseInt(this.mViewHolder.form_wall_janelas.getText().toString());


            this.mViewHolder.parede = new Wall(altura, largura, portas, janelas);

            String paredeAtual = data.getNumWalls();

            Gson gson = new Gson();

            data.storeString("Parede_" + paredeAtual, gson.toJson(this.mViewHolder.parede));

            Intent intent = new Intent();

            setResult(RESULT_OK, intent);
            this.finish();
        }
    }

    public static class ViewHolder {
        Button button_back;
        Button button_add;
        EditText form_wall_altura;
        EditText form_wall_largura;
        EditText forma_wall_portas;
        EditText form_wall_janelas;

        Wall parede;
    }
}