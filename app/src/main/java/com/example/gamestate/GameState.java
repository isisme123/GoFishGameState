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
    public List<Card> deck;
    public List<Card> playerHands; //Map of the player ID to their hand of cards
    public List<Card> opponentHands;
    //private Map<Integer, Integer> playerScores; // ..scores?!
    private int playerScore;
    private int opponentScore;
    private boolean gameOver;

    // Constructor
    public GameState() {
        currentPlayerIndex = 0;
        deck = createDeck();
        //deck = new ArrayList<>();
        playerScore = 0;
        opponentScore = 0;
        //playerHands = NULL;
//        playerHands = new HashMap<>();
//        playerHands.put(0, new ArrayList<Card>());
//        playerHands.put(1, new ArrayList<Card>());
        dealCards(playerHands);
        dealCards(opponentHands);
//        playerScores = new HashMap<>();
//        playerScores.put(0, 0);
//        playerScores.put(1, 0);
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

        // Get the current player index
        public int getCurrentPlayerIndex () {
            return currentPlayerIndex;
        }

        // Set the current player index
        public void setCurrentPlayerIndex ( int currentPlayerIndex){
            this.currentPlayerIndex = currentPlayerIndex;
        }

        // Get the deck
        public List<Card> getDeck () {
            return deck;
        }

        // Set the deck
        public void setDeck (List <Card> deck) {
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
        //"StringBuilder" google that!!!!
//        @Override
//        public String toString () {
//            //add the current player index and deck to the output string.
//            String output = "Current Player Index: " + currentPlayerIndex + "\n";
//            output += "Deck: " + deck + "\n";
//            for (int i = 0; i < NUM_PLAYERS; i++) {
//                output += "Player " + i + " Hand: ";
//                List<Card> hand = playerHands.get(i);
//                for (int j = 0; j < hand.size(); j++) {
//                    output += hand.get(j);
//                    if (j != hand.size() - 1) {
//                        output += ", ";
//                    }
//                }
//                output += "\n";
//                output += "Player " + i + " Score: " + playerScore.get(i) + "\n";
//            }
//            output += "Game Over: " + gameOver + "\n";
//            return output;
//        }
//    }
    }


