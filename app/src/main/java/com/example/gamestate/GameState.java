package com.example.gamestate;

import android.util.Log;

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
    private int playerIndex; //player who's turn it is
    private int opponentIndex;
    public List<Card> deck;
    public List<Card> playerHands; //Map of the player ID to their hand of cards
    public List<Card> opponentHands;
    //private Map<Integer, Integer> playerScores; // ..scores?!
    private int playerScore;
    private int opponentScore;
    private boolean gameOver;

    // Constructor
    public GameState() {
        playerIndex = 0;
        opponentIndex = 0;
        deck = createDeck();
        playerScore = 0;
        opponentScore = 0;
        dealCards(playerHands);
        dealCards(opponentHands);
        gameOver = false;
    }

    // Create a new deck of cards
    private List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int rank = 1; rank <= 13; rank++) {
                deck.add(new Card(rank));
            }
        }
        return deck;
    }

    // Deal the cards to the players
    public void dealCards (List < Card > j) {
        for (int i = 0; i < HAND_SIZE; i++) {
            Random random = new Random();
            int k = random.nextInt(deck.size());
            j.add(deck.get(k));
            deck.remove(k);

        }
    }
    // Ask for a card
    public boolean askForCard(int playerIndex, int rank) {
        boolean found = false;
        if (playerIndex == this.playerIndex && rank > 0 && rank <= 13) {
            for (int i = 0; i < opponentHands.size(); i++) {
                if (opponentHands.get(i).getRank() == rank) {
                    playerHands.add(opponentHands.remove(i));
                    found = true;
                }
            }
            if (found) {
                if (checkForFour(playerHands, rank)) {
                    playerScore++;
                }
                return true;
            }
        }
        return false;
    }

    //Go fish to determine a legal move
    public boolean goFish(int playerIndex) {
        if (playerIndex == this.playerIndex) {
            Random random = new Random();
            int k = random.nextInt(deck.size());
            Card cardDrawn = deck.get(k);
            playerHands.add(cardDrawn);
            deck.remove(k);
            if (checkForFour(playerHands, cardDrawn.getRank())) {
                playerScore++;
            }
            return true;
        }
        return false;
    }

    // Check for four of a kind
    //helper method
    private boolean checkForFour(List<Card> hand, int rank) {
        int count = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getRank() == rank) {
                count++;
            }
        }
        return count == 4;
    }
    // Draw card from deck
    public boolean drawCard(int playerIndex) {
        if (playerIndex == this.playerIndex) {
            if (deck.size() > 0) {
                playerHands.add(deck.remove(0));
                return true;
            }
        }
        return false;
    }

    // Get the current player index
    public int getCurrentPlayerIndex () {
        return playerIndex;
    }

    // Set the current player index
    public void setCurrentPlayerIndex ( int currentPlayerIndex){
        this.playerIndex = currentPlayerIndex;
    }

    public int getOpponentIndex () {
        return opponentIndex;
    }

    // Set the current player index
    public void setOpponentIndex ( int opponentIndex){
        this.opponentIndex = opponentIndex;
    }

    // Get the deck
    public List<Card> getDeck () {
        return deck;
    }

    // Set the deck
    public void setDeck (List<Card> deck) {
        this.deck = deck;
    }

    // Get the player hands
    public List<Card> getPlayerHands () {
        return playerHands;
    }

    public List<Card> getOpponentHands(){
        return opponentHands;
    }

    // Set the player hands
    public void setPlayerHands (List<Card> playerHands) {
        this.playerHands = playerHands;
    }

    public void setOpponentHands(List<Card> opponentHands){
        this.opponentHands = opponentHands;
    }

    // Get the player scores
    public int getPlayerScore (int playerScore){
        return playerScore;
    }
    public int getOpponentScore () {
        return opponentScore;
    }

    // Set the player scores
    public void setPlayerScore (int playerScore){
        this.playerScore = playerScore;
    }

    // Check if the game is over
    public boolean isGameOver() {
        return gameOver;
    }

    // Set the game over state
    public void setGameOver(boolean gameOver){
        this.gameOver = gameOver;
    }

    //This toString print the state of the game.
    //String concatenation?! THIS MIGHT BE WRONG HEHE, IDK WHAT I'M DOING
    @Override
    public String toString() {
        return "GameState{" +
                "playerIndex=" + playerIndex +
                ", opponentIndex=" + opponentIndex +
                ", deck=" + deck +
                ", playerHands=" + playerHands +
                ", opponentHands=" + opponentHands +
                ", playerScore=" + playerScore +
                ", opponentScore=" + opponentScore +
                ", gameOver=" + gameOver +
                '}';
    }
}


