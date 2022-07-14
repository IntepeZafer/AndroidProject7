package com.example.landmarkbook;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.landmarkbook.databinding.RecylerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {
    // viewHolder sınıfından bir obje oluşturulduunda çağrılacak metod xml bağlanma işlemi burda yapırlır
    ArrayList<Landmark> landmarkArrayList;
    private String landmark;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecylerRowBinding recylerRowBinding = RecylerRowBinding.inflate(LayoutInflater.from(parent.getContext()) , parent , false);
        return new LandmarkHolder(recylerRowBinding);
    }
    // viewHolder sınıfı bağlandığında neler olacağını belirleyen metoddur
    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) {
        holder.binding.recylerViewTextView.setText(landmarkArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext() , DetailsActivity.class);
                intent.putExtra(landmark , landmarkArrayList.get(position));
                singleton singleton = singleton.getInstance();
                singleton.setSentLandmark(landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }
    // xml'in kaçkere oluşturulacağını belirler
    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }
    // Yardımcı Bir Sınıfdır Görünümümlerimizi Tutar
    public class LandmarkHolder extends RecyclerView.ViewHolder{
        private RecylerRowBinding binding;
        public LandmarkHolder(RecylerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
