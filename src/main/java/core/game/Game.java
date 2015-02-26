
package core.game;

import java.util.Objects;

import static core.game.Status.NEW;

/**
 *
 * @author SanderP
 * @version 0.0.1
 */
public abstract class Game {
    protected String name;
    protected Status status;
    
    public Game(String name){
        this.name = name;
        this.status = NEW;
    }
    
    public abstract void start();
    public abstract void stop();
    public abstract void reset();

    public String getName() {
        return name;
    }

    @Override
    public abstract String toString();
    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    public Status getStatus() {
        return status;
    }
}
