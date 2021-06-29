

/*
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
package app.LEETCODE;

public class MedianSortedArrays {
    public double findMedianSortedArrays(final int[] nums1, final int[] nums2) {
         int m = nums1.length;
         int n = nums2.length;
        int index  = m+n;
        int k = 0;
        final int arry[] = new int[m+n];
        double  result  = 0;
        if (m==0) {
            if (n%2==0) {
                result  = (nums2[n/2]+nums2[n / 2-1])/2.0;
            }else {
                result =  nums2[(n-1)/2];
                }
        }else if (n == 0) {
            if (m%2 == 0) {
                result = (nums1[m/2]+nums1[m/2-1])/2.0;
            } else {
                result = nums1[(m-1)/2];
                }
        }else {
            int i = 0;
            int j = 0;
            while (k!=index) {
                if (nums1[i]<=nums2[j]) {
                    arry [k] = nums1[i];
                    i++;
                    k++;
                }else if (nums1[i] > nums2[j]){
                    arry [k] = nums2[j];
                    j++;
                    k++;
                }
            }
                                                              
            if (j == n) {
                
                for (j = 0;j<nums2.length;j++) {
                        arry[++k] = nums2[j];
                    }         
            }else if (i == m) {
                
                for (i = 0;i<nums1.length;i++) {
                    arry[++k] = nums1[i];
                    }
            }
            for (int o = 0; o <= index - 1; o++) {
                System.out.print(arry[o] + " ");
            }

            if (index % 2 == 0) {
                result = (arry[index / 2 - 1] + arry[index / 2]) / 2.0;
            } else {
                result = arry[(index - 1) / 2];
            }
           
        }
        return (double)result;
    }
}