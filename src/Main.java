import Heroes.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        ArrayList<BaseHero> team1 = createTeam("Team 1", 0, random);
        System.out.println();
        ArrayList<BaseHero> team2 = createTeam("Team 2", 3, random);
        System.out.println();

        ArrayList<BaseHero> moves = new ArrayList<>();
        moves.addAll(team1);
        moves.addAll(team2);

        moves.sort((hero1, hero2) -> hero2.initiative - hero1.initiative);

        //moves.forEach(hero -> System.out.println(hero.getName() + ", initiative = " + hero.initiative));
        for (BaseHero hero : moves) {
            if (hero instanceof Spearman) {
                System.out.println(hero.getName() + ", initiative = " + hero.initiative + hero.getCoordinates());

                ArrayList<BaseHero> friends;
                ArrayList<BaseHero> opponents;
                if (team1.contains(hero)) {
                    friends = team1;
                    opponents = team2;
                } else {
                    friends = team2;
                    opponents = team1;
                }

                for (int i = 0; i < 15; i++) {
                    hero.step(opponents, friends);
                }
                System.out.println(hero.getName() + ", initiative = " + hero.initiative + hero.getCoordinates());
            }
        }

    }

    public static ArrayList<BaseHero> createTeam(String teamName, int index, Random random) {

        ArrayList<BaseHero> team = new ArrayList<>();

        for (int i = 0; i < (index == 0 ? 10 : index); i++) { // Для проверки движения по оси Y
            Coordinate coordinates = new Coordinate(index * 3, i); // Команда 1 находится в левой части поля
            team.add(randomHero(index, random, coordinates));
        }

        System.out.println(teamName + ":");
        team.forEach(hero ->System.out.println(hero.getName() + hero.getCoordinates()));

        return team;

    }

    public static BaseHero randomHero(int index, Random random, Coordinate coordinates) {

        int choice = index + random.nextInt(4);

        return switch (choice) {
            case 0 -> new Magician(coordinates); //Колдун / Маг
            case 1 -> new Crossbowman(coordinates); //Арбалетчик / Лучник
            case 2 -> new Spearman(coordinates); //Копейщик / Пехота
            case 3 -> new Peasant(coordinates); //Крестьянин
            case 4 -> new Sniper(coordinates); //Снайпер
            case 5 -> new Monk(coordinates); //Монах
            case 6 -> new Outlaw(coordinates); //Разбойник / Вор
            default -> new Peasant(coordinates); //если что-то пошло не так, пусть будет крестьянин
        };

    }
}