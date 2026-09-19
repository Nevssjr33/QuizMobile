package com.jeferson.quizmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private RadioGroup rgQuestao1, rgQuestao2;
    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.etNome);
        rgQuestao1 = findViewById(R.id.rgQuestao1);
        rgQuestao2 = findViewById(R.id.rgQuestao2);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnFinalizar.setOnClickListener(v -> validarEProcessar());
    }

    private void validarEProcessar() {
        String nome = etNome.getText().toString().trim();
        int q1Id = rgQuestao1.getCheckedRadioButtonId();
        int q2Id = rgQuestao2.getCheckedRadioButtonId();

        if (nome.isEmpty()) {
            Toast.makeText(this, "Por favor, informe seu nome.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (q1Id == -1) {
            Toast.makeText(this, "Por favor, responda à Questão 1.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (q2Id == -1) {
            Toast.makeText(this, "Por favor, responda à Questão 2.", Toast.LENGTH_SHORT).show();
            return;
        }

        int acertos = 0;
        if (q1Id == R.id.q1C) { // Alternativa C (Activity)
            acertos++;
        }
        if (q2Id == R.id.q2C) { // Alternativa C (editText.getText().toString())
            acertos++;
        }

        int nota = 0;
        if (acertos == 2) {
            nota = 10;
        } else if (acertos == 1) {
            nota = 5;
        }

        Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
        intent.putExtra("NOME", nome);
        intent.putExtra("ACERTOS", acertos);
        intent.putExtra("NOTA", nota);
        startActivity(intent);
    }
}