package heroes;

import java.util.ArrayList;

//Снайпер
public class Sniper extends BaseHero {

    public Sniper(Coordinate coordinates) {
        super(coordinates);
        this.strength = 100;
        this.weapon = 10;
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
    public void step(ArrayList<BaseHero> opponents, ArrayList<BaseHero> friends, int direction) {
        if (this.hp > 0 && this.weapon > 0) {
            BaseHero closestOpponent = findClosestElement(opponents);
            attack(closestOpponent);
            this.weapon--;
            this.history = "Я выстрелил в " + closestOpponent.getName() + ", потратил 1 патрон";
        } else {
            if (this.hp <= 0) {
                this.history =  "";
            } else {
                this.history =  "У меня закончились патроны";
                this.hp = 0;
            }
        }
    }

    @Override
    public String getInfo() {
        return "Снайпер: " + this.history;
    }
}
