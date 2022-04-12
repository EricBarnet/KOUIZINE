package fr.lilk.kouizine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class Inscription extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    EditText emailEdit, prenomEdit, nomEdit, mdpEdit, confirmMdpEdit, verif;
    Button buttonInscris;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);

        mAuth = FirebaseAuth.getInstance();

        emailEdit = findViewById(R.id.emailEdit);
        prenomEdit = findViewById(R.id.prenomEdit);
        nomEdit = findViewById(R.id.nomEdit);
        mdpEdit = findViewById(R.id.mdpEdit);
        confirmMdpEdit = findViewById(R.id.confirmMdpEdit);
        buttonInscris = (Button) findViewById(R.id.buttonInscri);
        buttonInscris.setOnClickListener(this);

    }

    private Boolean verificationEmail(){
        String val = verif.getText().toString();
        /* Restriction regex pour écrire un mail allant de a-z ou A-Z ou des chiffres ou "." ou "_" ou "-"
        * [a-zA-Z0-9._-]+@[a-z]+\.+[a-z]+ peut correspondre à aef.dq23c@gmail.com
        * mais ne peut pas être $s/@°@gmail.com car elle ne respecte pas le format a-z A-Z 0-9 et ". ou _ ou -"
        * */
        String restrict = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty()){
            verif.setError("Email ne doit pas être vide");
            return false;
        }else if(!val.matches(restrict)){
            verif.setError("Format email invalide");
            return false;
        }else{
            verif.setError(null);
            return true;
        }
    }

    private Boolean verificationPrenom(){
        String val = verif.getText().toString();
        /* Restriction regex pour écrire un mail allant de a-z ou A-Z ou des chiffres ou "." ou "_" ou "-"
         * [a-zA-Z0-9._-]+@[a-z]+\.+[a-z]+ peut correspondre à aef.dq23c@gmail.com
         * mais ne peut pas être $s/@°@gmail.com car elle ne respecte pas le format a-z A-Z 0-9 et ". ou _ ou -"
         * */
        String WhiteSpace = "\\s";
        if(val.isEmpty()){
            verif.setError("le prenom ne doit pas être vide");
            return false;
        }else if(val.matches(WhiteSpace)){
            verif.setError("le prenom doit pas avoir d'espace");
            return false;
        }else{
            verif.setError(null);
            return true;
        }
    }

    private Boolean verificationNom(){
        String val = verif.getText().toString();
        /* Restriction regex pour écrire un mail allant de a-z ou A-Z ou des chiffres ou "." ou "_" ou "-"
         * [a-zA-Z0-9._-]+@[a-z]+\.+[a-z]+ peut correspondre à aef.dq23c@gmail.com
         * mais ne peut pas être $s/@°@gmail.com car elle ne respecte pas le format a-z A-Z 0-9 et ". ou _ ou -"
         * */
        if(val.isEmpty()){
            verif.setError("le nom ne doit pas être vide");
            return false;
        }else{
            verif.setError(null);
            return true;
        }
    }

    private Boolean verificationMdp(){
        String val = verif.getText().toString();
        String passwordRestrict = "^" + // début de ligne ^
                "[a-zA-Z]" + // au moins un caractère a-z A-Z
                "[@#$%^&+=]" + // au moins un caractère spécial
                "\\S+" + // tout sauf des espaces
                ".{8,}" + // au moins 8 caractères mdp
                "$"; // fin de ligne
        if(val.isEmpty()){
            verif.setError("Mot de passe ne doit pas être vide");
            return false;
        }else if(!val.matches(passwordRestrict)){
            verif.setError("Format mot de passe invalide");
            return false;
        }else{
            verif.setError(null);
            return true;
        }
    }

    private Boolean verificationConfirmMdp(){
        String val = verif.getText().toString();
        String passwordRestrict = "^" + // début de ligne ^
                "[a-zA-Z]" + // au moins un caractère a-z A-Z
                "[@#$%^&+=]" + // au moins un caractère spécial
                "\\S+" + // tout sauf des espaces
                ".{8,}" + // au moins 8 caractères mdp
                "$"; // fin de ligne
        if(val.isEmpty()){
            verif.setError("Mot de passe ne doit pas être vide");
            return false;
        }else if(!val.matches(passwordRestrict)){
            verif.setError("Format mot de passe invalide");
            return false;
        }else{
            verif.setError(null);
            return true;
        }
    }




    public void registerUser(View view){
        String email = emailEdit.getText().toString();
        String prenom = prenomEdit.getText().toString();
        String nom = nomEdit.getText().toString();
        String mdp = mdpEdit.getText().toString();
        String confirmMdp = confirmMdpEdit.getText().toString();
    }

    @Override
    public void onClick(View view) {
        if(view.equals(buttonInscris)){
            
        }
    }
}
