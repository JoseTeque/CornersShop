package m.google.androidcornershop.cart;

import io.reactivex.Observable;
import m.google.androidcornershop.modelo.Order;

public class CartRepository implements CartInterfacesRepository {
    @Override
    public Observable<Order> getResultFromNetwork() {
        return null;
    }

    @Override
    public Observable<Order> getResultFromCache() {
        return null;
    }

    @Override
    public Observable<Order> getResultData() {
        return null;
    }
}
