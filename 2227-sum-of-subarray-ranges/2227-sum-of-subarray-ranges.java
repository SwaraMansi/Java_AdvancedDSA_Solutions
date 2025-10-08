class Solution {
    public long subArrayRanges(int[] nums) {
           return sumOfSubarrayMaximums(nums) - sumOfSubarrayMinimums(nums);
    }
    public long sumOfSubarrayMaximums(int[] nums) {
        int n = nums.length;
    int[] left = new int[n];
    int[] right = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
            stack.pop();
        }
        left[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
        stack.push(i);
    }

    stack.clear();

    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
            stack.pop();
        }
        right[i] = stack.isEmpty() ? (n - i) : (stack.peek() - i);
        stack.push(i);
    }

    long sum = 0;
    for (int i = 0; i < n; i++) {
        sum += (long) nums[i] * left[i] * right[i];
    }

    return sum;
    }
     public long sumOfSubarrayMinimums(int[] arr) {
     
        int n= arr.length;
         int[] left = new int[n];
         int[] right= new int[n];
         Stack<Integer> stack=new Stack<>();

         for(int i=0;i<n;i++){
            int count=1;
            while(!stack.isEmpty() && arr[stack.peek()]> arr[i]){
                stack.pop();
            }left[i]= stack.isEmpty() ? (i+1): (i-stack.peek());
            stack.push(i);
         }
          stack.clear();
          
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i]= stack.isEmpty() ? (n-i): (stack.peek()-i);
            stack.push(i);
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum  += (long) arr[i] * left[i] * right[i];
        }
        return sum;
    }
}