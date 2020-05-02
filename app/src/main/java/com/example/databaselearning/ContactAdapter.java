package com.example.databaselearning;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private final List<Three_Contacts> contacts;

    public ContactAdapter(List<Three_Contacts> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itens_list, parent, false);
        return new ContactHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {

        holder.nomeContato.setText(contacts.get(position).getName());
        holder.telefoneContato.setText(contacts.get(position).getTelefone());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


    //Quando clicar em algum item da lista, irá direcionar para outra activity.
    public class ContactHolder extends RecyclerView.ViewHolder{

        public TextView nomeContato;
        public TextView telefoneContato;

        public ContactHolder(@NonNull View itemView, final Context context) {
            super(itemView);

            nomeContato = itemView.findViewById(R.id.txtNomeLista);
            telefoneContato = itemView.findViewById(R.id.txtTelefoneLista);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(contacts.size()>0){
                        Three_Contacts c = contacts.get(getLayoutPosition());

                        Intent intent = new Intent(context, ChangeScheduleActivity.class);
                        intent.putExtra("Contact", c);
                        context.startActivity(intent);
                    }
                }
            });
        }


    }
}
