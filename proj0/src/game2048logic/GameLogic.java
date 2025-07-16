package game2048logic;

import game2048rendering.Side;

import com.google.common.truth.Truth;


/**
 * @author  Josh Hug
 */
public class GameLogic {
    /** Moves the given tile up as far as possible, subject to the minR constraint.
     *
     * @param board the current state of the board
     * @param r     the row number of the tile to move up
     * @param c -   the column number of the tile to move up
     * @param minR  the minimum row number that the tile can land in, e.g.
     *              if minR is 2, the moving tile should move no higher than row 2.
     * @return      if there is a merge, returns the 1 + the row number where the merge occurred.
     *              if no merge occurs, then return 0.
     */
    public static int moveTileUpAsFarAsPossible(int[][] board, int r, int c, int minR) {
        // TODO: Fill this in in tasks 2, 3, 4
        while (r > minR) {
            if (board[r-1][c] == 0) {
                board[r-1][c] = board[r][c];
                board[r][c] = 0;
                r = r - 1;
            } else if (board[r-1][c] != 0) {
                if (board[r-1][c] == board[r][c]){
                    board[r-1][c] = 2 * board[r-1][c];
                    board[r][c] = 0;
                    return r;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return 0;
    }

    /**
     * Modifies the board to simulate the process of tilting column c
     * upwards.
     *
     * @param board     the current state of the board
     * @param c         the column to tilt up.
     */

    public static void tiltColumn(int[][] board, int c) {
        // TODO: fill this in in task 5
        int minR = 0;
        for (int r = 1; r < board.length; r++) {
            if (board[r][c] != 0){
            int limitRow = moveTileUpAsFarAsPossible(board, r, c, minR);
            // 如果合并发生，则记录limitRow，并把minR赋值为这个limitRow
            if (limitRow != 0){
                minR = limitRow;
            }

            }
        }
    }

    /**
     * Modifies the board to simulate tilting all columns upwards.
     *
     * @param board     the current state of the board.
     */
    public static void tiltUp(int[][] board) {
        // TODO: fill this in in task 6
        for (int column = 0; column < board.length; column++) {
            tiltColumn(board, column);
        }

    }

    /**
     * Modifies the board to simulate tilting the entire board to
     * the given side.
     *
     * @param board the current state of the board
     * @param side  the direction to tilt
     */
    public static void tilt(int[][] board, Side side) {
        // TODO: fill this in in task 7
        if (side == Side.EAST) {
            MatrixUtils.rotateLeft(board);
            tiltUp(board);
            MatrixUtils.rotateRight(board);
        } else if (side == Side.WEST) {
            MatrixUtils.rotateRight(board);
            tiltUp(board);
            MatrixUtils.rotateLeft(board);
        } else if (side == Side.SOUTH) {
            MatrixUtils.rotateLeft(board);
            MatrixUtils.rotateLeft(board);
            tiltUp(board);
            MatrixUtils.rotateRight(board);
            MatrixUtils.rotateRight(board);
        } else {
            tiltUp(board);
        }
    }
}
