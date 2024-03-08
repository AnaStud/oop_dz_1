import Heroes.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Крестьянин
        Peasant peasant = new Peasant();
        System.out.println(peasant);
        peasant.attack(peasant);
        peasant.heal(peasant);
        peasant.getMoney();
        System.out.println(peasant);

        //Разбойник
        Outlaw outlaw = new Outlaw();
        System.out.println(outlaw);
        outlaw.attack(outlaw);
        outlaw.heal(outlaw);
        outlaw.getMoney();
        System.out.println(outlaw);

        //Снайпер
        Sniper sniper = new Sniper();
        System.out.println(sniper);
        sniper.attack(sniper);
        sniper.heal(sniper);
        sniper.getMoney();
        System.out.println(sniper);

        //Колдун
        Magician magician = new Magician();
        System.out.println(magician);
        magician.attack(magician);
        magician.heal(magician);
        magician.getMoney();
        System.out.println(magician);

        //Копейщик
        Spearman spearman = new Spearman();
        System.out.println(spearman);
        spearman.attack(spearman);
        spearman.heal(spearman);
        spearman.getMoney();
        System.out.println(spearman);

        //Арбалетчик
        Crossbowman crossbowman = new Crossbowman();
        System.out.println(crossbowman);
        crossbowman.attack(crossbowman);
        crossbowman.heal(crossbowman);
        crossbowman.getMoney();
        System.out.println(crossbowman);

        //Монах
        Monk monk = new Monk();
        System.out.println(monk);
        monk.attack(monk);
        monk.heal(monk);
        monk.getMoney();
        System.out.println(monk);
    }
}