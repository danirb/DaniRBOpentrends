package com.devforbest.danirbopentrends.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devforbest.danirbopentrends.R;
import com.devforbest.danirbopentrends.models.Human;
import com.devforbest.danirbopentrends.network.ResponseModel;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.GnomeViewHolder> implements View.OnClickListener {

    private final List<ResponseModel.Result> listHumen;
    private final Context mContext;
    private View.OnClickListener listener;

    public ListRecyclerAdapter(List<ResponseModel.Result> listHumen, Context context) {
        this.listHumen = listHumen;
        this.mContext = context;
    }

    @Override
    public GnomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_human, parent, false);
        v.setOnClickListener(this);
        return new GnomeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GnomeViewHolder holder, int position) {
        Human human = listHumen.get(position).getEntity();
        holder.humanName.setText(human.getNumber());


        Picasso.with(mContext)
                .load(human.getPicture())
                .fit().centerCrop()
                .into(holder.humanPicture);

    }

    @Override
    public int getItemCount() {
        return listHumen.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onClick(v);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public class GnomeViewHolder extends RecyclerView.ViewHolder {

        final TextView humanName;
        final ImageView humanPicture;

        public GnomeViewHolder(View itemView) {
            super(itemView);
            humanPicture = (ImageView) itemView.findViewById(R.id.human_picture);
            humanName = (TextView) itemView.findViewById(R.id.human_name);


        }
    }
}
