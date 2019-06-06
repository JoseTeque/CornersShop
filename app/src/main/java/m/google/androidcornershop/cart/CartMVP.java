package m.google.androidcornershop.cart;

import io.reactivex.Observable;
import m.google.androidcornershop.modelo.Order;

public interface CartMVP {

    interface View{
        void updateOrder(Order order);

        void showSnackbar(String s);
    }

    interface Presenter{

        void loadData();

        void rxjavaUnsuscribe();

        void setView(CartMVP.View view);

    }

    interface Model{
        Observable<Order> results();
    }


}
