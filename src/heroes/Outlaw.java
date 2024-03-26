package heroes;

import java.util.ArrayList;

//Разбойник
public class Outlaw extends BaseHero {

    public Outlaw(Coordinate coordinates) {
        super(coordinates);
        this.strength = 50;
        this.weapon = 10;
        this.money = 0;
        this.initiative = 2;
    }

    @Override
    public void getMoney() {
        this.money += 100;
        this.weapon -= 1;
        System.out.printf("%s: Я награбил 100 монет. Потратил 1 оружие.\n", this.name);
    }

    @Override
    public String getInfo() {
        return "Разбойник";
    }
}
