package eu.barcikowski.proexetestapp.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import eu.barcikowski.proexetestapp.R;
import eu.barcikowski.proexetestapp.model.Item;

public class SampleItemAdapter extends RecyclerView.Adapter<SampleItemAdapter.ViewHolder>{

    private List<Item> item;
    private Context context;

    public SampleItemAdapter(List<Item> item, Context context){
        this.item = item;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemcard,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Item item = this.item.get(position);
        holder.text.setText(item.getName());
        Picasso.with(context)
                .load(item.getImgURL())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return 0;
    }




    public class ViewHolder extends RecyclerView.ViewHolder{


            public TextView text;
            public ImageView image;

            public ViewHolder(View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.textView);
                image = itemView.findViewById(R.id.imageView);
            }




        }
    }





