package org.school.housingmember.adapters.adv_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.school.housingmember.R;
import org.school.housingmember.models.Advertisement;

import java.util.List;

public class AdvertisementAdapter extends RecyclerView.Adapter<AdvViewHolder>{
    private final List<Advertisement> advertisementList;
    private RVClickListener rvClickListener;

    public AdvertisementAdapter(List<Advertisement> advertisementList) {
        this.advertisementList = advertisementList;
    }

    @NonNull
    @Override
    public AdvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_advertisement,parent,false);
        return new AdvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdvViewHolder holder, int position) {
        Advertisement advertisement = advertisementList.get(position);
        holder.setData(advertisement);

        if (rvClickListener!=null){
            holder.itemView.setOnClickListener(view -> rvClickListener.onItemClick(advertisement.info));
        }

    }

    @Override
    public int getItemCount() {
        return advertisementList.size();
    }

    public void setRvClickListener(RVClickListener rvClickListener) {
        this.rvClickListener = rvClickListener;
    }


    public interface RVClickListener{
        void onItemClick(String ad_info);
    }
}
