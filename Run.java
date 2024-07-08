import javax.swing.JFrame;

public class Run  {
    public static void main(String[] args) {
        Game gg = new Game();
        GameController g = new GameController(gg);
        GameView v = new GameView(g);
        
    }
}
