package com.midterm.tranducthong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CyclerAdapter extends RecyclerView.Adapter<CyclerAdapter.ViewHolder> {

    private ArrayList<ApiModel> lsmodel;
    private Context lcontext;
    public CyclerAdapter(Context context, ArrayList<ApiModel> model) {
        this.lcontext = context;
        this.lsmodel = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rcvcell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txttime.setText(lsmodel.get(position).getTimestamp());
        holder.txtname.setText(lsmodel.get(position).getDesc());
        holder.txtdesc.setText(lsmodel.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return lsmodel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtname;
        public TextView txtdesc;
        public TextView txttime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtdesc = itemView.findViewById(R.id.txtdesc);
            txtname = itemView.findViewById(R.id.txttitle);
            txttime = itemView.findViewById(R.id.txttimestamp);

        }


    }

}
