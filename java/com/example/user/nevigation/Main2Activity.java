package com.example.user.nevigation;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {
    Button button;
    EditText editText;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    String firstname;
    String lastname;
    String email;
    String password;
    String re_password;
    String branch;
    String phn;
    FirebaseAuth mAuth;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference=database.getReference();
    DatabaseReference databaseReference1=databaseReference.child("sumit");

   // String url="https://nischay.000webhostapp.com/new7.php";

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pre Register");
        button=findViewById(R.id.btn);
        editText=findViewById(R.id.et1);
        editText1=findViewById(R.id.et2);
        editText2=findViewById(R.id.et3);
        editText3=findViewById(R.id.et4);
        editText4=findViewById(R.id.et5);
        editText5=findViewById(R.id.et6);
        editText6=findViewById(R.id.et7);
        mAuth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstname=editText.getText().toString();
                lastname=editText1.getText().toString();
                email=editText2.getText().toString();
                phn=editText3.getText().toString();
                password=editText4.getText().toString();
                re_password=editText5.getText().toString();
                branch=editText6.getText().toString();
                if(firstname.isEmpty())
                {
                    editText.setError("first name can not be empty");
                    return;
                }
                if(lastname.isEmpty())
                {
                    editText1.setError("last name can not be empty");
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches())
                {
                    editText2.setError("enter valid emailid");
                    return;
                }
                if(password.isEmpty()||password.length()<=5)
                {
                    editText4.setError("min 5 char required");
                    return;
                }
                if(re_password.isEmpty()||re_password.length()<=5||!password.equals(re_password))
                {
                    editText5.setError("password did not match");
                    return;
                }
                if(phn.isEmpty()||phn.length()!=10)
                {
                    editText3.setError("invalid phn no");
                    return;
                }
                if(branch.isEmpty())
                {
                    editText6.setError("enter branch");
                    return;
                }


                final ProgressDialog progressDialog=ProgressDialog.show(Main2Activity.this,"registering","wait you are getting register",false);


                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    /*Toast.makeText(Main2Activity.this, "u have register succesfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Main2Activity.this,MainActivity.class));*/
                                    final String id=databaseReference1.push().getKey();
                                    databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            databaseReference1.child(id).child("firstname").setValue(firstname);
                                            databaseReference1.child(id).child("lastname").setValue(lastname);
                                            databaseReference1.child(id).child("email").setValue(email);
                                            databaseReference1.child(id).child("phn").setValue(phn);
                                            databaseReference1.child(id).child("password").setValue(password);
                                            databaseReference1.child(id).child("re_password").setValue(re_password);
                                            databaseReference1.child(id).child("branch").setValue(branch);
                                            progressDialog.dismiss();
                                            Toast.makeText(Main2Activity.this, "REGISTER SUCCESFULLY", Toast.LENGTH_SHORT).show();


                                        }


                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                            Toast.makeText(Main2Activity.this, "RE-try", Toast.LENGTH_SHORT).show();

                                        }
                                    });

                                } else {

                                    Toast.makeText(Main2Activity.this, task.getException().toString(),
                                            Toast.LENGTH_SHORT).show();

                                }


                            }
                        });



               /* StringRequest stringRequest=new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(),"register succesfully",Toast.LENGTH_LONG).show();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {



                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> map=new HashMap<String,String>();
                        map.put("firstname",firstname);
                        map.put("lastname",lastname);
                        map.put("email",email);
                        map.put("phn",phn);
                        return map;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);*/
                editText.setText("");
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
                editText6.setText("");
                //startActivity(new Intent(Main2Activity.this,MainActivity.class));


            }
        });
    }
}



