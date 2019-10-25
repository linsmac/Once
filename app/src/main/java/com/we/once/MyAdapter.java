package com.we.once;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import static com.we.once.R.color.c2;
import static com.we.once.R.color.c3;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context mContext;
    private List<PostModel> myDataList;

    public MyAdapter(Context context, List<PostModel> myDataList) {
        this.mContext = context;
        this.myDataList = myDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvDate.setText(myDataList.get(position).getDate());
        holder.tvType.setText(myDataList.get(position).getType());
        holder.tvMoney.setText(myDataList.get(position).getMoney());
        if (myDataList.get(position).getColor().equals("0")){
            holder.layout.setBackground(mContext.getDrawable(R.color.c1));
        } else if (myDataList.get(position).getColor().equals("1")) {
            holder.layout.setBackground(mContext.getDrawable(c2));
        } else if (myDataList.get(position).getColor().equals("2")){
            holder.layout.setBackground(mContext.getDrawable(c3));
        }
    }

    @Override
    public int getItemCount() {
        return myDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvDate;
        public TextView tvType;
        public TextView tvMoney;
        public ConstraintLayout layout;


        public ViewHolder(View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.textViewDate);
            tvType = itemView.findViewById(R.id.textViewType);
            tvMoney = itemView.findViewById(R.id.textViewMoney);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}