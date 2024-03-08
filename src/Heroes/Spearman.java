package Heroes;

//Копейщик
public class Spearman extends BaseHero {

    public Spearman() {
        super();
        this.strength = 50;
        this.weapon = 10;
        this.money = 100;
    }

    @Override
    public void getMoney() {
        this.money += 100;
        this.weapon -= 1;
        System.out.printf("%s: Я заработал 100 монет. Потратил 1 оружие.\n", this.name);
    }
}
