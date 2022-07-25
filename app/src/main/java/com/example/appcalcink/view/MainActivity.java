package com.example.appcalcink.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcalcink.R;
import com.example.appcalcink.data.Data;
import com.example.appcalcink.model.Wall;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();
    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new Data(this);
        data.setNumWalls("0");

        this.mViewHolder.wall1_altura = findViewById(R.id.wall1_altura);
        this.mViewHolder.wall1_largura = findViewById(R.id.wall1_largura);

        this.mViewHolder.button_add = findViewById(R.id.button_add);
        this.mViewHolder.layout_wall1 = findViewById(R.id.layout_wall1);
        this.mViewHolder.wall1_info = findViewById(R.id.wall1_info);
        this.mViewHolder.layout_empty = findViewById(R.id.layout_empty);
        this.mViewHolder.layout_room = findViewById(R.id.layout_room);

        this.mViewHolder.button_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_add) {
            Intent intent = new Intent(this, Form.class);
            startActivityForResult(intent, 37);
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 37) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "cancelado", Toast.LENGTH_SHORT).show();
            }
            else {
                Gson gson = new Gson();

                String wallString = this.data.getStoredString("Parede_0");
                Wall parede1 = gson.fromJson(wallString, Wall.class);

                this.mViewHolder.wall1_altura.setText(String.valueOf(parede1.getAltura()));
                this.mViewHolder.wall1_largura.setText(String.valueOf(parede1.getLargura()));

//                this.mViewHolder.wall1_portas.setText(parede1.getPortas().toString());
//                this.mViewHolder.wall1_janelas.setText(parede1.getJanelas().toString());

                this.mViewHolder.layout_empty.setVisibility(View.GONE);
                this.mViewHolder.layout_room.setVisibility(View.VISIBLE);
                this.mViewHolder.wall1_info.setVisibility(View.VISIBLE);
                this.mViewHolder.layout_wall1.setVisibility(View.VISIBLE);
            }
        }
    }

    public static class ViewHolder {
        // Botões
        Button button_add;
        Button button_calc;

        // Empty
        RelativeLayout layout_empty;

        // Room
        RelativeLayout layout_room;

        // Parede 1
        RelativeLayout layout_wall1;
        RelativeLayout wall1_header;
        RelativeLayout wall1_info;
        TextView wall1_portas;
        TextView wall1_janelas;
        TextView wall1_altura;
        TextView wall1_largura;

        // Parede 2
        RelativeLayout layout_wall2;
        RelativeLayout wall2_header;
        RelativeLayout wall2_info;
        TextView wall2_portas;
        TextView wall2_janelas;
        TextView wall2_altura;
        TextView wall2_largura;

        // Parede 3
        RelativeLayout layout_wall3;
        RelativeLayout wall3_header;
        RelativeLayout wall3_info;
        TextView wall3_portas;
        TextView wall3_janelas;
        TextView wall3_altura;
        TextView wall3_largura;


        // Parede 4
        RelativeLayout layout_wall4;
        RelativeLayout wall4_header;
        RelativeLayout wall4_info;
        TextView wall4_portas;
        TextView wall4_janelas;
        TextView wall4_altura;
        TextView wall4_largura;
    }
}