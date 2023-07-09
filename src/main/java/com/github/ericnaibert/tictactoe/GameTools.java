package com.github.ericnaibert.tictactoe;
public class GameTools {

    public static void playerCheck(char[][] board, int pos) {
        switch (pos) {
            case 1 -> board[0][0] = 'X';
            case 2 -> board[0][1] = 'X';
            case 3 -> board[0][2] = 'X';
            case 4 -> board[1][0] = 'X';
            case 5 -> board[1][1] = 'X';
            case 6 -> board[1][2] = 'X';
            case 7 -> board[2][0] = 'X';
            case 8 -> board[2][1] = 'X';
            case 9 -> board[2][2] = 'X';
            default -> System.out.println("Enter a valid spot!");
        }

    }

    public static void cpuCheck(char[][] board, int cpuPos) {
        switch (cpuPos) {
            case 1 -> board[0][0] = 'O';
            case 2 -> board[0][1] = 'O';
            case 3 -> board[0][2] = 'O';
            case 4 -> board[1][0] = 'O';
            case 5 -> board[1][1] = 'O';
            case 6 -> board[1][2] = 'O';
            case 7 -> board[2][0] = 'O';
            case 8 -> board[2][1] = 'O';
            case 9 -> board[2][2] = 'O';
            default -> System.out.println("Enter a valid spot!");
        }

    }

    @SuppressWarnings("unused")
    public static void playableBoard(char[][] board) {
        int var2 = board.length;

        for (char[] strings : board) {
            for (int column = 0; column < board.length; ++column) {
                System.out.print(strings[column]);
            }

            System.out.print("\n");
        }

    }
}



