public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            nums1 = new int[0];
        }
        if (nums2 == null) {
            nums2 = new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> res = new HashSet<>();
        int ind1 = 0;
        int ind2 = 0;
        while (ind1 < nums1.length && ind2 < nums2.length) {
            if (nums1[ind1] < nums2[ind2]) {
                ind1++;
            } else if (nums1[ind1] > nums2[ind2]) {
                ind2++;
            } else {
                res.add(nums1[ind1]);
                ind1++;
                ind2++;
            }
        }
        int[] resArray = new int[res.size()];
        int ind = 0;
        for (int num : res) {
            resArray[ind++] = num;
        }
        return resArray;
    }
}
