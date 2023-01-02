package com.example.asmasyamfinalproject.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asmasyamfinalproject.databinding.ItemGameLevelBinding;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.DataViewHolder> {

    ArrayList<DataOfLevel> arrayList ;
    Context context ;
    Listener listener ;

    public AdapterClass(ArrayList<DataOfLevel> arrayList , Context context , Listener listener) {
        this.arrayList = arrayList;
        this.context = context ;
        this.listener = listener ;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGameLevelBinding binding = ItemGameLevelBinding.inflate(LayoutInflater.from(parent.getContext()) , parent , false);

        return new DataViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        int pos = position ;
        holder.textViewLevel.setText("مرحلة " + arrayList.get(position).getLevelNo());
        holder.textViewPoints.setText(" النقاط المطلوبة " + arrayList.get(position).getUnlockPoints());
        holder.imageViewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.OnClick(pos);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout ;
        ImageView imageViewGame ;
        TextView textViewLevel ;
        TextView textViewPoints ;

        public DataViewHolder(@NonNull ItemGameLevelBinding binding) {
            super(binding.getRoot());

            linearLayout = binding.linearLayout ;
            imageViewGame = binding.imageView2 ;
            textViewLevel = binding.textViewLevel ;
            textViewPoints = binding.textViewPoints ;

        }
    }
}
