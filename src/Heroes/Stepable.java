package Heroes;

import java.util.ArrayList;

public interface Stepable {
    public void step(ArrayList<BaseHero> opponents, ArrayList<BaseHero> friends);
}
