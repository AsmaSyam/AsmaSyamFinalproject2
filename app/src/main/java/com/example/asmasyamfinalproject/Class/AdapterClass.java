package com.example.asmasyamfinalproject.Class;

import android.view.LayoutInflater;
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

    public AdapterClass(ArrayList<DataOfLevel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGameLevelBinding binding = ItemGameLevelBinding.inflate(LayoutInflater.from(parent.getContext()) , parent , false);

        return new DataViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        holder.textViewLevel.setText("مرحلة" + arrayList.get(position).getLevelNo());
        holder.textViewPoints.setText("النقاط المطلوبة" + arrayList.get(position).getUnlockPoints());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewBorder ;
        LinearLayout linearLayout ;
        ImageView imageViewGame ;
        TextView textViewLevel ;
        TextView textViewPoints ;

        public DataViewHolder(@NonNull ItemGameLevelBinding binding) {
            super(binding.getRoot());

            imageViewBorder = binding.imageViewBorder ;
            linearLayout = binding.linearLayout ;
            imageViewGame = binding.imageView2 ;
            textViewLevel = binding.textViewLevel ;
            textViewPoints = binding.textViewPoints ;

        }
    }
}
