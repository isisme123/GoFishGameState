package com.example.gamestate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameState {
    // Constants
    public static final int NUM_PLAYERS = 2;
    public static final int NUM_CARDS = 52;
    public static final int HAND_SIZE = 7;

    // Instance variables
    private int currentPlayerIndex; //player who's turn it is
    private List<Card> deck;
    private Map<Integer, List<Card>> playerHands; //Map of the player ID to their hand of cards
    private Map<Integer, Integer> playerScores; // ..scores?!
    private boolean gameOver;

    // Constructor
    public GameState() {
        currentPlayerIndex = 0;
        deck = createDeck();
        //deck = new ArrayList<>();
        playerHands = new HashMap<>();
        playerHands.put(0, new ArrayList<Card>());
        playerHands.put(1, new ArrayList<Card>());
        dealCards();
        playerScores = new HashMap<>();
        playerScores.put(0, 0);
        playerScores.put(1, 0);
        gameOver = false;
    }

    // Create a new deck of cards
    private List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }

    // Deal the cards to the players
    private void dealCards() {
        for (int i = 0; i < HAND_SIZE; i++) {
            for (int j = 0; j < NUM_PLAYERS; j++) {
                playerHands.get(j).add(deck.remove(0));
            }
        }
    }

    // Get the current player index
    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    // Set the current player index
    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    // Get the deck
    public List<Card> getDeck() {
        return deck;
    }

    // Set the deck
    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    // Get the player hands
    public Map<Integer, List<Card>> getPlayerHands() {
        return playerHands;
    }

    // Set the player hands
    public void setPlayerHands(Map<Integer, List<Card>> playerHands) {
        this.playerHands = playerHands;
    }

    // Get the player scores
    public Map<Integer, Integer> getPlayerScores() {
        return playerScores;
    }

    // Set the player scores
    public void setPlayerScores(Map<Integer, Integer> playerScores) {
        this.playerScores = playerScores;
    }

    // Check if the game is over
    public boolean isGameOver() {
        return gameOver;
    }

    // Set the game over state
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
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

