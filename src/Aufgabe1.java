import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class Aufgabe1 {
    final static int min = 0;
    final static int max = 5;
    public static float sumTimes = 0;


    public static void main(String[] args) throws FileNotFoundException {

// Umleitung der Ausgabe in die Datei Aufgabe1.txt
        System.setOut(new PrintStream(new FileOutputStream("Aufgabe1.txt")));
        System.out.println("Ausgabe für Aufgabe 1:");

// Aufrufe Ihres Algorithmus mit geeigneten Testdaten
        int rep = 5;
        run(rep, 6);
        System.out.println(sumTimes);
        System.out.println(rep);
        System.out.println(rep/2);
    }


    // nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

    public static int[] makeArray(int x){
        int[] array = new int[x];
        for(int i = 0;i<array.length;i++){
             array[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
        }
        return array;
    }

    public static boolean pressureIsOK(int[] values){
        for (int i = 0; i<values.length ; i++) {
            if (values[i] < 2) {
                sumTimes += (i+1);
                return false;
            }
        }
        sumTimes += (values.length);
        return true;
    }

    public static void run(int rep, int length){
        for (int i = 0; i<rep ;i++){
            pressureIsOK(makeArray(length));
        }
    }
}

//minimale Anzahl an Durchläufen = 1
//maximal Anzahl an Durchläufen = n
//durchschnittliche Anzahl = min+max/2 = (1+n)/2