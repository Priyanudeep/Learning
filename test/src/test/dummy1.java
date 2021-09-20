package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class dummy1 {

	private static void test(int[] nums1, int m, int[] nums2, int n) {
		if (m == 0) {
			nums1[0] = nums2[0];
		}
		else if(n == 0) {
			return;
		}
		else if (nums2[n - 1] <= nums1[0]) {
			int k = nums1.length - 1;
			m--;
			for (; m >= 0; m--, k--) {
				nums1[k] = nums1[m];
			}
			m = 0;
			for (; m <= n - 1; ++m) {
				nums1[m] = nums2[m];
			}
		} else if (nums1[m - 1] < nums2[0]) {
			for (int i = 0; m < nums1.length; ++m, ++i) {
				nums1[m] = nums2[i];
			}
		} else {
			m--;
			n--;
			int k = nums1.length - 1;
			while (k >= 1) {
				if (nums1[m] >= nums2[n]) {
					nums1[k] = nums1[m];
					if (m != 0) {
						m--;
					}
				} else {
					nums1[k] = nums2[n];
					if (n != 0) {
						n--;
					}
				}
				k--;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = new int[] {2, 5, 6};
		test(nums1, 3, nums2, 3);
		System.out.println("Over...");
	}

}
