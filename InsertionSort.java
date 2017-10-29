/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertionsort;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author Dante
 */

public class InsertionSort {
 
	public static void main(String[] args) { 
	    int[] arr = populateArr(7);
	    //not sorted
	    System.out.println(Arrays.toString(arr));
	    //sorted
	    System.out.println(Arrays.toString(insertionSort(arr)));
	} 
	private static int[] insertionSort(int[] arr){
		
	    int temp;
            for (int i = 1; i < arr.length; i++) {
		    for(int j = i ; j > 0 ; j--){
			    if(arr[j] < arr[j-1]){
				temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			    }
		    }
	    }
	    return arr;
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
