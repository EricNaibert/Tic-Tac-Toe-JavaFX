package com.github.ericnaibert.tictactoe;

public class GameBoard {

    public static char[][] board = new char[3][3];

    public static void gameBoard() {
        board[0][0] = ' '; board[0][1] = ' '; board[0][2] = ' ';
        board[1][0] = ' '; board[1][1] = ' '; board[1][2] = ' ';
        board[2][0] = ' '; board[2][1] = ' '; board[2][2] = ' ';
    }
}
