package com.bawei.myapplication.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.myapplication.R;
import com.bawei.myapplication.model.Bean;
import com.bawei.myapplication.util.NetUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:张奕漫
 *@Date: 2019/12/29
 *@Time:19:52
 *@Description:
 * */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Bean.DataBean> data;

    public MyAdapter(List<Bean.DataBean> data) {

        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = data.get(position).getGoods_name();
        holder.textView.setText(name);
        String currency_price = data.get(position).getCurrency_price();
        holder.textView1.setText(currency_price+"");
        NetUtil.getInstance().getPhoto(data.get(position).getGoods_thumb(),holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListeren.onClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.tv01);
            textView1 = itemView.findViewById(R.id.tv02);
        }
    }
    onClickItemListeren onClickItemListeren;

    public void setOnClickItemListeren(MyAdapter.onClickItemListeren onClickItemListeren) {
        this.onClickItemListeren = onClickItemListeren;
    }

    public interface onClickItemListeren{
        void onClickItem (int i);
    }

}
