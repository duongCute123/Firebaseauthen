package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class update extends AppCompatActivity {
    Button btn_update;
    EditText edit_new1,edit_new2;
    FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        firestore=FirebaseFirestore.getInstance();
        edit_new1=findViewById(R.id.edit_new1);
        edit_new2=findViewById(R.id.edit_new2);
        btn_update=findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname=edit_new1.getText().toString();
                String newnam=edit_new2.getText().toString();
                edit_new1.setText("");
                edit_new2.setText("");
                Map<String,Object> userDetail=new HashMap<>();
                userDetail.put("FirstName",newnam);
                firestore.collection("user")
                        .whereEqualTo("FirstName",firstname)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()){
                                    DocumentSnapshot documentSnapshot=task.getResult().getDocuments().get(0);
                                    String documentId=documentSnapshot.getId();
                                    firestore.collection("user")
                                            .document(documentId)
                                            .update(userDetail)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    Toast.makeText(update.this, "Caapjj nhật thành công", Toast.LENGTH_SHORT).show();
                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(update.this, "Lỗi cập nhật", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }else {
                                    Toast.makeText(update.this, "Faile", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}