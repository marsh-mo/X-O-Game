import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Actions extends MouseAdapter implements ActionListener{
     private GameController gameController;
     private GameView gameView;
     private int row, col;
     private winningNotifi winningNotifi;
    
     public Actions(GameController gameController ,GameView gameView ,int row , int col ){
        this.gameController = gameController;
        this.gameView = gameView;
        this.row = row;
        this.col = col;
     }

      public Actions(GameView gameView ,winningNotifi winningNotifi){
        this.gameView = gameView;
        this.winningNotifi = winningNotifi;    
     }

     @Override
    public void mouseClicked(MouseEvent e) {
        
      if(!gameController.alreadyClicked(row, col)){
        gameController.finishTheGame();
        gameController.gameLogic(row, col);
        gameView.updateScreen();
}

    }

@Override
public void actionPerformed(java.awt.event.ActionEvent e) {
          JButton button = (JButton) e.getSource();
        if(button.getText().equals("Exit Game")){
            System.exit(0);
        }else if(button.getText().equals("New Game")){
            gameView.dispose();
            winningNotifi.dispose();
            Run run = new Run();
            run.main(null);
            
        }
}
    
}
