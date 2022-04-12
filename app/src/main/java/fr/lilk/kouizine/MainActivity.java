package fr.lilk.kouizine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonSignin, buttonConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSignin= (Button) findViewById(R.id.buttonSignin);
        buttonSignin.setOnClickListener(this);
        buttonConnected = (Button) findViewById(R.id.buttonConnected);
        buttonConnected.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.equals(buttonConnected)){
            Intent intent = new Intent(getApplicationContext(), Connexion.class);
            startActivity(intent);
        }else if(view.equals(buttonSignin)){
            Intent intent = new Intent(getApplicationContext(), Inscription.class);
            startActivity(intent);
        }
    }
}