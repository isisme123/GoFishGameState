package com.example.gamestate;

/**
 * This class has all the information about the card, which get used in the game
 * state class.
 * @author Isaela Timogene-Julien
 * @author Jude Reynolds
 * @author Alexis Nguyen
 * @author Heidi Pham
 * @version 1.0
 */

public class Card {
    // Constants
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    private int rank;

    // Constructor
    public Card(int rank) {
        this.rank = rank;
    }

    public Card(Card c) {
        this.rank = c.rank;
    }
    // Deep Constructor
    public int getRank() {
        return rank;
    }

    // Get the card's value
    public int getValue() {
        if (rank == ACE) {
            return 11;
        } else if (rank >= JACK && rank <= KING) {
            return 10;
        } else {
            return rank;
        }
    }

    // Get the card's string representation
    @Override
    public String toString() {
        String rankString;
        if (rank == ACE) {
            rankString = "A";
        } else if (rank == JACK) {
            rankString = "J";
        } else if (rank == QUEEN) {
            rankString = "Q";
        } else if (rank == KING) {
            rankString = "K";
        } else {
            rankString = Integer.toString(rank);
        }
        return rankString;
    }
}
