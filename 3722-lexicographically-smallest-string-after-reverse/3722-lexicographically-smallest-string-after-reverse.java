class Solution {
    public String lexSmallest(String s) {
        int n = s.length();
        String best = s;  // initial best is original string

        for (int k = 1; k <= n; k++) {

            String first = reverse(s.substring(0, k)) + s.substring(k);

            String second = s.substring(0, n - k) + reverse(s.substring(n - k));

            if (first.compareTo(best) < 0) {
                best = first;
            }
            if (second.compareTo(best) < 0) {
                best = second;
            }
        }

        return best;
    }

    public String reverse(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}
