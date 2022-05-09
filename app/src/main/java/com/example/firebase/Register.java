package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText edit12,edit13;
    Button btn_regis;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edit12=findViewById(R.id.edit_name1);
        edit13=findViewById(R.id.edit_pass1);
        btn_regis=findViewById(R.id.btn_regis);
        auth=FirebaseAuth.getInstance();
        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=edit12.getText().toString();
                String pass=edit13.getText().toString();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập pass",Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Tạo tài khoản thành công",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Register.this,Login.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Tạo tài khaonr thất bại",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}