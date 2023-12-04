package com.lorenkontic.luckynumberapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonLuck;
    EditText editTextName;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if(itemId==R.id.action_home){
            Toast.makeText(this, "You selected Home", Toast.LENGTH_SHORT).show();
            
        } else if (itemId == R.id.action_search) {
            Toast.makeText(this, "You selected search", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLuck = findViewById(R.id.button_luck);
        editTextName = findViewById(R.id.edit_text_name);




        buttonLuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = editTextName.getText().toString();
                if (userName.isEmpty()) {
                    Toast toast = Toast.makeText(MainActivity.this, "Please enter a name", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Intent i = new Intent(getApplicationContext(),
                            LuckyNumberActivity.class);

                    // Passing the name to second activity
                    i.putExtra("name", userName);
                    startActivity(i);
                }
            }
        });


    }

}