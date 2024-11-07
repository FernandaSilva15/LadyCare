package com.example.lady_iza_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetalhesEnderecoFragment extends Fragment {

    private static final String ARG_ENDERECO = "endereco";
    private static final String ARG_IMAGEM = "imagem";
    private static final String ARG_TITULO = "titulo";


    public static DetalhesEnderecoFragment newInstance(String titulo, String endereco, int imagem) {
        DetalhesEnderecoFragment fragment = new DetalhesEnderecoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ENDERECO, endereco);
        args.putInt(ARG_IMAGEM, imagem);
        args.putString(ARG_TITULO, titulo);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_detalhes_endereco_fragment, container, false);



        // Recebe os argumentos e configura os elementos da interface
        Bundle arguments = getArguments();
        if (arguments!= null) {
            String titulo = arguments.getString(ARG_TITULO);
            String endereco = arguments.getString(ARG_ENDERECO);
            int imagem = arguments.getInt(ARG_IMAGEM);

            TextView textTitulo = view.findViewById(R.id.TituloDetalhe);
            TextView textViewEndereco = view.findViewById(R.id.textDetalhes);
            ImageView imageViewEndereco = view.findViewById(R.id.imageView);

            textTitulo.setText(titulo);
            textViewEndereco.setText(endereco);
            imageViewEndereco.setImageResource(imagem);
        }

        // Configura o botão de voltar
        ImageButton buttonVoltar = view.findViewById(R.id.ButtonVoltar);
        buttonVoltar.setOnClickListener(v -> {
            // Volta para o fragmento anterior na pilha de navegação
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        return view;
    }
}