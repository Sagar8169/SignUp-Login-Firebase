package com.example.signuploginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import androidx.core.view.GravityCompat;
import com.google.android.material.navigation.NavigationView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView userName;
    private Button logout;
    private GoogleSignInClient gClient;
    private GoogleSignInOptions gOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        logout = findViewById(R.id.logout);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        // Set up Google Sign-In
        gOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gClient = GoogleSignIn.getClient(this, gOptions);

        GoogleSignInAccount gAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (gAccount != null) {
            String gName = gAccount.getDisplayName();
            userName.setText(gName);
        }

        // Set up the logout functionality
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Log out the user and navigate to LoginActivity
                        finish();
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    }
                });
            }
        });

        // Set up the toolbar
        setSupportActionBar(toolbar);

        // Set up the Drawer Layout and Toggle Button
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Handle Navigation Menu Item Clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            Intent intent;
            if (item.getItemId() == R.id.nav_home) {
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.about_us) {
                // Redirect to the About Us page
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bookfather.in/about-page/"));
                startActivity(intent);
            } else if (item.getItemId() == R.id.contact_us) {
                // Redirect to the Contact Us page
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bookfather.in/contact-us/"));
                startActivity(intent);
            } else if (item.getItemId() == R.id.privacy_policy) {
                // Redirect to the Privacy Policy page
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bookfather.in/privacy-policy/"));
                startActivity(intent);
            } else if (item.getItemId() == R.id.share_app) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this app!");
                startActivity(Intent.createChooser(shareIntent, "Share App"));
            } else if (item.getItemId() == R.id.rate_app) {
                Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName()));
                startActivity(rateIntent);
            } else if (item.getItemId() == R.id.our_website) {
                // Redirect to the main website
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bookfather.in"));
                startActivity(intent);
            } else if (item.getItemId() == R.id.nav_logout) {
                logout();
            }
            drawerLayout.closeDrawer(GravityCompat.START); // Close the drawer
            return true;
        });




        // Find the LinearLayout for subjects 1 to 8 and set click listeners
        for (int i = 1; i <= 8; i++) {
            int resId = getResources().getIdentifier("subject" + i, "id", getPackageName());
            LinearLayout subject = findViewById(resId);

            final int index = i;

            if (subject != null) {
                subject.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent;
                        switch (index) {
                            case 1:
                                intent = new Intent(MainActivity.this, ChapterActivity1.class);
                                break;
                            case 2:
                                intent = new Intent(MainActivity.this, ChapterActivity2.class);
                                break;
                            case 3:
                                intent = new Intent(MainActivity.this, ChapterActivity3.class);
                                break;
                            case 4:
                                intent = new Intent(MainActivity.this, ChapterActivity4.class);
                                break;
                            case 5:
                                intent = new Intent(MainActivity.this, ChapterActivity5.class);
                                break;
                            case 6:
                                intent = new Intent(MainActivity.this, ChapterActivity6.class);
                                break;
                            case 7:
                                intent = new Intent(MainActivity.this, ChapterActivity7.class);
                                break;
                            case 8:
                                intent = new Intent(MainActivity.this, ChapterActivity8.class);
                                break;
                            default:
                                return;
                        }
                        startActivity(intent);
                    }
                });
            }
        }
    }

    private void logout() {
        gClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
