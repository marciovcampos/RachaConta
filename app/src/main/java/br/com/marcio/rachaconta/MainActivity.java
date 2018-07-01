package br.com.marcio.rachaconta;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // DECLARACAO DAS PROPRIEDADES DA TELA
    private int seekBarProgress = 10;
    private SeekBar seekBar;
    private TextView txtSeekBar, txtResultado;
    private EditText edtNumeroPessoasNaoBebem, edtNumeroPessoasBebem;
    private EditText edtValorTotalBebidasAcoolicas, edtValorTotalBebidasNaoAcoolicas, edtValorTotalComida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INICIALIZAR COMPONENTES  VISUAIS
        Inicializar();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                txtSeekBar.setText(seekBarProgress*10 + "%");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });

    }

    // PROCEDIMENTO PARA VALIDAR OS CAMPOS STRINGS
    public Boolean validaCampo(String campo){
        if(campo == null  || campo.equals(""))
            return false;
        return true;
    }

    // PROCEDIMENTO PARA IMPRIMIR UMA MENSAGEM NA TELA
    public void print(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


    // PROCEDIMENTO PARA INICIALIZAR OS  OBJETOS VISUAIS
    private void Inicializar(){
        seekBar = findViewById(R.id.seekBarId);
        txtSeekBar = findViewById(R.id.txtSeekBarId);

        edtNumeroPessoasNaoBebem = findViewById(R.id.edtNumeroPessoasNaoBebemId);
        edtNumeroPessoasBebem = findViewById(R.id.edtNumeroPessoasBebemId);
        edtValorTotalBebidasAcoolicas = findViewById(R.id.edtValorTotalBebidasAcoolicasId);
        edtValorTotalBebidasNaoAcoolicas = findViewById(R.id.edtValorTotalBebidasNaoAcoolicasId);
        edtValorTotalComida = findViewById(R.id.edtValorTotalComidaId);
        txtResultado = findViewById(R.id.txtResultadoId);

    }

    // PROCEDIMENTO PARA VALIDAR OS CAMPOS STRINGS
    public Boolean ValidaCampo(String campo){
        if(campo == null || campo.equals(""))
            return false;
        return true;
    }

    // PROCEDIMENTO PARA EXECUTAR A ACAO DO BOTAO
    public void CalcularConta(View view){
        if(ValidaCampos()){

            int NumeroPessoasNaoBebem = Integer.parseInt(edtNumeroPessoasNaoBebem.getText().toString());
            int NumeroPessoasBebem = Integer.parseInt(edtNumeroPessoasBebem.getText().toString());
            double ValorTotalBebidasAcoolicas = Double.parseDouble(edtValorTotalBebidasAcoolicas.getText().toString());
            double ValorTotalBebidasNaoAcoolicas = Double.parseDouble(edtValorTotalBebidasNaoAcoolicas.getText().toString());
            double ValorTotalComida = Double.parseDouble(edtValorTotalComida.getText().toString());


            double ContribucaoComida =  ValorTotalComida / (NumeroPessoasBebem+NumeroPessoasNaoBebem);
            double ContribuicaoBebidasAcoolicas = ValorTotalBebidasAcoolicas / NumeroPessoasBebem;
            double ContribuicaoBebidasNaoAcoolicas = ValorTotalBebidasNaoAcoolicas / NumeroPessoasNaoBebem;

            double PorcentagemGarcom = 1 + (((double)(seekBarProgress))/100);

            double ValorTotal = ValorTotalComida + ValorTotalBebidasNaoAcoolicas + ValorTotalBebidasAcoolicas;
            double ValorGarcom = (ValorTotal*PorcentagemGarcom) - ValorTotal;
            double ValorIndividialComBebidaAcoolica = (ContribucaoComida + ContribuicaoBebidasAcoolicas)*PorcentagemGarcom;
            double ValorIndividualBebidaNaoAcoolica = (ContribucaoComida + ContribuicaoBebidasNaoAcoolicas)*PorcentagemGarcom;

            String resultado = "\n";
            resultado += "VALOR TOTAL \n R$ "+ String.format("%02.2f", ValorTotal)+ "\n\n";
            resultado += "VALOR GARÇOM \n R$ "+ String.format("%02.2f", ValorGarcom)+ "\n\n";
            resultado += "VALOR TOTAL COM GARÇOM \n R$ "+ String.format("%02.2f", (ValorTotal*PorcentagemGarcom))+ "\n\n";
            resultado += "VALOR POR PESSOA QUE NÃO BEBEM \n "+ NumeroPessoasNaoBebem +" X R$ "+ String.format("%02.2f", ValorIndividualBebidaNaoAcoolica)+ "\n\n";
            resultado += "VALOR POR PESSOA QUE BEBE \n "+ NumeroPessoasBebem +" X R$ "+ String.format("%02.2f", ValorIndividialComBebidaAcoolica)+ "\n";

            txtResultado.setText(resultado);

        }else{
            Toast.makeText(getApplicationContext(), "Preencha os valores!", Toast.LENGTH_LONG).show();
        }
    }

    //PROCEDIMENTO QUE VALIDA TODOS OS CAMPOS DA TELA
    public Boolean ValidaCampos(){

        if(ValidaCampo(edtNumeroPessoasNaoBebem.getText().toString())
                && ValidaCampo(edtNumeroPessoasBebem.getText().toString())
                && ValidaCampo(edtValorTotalBebidasAcoolicas.getText().toString())
                && ValidaCampo(edtValorTotalBebidasNaoAcoolicas.getText().toString())
                && ValidaCampo(edtValorTotalComida.getText().toString())
                && ValidaCampo(edtValorTotalBebidasNaoAcoolicas.getText().toString())
                ){
            return true;
        }

        return false;

    }





}
