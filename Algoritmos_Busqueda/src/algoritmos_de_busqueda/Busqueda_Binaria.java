package algoritmos_de_busqueda;

import java.util.Scanner;

public class Busqueda_Binaria {
	/* Este m�todo es eficaz con arrays de muchos elementos ordenados, 
	 * en arrays peque�os puede que sea menos eficiente que la b�squeda
	 * secuencial porque realiza m�s comparaciones aumentando el tiempo
	 * de ejecuci�n.
	 * 
	 */
	private int[] array;
	private final int POS = 100;
	
	public void cargar() {
		array=new int[POS];
		for(int f=0;f<POS;f++) {
			array[f]=(int)(Math.random()*100);}
	}
	public void burbuja() {
		for (int i = 0; i< POS-1; i++) {
			for (int j = POS-1; j > i; j--) {
				if (array[j] < array[j-1]) {

					int aux = array[j];
					array[j] = array [j-1];
					array[j-1] = aux;
				}
			}
		}
	}
	public void imprimir() {
		System.out.println("Vector ordenado por m�todo burbuja.");
		for(int f=0;f<array.length;f++) {
			System.out.println("Posici�n " + f + " contiene: " + array[f]);
		}
	}
	
	int busqueda_Bin(int dato) {
		int inicio= 0, fin= POS-1, med = POS/2, encontrado=-1;
		while (inicio <= fin && encontrado == -1) {
			if (array[med] == dato)
				encontrado = med;
			/* mover inicio y fin para dividir el �rea de b�squeda */
			else {
				if (array[med] > dato) //Dato estar� del principio a la mitad
					fin = med - 1;
				else // Dato estar� de la mitad al final
					inicio = med + 1;
				med = ( inicio + fin ) / 2;
			}
		}
		return encontrado;
	}
	
	public static void main(String[] ar) {
		
		int dato_a_buscar = 0;
		
		Busqueda_Binaria pv=new Busqueda_Binaria();
		pv.cargar();
		pv.burbuja();
		pv.imprimir();
		System.out.println("Introduzca un n�mero para buscarlo en el vector:");
		Scanner In = new Scanner (System.in);
		dato_a_buscar = In.nextInt();		
		System.out.println("El dato a buscar se ha encontrado en la posici�n:" + pv.busqueda_Bin(dato_a_buscar)); 
		
	}
	
}
