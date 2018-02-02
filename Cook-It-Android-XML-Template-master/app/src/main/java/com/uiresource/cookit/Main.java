package com.uiresource.cookit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.MenuInflater;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uiresource.cookit.utils.AppBarStateChangeListener;
import com.uiresource.cookit.utils.CircleGlide;
import com.uiresource.cookit.utils.CustomTypefaceSpan;

public class Main extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private TextView txtNomUsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar(R.id.toolbar, "Siremo", R.color.colorPink, R.color.colorWhiteTrans, R.drawable.ic_burger);

        FragmentTransaction ft;
        FragmentHome fragmentHome = new FragmentHome();
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragmentHome).commit();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();




        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);
        ImageView imageView = (ImageView) header.findViewById(R.id.imageView);
        txtNomUsu = (TextView) header.findViewById(R.id.txtNomUsuario);
        SharedPreferences miPreferencia = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String nomUsuario = miPreferencia.getString("nomUsuario","No de pudo obtener");
        txtNomUsu.setText(nomUsuario);
        //IMAGEN DE USUARIO
        /*Glide.with(this)
                .load(Uri.parse("https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg"))
                .transform(new CircleGlide(this))
                .into(imageView);*/
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
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);  // OPEN DRAWER
                return true;
            case R.id.buscar_id:
                Intent myIntent = new Intent(Main.this,
                        BuscadorActivity.class);
                startActivity(myIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
       // FragmentManager fragmentManager = ;

        FragmentTransaction ft;
        FragmentHome fragmentHome = new FragmentHome();
        fragmentEstilo fragmentEstil = new fragmentEstilo();
        fragmentMeGusta fragmentMeGustaron = new fragmentMeGusta();
        ConjuntosFragment fragmentConjuntos = new ConjuntosFragment();
        AboutFragment aboutFragment = new AboutFragment();

        if (id == R.id.salir) {
            this.finish();
            startActivity(new Intent(this, LoginActivity.class));
        } else if (id == R.id.Acercade) {
            //conocenos
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout, aboutFragment).commit();

        }else if (id == R.id.vestiConjuntos) {

            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout, fragmentConjuntos).commit();

        }
        else if (id == R.id.vestiReco) {

            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout, fragmentHome).commit();

        } else if (id == R.id.vestiEstilo) {

            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout, fragmentEstil).commit();

        }else if (id == R.id.history) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout, fragmentMeGustaron).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}