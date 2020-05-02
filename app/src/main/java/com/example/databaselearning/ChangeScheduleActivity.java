package com.example.databaselearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_schedule);

        Bundle bundle = getIntent().getExtras();
        final Three_Contacts contacts = (Three_Contacts)bundle.getSerializable("Contact");

        final EditText txtName, txtPhone;
        txtName = findViewById(R.id.txtChangeName);
        txtPhone = findViewById(R.id.txtChangePhone);

        txtName.setText(contacts.getName().toString());
        txtPhone.setText(contacts.getTelefone().toString());

        Button btDelete, btEdit;
        btDelete = findViewById(R.id.btDelete);
        btEdit = findViewById(R.id.btEdit);

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Four_ContactsDAO contactsDAO = new Four_ContactsDAO(getBaseContext());

                if(contactsDAO.Remover(contacts.getID()))
                    Toast.makeText(getBaseContext(), "Contato removido com sucesso!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "Falha ao deletar o contato!", Toast.LENGTH_LONG).show();

                finish();
            }
        });

        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtName.getText().toString();
                String phone = txtPhone.getText().toString();

                Four_ContactsDAO contactsDAO = new Four_ContactsDAO(getBaseContext());
                if(contactsDAO.Alterar(contacts.getID(),name,phone))
                    Toast.makeText(getBaseContext(), "Alteração feita com sucesso!", Toast.LENGTH_LONG).show();
                else
                Toast.makeText(getBaseContext(), "Falha na alteração!", Toast.LENGTH_LONG).show();

                finish();
            }
        });
    }
}
