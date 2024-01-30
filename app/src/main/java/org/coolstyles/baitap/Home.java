package org.coolstyles.baitap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//import adapter.ConstantAdapter;
import org.coolstyles.baitap.Constants;

public class Home extends AppCompatActivity {
    private RecyclerView rvContact;
    private Button showAlertDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        showAlertDialogButton = findViewById(R.id.showAlertDialogButton);
        rvContact = findViewById(R.id.rv_contact);

        //  initGUI();

        showAlertDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Custom.class);
                Alert.showAlertDialog(Home.this, intent);
            }
        });
    }


}
