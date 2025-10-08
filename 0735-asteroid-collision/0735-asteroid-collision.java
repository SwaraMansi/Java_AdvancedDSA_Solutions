class Solution {
    public int[] asteroidCollision(int[] asteroids) {
     Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids) {
            boolean destroyed = false;
            
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                if (stack.peek() < -ast) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == -ast) {
                  
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }
            if (destroyed==false) {
                stack.push(ast);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        
        return res;
    }
}