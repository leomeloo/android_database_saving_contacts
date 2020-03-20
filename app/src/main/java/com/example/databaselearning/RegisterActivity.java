package com.example.databaselearning;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btCadastrar = findViewById(R.id.btCadastrar);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtNome = findViewById(R.id.txtNome);
                EditText txtTelefone = findViewById(R.id.txtTelefone);

                String nome = txtNome.getText().toString();
                String telefone = txtTelefone.getText().toString();

                Four_ContactsDAO contactsDAO = new Four_ContactsDAO(getBaseContext());
                if(contactsDAO.Cadastrar(nome,telefone)){
                    Toast.makeText(getBaseContext(), "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getBaseContext(), "Falha ao realizar o cadastro!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
