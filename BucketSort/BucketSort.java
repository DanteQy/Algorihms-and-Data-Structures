/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketsort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Dante
 */
public class BucketSort {

    public static int dim = 15;

    /**
     * @param args the command line arguments
     */
    static void bucketSort(float arr[]) {
        float[][] temp = new float[dim][dim];

        int n = arr.length;
        int val = 0; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = (float) 0;
            }
        }

        for (int i = 0; i < n; i++) {
            val = (int) (arr[i] * 10);
            int j = 0;
            while (temp[val][j] != 0) {
                j++;
            }
            temp[val][j] = arr[i];
        }

        for (int i = 0; i < temp.length; i++) {
            insertionSort(temp[i]);
        }
        int k = 0;
        
        for (int i = 0; i < temp.length; i++) {
            int j = 0;
            for ( j = 0; j < temp.length; j++){
                if (temp[i][j] != 0.0) {
                    arr[k] = temp[i][j];
                    k++;
                }
                
            }

        }
        System.out.println(Arrays.toString(arr));

    }

    private static float[] insertionSort(float[] arr) {

        float temp;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String args[]) { 
        float arr[] = generateRandomNumbers(dim);
        System.out.println(Arrays.toString(arr));
        bucketSort(arr);
 
    }

    public static float[] generateRandomNumbers(int n) {
 
        float[] result = new float[n];
        Random random = new Random();

        for (int i = 0; i < result.length; i++) { 
            result[i] = random.nextInt(((100 - 1) + 1) + 1);
            result[i] = (result[i] / 100); 
        } 

        return result;
    }

}
