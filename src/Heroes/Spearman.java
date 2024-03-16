package Heroes;

import java.util.ArrayList;

//Копейщик
public class Spearman extends BaseHero {

    public Spearman(Coordinate coordinates) {
        super(coordinates);
        this.strength = 50;
        this.weapon = 10;
        this.money = 100;
        this.initiative = 2;
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
