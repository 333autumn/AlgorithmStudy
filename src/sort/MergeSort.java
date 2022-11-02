package sort;

import utils.Utils;

/**
 * 归并排序
 */
public class MergeSort extends Utils {

    public static void main(String[] args) {
        int[] arr=new int[]{84,83,88,87,61,50,70,60,80,99};
        //提前开辟出结果数组，递归过程中都使用该数组，减少空间的占用
        int[] result=new int[arr.length];
        mergeSort(arr);
        print(arr);
    }

    public static void mergeSort(int[] arr) {
        if (arr.length == 0) return;
        int[] result = mergeSort(arr, 0, arr.length - 1);
        // 将结果拷贝到 arr 数组中
        System.arraycopy(result, 0, arr, 0, result.length);
    }

    // 对 arr 的 [start, end] 区间归并排序
    private static int[] mergeSort(int[] arr, int start, int end) {
        // 只剩下一个数字，停止拆分，返回单个数字组成的数组
        if (start == end) return new int[]{arr[start]};
        int middle = (start + end) / 2;
        // 拆分左边区域
        int[] left = mergeSort(arr, start, middle);
        // 拆分右边区域
        int[] right = mergeSort(arr, middle + 1, end);
        // 合并左右区域
        return merge(left, right);
    }

    // 将两个有序数组合并为一个有序数组
    // 采取双指针法，不断比较两个数组的元素将较小的元素放在结果数组中
    private static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int index1 = 0, index2 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] <= arr2[index2]) {
                result[index1 + index2] = arr1[index1];
                index1++;
            } else {
                result[index1 + index2] = arr2[index2];
                index2++;
            }
        }
        // 将剩余数字补到结果数组之后
        while (index1 < arr1.length) {
            result[index1 + index2] = arr1[index1];
            index1++;
        }
        while (index2 < arr2.length) {
            result[index1 + index2] = arr2[index2];
            index2++;
        }
        return result;
    }

}
