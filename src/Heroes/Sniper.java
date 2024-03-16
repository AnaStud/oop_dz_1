package Heroes;

import java.util.ArrayList;

//Снайпер
public class Sniper extends BaseHero {

    public Sniper(Coordinate coordinates) {
        super(coordinates);
        this.strength = 100;
        this.weapon = 100;
        this.money = 0;
        this.initiative = 3;
    }

    @Override
    public void getMoney() {
        this.money += 100;
        this.weapon -= 1;
        System.out.printf("%s: Я заработал 100 монет. Потратил 1 оружие.\n", this.name);
    }

    @Override
    public void step(ArrayList<BaseHero> opponents) {

    }
}
