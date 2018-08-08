package com.example.user.nevigation;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView  navigationView;
    private DrawerLayout mDrawelayout;
    private ActionBarDrawerToggle mtoggle;
    AppBarLayout appBarLayout;
    Button button;
    EditText editText1;
    EditText editText2;
    FirebaseAuth mAuth;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn1);
        editText1 = findViewById(R.id.ete);
        editText2=findViewById(R.id.etp);
        mAuth = FirebaseAuth.getInstance();


        mDrawelayout=(DrawerLayout)findViewById(R.id.drawerlayout1);
        navigationView=findViewById(R.id.nv);
       appBarLayout=findViewById(R.id.appBar);
       getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getSupportActionBar().setTitle("HOME");


        mtoggle=new ActionBarDrawerToggle(this,mDrawelayout,R.string.open,R.string.close);
      //  mDrawelayout.addDrawerListner(mDrawelayout);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.a:
                        startActivity(new Intent(MainActivity.this,Main2Activity.class));
                        break;
                    case R.id.e:
                        startActivity(new Intent(MainActivity.this,Main3Activity.class));
                        break;
                    case R.id.f:
                        startActivity(new Intent(MainActivity.this,Main4Activity.class));
                        break;
                    case R.id.d:

                        Uri gmmIntentUri = Uri.parse("geo:0,0?q=29.9200,78.1230(gurukula university)");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                        break;
                    case R.id.c:
                        startActivity(new Intent(MainActivity.this,Main5Activity.class));
                        break;
                    case R.id.g:
                        startActivity(new Intent(MainActivity.this,Main6Activity.class));
                        break;



                }
                mDrawelayout.closeDrawer(navigationView);
                return true;

            }
        });
        mtoggle=new ActionBarDrawerToggle(this,mDrawelayout,R.string.open,R.string.close);
        mDrawelayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String s1 = editText1.getText().toString();
                String s2 = editText2.getText().toString();

              /*  if(!Patterns.EMAIL_ADDRESS.matcher(s2.trim()).matches())
                {
                    editText2.setError("enter email and password");
                    return;
                }*/
              if(s1.equals("") || s2.equals(""))
              {
                  editText1.setError("empty email or password");
                  return;
              }
                final ProgressDialog progressDialog=ProgressDialog.show(MainActivity.this,"loading","wait you are getting loging",false);
                mAuth.signInWithEmailAndPassword(s1, s2)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressDialog.dismiss();
                                    Toast.makeText(MainActivity.this, "u have login succsesfully", Toast.LENGTH_SHORT).show();
                                    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                    SharedPreferences.Editor editor = sharedPref.edit();
                                    editor.putString("LoggedInUser", s1);
                                    editor.putBoolean("loggedin",true);
                                    editor.commit();


                                } else {

                                    progressDialog.dismiss();
                                    Toast.makeText(MainActivity.this, task.getException().toString(),
                                            Toast.LENGTH_SHORT).show();

                                }


                            }
                        });
                editText1.setText("");
                editText2.setText("");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mtoggle.onOptionsItemSelected(item)){return true;}
            return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
