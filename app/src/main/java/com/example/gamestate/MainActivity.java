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
                // Perform action here





                // Resets editText
                editText.setText("");

                // First Instance
                GameState firstInstance = new GameState();

                // Second Instance
                GameState secondInstance = new GameState(firstInstance);

                // Calling each method
                firstInstance.askForCard(firstInstance.getCurrentPlayerIndex(), 0);
                editText.append("Player " + firstInstance.getCurrentPlayerIndex() + "asked for a " + "\n");
                    // Is there a getter for the card or something? Because I would theoretically use it here

                firstInstance.drawCard(firstInstance.getCurrentPlayerIndex());
                editText.append("Player " + firstInstance.getCurrentPlayerIndex() + "drew a " + "\n");
                    // And here too

                firstInstance.goFish(firstInstance.getCurrentPlayerIndex());
                editText.append("Player " + firstInstance.getCurrentPlayerIndex() +
                        "drew from the Go Fish pile!\n");

                firstInstance.isGameOver();
                editText.append("GAME OVER!\n");

                // Third Instance
                GameState thirdInstance = new GameState();

                // Fourth Instance
                GameState fourthInstance = new GameState(thirdInstance);

                // Calling toString method on second and fourth instances
                editText.append(secondInstance.toString()+"\n");
                editText.append(fourthInstance.toString()+"\n");






                EditText edit_text = (EditText) findViewById(R.id.edit_text);
                //Printing the current state of the Go Fish game
                GameState gameState = new GameState();
                String printState = "The game state is: " + gameState.toString();
                Log.d("Go Fish", printState);
            }
        });
    }
}