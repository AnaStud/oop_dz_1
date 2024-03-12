package Heroes;

//Колдун
public class Magician extends BaseHero {

    public Magician(Coordinate coordinates) {
        super(coordinates);
        this.strength = 50;
        this.weapon = 0;
        this.money = 0;
    }

    @Override
    public void heal(BaseHero target) {
        this.hp = Math.min(this.hp + this.strength, this.maxHp);
        System.out.printf("%s: Я восстановил здоровье у %s до %d.\n", this.name, target.getName(), this.hp);
    }

    @Override
    public void getMoney() {
        this.money += 10;
        this.strength -= 1;
        System.out.printf("%s: Я наколдовал 10 монет. Потратил 1 силу.\n", this.name);
    }
}
