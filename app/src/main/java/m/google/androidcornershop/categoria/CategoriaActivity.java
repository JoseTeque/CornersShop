package m.google.androidcornershop.categoria;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import m.google.androidcornershop.R;
import m.google.androidcornershop.adapter.CategoriaAdapter;
import m.google.androidcornershop.cart.CartActivity;
import m.google.androidcornershop.http.HttpInterfaces;
import m.google.androidcornershop.interfaces.OnClickRecycler;
import m.google.androidcornershop.modelo.Modelo;
import m.google.androidcornershop.root.App;

public class CategoriaActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CategoriaMVP.View {

    private static final String TAG = "CategoriaActivity";
    @BindView(R.id.IdRecylerCategoria)
    RecyclerView recyclerView;

   @BindView(R.id.IdConstra)
   ConstraintLayout constraintLayout;


   private CategoriaAdapter adapter;
   private List<Modelo> cateList= new ArrayList<>();
   private HttpInterfaces interfaces;

   @Inject
   CategoriaMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((App)getApplication()).getComponent().inject(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ButterKnife.bind(this);

        //Init  View
        adapter= new CategoriaAdapter(this,cateList);
      recyclerView.setHasFixedSize(true);
      recyclerView.setItemAnimator(new DefaultItemAnimator());
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
      recyclerView.setAdapter(adapter);

      adapter.setListener(new OnClickRecycler() {
          @Override
          public void onItemListener(View view, int position) {
              Toast.makeText(CategoriaActivity.this, String.valueOf(adapter.getItem(position).getId()), Toast.LENGTH_SHORT).show();
          }
      });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.categoria, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            cart();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void cart() {
        Intent intent= new Intent(CategoriaActivity.this, CartActivity.class);
        startActivity(intent);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void updateCategoria(final Modelo modelo) {
        cateList.add(modelo);
        adapter.notifyItemInserted(cateList.size()-1);

    }

    @Override
    public void showSnackbar(String message) {
        Snackbar.make(constraintLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadData();

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxjavaUnsuscribe();
        adapter.notifyDataSetChanged();
        cateList.clear();
    }


}
