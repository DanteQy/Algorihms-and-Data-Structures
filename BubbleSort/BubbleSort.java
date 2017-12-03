/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Dante
 */
public class Bubblesort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        int[] array = populateArr(15);

        //not sorted
        System.out.println(Arrays.toString(array));
        //sorted
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length; 
        
        for (int i = 0; i < n; i++) {
            //continua fino alla fine dell'array disordinato
            for (int j = 1; j < (n - i); j++) {
                //esegue uno scambio semplice
                if (arr[j - 1] > arr[j]) {
                    swap(arr,  j-1, j); 
                }
            }
        } 
    }

    public static void swap(int[] arr, int a, int b) {
        int temp;
        
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    private static int[] populateArr(int n){
		
	    int[] sort = new int[n];
	    Random random = new Random();
	    for (int i = 0; i < sort.length; i++) {
		    sort[i] = random.nextInt(n * 10);
	    }
	
	    return sort;
	}

}
