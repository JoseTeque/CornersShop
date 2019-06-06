package m.google.androidcornershop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import m.google.androidcornershop.R;
import m.google.androidcornershop.http.HttpInterfaces;
import m.google.androidcornershop.interfaces.OnClickRecycler;
import m.google.androidcornershop.modelo.Modelo;
import m.google.androidcornershop.modelo.Order;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.ViewHolder> {

      private Context context;
      private List<Modelo> cateList;
      private  OnClickRecycler listener;

    public CategoriaAdapter(Context context, List<Modelo> cateList) {
        this.context = context;
        this.cateList = cateList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.categoria_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
           final Modelo categoria= cateList.get(i);

           viewHolder.nameFood.setText(categoria.getNombre());
           viewHolder.IdCart.setText(String.valueOf(categoria.getId()));

           Picasso.get().load(categoria.getImagen()).into(viewHolder.foodImage);

    }



    @Override
    public int getItemCount() {
        return cateList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.Id_Image_Food)
        public ImageView foodImage;

        @BindView(R.id.Id_txtnombrefood)
        public TextView nameFood;

        @BindView(R.id.IdImagenCart)
        public ImageButton btnCart;

        @BindView(R.id.Id_txtidfood)
        public TextView IdCart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            btnCart.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemListener(v,getAdapterPosition());
        }
    }

    public void setListener(OnClickRecycler listener) {
        this.listener = listener;
    }

   public Modelo getItem(int position)
   {
        return cateList.get(position);
   }
}

