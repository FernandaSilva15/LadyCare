package com.example.lady_iza_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class EnderecosFragment extends Fragment {

    private static final String ARG_TIPO = "tipo";

    public static EnderecosFragment newInstance(String tipo) {
        EnderecosFragment fragment = new EnderecosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TIPO, tipo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_enderecos_fragment, container, false);


        // Configura o botão de voltar para remover o fragmento da pilha de navegação
        ImageButton Voltar = view.findViewById(R.id.Voltar);
        Voltar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                // Retornar para a Activity
                Intent intent = new Intent(getActivity(), Opcoes_Locais.class);
                startActivity(intent); getActivity().finish();
            }
        });


        // Verificar se os argumentos não são nulos
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey(ARG_TIPO)) {
            throw new IllegalStateException("O argumento 'localID' é necessário para este fragmento");
        }

        // Obter o tipo de local selecionado
        String tipo = arguments.getString(ARG_TIPO);


        // Configurar os elementos da interface com base no tipo de local
        TextView textTitulo = view.findViewById(R.id.textTitulo);
        TextView text1 = view.findViewById(R.id.endereco1);
        TextView text2 = view.findViewById(R.id.endereco2);
        TextView text3 = view.findViewById(R.id.endereco3);
        TextView text4 = view.findViewById(R.id.endereco4);

        // Configurar a exibição dos endereços com base no tipo
        if ("maternidades".equalsIgnoreCase(tipo)) {
            textTitulo.setText("Maternidades e Hospitais Públicos");
            text1.setText("Maternidade Ana Braga\nEndereço: Av. Cosme Ferreira, s/n, São José I Manaus - AM, 69083-000");
            text1.setOnClickListener(v -> abrirDetalhes("Maternidades e Hospitais Públicos", "Maternidade Ana Braga\\nEndereço: Av. Cosme Ferreira, s/n, São José I Manaus - AM, 69083-000", R.drawable.imagem_maternidade));

            text2.setText("Maternidade Azilda Marreiro\nEndereço: R. Carlos Maurício, 42 - Compensa, Manaus - AM, 69035-120");
            text3.setText("Hospital e Maternidade Adventista de Manaus\nEndereço: R. Belo Horizonte, 188 - Adrianópolis, Manaus - AM, 69057-010");
            text4.setText("Hospital Geral Dr. Geraldo da Rocha\nEndereço: Av. Governador José Lindoso, 420 - Alvorada, Manaus - AM, 69043-000");

            //text2.setOnClickListener(v -> abrirDetalhes("Maternidade Azilda Marreiro", R.drawable.imagem_maternidade_azilda));
            //text3.setOnClickListener(v -> abrirDetalhes("Hospital e Maternidade Adventista de Manaus", R.drawable.imagem_hospital_adventista));
            //text4.setOnClickListener(v -> abrirDetalhes("Hospital Geral Dr. Geraldo da Rocha", R.drawable.imagem_hospital_geral));

        }  else if ("ubs".equalsIgnoreCase(tipo)) {
            textTitulo.setText("Unidades Básicas de Saúde");
            text1.setText("UBS Santo Agostinho\nEndereço: Av. Santo Agostinho, 40 - Centro, Manaus - AM, 69005-000");
            text1.setOnClickListener(v -> abrirDetalhes("UBS Santo Agostinho", "Endereço: Av. Santo Agostinho, 40 - Centro, Manaus - AM, 69005-000", R.drawable.img_ubs));

            text2.setText("UBS Parque das Nações\nEndereço: R. Nações Unidas, 150 - Cidade Nova, Manaus - AM, 69090-010");
            text3.setText("UBS Saúde e Vida\nEndereço: R. Vida Longa, 45 - Compensa, Manaus - AM, 69095-020");
            text4.setText("UBS Alegria de Viver\nEndereço: Av. Alegria, 12 - Tarumã, Manaus - AM, 69085-030");

           // text2.setOnClickListener(v -> abrirDetalhes("UBS Parque das Nações", R.drawable.imagem_ubs_parque_das_nacoes));
            //text3.setOnClickListener(v -> abrirDetalhes("UBS Saúde e Vida", R.drawable.imagem_ubs_saude_vida));
            //text4.setOnClickListener(v -> abrirDetalhes("UBS Alegria de Viver", R.drawable.imagem_ubs_alegria_de_viver));


        }else if ("clinicas".equalsIgnoreCase(tipo)) {
            textTitulo.setText("Clínicas e Centros de Saúde");
            text1.setText("Clínica Médica Central\nEndereço: R. Centro Médico, 50 - Centro, Manaus - AM, 69000-000");
            text1.setOnClickListener(v -> abrirDetalhes("Clínica Médica Central", "Endereço: R. Centro Médico, 50 - Centro, Manaus - AM, 69000-000", R.drawable.img_clinica));


            text2.setText("Clínica de Saúde Familiar\nEndereço: Av. Saúde, 100 - Parque 10, Manaus - AM, 69050-010");
            text3.setText("Clínica Bem-Estar\nEndereço: Rua Alegria, 23 - Aleixo, Manaus - AM, 69060-020");
            text4.setText("Clínica do Trabalhador\nEndereço: Av. Independência, 300 - São Francisco, Manaus - AM, 69080-030");

           // text2.setOnClickListener(v -> abrirDetalhes("Clínica de Saúde Familiar", R.drawable.imagem_clinica_saude_familiar));
            //text3.setOnClickListener(v -> abrirDetalhes("Clínica Bem-Estar", R.drawable.imagem_clinica_bem_estar));
            //text4.setOnClickListener(v -> abrirDetalhes("Clínica do Trabalhador", R.drawable.imagem_clinica_do_trabalhador));
        }



        return view;
    }

    private void abrirDetalhes(String titulo, String endereco, int imagem) {
        // Cria uma instância do fragmento de detalhes e passa os argumentos
        DetalhesEnderecoFragment detalhesFragment = DetalhesEnderecoFragment.newInstance(titulo, endereco, imagem);

        // Substitui o fragmento atual pelo fragmento de detalhes
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, detalhesFragment) // Certifique-se de que R.id.fragment_container seja o ID correto do contêiner
                .addToBackStack(null) // Permite retornar ao fragmento anterior
                .commit();

    }
}
