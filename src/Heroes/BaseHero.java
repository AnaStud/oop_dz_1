package Heroes;
import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements Stepable {
    protected static int id;
    protected static Random random;
    protected String name; //имя
    protected int hp; //здоровье
    protected int maxHp; //максимальное здоровье
    protected int strength; //сила
    protected int weapon; //оружие
    protected int money; //деньги
    protected Coordinate coordinates; //положение на поле (координаты)

    public int initiative; //инициатива

    static {
        BaseHero.id = 0;
        BaseHero.random = new Random();
    }
    public BaseHero(Coordinate coordinates) {
        this.name = String.format("%s_%d", this.getClass().getSimpleName(), ++BaseHero.id);
        this.hp = 100;
        this.maxHp = 100;
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return String.format("%s: Здоровье: %d, Сила: %d, Оружие: %d, Деньги: %d",
                                this.name, this.hp, this.strength, this.weapon, this.money);
    }

    public String getName() {
        return this.name;
    }
    public int getX() {
        return this.coordinates.x;
    }
    public int getY() {
        return this.coordinates.y;
    }

    public String getCoordinates() {
        return " (" + String.valueOf(coordinates.x) + ":" + String.valueOf(coordinates.y) + ")";
    }

    public BaseHero findClosestElement(ArrayList<BaseHero> opponents) {

        BaseHero closestHero = opponents.getFirst();
        double minDistance = this.coordinates.calculateDistance(closestHero.getX(), closestHero.getY());

        for (BaseHero hero : opponents) {
            double distance = this.coordinates.calculateDistance(hero.getX(), hero.getY());
            if (distance < minDistance) {
                minDistance = distance;
                closestHero = hero;
            }
        }

        return closestHero;
    }

    public void goToOpponent(BaseHero closestOpponent, ArrayList<BaseHero> friends) {
        double dX = closestOpponent.getX() - this.getX();
        double dY = closestOpponent.getY() - this.getY();

        if (Math.abs(dX) > Math.abs(dY)) {
            this.coordinates.stepX(dX > 0, friends);
            System.out.println("Шагнул по оси Х " + this.getCoordinates());
        } else {
            this.coordinates.stepY(dY > 0, friends);
            System.out.println("Шагнул по оси Y " + this.getCoordinates());
        }
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

    public abstract void step(ArrayList<BaseHero> opponents, ArrayList<BaseHero> friends);
}
