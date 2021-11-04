package com.example.dadm_prac1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pregunta_Texto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pregunta_Texto extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String preguntas[] = new String[6];
    private String respuestas1[] = new String[6];
    private String respuestas2[] = new String[6];
    private String respuestas3[] = new String[6];
    private String respuestas4[] = new String[6];
    private int soluciones[] = new int[6];

    int solucion;

    TextView pregunta;
    ImageView planks;
    RadioButton respuesta1, respuesta2, respuesta3, respuesta4;
    RadioGroup respuestas;

    public Pregunta_Texto() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pregunta_Texto.
     */
    // TODO: Rename and change types and number of parameters
    public static Pregunta_Texto newInstance(String param1, String param2) {
        Pregunta_Texto fragment = new Pregunta_Texto();
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
        View view = inflater.inflate(R.layout.fragment_pregunta__texto, container, false);
        Activity_Quiz quiz = (Activity_Quiz) getActivity();
        pregunta = (TextView) view.findViewById(R.id.TV_Pregunta);
        respuestas = (RadioGroup) view.findViewById(R.id.respuestas);
        respuesta1 = (RadioButton) view.findViewById(R.id.respuesta1);
        respuesta2 = (RadioButton) view.findViewById(R.id.respuesta2);
        respuesta3 = (RadioButton) view.findViewById(R.id.respuesta3);
        respuesta4 = (RadioButton) view.findViewById(R.id.respuesta4);
        planks = (ImageView) view.findViewById(R.id.planks);

        int i = 0;
        for (QuestionsData question:quiz.textQuestionsList)
        {
            preguntas[i] = question.getQuestion().trim();
            respuestas1[i] = question.getAnswer1().trim();
            respuestas2[i] = question.getAnswer2().trim();
            respuestas3[i] = question.getAnswer3().trim();
            respuestas4[i] = question.getAnswer4().trim();
            switch (question.getCorrectAnswers()){
                case 0001:
                    soluciones[i] = 3;
                    break;
                case 0010:
                    soluciones[i] = 2;
                    break;
                case 0100:
                    soluciones[i] = 1;
                    break;
                case 1000:
                    soluciones[i] = 0;
                    break;
                default:
                    break;
            }
            i++;
        }

        int preg = quiz.getNumPreg();
        solucion = soluciones[preg];

        if(preg != 2){
            planks.setVisibility(View.GONE);
        } else {
            planks.setVisibility(View.VISIBLE);
        }

        pregunta.setText(preguntas[preg]);
        respuesta1.setText(respuestas1[preg]);
        respuesta2.setText(respuestas2[preg]);
        respuesta3.setText(respuestas3[preg]);
        respuesta4.setText(respuestas4[preg]);

        respuestas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int buttonChecked) {
                RadioButton checked = radioGroup.findViewById(buttonChecked);
                int checkedID = radioGroup.indexOfChild(checked);
                quiz.setAcierto(solucion==checkedID);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}