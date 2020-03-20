import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databaselearning.ChangeScheduleActivity;
import com.example.databaselearning.R;
import com.example.databaselearning.Three_Contacts;

import java.util.List;

public class ContactAdapter {

    private final List<Three_Contacts> contacts;

    public ContactAdapter(List<Three_Contacts> contacts) {
        this.contacts = contacts;
    }

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
