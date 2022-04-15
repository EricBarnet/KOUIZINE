//package fr.lilk.kouizine;
//
//import android.content.Context;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.squareup.picasso.Picasso;
//
//public class ViewHolder extends RecyclerView.ViewHolder {
//    View view;
//    public ViewHolder(@NonNull View itemView){
//        super(itemView);
//
//        view = itemView;
//
//
//    }
//
//    public void setdetails(Context context, String title, String duree , String image){
//        TextView tvRecipename = view.findViewById(R.id.tvRecipeName);
//        TextView tvDuree = view.findViewById(R.id.tvRecetteDuree);
//        ImageView tvImage = view.findViewById(R.id.);
//
//        tvRecipename.setText(title);
//        Picasso.get().load(image).into(tvImage);
//
//        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
//        itemView.startAnimation(animation);
//    }
//}
