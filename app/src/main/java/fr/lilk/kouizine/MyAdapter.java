package fr.lilk.kouizine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Recette> list;

    public MyAdapter(Context context, ArrayList<Recette> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Recette recette = list.get(position);
        holder.RecipeName.setText(recette.getRecetteNom());
        holder.Duree.setText(recette.getRecetteDuree());
        holder.Exemple.setText(recette.getExemple());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView RecipeName, Duree, Exemple;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            RecipeName = itemView.findViewById(R.id.tvRecipeName);
            Duree = itemView.findViewById(R.id.tvRecetteDuree);
            Exemple = itemView.findViewById(R.id.tvRecetteExemple);
        }
    }
}
