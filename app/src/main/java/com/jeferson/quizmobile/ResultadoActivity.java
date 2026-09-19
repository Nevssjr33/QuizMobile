package com.jeferson.quizmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvResultadoNome, tvResultadoAcertos, tvResultadoNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultadoNome = findViewById(R.id.tvResultadoNome);
        tvResultadoAcertos = findViewById(R.id.tvResultadoAcertos);
        tvResultadoNota = findViewById(R.id.tvResultadoNota);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("NOME");
        int acertos = intent.getIntExtra("ACERTOS", 0);
        int nota = intent.getIntExtra("NOTA", 0);

        tvResultadoNome.setText("Aluno: " + nome);
        tvResultadoAcertos.setText("Quantidade de acertos: " + acertos + " de 2");
        tvResultadoNota.setText("Nota obtida: " + nota + " pontos");
    }
}