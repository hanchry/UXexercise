package com.example.uxexercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    Toolbar toolbar;
    AppBarConfiguration appBarConfiguration;
    DrawerLayout drawerLayout;
    NavigationView navigationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupNavigation();
    }
    private void initViews() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationDrawer  = findViewById(R.id.navigation_drawer);
        toolbar = findViewById(R.id.main_menu);
    }

    private void setupNavigation() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        setSupportActionBar(toolbar);

        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.settings,
                R.id.help)
                .setOpenableLayout(drawerLayout)
                .build();


       //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
       NavigationUI.setupActionBarWithNavController(this, navController);
       NavigationUI.setupWithNavController(navigationDrawer, navController);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.person) {
            Toast.makeText(getApplicationContext(), "alien clicked", Toast.LENGTH_SHORT).show();
            return super.onOptionsItemSelected(item);
        }
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }

    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }


}