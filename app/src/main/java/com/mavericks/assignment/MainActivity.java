package com.mavericks.assignment;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.mavericks.assignment.adapter.UserAdapter;
import com.mavericks.assignment.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<User> users;
    private RecyclerView rvUserNames;
    private FloatingActionButton fabAddUser;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        papulateView();
        papulateList();
        papulateRecyclerView();
    }

    private void papulateView(){
        rvUserNames  = (RecyclerView) findViewById(R.id.rv_userNames);
        fabAddUser  = (FloatingActionButton) findViewById(R.id.fab_addUser);
        fabAddUser.setOnClickListener(this);
    }

    private void papulateList(){
        users = new ArrayList<>();
        users.add(new User("Tabassum", "Latif"));
        users.add(new User("mobin", "Sheikh"));
        users.add(new User("Muhammad", "Jabbar"));
        users.add(new User("Ali", "amin"));
        users.add(new User("Nouman", "Sabir"));
    }

    private void papulateRecyclerView(){
        userAdapter = new UserAdapter(users);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvUserNames.setLayoutManager(mLayoutManager);
        rvUserNames.setItemAnimator(new DefaultItemAnimator());
        rvUserNames.setAdapter(userAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_addUser:
                showAddUserDialog();
                break;
        }
    }

    private void showAddUserDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
        final View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_user, null);
        dialogBuilder.setView(dialogView);
        final EditText edtFirstName = (EditText) dialogView.findViewById(R.id.edtFirstName);
        final EditText edtLastName = (EditText) dialogView.findViewById(R.id.edtLastName);
        dialogBuilder.setTitle("Add User");
        dialogBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if(!edtFirstName.getText().equals("")){
                    if(!edtLastName.getText().equals("")){
                        users.add(new User(edtFirstName.getText().toString(), edtLastName.getText().toString()));
                    }else{
                        edtLastName.setError("Enter last name");
                    }
                }else{
                    edtFirstName.setError("Enter first name");
                }

                return;
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                return;
            }
        });
        dialogBuilder.setCancelable(false);
        AlertDialog alertDialog = dialogBuilder.create();

        alertDialog.show();
    }
}
