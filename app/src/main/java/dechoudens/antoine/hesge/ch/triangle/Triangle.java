package dechoudens.antoine.hesge.ch.triangle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Module 635.1 - Programmation
 * Activité principale
 *
 * @author ??? - HEG-Genève
 * @version Version 1.0
 */
public class Triangle extends AppCompatActivity {
    private TextView edCoteA;
    private TextView edCoteB;
    private TextView edCoteC;
    private TextView edAire;
    private Button btnCalculer;
    private Button btnNouveau;
    private Button btnTerminer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        initComp();
        addTextListeners();
    } // onCreate

    private void addTextListeners() {
        TextWatcher listener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                check();
            }
        };

        edCoteA.addTextChangedListener(listener);
        edCoteB.addTextChangedListener(listener);
        edCoteC.addTextChangedListener(listener);
    }

    public void calculer(View v) {
        double a = Double.parseDouble(edCoteA.getText().toString());
        double b = Double.parseDouble(edCoteB.getText().toString());
        double c = Double.parseDouble(edCoteC.getText().toString());

        double p = 0.5 * (a + b + c);
        double aire = Math.sqrt(p * (p - a) * (p - b) * (p - c));


        edAire.setText(String.valueOf(aire));
    }

    private void check() {
        if (edCoteA.getText().length() > 0 && edCoteB.getText().toString().length() > 0 && edCoteC.getText().toString().length() > 0) {
            btnCalculer.setEnabled(true);
            btnNouveau.setEnabled(true);
        } else {
            btnCalculer.setEnabled(false);
            btnNouveau.setEnabled(false);
        }
    }

    private void initComp() {
        edCoteA = (TextView) findViewById(R.id.edCoteA);
        edCoteB = (TextView) findViewById(R.id.edCoteB);
        edCoteC = (TextView) findViewById(R.id.edCoteC);
        edAire = (TextView) findViewById(R.id.edAire);
        btnCalculer = (Button) findViewById(R.id.btnCalculer);
        btnNouveau = (Button) findViewById(R.id.btnNouveau);
        btnTerminer = (Button) findViewById(R.id.btnTerminer);
    }

    public void finish(View v) {
        finish();
    }

} // Triangle
