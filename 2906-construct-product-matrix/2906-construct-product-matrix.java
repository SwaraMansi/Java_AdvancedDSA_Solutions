class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int size = n * m;
        
        int mod = 12345;
        
        // Flatten matrix
        int[] arr = new int[size];
        int k = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[k++] = grid[i][j] % mod;
            }
        }
        
        // Result array (store prefix first)
        int[] res = new int[size];
        
        // Step 1: Left product
        res[0] = 1;
        for(int i = 1; i < size; i++) {
            res[i] = (res[i - 1] * arr[i - 1]) % mod;
        }
        
        // Step 2: Right product
        int right = 1;
        for(int i = size - 1; i >= 0; i--) {
            res[i] = (res[i] * right) % mod;
            right = (right * arr[i]) % mod;
        }
        
        // Convert back to 2D
        int[][] ans = new int[n][m];
        k = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans[i][j] = res[k++];
            }
        }
        
        return ans;
    }
}