package m.google.androidcornershop.http;

import java.util.List;

import io.reactivex.Observable;
import m.google.androidcornershop.modelo.Modelo;
import m.google.androidcornershop.modelo.Order;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HttpInterfaces {

    @GET("categoria")
    Observable<List<Modelo>> getCategoria();

    @GET("orden")
    Observable<List<Order>> getOrden();


    @FormUrlEncoded
    @POST("orden/nuevo")
    Call<ResponseBody> postOrden(@Field("nombre") String nombre, @Field("contador") int contador, @Field("imagen") String imagen);
}
