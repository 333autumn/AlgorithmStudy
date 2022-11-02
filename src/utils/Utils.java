package utils;

import java.util.Arrays;

public class Utils {
    //交换数组中两个数
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //打印数组到控制台
    public static void print(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    //判断数组是否有序
    public static void judge(int[] arr){
        StringBuilder before=new StringBuilder();
        for (int i : arr) {
            before.append(i);
        }
        Arrays.sort(arr);
        StringBuilder after=new StringBuilder();
        for (int i : arr) {
            after.append(i);
        }
        if (before.toString().equals(after.toString())){
            System.out.println("数组已经有序");
        }else {
            System.out.println("数组不是有序");
        }
    }

}
