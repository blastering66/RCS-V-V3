package id.tech.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pkmmte.view.CircularImageView;

import java.util.ArrayList;
import java.util.List;

import id.tech.verificareolx.R;

/**
 * Created by RebelCreative-A1 on 02/03/2016.
 */
public class Olx_RecyclerAdapter_Gallery extends RecyclerView.Adapter<Olx_RecyclerAdapter_Gallery.ViewHolder>{
    private Activity activity_adapter;
    private Context context_adapter;
    private List<RowDataGallery> data, selected;
    private onSelectedImageInterface listener;

    public Olx_RecyclerAdapter_Gallery(Activity activity_adapter, Context context_adapter, List<RowDataGallery> data) {
        this.activity_adapter = activity_adapter;
        this.context_adapter = context_adapter;
        this.data = data;

        selected = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final RowDataGallery item = data.get(position);

        try{
            listener = (onSelectedImageInterface)activity_adapter;
        }catch (ClassCastException e){

        }

        holder.img.setImageBitmap(item.bitmap);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedImage(position);

            }
        });

    }

    public interface onSelectedImageInterface{
        public void changeActionbarTitle(int size_selected);
    }

    private void selectedImage(int positiion){

        if(selected.size() >= 7 ){
            Toast.makeText(context_adapter, "Maksimal 7 Gambar", Toast.LENGTH_LONG).show();
        }else{
            selected.add(data.get(positiion));
            Parameter_Collections.data_selected = selected;
            listener.changeActionbarTitle(selected.size());
            data.remove(positiion);
            notifyDataSetChanged();

        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context_adapter).inflate(R.layout.item_gallery, null);

        ViewHolder viewHolder = new ViewHolder(v, activity_adapter);
        return viewHolder;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
                public ImageView img;

        private Activity activity;

        public ViewHolder(View v, Activity activity) {
            super(v);
            img = (ImageView) v.findViewById(R.id.img);
            this.activity = activity;
        }

    }
}
