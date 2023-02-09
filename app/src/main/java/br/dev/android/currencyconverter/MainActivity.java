package br.dev.android.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.inputValue = findViewById(R.id.inputValor);
        this.mViewHolder.dolarResultText = findViewById(R.id.resultInDolar);
        this.mViewHolder.euroResultText = findViewById(R.id.resultInEuro);
        this.mViewHolder.calculaterButton = findViewById(R.id.btnCalcular);

        this.mViewHolder.calculaterButton.setOnClickListener(this);

        this.cleanValues();

    }


    //Ações de clique
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalcular) {
            //botão quem chamou
            String value = this.mViewHolder.inputValue.getText().toString();
            if ("".equals(value)) {
                //string vazia - mensagem de erro
                Toast.makeText(this, this.getString(R.string.error_sem_valor), Toast.LENGTH_SHORT).show();
            } else {
                //sucesso
                Double realValue = Double.valueOf(value);
                this.calculater(realValue);
            }

        }

    }

    private void cleanValues() {
        this.mViewHolder.dolarResultText.setText("");
        this.mViewHolder.euroResultText.setText("");
    }

    private void calculater(Double value) {
        Double dolar = 5.20;
        Double euro = 5.58;
        Double dolarResult = (value / dolar);
        Double euroResult = (value / euro);
        this.mViewHolder.dolarResultText.setText(String.format("%.2f",dolarResult));
        this.mViewHolder.euroResultText.setText(String.format("%.2f",euroResult));


    }

    //Metodo static que evita que façamos uma busca pelos elementos repetidas vezes
    private static class ViewHolder {

        EditText inputValue;
        TextView dolarResultText;
        TextView euroResultText;
        Button calculaterButton;

    }
}
