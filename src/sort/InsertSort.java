package sort;

import utils.Utils;

/**
 * 插入排序
 */
public class InsertSort extends Utils {

    public static void main(String[] args) {
        int[] arr=new int[]{84,83,88,87,61,50,70,60,80,99};
        insertSort(arr);
        print(arr);
    }

    //交换法插入排序
    public static void insertSort1(int[] arr) {
        for (int i=1;i<arr.length;i++){
            int j=i;
            while (j>0&&arr[j-1]>arr[j]){
                swap(arr,j,j-1);
                j--;
            }
        }
    }

    //移动法插入排序
    public static void insertSort(int[] arr) {
        for (int i=1;i<arr.length;i++){
            int current=arr[i];//保留要插入的数
            int j=i;
            while (j>0&&arr[j-1]>current){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=current;
        }
    }

}
