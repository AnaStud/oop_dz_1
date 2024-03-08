package Heroes;

//Снайпер
public class Sniper extends BaseHero {

    public Sniper() {
        super();
        this.strength = 100;
        this.weapon = 100;
        this.money = 0;
    }

    @Override
    public void getMoney() {
        this.money += 100;
        this.weapon -= 1;
        System.out.printf("%s: Я заработал 100 монет. Потратил 1 оружие.\n", this.name);
    }
}
