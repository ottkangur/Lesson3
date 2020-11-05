package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) throws FileNotFoundException {

        //ex1
        // exercise1();
        System.out.println();

        //ex2
        //exercise2(3);
        System.out.println();
        System.out.println();

        //ex3
        //exercise3(3,3);
        System.out.println();

        //ex4
        //System.out.println(fibonacci(12));
        System.out.println();

        //ex5

        //ex6
        exercise6();
        /**List<String> words = new ArrayList<String>();
        words.add("ab5"); //3
        words.add("cd1"); //2
        words.add("ef4"); //4
        words.add("gh2"); //1
        List<Integer> nr = new ArrayList<Integer>();
        nr.add(5);
        nr.add(1);
        nr.add(4);
        nr.add(2);
        System.out.println(words);
        for (int i = 0; i < words.size(); i++) {
            String temp;
            int min = nr.get(i);
            for (int j = 0 + i; j < nr.size(); j++) {
                if (nr.get(j) < nr.get(i)) {
                    temp = words.get(j);
                    min = nr.get(j);
                    words.remove(j);
                    nr.remove(j);
                    System.out.println(words);
                    System.out.println(nr);
                    words.add(i, temp);
                    nr.add(i, min);
                    System.out.println(words);
                    System.out.println(nr);
                }
            }
        }
        System.out.println(words);*/
    }

    public static void exercise1() {
        // TODO loo 10 elemendile täisarvude massiv
        // TODO loe sisse konsoolist 10 täisarvu
        // TODO trüki arvud välja vastupidises järiekorras
        int[] a = new int[10];
        System.out.println("Paku 10 arvu: ");
        for (int i = 0; i < 10; i++) {
            Scanner scanner = new Scanner(System.in);
            int line = scanner.nextInt();
            a[i] = line;
            //System.out.println(a[i]);
        }
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.println(a[i]);
        }
    }

    public static void exercise2(int x) {
        // TODO prindi välja x esimest paaris arvu
        // Näide:
        // Sisend 5
        // Väljund 2 4 6 8 10
        int väljund = 0;
        for (int i = 0; i < x; i++) {
            väljund += 2;
            System.out.print(väljund + " ");
        }
    }

    public static void exercise3(int x, int y) {
        // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
        // TODO näiteks x = 3 y = 3
        // TODO väljund
        // 1 2 3
        // 2 4 6
        // 3 6 9
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();   //tekitab taande pärast igat j-tsükli läbimist
        }
    }

    public static int fibonacci(int n) {
        // TODO
        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
        // Tagasta fibonacci jada n element

        int a = 0;
        int b = 1;
        int c = 0;
        //int[] jada = new int[n];
        if (n == 1) {
            return a;
        } else if (n == 2) {
            return b;
        } else {
            for (int i = 2; i < n; i++) {
                c = a + b;
                a = b;
                b = c;
                //jada[i] = c;
                //System.out.print(c + " ");
            }
            return c;
        }
    }

    public static void exercise5(int n) {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
        System.out.println(n);

    }

    public static void exercise6() throws FileNotFoundException {
        /*
            Kirjutada Java programm, mis loeb failist visits.txt sisse looduspargi külastajad erinevatel jaanuari päevadel ning
            a) sorteerib külastuspäevad külastajate arvu järgi kasvavalt ning prindib tulemuse konsoolile;
            b) prindib konsoolile päeva, mil külastajaid oli kõige rohkem.
            Faili asukoht tuleb programmile ette anda käsurea parameetrina.
         */

        File file = new File("visits.txt");
        Scanner scanner = new Scanner(file);
        List<String[]> visits = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        List<String> date = new ArrayList<>();
        while (scanner.hasNext()) {
            String visit = scanner.nextLine();
            String[] visitArr = visit.split(", ");
            visits.add(visitArr);           //list, kus üks rida on array, kus kpv ja külastajate nr omakorda Stringina
            count.add(Integer.parseInt(visitArr[1]));   //list, kus on kõik külastajate nrd
        }
        //System.out.println(count);
        for (int i = 0; i < visits.size(); i++) {
            String[] temp;
            int min;
            for (int j = 0 + i; j < count.size(); j++) {
                if (count.get(j) < count.get(i)) {
                    temp = visits.get(j);
                    min = count.get(j);
                    visits.remove(j);
                    count.remove(j);
                    visits.add(i, temp);
                    count.add(i, min);
                }
            }
        }
        for (int i = 0; i < visits.size(); i++){
            date.add(visits.get(i)[0]);     //list, kus on kpv-d ümberjärjestatult
        }
        //System.out.println(count);
        System.out.println(date);
        System.out.println();
        System.out.println("Kõige rohkem käis külastajaid " + date.get(date.size()-1));

        //String a = "dfg gdfg 232";
        //String[] b = a.split(" ");
        //System.out.println(b[0]);
        //System.out.println(b[1].trim());    //eemaldab kõik white-space'd (tühikud)
        //Visit visit = new Visit("visits.txt");

        //visits.sort(new Comparator<Visit>()){
        //  public int compare(visit 1, visit 2){
        //      return 0;
        //  }
        //}

        //b1 = 1;
        //b2 = 2;
        //if(b1.compareTo(b2) < 0){
        //  System.out.println("true");
        //}
        //output: -1; true
    }

    public static void exercise7() {
        // TODO arvuta kasutades BigDecimali 1.89 * ((394486820340 / 15 ) - 4 )
        BigDecimal a = new BigDecimal("1.89");
        BigDecimal b = new BigDecimal("394486820345");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");

        System.out.println(b.divide(c, 4, RoundingMode.HALF_UP));
    }

    public static void exercise8() {
        /*
        Failis nums.txt on üksteise all 150 60-kohalist numbrit.
        Kirjuta programm, mis loeks antud numbrid failist sisse ja liidaks need arvud kokku ning kuvaks ekraanil summa.
        Faili nimi tuleb programmile ette anda käsurea parameetrina.
        VASTUS:
        Õige summa: 77378062799264987173249634924670947389130820063105651135266574
         */
    }

    public static void exercise9() {
        /* TODO
        Sama mis eelmises ülesandes aga ära kasuta BigInt ega BigDecimal klassi
         */
    }


}