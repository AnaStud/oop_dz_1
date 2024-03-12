import Heroes.*;
import java.util.ArrayList;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        ArrayList<BaseHero> team1 = createTeam("Team 1", 0, random);
        System.out.println();
        ArrayList<BaseHero> team2 = createTeam("Team 2", 3, random);
        System.out.println();

        for (BaseHero hero : team1) {
            if (hero instanceof Crossbowman) {
                BaseHero closest = ((Crossbowman) hero).findClosestElement(team2);
                System.out.println("Для " + hero.getName() + " ближайший соперник " + closest.getName());
            }
        }

    }

    public static ArrayList<BaseHero> createTeam(String teamName, int index, Random random) {

        ArrayList<BaseHero> team = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Coordinate coordinates = new Coordinate(0, i); // Команда 1 находится в левой части поля
            team.add(randomHero(index, random, coordinates));
        }

        System.out.println(teamName + ":");
        for (BaseHero hero : team) {
            System.out.println(hero.getName() + hero.getCoordinates());
        }

        return team;

    }

    public static BaseHero randomHero(int index, Random random, Coordinate coordinates) {

        BaseHero hero = null;

        int choice = index + random.nextInt(4);
        switch (choice) {
            case 0:
                hero = new Magician(coordinates); //Колдун
                break;
            case 1:
                hero = new Crossbowman(coordinates); //Арбалетчик
                break;
            case 2:
                hero = new Spearman(coordinates); //Копейщик
                break;
            case 3:
                hero = new Peasant(coordinates); //Крестьянин
                break;
            case 4:
                hero = new Sniper(coordinates); //Снайпер
                break;
            case 5:
                hero = new Monk(coordinates); //Монах
                break;
            case 6:
                hero = new Outlaw(coordinates); //Разбойник
                break;
        }

        return hero;

    }
}