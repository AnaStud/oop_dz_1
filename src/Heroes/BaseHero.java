package Heroes;

import java.util.Random;
 
public abstract class BaseHero {
    protected static int id;
    protected static Random random;
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int strength;
    protected int weapon;
    protected int money;

    static {
        BaseHero.id = 0;
        BaseHero.random = new Random();
    }
    public BaseHero() {
        this.name = String.format("%s_%d", this.getClass().getSimpleName(), ++BaseHero.id);
        this.hp = 100;
        this.maxHp = 100;
    }

    @Override
    public String toString() {
        return String.format("%s: Здоровье: %d, Сила: %d, Оружие: %d, Деньги: %d",
                                this.name, this.hp, this.strength, this.weapon, this.money);
    }

    public String getName() {
        return this.name;
    }

    public void attack(BaseHero target) {
        int damage = BaseHero.random.nextInt(10, this.strength);
        target.getDamage(damage);
    }
    public void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        else {
            this.hp = 0;
        }
        System.out.printf("%s: Урон %d. Здоровье %d.\n", this.name, damage, this.hp);
    }

    public void heal(BaseHero target) {
        System.out.printf("%s: Я не умею лечить.\n", this.name);
    }

    public abstract void getMoney();
}
