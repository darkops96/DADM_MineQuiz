package com.example.dadm_prac1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pregunta_Imagenes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pregunta_Imagenes extends Fragment {

    private CheckBox respuesta1, respuesta2, respuesta3;
    private TextView pregunta;
    private ImageView imagen1, imagen2, imagen3;
    private boolean[] respCorrecta, check;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private int numPregunta;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Pregunta_Imagenes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pregunta_Imagenes.
     */
    // TODO: Rename and change types and number of parameters
    public static Pregunta_Imagenes newInstance(String param1, String param2) {
        Pregunta_Imagenes fragment = new Pregunta_Imagenes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregunta__imagenes, container, false);
        Activity_Quiz quiz = (Activity_Quiz) getActivity();

        pregunta = (TextView) view.findViewById(R.id.TV_Pregunta);

        respuesta1 = (CheckBox) view.findViewById(R.id.checkBox1);
        respuesta2 = (CheckBox) view.findViewById(R.id.checkBox2);
        respuesta3 = (CheckBox) view.findViewById(R.id.checkBox3);

        imagen1=(ImageView) view.findViewById(R.id.imageView);
        imagen2=(ImageView) view.findViewById(R.id.imageView2);
        imagen3=(ImageView) view.findViewById(R.id.imageView3);

        if(quiz.getNumPreg() == 0){
            pregunta.setText("¿Que criaturas fueron\n eliminadas en 2021?");
            String idAllay =  Integer.toString(R.drawable.allay);
            imagen1.setImageResource(Integer.parseInt(idAllay));
            imagen2.setImageResource(R.drawable.glare);
            imagen3.setImageResource(R.drawable.golemcobre);
            respCorrecta = new boolean[]{false, true, true};
        } else if(quiz.getNumPreg() == 1){
            pregunta.setText("¿Que picos pueden picar\n la bedrock?");
            imagen1.setImageResource(R.drawable.picomadera);
            imagen2.setImageResource(R.drawable.picodiamante);
            imagen3.setImageResource(R.drawable.picohierro);
            respCorrecta = new boolean[]{false, false, false};
        }else if(quiz.getNumPreg() == 2){
            pregunta.setText("¿En que bloque crece\n la caña de azucar?");
            imagen1.setImageResource(R.drawable.sand);
            imagen2.setImageResource(R.drawable.soulsand);
            imagen3.setImageResource(R.drawable.grass);
            respCorrecta = new boolean[]{true, false, false};
        } else {
            pregunta.setText("¿Con que se puede\ncurar a un lobo\nen Minecraft Vanilla?");
            imagen1.setImageResource(R.drawable.ternera);
            imagen2.setImageResource(R.drawable.pezglobo);
            imagen3.setImageResource(R.drawable.cerdo);
            respCorrecta = new boolean[]{true, false, true};
        }

        check = new boolean[]{false, false, false};
        checkAnswer();

        respuesta1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    check[0] = true;
                } else{
                    check[0] = false;
                }
                checkAnswer();
            }
        });

        respuesta2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    check[1] = true;
                } else{
                    check[1] = false;
                }
                checkAnswer();
            }
        });

        respuesta3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    check[2] = true;
                } else{
                    check[2] = false;
                }
                checkAnswer();
            }
        });

        return view;
    }

    private void checkAnswer(){
        Activity_Quiz quiz = (Activity_Quiz) getActivity();
        boolean checkPreg = true;
        for (int i = 0; i < respCorrecta.length; i++){
            if(respCorrecta[i] != check[i]) {
                checkPreg = false;
                break;
            }
        }
        quiz.setAcierto(checkPreg);
    }
}