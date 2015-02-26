package core.game;

import java.util.Objects;

/**
 *
 * @author SanderP
 * @version 0.0.1
 */

//TODO: add logging (slf4j)
public class GameController {
    private Game game;
    
    public GameController(final Game game){
        this.game = game;         
    }
    
    public void loadGame(Game game) {
        setGame(game);
    }
    
    public Game getGame() {
        return game;
    }

    /**
        Please use the loadGame function when changing the Game
     **/
    @Deprecated
    protected void setGame(Game game){
        this.game = game;
    }
    
    public void startGame(){
        if(game == null)
            return;
        
        game.start();
    }
    
    public void stopGame(){
        if(game == null)
            return;
        
        game.stop();
    }
    
    public void resetGame(){
        if(game == null)
            return;
        
        game.reset();
    }
    
    @Override
    public boolean equals(Object object){
        if(object instanceof GameController){
            GameController gc = (GameController) object;
            
            if(gc.game.equals(this.game)){
                return true;
            }
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.game);
        return hash;
    }
    
    @Override
    public String toString(){
        return "GameController { " + game.toString() + "}";
    }
}
