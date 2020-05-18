package sort.CountingSort;

import java.util.Arrays;
import java.util.function.Consumer;

public class CountingSort {


    public static void main(String[] args) {
        int[] A = CountingSort.countingSort (new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1});
        Consumer<int[]> con = (x) -> System.out.println (Arrays.toString (x));

        con.accept (A);
    }

    public static int[] countingSort(int[] A) {
        int[] B = new int[A.length];
        // 假设A中的数据a'有，0<=a' && a' < k并且k=100
        int k = 100;
        countingSort (A, B, k);
        return B;
    }

    private static void countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k];
        // 计数
        for (int j = 0; j < A.length; j++) {
            int a = A[j];
            C[a] += 1;
        }
        System.out.println (Arrays.toString (C));
        // 求计数和
        for (int i = 1; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }
        System.out.println (Arrays.toString (C));
        // 整理
        for (int j = A.length - 1; j >= 0; j--) {
            int a = A[j];
            B[C[a] - 1] = a;
            C[a] -= 1;
        }
    }
}


//针对c数组的大小，优化过的计数排序
class CountSort {
    public static void main(String[] args) {
        //排序的数组
        int a[] = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
        int b[] = countSort (a);
        for (int i : b) {
            System.out.print (i + "  ");
        }
        System.out.println ();
    }

    public static int[] countSort(int[] a) {
        // 创建一个等长数组
        int b[] = new int[a.length];
        // 得到最大值和最小值
        int max = a[0], min = a[0];
        for (int i : a) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        //这里k的大小是要排序的数组中，元素大小的极值差+1
        int k = max - min + 1;
        int c[] = new int[k];
        // 得到每个元素的frequency
        for (int i = 0; i < a.length; ++i) {
            c[a[i] - min] += 1;//优化过的地方，减小了数组c的大小
        }
        // 通过累加，得到每个元素的相对位置
        for (int i = 1; i < c.length; ++i) {
            c[i] = c[i] + c[i - 1];
        }
        // 将每个元素按照其相对位置进行排序
        for (int i = a.length - 1; i >= 0; --i) {
            b[--c[a[i] - min]] = a[i];//按存取的方式取出c的元素
        }
        return b;
    }
}
