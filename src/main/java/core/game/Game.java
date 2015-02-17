
package core.game;

import java.util.Objects;

/**
 *
 * @author SanderP
 * @version 0.0.1
 */
public abstract class Game {
    protected String name;
    
    public Game(String name){
        this.name = name;
    }
    
    public abstract void start();
    public abstract void stop();
    public abstract void reset();
    
    @Override
    public abstract String toString();
    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();
}
