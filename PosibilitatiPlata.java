package Tema2TGC;
import java.util.Scanner;
/**
 * @author Elena Barbu
 */

public class PosibilitatiPlata {
	public static int numarPosibilitatiPlata(int suma, int[] a1) {
        int[] a2 = new int[suma + 1];
        a2[0] = 1; // o posibilitate pentru suma=0

        
        for (int el : a1) {
            for (int i = el; i <= suma; i++) {
                a2[i] += a2[i - el];
            }
        }

        return a2[suma];
    }

    public static void main(String[] args) {
        int suma;
        System.out.println("Introduceti suma: ");
        Scanner sc= new Scanner(System.in);
        suma=sc.nextInt();
        int[] bancnote = {1, 3, 5, 10, 25, 50};
        int rez = numarPosibilitatiPlata(suma, bancnote);
        System.out.println("Rezultat: "+ rez);
    }

}
