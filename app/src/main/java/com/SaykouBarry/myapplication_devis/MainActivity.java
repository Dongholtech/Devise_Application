package com.SaykouBarry.myapplication_devis;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // Déclaration des variables pour les champs de saisie et le bouton
    EditText champ_fg;
    EditText champ_euro;
    Button btn_convertir;
    double taux_conversion = 0.000110; // taux de conversion FG/Euro

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison des variables avec les champs de saisie et le bouton de l'interface graphique
        champ_fg = findViewById(R.id.fg);
        champ_euro = findViewById(R.id.euro);
        btn_convertir = findViewById(R.id.convertir);

        // Ajout d'un écouteur d'événement au bouton de conversion
        btn_convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupération de la valeur saisie dans le champ FG
                double valeur_fg = Double.parseDouble(champ_fg.getText().toString());

                // Conversion de FG en euro
                double valeur_euro = valeur_fg * taux_conversion;

                // Affichage de la valeur en euro dans le champ correspondant
                champ_euro.setText(String.format("%.2f", valeur_euro));
            }
        });
    }
}
