import java.util.Scanner;

public class GameController {
    private Game game;
    private int playerTurn;
    private int WinnerPlayer=0 ;

    public int checkValue(int row , int col){
       return game.checkValue(row, col);
    }

    public boolean alreadyClicked(int row , int col){
        if(checkValue(row, col)!=0){
            System.out.println("You already clicked this cell");
            setPlayerTurn(getPlayerTurn());
            return true;
        }
        return false;
      
    }


    public void gameLogic(int row , int col){
        if(!alreadyClicked(row, col)&&getPlayerTurn() == 1){
                game.updateValue(row, col,1);
            }
           
            else if(!alreadyClicked(row, col)&&getPlayerTurn() == 2){
                game.updateValue(row, col,2);
                 
            }
            if(getPlayerTurn()==1){
                setPlayerTurn(2);
                
                
            }else if(getPlayerTurn()==2){
                setPlayerTurn(1);
                
            }
    }

       public boolean finishTheGame(){
        if(game.rowsWinning()){
            
            setWinnerPlayer(game.getWinner());
             
           
            return true;
        }else if(game.columnsWinning()){
            
            setWinnerPlayer(game.getWinner());
           
            
            return true;
        }
        else if(game.diagonalsWinning()){
            
            setWinnerPlayer(game.getWinner());
             
    
            return true;
        }
        
        return false;

    }

    public boolean noOneWon(){
        return game.noOneWon();
    }

   


    GameController(Game game){
        this.game = game;
        this.playerTurn = 1;
        
    }

    

    public int column(){
       return game.getColumn();
        
    }
    public int row(){
        return game.getRow();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public int getWinnerPlayer() {
        return WinnerPlayer;
    }

    public void setWinnerPlayer(int winnerPlayer) {
        WinnerPlayer = winnerPlayer;
    }

    
    
}
