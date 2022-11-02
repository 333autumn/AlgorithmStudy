package sort;

import utils.Utils;

/**
 * 希尔排序
 */
public class ShellSort extends Utils {

    public static void main(String[] args) {
        int[] arr=new int[]{84,83,88,87,61,50,70,60,80,99};
        shellSort(arr);
        print(arr);
    }

    //希尔排序
    public static void shellSort(int[] arr) {
        //第一层循环控制增量,递减,最后一定为1
        for (int gap=arr.length/2;gap>=1;gap/=2){
            //第二层循环控制每一组的起始位置
            for (int start=0;start<gap;start++){
                //第三层循环控制每一组遍历
                for (int current=start+gap;current<arr.length;current+=gap){
                    int currentNumber=arr[current];
                    int temp=current;
                    while (temp>start&&arr[temp-gap]>currentNumber){
                        arr[temp]=arr[temp-gap];
                        temp-=gap;
                    }
                    arr[temp]=currentNumber;
                }
            }
        }
    }
}
