/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Dante
 */
class SelectionSort {
	public static void main(String[] args){
		int[] array = populateArr(18);
		System.out.println("To be sorted" + Arrays.toString(array));
		selectionSort(array);
		System.out.println("sorted" + Arrays.toString(array));
	}

	public static void selectionSort(int[] array){
		for(int i=0; i<array.length-1; i++){
			int minI = i;
			for(int j=i+1; j<array.length; j++){
				if(array[j] < array[minI])
					minI = j;		
			}
			swap(array, i, minI);
		}
	}
        
        
        public static int[] populateArr(int n){
		
	    int[] sort = new int[n];
	    Random random = new Random();
	    for (int i = 0; i < sort.length; i++) {
		    sort[i] = random.nextInt(n * 10);
	    }
	
	    return sort;
	}
	public static void swap(int[] array, int el1, int el2){
		int temp = array[el1];
		array[el1] = array[el2];
		array[el2] = temp;
	}
}
