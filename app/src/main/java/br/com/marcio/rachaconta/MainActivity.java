package br.com.marcio.rachaconta;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //DECLARANDO AS PROPRIEDADES VISUAIS
    private EditText edtValor;
    private EditText edtNumeroPessoas;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Realizando a refencia aos objetos visuais
//        edtValor = findViewById(R.id.edtValorId);
//        edtNumeroPessoas = findViewById(R.id.edtNumeroPessoasId);
//        txtResultado = findViewById(R.id.txtResultadoId);

    }
}
