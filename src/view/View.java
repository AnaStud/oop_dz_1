package view;

import controller.Main;
import heroes.BaseHero;
import java.util.Collections;

public class View {
    private static int step = 1;
    private static int l = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    private static String getChar(int x, int y){
        String out = "| ";
        for (BaseHero human: Main.allTeam) {
            if (human.getX() == x && human.getY() == y){
                if (human.getHp() == 0) {
                    out = "|" + (AnsiColors.ANSI_RED + human.getName().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
                if (Main.team1.contains(human)) out = "|" + (AnsiColors.ANSI_GREEN + human.getName().charAt(0) + AnsiColors.ANSI_RESET);
                if (Main.team2.contains(human)) out = "|" + (AnsiColors.ANSI_BLUE + human.getName().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    public static void view() {
        if (step == 1){
            System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        }
        step++;
        Main.allTeam.forEach((v) -> l = Math.max(l, v.toString().length()));
        System.out.print("_".repeat(l*2));
        System.out.println();
        System.out.print(top10 + "    ");
        System.out.print("Green side");
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l-9));
        System.out.println(":\tBlue side");
        for (int i = 0; i < 10; i++) {
            System.out.print(getChar(i, 0));
        }
        System.out.print("|    ");
        System.out.print(Main.team1.get(0));
        tabSetter(Main.team1.get(0).toString().length(), l);
        System.out.println(Main.team2.get(0));
        System.out.println(midl10);

        for (int j = 1; j < 9; j++) {
            for (int i = 0; i < 10; i++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(Main.team1.get(j));
            tabSetter(Main.team1.get(j).toString().length(), l);
            System.out.println(Main.team2.get(j));
            System.out.println(midl10);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(getChar(i, 9));
        }
        System.out.print("|    ");
        System.out.print(Main.team1.get(9));
        tabSetter(Main.team1.get(9).toString().length(), l);
        System.out.println(Main.team2.get(9));
        System.out.println(bottom10);
    }
}
