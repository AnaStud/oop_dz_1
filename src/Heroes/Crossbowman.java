package Heroes;
import java.util.ArrayList;
//Арбалетчик
public class Crossbowman extends BaseHero {

    public Crossbowman(Coordinate coordinates) {
        super(coordinates);
        this.strength = 80;
        this.weapon = 80;
        this.money = 100;
        this.initiative = 3;
    }

    @Override
    public void getMoney() {
        this.money += 100;
        this.weapon -= 1;
        System.out.printf("%s: Я заработал 100 монет. Потратил 1 оружие.\n", this.name);
    }

    @Override
    public void step(ArrayList<BaseHero> opponents, ArrayList<BaseHero> friends) {
        if (this.hp > 0 && this.weapon > 0) {
            BaseHero closestOpponent = findClosestElement(opponents);
            attack(closestOpponent);
            this.weapon--;
        }
    }
}
