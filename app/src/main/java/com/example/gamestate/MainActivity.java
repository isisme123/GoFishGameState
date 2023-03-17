package com.example.gamestate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class has a GUI that displays a multi-line
 * EditText that fills most of the display except for a single button labeled
 * Run Test.
 * @author Isaela Timogene-Julien
 * @author Jude Reynolds
 * @author Alexis Nguyen
 * @author Heidi Pham
 * @version 1.0
 */

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
                // Resets editText
                editText.setText("");

                // First Instance
                GameState firstInstance = new GameState();

                // Second Instance
                GameState secondInstance = new GameState(firstInstance);

                // Calling each method
                firstInstance.askForCard(firstInstance.getCurrentPlayerIndex(), 0);
                editText.append("Player " + firstInstance.getCurrentPlayerIndex() + " asked for a " +
                       firstInstance.askForCard(1, 6) + "\n");

                firstInstance.drawCard(firstInstance.getCurrentPlayerIndex());
                editText.append("Player " + firstInstance.getCurrentPlayerIndex() +
                        " drew a " + firstInstance.drawCard(1) + "\n");
                    // And here too
                firstInstance.goFish(firstInstance.getCurrentPlayerIndex());
                editText.append("Player " + firstInstance.getCurrentPlayerIndex() +
                        " drew from the Go Fish pile!" + "\n");

                firstInstance.isGameOver();
                editText.append("The game is over!" + "\n");

                // Third Instance
                GameState thirdInstance = new GameState();

                // Fourth Instance
                GameState fourthInstance = new GameState(thirdInstance);

                // Calling toString method on second and fourth instances
                //editText.append(secondInstance.toString()+"\n");
                //editText.append(fourthInstance.toString()+"\n");
                String secondInstanceStr = secondInstance.toString();
                String fourthInstanceStr = fourthInstance.toString();

                //comparing secondInstance and fourthInstance
                if (secondInstanceStr.equals(fourthInstanceStr)) {
                    editText.append("The two strings are identical.\n");
                } else {
                    editText.append("The two strings are not identical.\n");
                }

                // Print both strings to the multi-line EditText
                editText.append("\n" + "secondInstance string: " + secondInstanceStr + "\n");
                editText.append("\n" + "fourthInstance string: " + fourthInstanceStr + "\n");

            }
        });
    }
}