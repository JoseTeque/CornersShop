package m.google.androidcornershop.categoria;

import java.util.List;

import io.reactivex.Observable;
import m.google.androidcornershop.modelo.Modelo;

public interface CategoriaMVP {

    interface View{
        void updateCategoria(Modelo modelo);

        void showSnackbar(String s);
    }

    interface Presenter{

        void loadData();

        void rxjavaUnsuscribe();

        void setView(CategoriaMVP.View view);
    }

    interface Model{

        Observable<Modelo> results();
    }

}
