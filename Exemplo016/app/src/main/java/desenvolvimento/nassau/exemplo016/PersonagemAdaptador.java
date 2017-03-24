package desenvolvimento.nassau.exemplo016;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by paulo on 24/03/2017.
 */

public class PersonagemAdaptador extends RecyclerView.Adapter<PersonagemAdaptador.PersonagemViewHolder> {
    ArrayList<String> listaPlanetas = null;

    PersonagemAdaptador(Context context, ArrayList<String> planetas) {
        this.listaPlanetas = planetas;
    }

    @Override
    public PersonagemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.personagem_row, parent, false);
        PersonagemViewHolder viewHolder = new PersonagemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PersonagemViewHolder holder, int position) {
        holder.image.setImageResource(R.drawable.dmc_icon);
        holder.text.setText(listaPlanetas.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return listaPlanetas.size();
    }


    public static class PersonagemViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        protected ImageView image;
        protected TextView text;

        public PersonagemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            image = (ImageView) itemView.findViewById(R.id.image_id);
            text = (TextView) itemView.findViewById(R.id.text_id);
        }

        @Override
        public void onClick(View v) {
            Log.i(PersonagemViewHolder.class.getName(), "Voce clicou");
        }
    }
}
