package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class them_du_lieu extends AppCompatActivity {
    FirebaseFirestore db;
    Button btn_them,btn_real;
    EditText edit_t1,edit_t2,edit_t3;
    static final String TAG="đọc dữ liệu trên real";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_du_lieu);
        db=FirebaseFirestore.getInstance();
        btn_them=findViewById(R.id.btn_them);
        edit_t1=findViewById(R.id.edit_t1);
        edit_t2=findViewById(R.id.edit_t2);
        edit_t3=findViewById(R.id.edit_t3);
        btn_real=findViewById(R.id.button_real);
        btn_real.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    db.collection("user")
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(them_du_lieu.this, "Lấy dữ liệu thành công", Toast.LENGTH_SHORT).show();
                                        for (QueryDocumentSnapshot documentSnapshot:task.getResult()){
                                            Log.d(TAG,documentSnapshot.getId()+documentSnapshot.getData());
                                        }

                                    }
                                    else {
                                        Toast.makeText(them_du_lieu.this, "Lỗi thêm dữ liệu", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
            }
        });
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname=edit_t1.getText().toString();
                String lastname=edit_t2.getText().toString();
                String age=edit_t3.getText().toString();
                Map<String,Object> user=new HashMap<>();
                user.put("FirstName",firstname);
                user.put("LastName",lastname);
                user.put("Age",age);
                db.collection("user")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(them_du_lieu.this, "Thêm thành công nhé", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(them_du_lieu.this, "Lỗi thêm duex liệu", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}