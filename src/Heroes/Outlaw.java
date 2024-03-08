package Heroes;

//Разбойник
public class Outlaw extends BaseHero {

    public Outlaw() {
        super();
        this.strength = 50;
        this.weapon = 10;
        this.money = 0;
    }

    @Override
    public void getMoney() {
        this.money += 100;
        this.weapon -= 1;
        System.out.printf("%s: Я награбил 100 монет. Потратил 1 оружие.\n", this.name);
    }
}
