import java.awt.*;
import javax.swing.*;

public class winningNotifi extends JDialog {
    private JButton newGame , ExitGame;
    private GameController gameController;
    private JPanel buttonsContainer;
    private JLabel won;
    private GameView gameView;
    private ImageIcon image = new ImageIcon("Icon.jpeg");
   
    

   public winningNotifi(Frame parent,GameController gameController,GameView gameView){
    super((parent),"Game Over",true);
    this.gameController = gameController;
    this.gameView = gameView;
    
    Start();
   }


    public void Start(){
    
    setLayout(new BorderLayout());
    newGame = new JButton();
    ExitGame = new JButton();
    newGame.setFocusable(false);
    ExitGame.setFocusable(false);
    buttonsContainer = new JPanel();
    buttonsContainer.setLayout(new GridLayout(1,2));
    buttonsContainer.add(newGame);
    buttonsContainer.add(ExitGame);
    newGame.setText("New Game");
    ExitGame.setText("Exit Game");

    
    

            
        won = new JLabel("X Won");

        won.setHorizontalAlignment(JLabel.CENTER);
        add(won,BorderLayout.CENTER);
        
    

    add(buttonsContainer,BorderLayout.SOUTH);
    

    setTitle("Game Over");

    setSize(400, 300);
    setResizable(false);
    setIconImage(image.getImage());
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    
    newGame.addActionListener(new Actions(gameView, this));
    ExitGame.addActionListener(new Actions(gameView, this));

   }

   public void updatetheWinner(){
    if(gameController.getWinnerPlayer()==1){
        won.setText("X player has won the game");
    }else if(gameController.getWinnerPlayer()==2){
        won.setText("O player has won the game");
    }else if(gameController.noOneWon()){
        won.setText("No one has won!!");
    }
   }

   public void display() {
        setLocationRelativeTo(null); // Center the dialog
        setVisible(true);
    }

   
}
