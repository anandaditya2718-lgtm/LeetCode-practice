import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0){
            if(nums2[j] > nums1[i]){
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }

        
        while(j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter number of elements in nums1 (m): ");
        int m = sc.nextInt();

       
        int[] nums1 = new int[m + 100]; 
        System.out.println("Enter " + m + " sorted elements of nums1:");
        for(int i = 0; i < m; i++){
            nums1[i] = sc.nextInt();
        }

       
        System.out.print("Enter number of elements in nums2 (n): ");
        int n = sc.nextInt();

       
        int[] nums2 = new int[n];
        System.out.println("Enter " + n + " sorted elements of nums2:");
        for(int i = 0; i < n; i++){
            nums2[i] = sc.nextInt();
        }

        
        nums1 = Arrays.copyOf(nums1, m + n);

        Solution obj = new Solution();
        obj.merge(nums1, m, nums2, n);

        System.out.println("Merged array:");
        for(int num : nums1){
            System.out.print(num + " ");
        }

    }
}