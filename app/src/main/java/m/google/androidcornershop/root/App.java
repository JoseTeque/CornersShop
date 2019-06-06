package m.google.androidcornershop.root;

import android.app.Application;

import m.google.androidcornershop.categoria.CategoriaModule;
import m.google.androidcornershop.http.CategoriaModuleHttp;

public class App extends Application {
     private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component= DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .categoriaModule(new CategoriaModule())
                .categoriaModuleHttp(new CategoriaModuleHttp())
                .build();

    }
 public ApplicationComponent getComponent(){
   return component;
 }
}
