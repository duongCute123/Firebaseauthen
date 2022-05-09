package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText edit1,edit2;
    TextView txt1;
    Button btn_log;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit1=findViewById(R.id.edit_name);
        edit2=findViewById(R.id.edit_pass);
        txt1=findViewById(R.id.txt_regis);
        btn_log=findViewById(R.id.btn_log);
        auth=FirebaseAuth.getInstance();
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=edit1.getText().toString();
                String pass=edit2.getText().toString();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập lại pass",Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Login.this,Mainstart.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
    }
}