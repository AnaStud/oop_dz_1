package Heroes;

//Арбалетчик
public class Crossbowman extends BaseHero {

    public Crossbowman() {
        super();
        this.strength = 80;
        this.weapon = 80;
        this.money = 100;
    }

    @Override
    public void getMoney() {
        this.money += 100;
        this.weapon -= 1;
        System.out.printf("%s: Я заработал 100 монет. Потратил 1 оружие.\n", this.name);
    }
}
