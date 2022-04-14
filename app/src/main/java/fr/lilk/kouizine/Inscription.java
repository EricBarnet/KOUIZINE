package fr.lilk.kouizine;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Inscription extends AppCompatActivity {

    private FirebaseAuth mAuth;

    TextInputEditText etRegEmail, etRegNom, etRegPrenom, etRegPass, etRegConfirmPass;
    TextView tvLoginHere;
    Button buttonInscris;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);

        mAuth = FirebaseAuth.getInstance();

        etRegEmail = findViewById(R.id.etRegEmail);
        etRegNom = findViewById(R.id.etRegNom);
        etRegPrenom = findViewById(R.id.etRegPrenom);
        etRegPass = findViewById(R.id.etRegPass);
        etRegConfirmPass = findViewById(R.id.etRegConfirmPass);
        buttonInscris = findViewById(R.id.btnRegister);

        tvLoginHere = findViewById(R.id.tvLoginHere);
        mAuth = FirebaseAuth.getInstance();

        buttonInscris.setOnClickListener(view -> {
            createUser();
        });

        tvLoginHere.setOnClickListener(view -> {
            startActivity(new Intent(Inscription.this, Connexion.class));
        });
    }

    private void createUser(){
        String email = etRegEmail.getText().toString();
        String nom = etRegNom.getText().toString();
        String prenom = etRegPrenom.getText().toString();
        String mdp = etRegPass.getText().toString();
        String confirmMdp = etRegConfirmPass.getText().toString();

        if(TextUtils.isEmpty(email)){
            etRegEmail.setError("L'email peut pas etre vide");
            etRegEmail.requestFocus();
        }else if(TextUtils.isEmpty(nom)){
            etRegNom.setError("Nom vide");
            etRegNom.requestFocus();
        }else if(TextUtils.isEmpty(prenom)){
            etRegPrenom.setError("Prenom vide");
            etRegPrenom.requestFocus();
        }else if(TextUtils.isEmpty(mdp)){
            etRegPass.setError("Mot de passe vide");
            etRegPass.requestFocus();
        }else if(TextUtils.isEmpty(confirmMdp)){
            etRegConfirmPass.setError("Comfirmer mot de passe vide");
            etRegConfirmPass.requestFocus();
        }else if(!confirmMdp.matches(mdp)){
            etRegConfirmPass.setError("Mot de passe non identique");
            etRegConfirmPass.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email, mdp).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Inscription.this, "Utilisateur a bien ete enregriste", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(Inscription.this, Accueil.class));
                    }else{
                        Toast.makeText(Inscription.this, "L'inscription a echoue" + task.getException().getMessage(), Toast.LENGTH_LONG).show();

                    }
                }
            });
        }
    }
}

