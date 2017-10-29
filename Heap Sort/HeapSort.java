/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Dante
 */
public class HeapSort {

    private static int N = 17;
    
    /**
     * Complexity: N-elements where each one calls heapify
     * Resulting complexity (n log n).
     */
    public static void sort(int arr[]) {
 
        // Build heap 
        for (int i = N / 2 - 1; i >= 0; i--){
            heapify(arr, N, i);
        }
        // max-heapify
        for (int i=N-1; i>=0; i--)
        {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        } 
    }

    //This build the heap
    public static void heapify(int arr[], int n, int i)
    {
        //i = root
        int max = i;  
        int left = left(i);  
        int right = right(i);  
 
        //left>max
        if ((left < n) && (arr[left] > arr[max]))
            max = left;
        //right>max
        if (( right < n) && (arr[right] > arr[max]))
            max = right;
 
        //if the largest is not in the root
        if (max != i)
        {
            swap(arr, max, i); 
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, max);
        }
    }

    //height has [n/2^(h+1)] nodes.
    public static int left(int i){
        return 2*i;
    }
    public static int right(int i){
        return (2*i)+1;
    }
    
     

    /* swapping 2 elements*/
    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    
    private static int[] populateArr(int n){
		
	    int[] sort = new int[n];
	    Random random = new Random();
	    for (int i = 0; i < sort.length; i++) {
		    sort[i] = random.nextInt(n * 10);
	    }
	    return sort;
    }
    
    public static void main(String[] args) {  
        int[] array =  populateArr(17);
        System.out.println("Original: " + Arrays.toString(array));
        sort(array);
        System.out.println("Heap Sort: " + Arrays.toString(array));
    }
}
