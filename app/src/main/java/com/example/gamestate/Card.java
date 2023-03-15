package com.example.gamestate;

public class Card {
    // Constants
//    public static final int SPADES = 0;
//    public static final int HEARTS = 1;
//    public static final int CLUBS = 2;
//    public static final int DIAMONDS = 3;
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    // Instance variables
    //private int suit;
    private int rank;

    // Constructor
    public Card(int rank) {
        //this.suit = suit;
        this.rank = rank;
    }

    public Card(Card c) {
        this.rank = c.rank;
    }
    // Deep Constructor


    // Get the suit
    //public int getSuit() {
        //return suit;
    //}

    // Get the rank
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
//        String suitString;
//        if (suit == SPADES) {
//            suitString = "S";
//        } else if (suit == HEARTS) {
//            suitString = "H";
//        } else if (suit == CLUBS) {
//            suitString = "C";
//        } else {
//            suitString = "D";
//        }
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
