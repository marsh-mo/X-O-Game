import java.awt.*;


import javax.swing.*;
import java.awt.event.ActionListener;


public class GameView extends JFrame  {
    private JLabel[][] GuiRowsCloumns;
    private JPanel GuiBoard;
    private GameController gameSetting;
    private ImageIcon images = new ImageIcon("Icon.jpeg");
    private Actions actions;
    private ImageIcon  pieceImage;
    private winningNotifi  winningNotifi;
    


    GameView(GameController gameSetting ){
        this.gameSetting = gameSetting;
        this.winningNotifi = new winningNotifi(this,gameSetting,this);
        Start();
        addAction();
        
    }


    public void addAction(){
        for(int i = 0 ; i <3; i++){
            for(int j = 0 ; j <3; j++){
                GuiRowsCloumns[i][j].addMouseListener(new Actions(gameSetting, this, i, j) );
            }
        }
    }

    public void Start() {
        setTitle("MareshXO");
        GuiBoard = new JPanel();
        GuiBoard.setLayout(new GridLayout(3,3));
        GuiRowsCloumns = new JLabel[gameSetting.column()][gameSetting.row()];
        for (int i = 0; i < gameSetting.column(); i++) {
            for (int j = 0; j < gameSetting.row(); j++) {
                GuiRowsCloumns[i][j] = new JLabel();
                GuiRowsCloumns[i][j].setHorizontalAlignment(JLabel.CENTER);
                GuiRowsCloumns[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(68,68,68),4));   
                GuiBoard.add(GuiRowsCloumns[i][j]);


            }
        }

       
        
        setSize(500, 500);
        add(GuiBoard);
        setIconImage(images.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
        
        

    }


    public void updateScreen(){
        for(int i = 0 ; i <3; i++){
            for(int j = 0 ; j <3; j++){
              updateCellIcon(GuiRowsCloumns[i][j], i, j);
            }
        }

        if(gameSetting.finishTheGame()||gameSetting.noOneWon()){
            winningNotifi.updatetheWinner();
            winningNotifi.display();
        }
    }

      public Image resizePieces(ImageIcon image) {//this function will resize the images
        try {
            Image originalImage = image.getImage();
            int newWidth = 70;
            int newHeight = 70;
            return originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String setIcon(int row , int col){
        return getImagePath(gameSetting.checkValue(row, col)); 
    }

    

       private void updateCellIcon(JLabel cell, int row, int col) {
          pieceImage = new ImageIcon(setIcon(row, col));
          cell.setIcon(new ImageIcon(resizePieces(pieceImage)));
        
    }



    public String getImagePath(int value) {
        if (value==1) {
            return "x.png";
        }else if(value==2){
            return "o.png";
        }
        return "";
    }
    

}