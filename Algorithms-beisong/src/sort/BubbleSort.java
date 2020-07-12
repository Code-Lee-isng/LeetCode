package sort;

public class BubbleSort {

    public static void bubbleSort(int[] arr){
        for(int i = arr.length - 1; i >= 0; i --){
            for(int j = 0; j < i; j ++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr){
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr.length - i - 1; j ++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }

}
