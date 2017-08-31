public class Solution {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        int[] prefixTable = getPrefixFunction(target);
        int matches = 0;
        for (int i = 0; i < source.length(); i++) {
            while (matches != 0 && source.charAt(i) != target.charAt(matches)) {
                matches = prefixTable[matches - 1] + 1;
            }
            if (source.charAt(i) == target.charAt(matches)) {
                matches++;
            }
            if (matches == target.length()) {
                return i - target.length() + 1;
            }
        }
        return -1;
    }
    
    private int[] getPrefixFunction(String str) {
        int[] prefixTable = new int[str.length()];
        prefixTable[0] = -1;
        int matches = -1;
        for (int i = 1; i < prefixTable.length; i++) {
            while (matches != -1 && str.charAt(matches + 1) != str.charAt(i)) {
                matches = prefixTable[matches];
            }
            if (str.charAt(matches + 1) == str.charAt(i)) {
                matches++;
            }
            prefixTable[i] = matches;
        }
        return prefixTable;
    }
    
}
