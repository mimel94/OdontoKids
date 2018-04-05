package com.mimel.odontokids;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Adapter.CustomExpandableListAdapter;
import Helper.FragmentNavigationManager;
import Interface.NavigationManager;

public class MainActivity extends AppCompatActivity {

    //NavigationView navigationView = null;
    //Toolbar toolbar = null;
    ImageView logoVolver;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDraweToggle;
    private String mActivityTytle;
    private String[] items;

    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    private List<String> lstTitle;
    private Map<String, List<String>> lstChild;
    private NavigationManager navigationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoVolver = (ImageView)findViewById(R.id.imageView);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTytle = getTitle().toString();
        expandableListView = (ExpandableListView) findViewById(R.id.navList);
        navigationManager = FragmentNavigationManager.getmInstance(this);

        //set the fragment initially
        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/

       // navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);



        initItems();

        View listHeaderView = getLayoutInflater().inflate(R.layout.nav_header_main, null, false);
        expandableListView.addHeaderView(listHeaderView);
        
        genData();

        addDrawersItem();

        setupDrawer();

        /*if(savedInstanceState == null){
            selectFirstItemAsDefault();
        }*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(mActivityTytle);

    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDraweToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDraweToggle.onConfigurationChanged(newConfig);
    }

    private void selectFirstItemAsDefault() {
        if(navigationManager != null){
            String firstItem = lstTitle.get(0);
            //navigationManager.showFragment(firstItem);
            //getSupportActionBar().setTitle(firstItem);
        }
    }

    private void setupDrawer() {

        mDraweToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("MENU");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(mActivityTytle);
                invalidateOptionsMenu();
            }
        };

        mDraweToggle.setDrawerIndicatorEnabled(true);
        //mDrawerLayout.addDrawerListener(mDraweToggle);
        mDrawerLayout.setDrawerListener(mDraweToggle);
        mDraweToggle.syncState();


    }

    private void addDrawersItem() {
        adapter = new CustomExpandableListAdapter(this, lstTitle, lstChild);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                getSupportActionBar().setTitle(lstTitle.get(i).toString());
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                getSupportActionBar().setTitle("OdondoKinds");
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                String selectItem = ((List)(lstChild.get(lstTitle.get(i)))).get(i1).toString();

                getSupportActionBar().setTitle(selectItem);

                if(items[0].equals(lstTitle.get(i))){
                    PraxiasFragment fragment = new PraxiasFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }else if (items[1].equals(lstTitle.get(i))){
                    OralRespirationFragment fragment = new OralRespirationFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }else if(items[2].equals(lstTitle.get(i))){
                    AtipicaDeglucionFragment fragment = new AtipicaDeglucionFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else{
                    throw new IllegalArgumentException("No soportado");
                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    private void genData() {

        List<String> title = Arrays.asList("Succión","Respiración oral","Deglución Atipica");
        List<String> childItem = Arrays.asList("Digital","Interposición lingual","Interposición labial");
        List<String> childItem2 = Arrays.asList("Ejercicios","Soplar pelota","Mas...");
        List<String> childItem3 = Arrays.asList("Masaje con manos","Masajeador","Mas...");
        lstChild = new TreeMap<>();
        lstChild.put(title.get(0),childItem);
        lstChild.put(title.get(1),childItem2);
        lstChild.put(title.get(2),childItem3);

        lstTitle = new ArrayList<>(lstChild.keySet());

    }

    private void initItems() {
        items = new String[]{"Succión","Respiración oral","Deglución Atipica"};
    }

    @Override
    public void onBackPressed() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            AboutUsFragment fragment = new AboutUsFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        if (mDraweToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /*
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_terapias_praxias) {

            PraxiasFragment fragment = new PraxiasFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_terapias_respiracion) {

            OralRespirationFragment fragment = new OralRespirationFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_terapias_deglucion_atipica) {
            AtipicaDeglucionFragment fragment = new AtipicaDeglucionFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_terapias_fortalecimiento_musculos) {
            StrengthMusclekFragment fragment = new StrengthMusclekFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
}
