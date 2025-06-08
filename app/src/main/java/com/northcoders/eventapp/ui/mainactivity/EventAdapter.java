package com.northcoders.eventapp.ui.mainactivity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.eventapp.R;
import com.northcoders.eventapp.databinding.EventItemBinding;
import com.northcoders.eventapp.model.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder>
{
    private List<Event> eventList;
    private Context context;

    private RecyclerViewInterface recyclerViewInterface;

    public EventAdapter(List<Event> eventList, Context context,RecyclerViewInterface recyclerViewInterface) {
        this.eventList = eventList;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EventItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.event_item,parent,false);
        return new EventViewHolder(binding,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.binding.setEvent(eventList.get(position));
    }

    @Override
    public int getItemCount() {
        //Log.d("RecyclerViewSize", "getItemCount: " + eventList.size());
        return eventList.size();
    }



    public static class EventViewHolder extends RecyclerView.ViewHolder{
        private EventItemBinding binding;
        public EventViewHolder(EventItemBinding eventItemBinding,RecyclerViewInterface recyclerViewInterface) {
            super(eventItemBinding.getRoot());
            this.binding = eventItemBinding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }





    }
}
