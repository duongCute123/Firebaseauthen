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

public class delete extends AppCompatActivity {
    EditText edit_f;
    Button btn_delete;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        db=FirebaseFirestore.getInstance();
        edit_f=findViewById(R.id.edit_f);
        btn_delete=findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname=edit_f.getText().toString();
                edit_f.setText("");
                db.collection("user")
                        .whereEqualTo("FirstName",firstname)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                DocumentSnapshot documentSnapshot=task.getResult().getDocuments().get(0);
                                String docmentId=documentSnapshot.getId();
                                if (task.isSuccessful()){
                                    db.collection("user")
                                            .document(docmentId)
                                            .delete()
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    Toast.makeText(delete.this, "Đã xóa nhé", Toast.LENGTH_SHORT).show();
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Toast.makeText(delete.this, "Lỗi thêm", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                }
                                else {
                                    Toast.makeText(delete.this, "Failse", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}