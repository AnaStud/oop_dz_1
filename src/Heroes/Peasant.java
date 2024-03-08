package Heroes;

//Крестьянин
public class Peasant extends BaseHero {

    public Peasant() {
        super();
        this.strength = 10;
        this.weapon = 0;
        this.money = 0;
    }

    @Override
    public void attack(BaseHero target) {
        System.out.printf("%s: Я не умею сражаться.\n", this.name);
    }

    @Override
    public void getMoney() {
        this.money += 5;
        System.out.printf("%s: Я заработал 5 монет.\n", this.name);
    }
}
