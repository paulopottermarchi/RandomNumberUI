package org.meicode.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity  {
    int i = 0;
    int t = 5;
    boolean restart = false;
    Random gerador = new Random();
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtWelcome = findViewById(R.id.txtWelcome);
        EditText edtName = findViewById(R.id.edtName);
        EditText edtNumber = findViewById(R.id.edtNumber);
        Button btnNo = (Button) findViewById(R.id.btnNo);
        btnNo.setVisibility(View.INVISIBLE);
        edtName.setVisibility(View.INVISIBLE);
        edtNumber.setVisibility(View.GONE);
        int random = gerador.nextInt(20);
        Button btn = (Button) findViewById(R.id.btnOk);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (i == 0) {
                        txtWelcome.setText("Qual o seu nome ?");
                        edtName.setVisibility(View.VISIBLE);
                        edtNumber.setVisibility(View.GONE);
                        i++;
                    } else if (i == 1) {
                        txtWelcome.setText("Oi " + edtName.getText().toString() + ", voce gostaria de iniciar o nosso jogo de adivinhação?");
                        btnNo.setVisibility(View.VISIBLE);
                        btnNo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i = 0;
                                btnNo.setVisibility(View.INVISIBLE);
                            }
                        });
                        edtName.setVisibility(View.GONE);
                        i++;
                    } else if (i == 2) {
                        txtWelcome.setText("Vou pensar em um numero de 1 a 20. Tente adivinhar ou você irá morrer!");
                        btnNo.setVisibility(View.INVISIBLE);
                        edtNumber.setVisibility(View.VISIBLE);
                        i++;
                    } else if (i == 3) {
                        int n = Integer.parseInt(edtNumber.getText().toString());
                        if (random == n) {
                            txtWelcome.setText("Parabens! Voce acertou e sobreviveu");
                            edtNumber.setVisibility(View.GONE);
                            t = 5;
                            i = 0;
                        } else {
                            t--;
                            String answer = (n > random) ? "O numero é menor" : "O numero é maior";
                            Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
                            txtWelcome.setText("Voce errou !! HAHAHA, voce tem mais " + t + " tentativas");
                        }
                        if (t == 0) {
                            txtWelcome.setText("acabou as suas chances, nos iremos ate a sua casa quando voce estiver dormindo");
                            t = 5;
                            i = 0;
                        }
                    }
                } catch (Exception e) {
                    txtWelcome.setText("Por favor insira um numero!");
                    i = 2;
                }
            }
        });


    }





    /*public void onBtnClick(View view) {

        TextView txtWelcome = findViewById(R.id.txtWelcome);
        EditText edtName = findViewById(R.id.edtName);
            txtWelcome.setText("Qual o seu nome ?");
            edtName.setVisibility(View.VISIBLE);
        txtWelcome.setText("Oi " + edtName.getText().toString() + ", voce gostaria de iniciar ?");
    }
    */

}