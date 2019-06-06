package m.google.androidcornershop.cart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import m.google.androidcornershop.R;
import m.google.androidcornershop.modelo.Order;

public class CartActivity extends AppCompatActivity implements CartMVP.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }

    @Override
    public void updateOrder(Order order) {

    }

    @Override
    public void showSnackbar(String s) {

    }
}
