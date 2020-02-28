package com.company;

public class Task1 {


    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Should have 2 strings as deck of cards");
        }

        String deckA = args[0];
        String deckB = args[1];


        int result = new Task1().solution(deckA, deckB);
        System.out.println("Result: " + result);
    }


    public int solution(String A, String B) {
        int turnsCount = 0;

        if (A.length() != B.length()) {
            return -1;
        }

        for (int i = 0; i < A.length(); i++) {
            String drawA = Character.toString(A.charAt(i));
            String drawB = Character.toString(B.charAt(i));

            Rank moveA = getRankForMove(drawA);
            Rank moveB = getRankForMove(drawB);

            if (moveA != null && moveB != null) {
                if (moveA.value > moveB.value) {
                    turnsCount++;
                }
            }
        }

        return turnsCount;
    }

    private Rank getRankForMove(String draw) {
        for (Rank rank : Rank.values()) {
            if (rank.subtitle.equals(draw)) {
                return rank;
            }
        }

        return null;
    }

    public enum Rank {

        TWO(2, "2"),
        THREE(3, "3"),
        FOUR(4, "4"),
        FIVE(5, "5"),
        SIX(6, "6"),
        SEVEN(7, " 7"),
        EIGHT(8, "8"),
        NINE(9, "9"),
        T(10, "T"),
        J(11, "J"),
        Q(12, "Q"),
        K(13, "K"),
        A(14, "A");

        private final int value;
        private final String subtitle;

        Rank(int value, String subtitle) {
            this.value = value;
            this.subtitle = subtitle;
        }


    }
}
