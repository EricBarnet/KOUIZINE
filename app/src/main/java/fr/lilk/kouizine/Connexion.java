package fr.lilk.kouizine;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Connexion extends AppCompatActivity {

    TextInputEditText etConnexionEmail;
    TextInputEditText etConnexionMdp;
    TextView tvInscrire;
    Button btnLogin;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);

        etConnexionEmail = findViewById(R.id.etLoginEmail);
        etConnexionMdp = findViewById(R.id.etLoginPass);
        tvInscrire = findViewById(R.id.tvRegisterHere);
        btnLogin = findViewById(R.id.btnLogin);

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(view -> {
            loginUser();
        });
        tvInscrire.setOnClickListener(view ->{
            startActivity(new Intent(Connexion.this, Inscription.class));
        });
    }

    private void loginUser(){
        String email = etConnexionEmail.getText().toString();
        String password = etConnexionMdp.getText().toString();

        if (TextUtils.isEmpty(email)){
            etConnexionEmail.setError("Email cannot be empty");
            etConnexionEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            etConnexionMdp.setError("Password cannot be empty");
            etConnexionMdp.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Connexion.this, "Connection avec succes", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Connexion.this, Accueil.class));
                    }else{
                        Toast.makeText(Connexion.this, "Erreur de connexion " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
