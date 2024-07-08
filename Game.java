import java.util.Arrays;

public class Game {
   private static int column = 3;
   private static int row = 3;
   private int[][] board = new int[column][row];
   private boolean thereisAwinner;
   private int winner;


   public Game(){
    for(int i = 0; i < column; i++){
        for(int j = 0; j < row; j++){
            board[i][j] = 0;
        }
    }
    this.thereisAwinner=false;

   }

public int checkValue(int row , int col){
    return board[row][col];
}

public void updateValue(int row , int col, int value){
     board[row][col] = value;
}

public boolean rowsWinning(){
        for(int i = 0 ; i < 3 ; i++){
        if (board[i][0] == 1 && board[i][1] == 1 && board[i][2] == 1) {
            setWinner(1);
            return true;
            
         
        } else if (board[i][0] == 2 && board[i][1] == 2 && board[i][2] == 2) {
            setWinner(2);
            return true;
        }
    }
        
    return false;

}

public boolean columnsWinning(){
        for(int i = 0 ; i < 3 ; i++){
        if (board[0][i] == 1 && board[1][i] ==1 && board[2][i] == 1) {
           setWinner(1);
           return true;
        } else if (board[0][i] == 2 && board[1][i] == 2 && board[2][i] == 2) {
            setWinner(2);
            return true;
        }
    }
    

    return false;
}


public boolean diagonalsWinning(){

    if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) {
        setWinner(1);
        return true;
    } else if (board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) {
        setWinner(2);
        return true;
    } else if (board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) {
        setWinner(1);
       return true;
    } else if (board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2) {
        setWinner(2);
        return true;
    }
    
    return false;
}


public boolean noOneWon(){
    for(int i = 0 ; i < 3 ; i ++){
         for(int j = 0 ; j < 3 ; j ++){
        if(board[i][j]==0){

       return false;
    }
    }
    }
    return true;
    
}

public int getColumn() {
    return column;
}
public void setColumn(int column) {
    this.column = column;
}
public int getRow() {
    return row;
}
public void setRow(int row) {
    this.row = row;
}
public int[][] getBoard() {
    return board;
}
public void setBoard(int[][] board) {
    this.board = board;
}

public boolean isThereisAwinner() {
    return thereisAwinner;
}

public void setThereisAwinner(boolean thereisAwinner) {
    this.thereisAwinner = thereisAwinner;
}

public int getWinner() {
    return winner;
}

public void setWinner(int winner) {
    this.winner = winner;
}


  
}
