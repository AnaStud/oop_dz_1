package controller;

import heroes.*;
import view.View;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static ArrayList<BaseHero> team1;
    public static ArrayList<BaseHero> team2;
    public static ArrayList<BaseHero> allTeam;
    public static void main(String[] args) {

        Random random = new Random();

        team1 = createTeam("Green", 0, random);
        System.out.println();
        team2 = createTeam("Blue", 3, random);
        System.out.println();

        allTeam = new ArrayList<>();
        allTeam.addAll(team1);
        allTeam.addAll(team2);

        allTeam.sort((hero1, hero2) -> hero2.initiative - hero1.initiative);

        boolean theEnd = false;
        View.view();
        for (int i = 0; i < 1000; i++) {
            for (BaseHero hero : allTeam) {
                if (team1.contains(hero)) {
                    hero.step(team2, team1, 1);
                    if (hero.isWinner(team2)) {
                        System.out.println("Команда Green победила!");
                        theEnd = true;
                        break;
                    }
                } else {
                    hero.step(team1, team2, -1);
                    if (hero.isWinner(team1)) {
                        System.out.println("Команда Blue победила!");
                        theEnd = true;
                        break;
                    }
                }
            }
            if (theEnd) { break; } else { View.view(); }
        }
    }

    public static ArrayList<BaseHero> createTeam(String teamName, int index, Random random) {

        ArrayList<BaseHero> team = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Coordinate coordinates = new Coordinate(index * 3, i); // Команда 1 находится в левой части поля
            team.add(randomHero(index, random, coordinates));
        }

//        System.out.println(teamName + ":");
//        team.forEach(hero ->System.out.println(hero.getName() + hero.getCoordinates()));

        return team;

    }

    public static BaseHero randomHero(int index, Random random, Coordinate coordinates) {

        int choice = index + random.nextInt(4);

        return switch (choice) {
            case 0 -> new Magician(coordinates  ); //Колдун / Маг
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