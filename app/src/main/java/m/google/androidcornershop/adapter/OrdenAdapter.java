package m.google.androidcornershop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import m.google.androidcornershop.R;
import m.google.androidcornershop.modelo.Modelo;
import m.google.androidcornershop.modelo.Order;

public class OrdenAdapter extends RecyclerView.Adapter<OrdenAdapter.ViewHolder> {

    private Context context;
    private List<Order> orderList;

    public OrdenAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.cart_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Order order= orderList.get(i);

        Picasso.get().load(order.getImagen()).into(viewHolder.foodImage);

        viewHolder.nameFood.setText(order.getNombre());

        viewHolder.btnCart.setNumber(String.valueOf(order.getContador()));

        viewHolder.btnCart.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.Id_Image_Food)
        public ImageView foodImage;

        @BindView(R.id.Id_txtnombrefood)
        public TextView nameFood;

        @BindView(R.id.Id_btn_quantity)
        public ElegantNumberButton btnCart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
