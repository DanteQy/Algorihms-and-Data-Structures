/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingsort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Dante
 */
public class CountingSort {
 

    /**
     * @param args the command line arguments
     */
    //Time complexity Big Theta(n+k)
    static int[] countingSort(int in[]) {
        int leng = in.length; 
        int max = getMax(in);
        //the size of the array is +1 from the max value since it start from 0
        int count[] = new int[max+1];
        int out[] = new int[leng];  
        
        //max = k
        //leng = n
        
        //O(k)
        for(int i = 0; i < max; i++){
            count[i] = 0; 
        } 
        
        System.out.println("-----------"); 
        //O(n)
        for(int j = 0; j < leng; j++){
            count[in[j]] = count[in[j]]+1;   
        } 
        
        System.out.println("2 : "+Arrays.toString(count));
        //O(k)
        for(int i = 1 ; i <= max; i++){ 
            count[i] =count[i]+ count[i-1]; 
            
        }
        
        System.out.println("///////////");
        //O(n)
        for(int j = 0; j < leng; j++){
            out[count[in[j]]-1] = in[j];
            count[in[j]] = count[in[j]]-1;
        }
         
        checkSort(in);
        return out;
       
    }

     static void checkSort(int[] arr){
        boolean test =true;
        for(int i = 1; i <arr.length; i++ ){
            if(arr[i]<arr[i-1])
                test = false;
        }
        
        if(test) System.out.print("Ordinato");
        else System.out.print("Non Ordinato");
    }
    
    public static void main(String args[]) {
        int leng = 15; 
        int arr[] = populateArr(leng);
        System.out.println(Arrays.toString(countingSort(arr)));
    }
    
    static int getMax(int arr[] )
    {
        int l = arr.length;
        int mx = arr[0];
        for (int i = 1; i < l ; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    private static int[] populateArr(int n){
		
	    int[] sort = new int[n];
	    Random random = new Random();
	    for (int i = 0; i < sort.length; i++) {
		    sort[i] = random.nextInt(10);
	    }
	
	    return sort;
	}

}
