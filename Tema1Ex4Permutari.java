import java.util.Scanner;
import java.util.Arrays;


public class Tema1Ex4Permutari {
	public static void reverse(String[] permutare,int start, int sfarsit){
		while(start<sfarsit) {
			String aux= permutare[start];
			permutare[start]=permutare[sfarsit];
			permutare[sfarsit]=aux;
			start++;
			sfarsit--;
		}
	}
	
	
	public static String[] permutareaAnterioara(String[] permutare) {
		int i= permutare.length -1; // i este ultimul indice din tablou
		
		while((i >0) && (permutare[i-1].compareTo(permutare[i]) <= 0)) {// compara lexicografic. Returneaza o valoare <0 daca permutare[i-1] < permutare[i], O daca sunt egale si nr >0 daca permutare[i-1] are rang lexicografic mai mare decat permutare[o]
			i=i-1;
		}
		
		if(i==0) // daca i este 0 inseamna ca este prima permutare (nu exista o permutare anterioara) 
			return null;
		
		// Cautam cel mai mare indice acolo unde permutare[j] < permutare[i-1]
		int j= permutare.length-1; // punem j sa fie ultimul indice
		
		while(permutare[j].compareTo(permutare[i-1]) >= 0) {
			j= j-1;
		}
		
		// interschimbat elementele de pe pozitia i-1 si j
		String aux= permutare[i-1];
		permutare[i-1]= permutare[j];
		permutare[j]=aux;
		
		// Inversam sirul
		reverse(permutare,i, permutare.length-1);
		
		return permutare;
	}
	
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Introducti elementele multimii S: ");
		String[] S= sc.nextLine().split(" "); // citeste elementele separate prin spatiu si le stocheaza in tabloul S
		
		System.out.println("Introduceti o permutare a lui S: ");
		String[] permutare=sc.nextLine().split(" ");
		
		String[] permAnt=permutareaAnterioara(permutare);
		
		if(permAnt == null) {
			System.out.println("Nu exista o permutare anterioara.");
		}
		else {
			System.out.println("Permutarea anterioara este: ");
			for(String element: permAnt) {
				System.out.print(element+" ");
			}
			
		}
		
		
	}

}
