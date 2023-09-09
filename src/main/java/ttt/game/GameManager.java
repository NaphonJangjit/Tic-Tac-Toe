package ttt.game;

public class GameManager {
    private char[][] board;
    private char currentPlayer;

    public GameManager(){
        board = new char[3][3];
        currentPlayer = 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean isPlaced(int row, int col){
        if(board[row][col] != ' ') {
            return false;
        }else {
            board[row][col] = getCurrentPlayer();
            return true;
        }
    }

    public void next() {
        if(getCurrentPlayer() == 'X'){
            setCurrentPlayer('O');
        }else if(getCurrentPlayer() == 'O'){
            setCurrentPlayer('X');
        }
    }

    public boolean checkWin() {
        for(int i = 0; i < 3; i++){
            if((getBoard()[i][0] == currentPlayer && getBoard() [i][1] == currentPlayer && getBoard()[i][2] == currentPlayer) || (getBoard()[0][i] == currentPlayer && getBoard() [1][i] == currentPlayer && getBoard()[2][i] == currentPlayer) || (getBoard()[0][0] == currentPlayer && getBoard() [1][1] == currentPlayer && getBoard()[2][2] == currentPlayer) || (getBoard()[0][2] == currentPlayer && getBoard() [1][1] == currentPlayer && getBoard()[2][0] == currentPlayer)){
                return true;
            }
        }
        return false;
    }

    public boolean checkDraw() {
        int cnt = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(getBoard()[i][j] != ' ') cnt++;
            }
        }

        if(cnt != 9) return false;

        return true;

    }

    public void reset(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
             getBoard()[i][j] = ' ';
            }
        }
    }

    private void setBoard(char[][] board) {
        this.board = board;
    }
}
