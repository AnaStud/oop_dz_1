package heroes;

import java.util.ArrayList;

public interface Stepable {
    void step(ArrayList<BaseHero> opponents, ArrayList<BaseHero> friends, int direction);

    String getInfo();
}
