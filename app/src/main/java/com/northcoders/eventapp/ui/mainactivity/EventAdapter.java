package com.northcoders.eventapp.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
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

    public EventAdapter(List<Event> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EventItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.event_item,parent,false);
        return new EventViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.binding.setEvent(eventList.get(position));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder{
        private EventItemBinding binding;
        public EventViewHolder(EventItemBinding eventItemBinding) {
            super(eventItemBinding.getRoot());
            this.binding = eventItemBinding;
        }
    }
}
