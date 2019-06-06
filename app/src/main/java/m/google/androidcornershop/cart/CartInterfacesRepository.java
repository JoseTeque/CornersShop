package m.google.androidcornershop.cart;

import io.reactivex.Observable;
import m.google.androidcornershop.modelo.Order;

public interface CartInterfacesRepository {

    Observable<Order> getResultFromNetwork();
    Observable<Order> getResultFromCache();
    Observable<Order> getResultData();
}
