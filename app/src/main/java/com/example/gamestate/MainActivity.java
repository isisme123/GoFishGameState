package com.example.gamestate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button runTestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        runTestButton = findViewById(R.id.run_test_button);

        runTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EditText edit_text = (EditText) findViewById(R.id.edit_text);
//                //Printing the current state of the Go Fish game
//                GameState firstInstance = new GameState(); //creating firstInstance
//                String printState = "The game state is: " + firstInstance.toString();
//                GameState secondInstance = new GameState(firstInstance);


            }
        });
    }
}