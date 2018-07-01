package br.com.marcio.rachaconta;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //DECLARANDO AS PROPRIEDADES VISUAIS
    private EditText edtValor;
    private EditText edtNumeroPessoas;
    private TextView txtResultado;
    private SeekBar seekBar;
    private TextView textPorcetagemAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBarPorcetagemGarcomId);
        textPorcetagemAtual = (TextView) findViewById(R.id.textPorcetagemAtualSeekBar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                textPorcetagemAtual.setText(seekBarProgress*10 + "%");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                textPorcetagemAtual.setText(seekBarProgress*10 + "%");
            }

        });


        //Realizando a refencia aos objetos visuais
//        edtValor = findViewById(R.id.edtValorId);
//        edtNumeroPessoas = findViewById(R.id.edtNumeroPessoasId);
//        txtResultado = findViewById(R.id.txtResultadoId);



    }
}
