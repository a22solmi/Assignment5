package com.example.networking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private List<Mountain> mountains;
    private OnClickListener onClickListener;
    private LayoutInflater layoutInflater;

    public RecycleViewAdapter(Context context, List<Mountain> mountains, OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.layoutInflater = LayoutInflater.from(context);
        this.mountains = mountains;
    }

    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recycle_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder holder, int position) {
        holder.text.setText(mountains.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            text = itemView.findViewById(R.id.item_name);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(mountains.get(getBindingAdapterPosition()));
        }
    }
    public interface OnClickListener {
        void onClick(Mountain mountain);
    }
}
