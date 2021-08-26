package com.example.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //Objetos de biding com as views
    private EditText nomeEt;
    private EditText emailEt;
    private CheckBox checadoCb;
    private EditText telefoneEt;
    private RadioGroup telefoneRb;
    private RadioButton comercialRb;
    private Spinner celularSp;
    private LinearLayout celularLl;
    private EditText dataNascimentoEt;
    private Spinner formacaoSp;
    private EditText vagasEt;
    private EditText fundamentalMedioLl;
    private EditText graduacaoEspecializacaoACLl;
    private EditText graduacaoEspecializacaoILl;
    private EditText mestradoDoutoradoACLl;
    private EditText mestradoDoutoradoILl;
    private EditText mestradoDoutoradoTMLl;
    private EditText mestradoDoutoradoOLl;
    private EditText numeroCelularEt;

    private ArrayList<String> formacaoList;
    private ArrayList<String> celularList;

    private String celular = "";
    private String formacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        formacaoList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.formacao)));
        ArrayAdapter<String> formacaoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, formacaoList);
        formacaoSp.setAdapter(formacaoAdapter);

        formacaoSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long id) {
                if (formacaoList.get(posicao).equals("Fundamental") || formacaoList.get(posicao).equals("Médio")) {
                    fundamentalMedioLl.setVisibility(View.VISIBLE);
                    graduacaoEspecializacaoACLl.setVisibility(View.GONE);
                    graduacaoEspecializacaoILl.setVisibility(View.GONE);
                    mestradoDoutoradoACLl.setVisibility(View.GONE);
                    mestradoDoutoradoILl.setVisibility(View.GONE);
                    mestradoDoutoradoTMLl.setVisibility(View.GONE);
                    mestradoDoutoradoOLl.setVisibility(View.GONE);
                }
                if (formacaoList.get(posicao).equals("Graduação") || formacaoList.get(posicao).equals("Especialização")) {
                    fundamentalMedioLl.setVisibility(View.GONE);
                    graduacaoEspecializacaoACLl.setVisibility(View.VISIBLE);
                    graduacaoEspecializacaoILl.setVisibility(View.VISIBLE);
                    mestradoDoutoradoACLl.setVisibility(View.GONE);
                    mestradoDoutoradoILl.setVisibility(View.GONE);
                    mestradoDoutoradoTMLl.setVisibility(View.GONE);
                    mestradoDoutoradoOLl.setVisibility(View.GONE);
                }
                if (formacaoList.get(posicao).equals("Mestrado") || formacaoList.get(posicao).equals("Doutorado")) {
                    fundamentalMedioLl.setVisibility(View.GONE);
                    graduacaoEspecializacaoACLl.setVisibility(View.GONE);
                    graduacaoEspecializacaoILl.setVisibility(View.GONE);
                    mestradoDoutoradoACLl.setVisibility(View.VISIBLE);
                    mestradoDoutoradoILl.setVisibility(View.VISIBLE);
                    mestradoDoutoradoTMLl.setVisibility(View.VISIBLE);
                    mestradoDoutoradoOLl.setVisibility(View.VISIBLE);
                } else {
                    //formacaoLl.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        celularList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.celular)));
        ArrayAdapter<String> celularAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, celularList);
        celularSp.setAdapter(celularAdapter);

        celularSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long id) {
                String celular = ((TextView) view).getText().toString();
                if (celularList.get(posicao).equals("Sim")) {
                    celularLl.setVisibility(View.VISIBLE);
                } else {
                    celularLl.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onClick(View view) {
        StringBuilder sb = new StringBuilder();

        sb.append(nomeEt.getText().toString());
        sb.append("\n");
        sb.append(emailEt.getText().toString());
        sb.append("\n");
        sb.append(checadoCb.isChecked() ? "deseja" : "não deseja");
        sb.append("\n");
        sb.append(telefoneEt.getText().toString());
        sb.append("\n");
        sb.append(comercialRb.isChecked() ? "residencial" : "comercial");
        sb.append("\n");
        sb.append(dataNascimentoEt.getText().toString());
        sb.append("\n");
        sb.append(vagasEt.getText().toString());
        sb.append("\n");
        String celular = ((TextView) celularSp.getSelectedView()).getText().toString();
        sb.append(celular);
        sb.append("\n");
        if(numeroCelularEt.getText().toString() != ""){
            sb.append(numeroCelularEt.getText().toString());
            sb.append("\n");
        }
        String formacao = ((TextView) formacaoSp.getSelectedView()).getText().toString();
        sb.append(formacao);
        sb.append("\n");
        if(fundamentalMedioLl.getText().toString() != ""){
            sb.append(fundamentalMedioLl.getText().toString());
            sb.append("\n");
        } else if (graduacaoEspecializacaoACLl.getText().toString() != ""){
            sb.append(graduacaoEspecializacaoACLl.getText().toString());
            sb.append("\n");
        } else if (graduacaoEspecializacaoILl.getText().toString() != ""){
            sb.append(graduacaoEspecializacaoILl.getText().toString());
            sb.append("\n");
        } else if (mestradoDoutoradoACLl.getText().toString() != ""){
            sb.append(mestradoDoutoradoACLl.getText().toString());
            sb.append("\n");
        } else if (mestradoDoutoradoILl.getText().toString() != ""){
            sb.append(mestradoDoutoradoILl.getText().toString());
            sb.append("\n");
        } else if (mestradoDoutoradoTMLl.getText().toString() != ""){
            sb.append(mestradoDoutoradoTMLl.getText().toString());
            sb.append("\n");
        } else if (mestradoDoutoradoOLl.getText().toString() != ""){
            sb.append(mestradoDoutoradoOLl.getText().toString());
            sb.append("\n");
        } else {
            sb.append("\n");
        }
        sb.append(vagasEt.getText().toString());

        if (view.getId() == R.id.salvarBt) {
            Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
        } else {
            if (view.getId() == R.id.limparBt) {
                nomeEt.setText("");
                emailEt.setText("");
                checadoCb.setChecked(false);
                telefoneEt.setText("");
                telefoneRb.setActivated(false);
                numeroCelularEt.setText("");
                dataNascimentoEt.setText("");
                fundamentalMedioLl.setText("");
                graduacaoEspecializacaoILl.setText("");
                mestradoDoutoradoACLl.setText("");
                mestradoDoutoradoILl.setText("");
                mestradoDoutoradoTMLl.setText("");
                mestradoDoutoradoOLl.setText("");
                vagasEt.setText("");
            }
        }
    }

    private void bindViews(){
        nomeEt = findViewById(R.id.nomeEt);
        emailEt = findViewById(R.id.emailEt);
        checadoCb = findViewById(R.id.checadoCb);
        telefoneEt = findViewById(R.id.telefoneEt);
        telefoneRb = findViewById(R.id.telefoneRb);
        comercialRb = findViewById(R.id.comercialRb);
        celularSp = findViewById(R.id.celularSp);
        celularLl = findViewById(R.id.celularLl);
        dataNascimentoEt = findViewById(R.id.dataNascimentoEt);
        formacaoSp = findViewById(R.id.formacaoSp);
        vagasEt = findViewById(R.id.vagasEt);
        fundamentalMedioLl = findViewById(R.id.fundamentalMedioLl);
        graduacaoEspecializacaoACLl = findViewById(R.id.graduacaoEspecializacaoACLl);
        graduacaoEspecializacaoILl = findViewById(R.id.graduacaoEspecializacaoILl);
        mestradoDoutoradoACLl = findViewById(R.id.mestradoDoutoradoACLl);
        mestradoDoutoradoILl = findViewById(R.id.mestradoDoutoradoILl);
        mestradoDoutoradoTMLl = findViewById(R.id.mestradoDoutoradoTMLl);
        mestradoDoutoradoOLl = findViewById(R.id.mestradoDoutoradoOLl);
        numeroCelularEt = findViewById(R.id.numeroCelularEt);
    }
}