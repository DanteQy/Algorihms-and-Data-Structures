/*
 * To change this license header, choose Firsticense Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Dante
 */
public class MergeSort {

    public static void mergeSort(int array[], int left, int right) {
        if (left < right) {
            mergeSort(array, left, (left + right) / 2);
            mergeSort(array, (left + right / 2) + 1, right);
            merge(array, left, (left + right) / 2, right);
        }
    }

    private static void merge(int array[], int left, int center, int right) {
        int i = 0;
        int j = 0;
        int k = 0;

        //crea 2 array di supporto per le 2 metà
        int First[] = new int[center - left + 1];   
        int Second[] = new int[right - center];      

        k = 0;
        //riempie il primo array con la prima metà
        for (i = left; i < center + 1; i++){  
            First[k++] = array[i];                   
        }
        k = 0;
        //riempie il secondo array con la seconda metà
        for (i = center + 1; i <= right; i++) {
            Second[k++] = array[i];
        }

        i = 0; j = 0; k = left;
        
        //confronta i due array per vedere quale elemento mettere
        while ( i < (center - left + 1) && j < (right - center) ) {
            if (First[i] < Second[j]) {
                array[k++] = First[i++];
            } else {
                array[k++] = Second[j++];
            }
        }
        
        if ((center - left + 1) == i ) {
            while (j < (right - center)) {
                array[k++] = Second[j++];
            }
        } else {
            while (i < (center - left + 1)) {
                array[k++] = First[i++];
            }
        }

    }
    
    public static void main(String[] args) { 
        
        int size = 15; 
        int[] array = populateArr(size);
        System.out.println("Start: "+Arrays.toString(array));
        //After sort
        mergeSort(array, 0, array.length - 1);
        System.out.println("Sorted: "+Arrays.toString(array));
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
