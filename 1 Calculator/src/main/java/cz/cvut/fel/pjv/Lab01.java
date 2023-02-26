package cz.cvut.fel.pjv;

import java.util.Scanner;

public class Lab01 {

    public void start(String[] args) {

        System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");

        String[] first_question = { "Zadej scitanec: ", "Zadej mensenec: ", "Zadej cinitel: ", "Zadej delenec: " };
        String[] second_question = { "Zadej scitanec: ", "Zadej mensitel: ", "Zadej cinitel: ", "Zadej delitel: " };

        // get operation
        Scanner in = new Scanner(System.in);
        int operation;
        if (in.hasNextInt()) {
            operation = in.nextInt() - 1;
            if (operation < 0 || operation > 3) {
                System.out.println("Chybna volba!");
                in.close();
                return;
            }
        } else {
            System.out.println("Chybna volba!");
            in.close();
            return;
        }

        // get first number
        System.out.println(first_question[operation]);
        double first;
        if (in.hasNextDouble()) {
            first = in.nextDouble();
        } else {
            System.out.println("Chybna volba!");
            in.close();
            return;
        }

        // get second number
        System.out.println(second_question[operation]);
        double second;
        if (in.hasNextDouble()) {
            second = in.nextDouble();
        } else {
            System.out.println("Chybna volba!");
            in.close();
            return;
        }

        // check on division by 0
        if (operation == 3 && second == 0) {
            System.out.println("Pokus o deleni nulou!");
            in.close();
            return;
        }

        // get amount of numbers after dot
        System.out.println("Zadej pocet desetinnych mist: ");
        int dot;
        if (in.hasNextInt()) {
            dot = in.nextInt();
            if (dot < 0) {
                System.out.println("Chyba - musi byt zadane kladne cislo!");
                in.close();
                return;
            }
        } else {
            System.out.println("Chybna volba!");
            in.close();
            return;
        }

        String form = "%." + dot + "f";

        double[] result = { first + second, first - second, first * second, first / second };

        String[] resultForm = {
                form + " + " + form + " = " + form,
                form + " - " + form + " = " + form,
                form + " * " + form + " = " + form,
                form + " / " + form + " = " + form,
        };

        System.out.printf(resultForm[operation] + '\n', first, second, result[operation]);

        in.close();
    }
}