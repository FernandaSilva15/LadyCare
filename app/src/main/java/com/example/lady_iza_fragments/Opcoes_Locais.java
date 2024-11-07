package com.example.lady_iza_fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Opcoes_Locais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_locais);

        // Encontre os TextViews
        TextView text1 = findViewById(R.id.textView2);
        TextView text2 = findViewById(R.id.textView3);
        TextView text3 = findViewById(R.id.textView4);

        // Defina os ouvintes de clique para os TextViews
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ir_endereco(v, "maternidades");
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ir_endereco(v,"ubs");
            }
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ir_endereco(v, "clinicas");
            }
        });
    }

    public void ir_endereco(View view, String titulo) {
        // Tornar o container de fragmento visível e o layout de opções invisível
        findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
        findViewById(R.id.constraintopcoes).setVisibility(View.INVISIBLE);

        // Criar uma nova instância do fragmento EnderecosFragment com o tipo recebido
        EnderecosFragment fragment = EnderecosFragment.newInstance(titulo);

        // Iniciar a transação de fragmentos
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null); // Para permitir voltar
        transaction.commit();
    }













}
