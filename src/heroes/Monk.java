package heroes;

import java.util.ArrayList;

//Монах
public class Monk extends BaseHero {

    public Monk(Coordinate coordinates) {
        super(coordinates);
        this.strength = 10;
        this.weapon = 0;
        this.money = 0;
        this.initiative = 0;
    }

    @Override
    public void attack(BaseHero target) {
        System.out.printf("%s: Я не умею сражаться.\n", this.name);
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
        System.out.printf("%s: Я заработал 10 монет. Потратил 1 силу.\n", this.name);
    }

    @Override
    public String getInfo() {
        return "Монах: " + this.history;
    }
}
