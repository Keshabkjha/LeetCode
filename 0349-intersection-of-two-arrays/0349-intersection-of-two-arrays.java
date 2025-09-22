class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for(int e: nums1) s.add(e);
        Set<Integer> r = new HashSet<>();
        for(int e : nums2){
            if(s.contains(e)) r.add(e);
        }
        int[] res = new int[r.size()];
        int i = 0;
        for(int e:r)res[i++]= e;
        return res;
    }
}