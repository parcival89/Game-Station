package core.speler;

/**
 * Created by SanderP on 18/02/2015.
 */
public abstract class Speler {
    protected String naam;

    protected Speler(String naam){
        this.naam = naam;
    }

    protected void setNaam(String naam){
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }
}
