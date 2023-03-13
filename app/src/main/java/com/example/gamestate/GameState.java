package com.example.gamestate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameState {
    // Constants
    public static final int NUM_PLAYERS = 2;
    public static final int NUM_CARDS = 52;
    public static final int HAND_SIZE = 7;

    // Instance variables
    private int currentPlayerIndex; //player who's turn it is
    private List<Card> deck;
    private List<Card> playerHands; //Array list of players cards

    private List<Card> opponentDeck; //Array list of opponent cards
    private int yourScore;
    private int opponentScore;
    private boolean gameOver;

    // Constructor
    public GameState() {
        currentPlayerIndex = 0;
        deck = createDeck();
        yourScore = 0;
        opponentScore = 0;
        dealCards(playerHands);
        dealCards(opponentDeck);
        gameOver = false;
    }

    // Create a new deck of cards
    private List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                deck.add(new Card(rank));
            }
        }
        return deck;
    }

    // Deal the cards to the players
    private void dealCards(List<Card> j) {
        for (int i = 0; i < HAND_SIZE; i++) {
            Random random = new Random();
            int k = random.nextInt(deck.size());
            j.add(deck.get(k));
            deck.remove(k);

        }
    }


    //This toString print the state of the game.
    //"StringBuilder" google that!!!!
    @Override
    public String toString() {
        //add the current player index and deck to the output string.
        String output = "Current Player Index: " + currentPlayerIndex + "\n";
        output += "Deck: " + deck + "\n";
        for (int i = 0; i < NUM_PLAYERS; i++) {
            output += "Player " + i + " Hand: ";
            List<Card> hand = playerHands.get(i);
            for (int j = 0; j < hand.size(); j++) {
                output += hand.get(j);
                if (j != hand.size() - 1) {
                    output += ", ";
                }
            }
            output += "\n";
            output += "Player " + i + " Score: " + playerScores.get(i) + "\n";
        }
        output += "Game Over: " + gameOver + "\n";
        return output;
    }
}

