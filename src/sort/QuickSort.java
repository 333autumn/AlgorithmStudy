package sort;

import utils.Utils;

/**
 * 快速排序
 */
public class QuickSort extends Utils {

    public static void main(String[] args) {
        int[] arr=new int[]{84,83,88,87,61,50,70,60,80,99};
        quickSort(arr);
        print(arr);
    }

    //快速排序入口
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    //快速排序
    public static void quickSort(int[] arr, int start, int end) {
        // 如果区域内的数字等于1个或者0个，退出递归
        // start == end -> 1个
        // start == end + 1 -> 0个 (start都大于end了当然是0个)
//        if (start == end || start == end + 1) return;
        //简写
        if (start>=end) return;
        // 将数组分区，并获得中间值的下标
        int middle = partition(arr, start, end);
        // 对左边区域快速排序
        quickSort(arr, start, middle - 1);
        // 对右边区域快速排序
        quickSort(arr, middle + 1, end);
    }

    //最简单的分区算法
    //将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
    public static int partition1(int[] arr, int start, int end) {
        // 取第一个数为基数
        int pivot=arr[start];
        int left=start+1;
        int right=end;
        while (left<right){
            while (left<right&&arr[left]<=pivot) left++;
            //退出上面这个循环只有两种情况
            //1.left=right
            //2.arr[left]>pivot
            if (left!=right){//说明arr[left]>pivot
                swap(arr,left,right);
                right--;
            }
        }
        //退出循环时left=right 比较arr[right]是否大于基数 如果大于基数 则right-1为最后一个小于基数的位置
        //基数就要和这个位置交换 并返回这个位置的下标
        if (left==right&&arr[right]>pivot) right--;
        swap(arr,start,right);
        return right;
    }

    //双指针分区算法
    public static int partition(int[] arr, int start, int end) {
        // 取第一个数为基数
        int pivot=arr[start];
        int left=start+1;
        int right=end;
        while (left<right){
            //left和right一定会在start-end的范围内相遇 所以不用控制left和right的边界范围
            //如果left大于right 则已经找到了中轴的位置 不需要再继续了
            while (left<right&&arr[left]<=pivot) left++;
            while (left<right&&arr[right]>=pivot) right--;
            if (left<right){
                swap(arr,left,right);
                left++;
                right--;
            }
        }
        if (left==right&&arr[right]>pivot) right--;
        swap(arr,start,right);
        return right;
    }

}
