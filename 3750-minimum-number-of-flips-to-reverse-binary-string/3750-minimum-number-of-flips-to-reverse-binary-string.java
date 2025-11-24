class Solution {
    public int minimumFlips(int n) {
        int flip=0;
    int[] arr = Integer.toBinaryString(n)
                          .chars()
                          .map(c -> c - '0')
                          .toArray();
    int[] match= new int[arr.length];
    int k=0;
    for(int i=arr.length-1;i>=0;i--){
        match[k]= arr[i];
        k++;
    }                      
    for(int i=0;i< arr.length;i++){
        if(arr[i] != match[i]){
        flip++;
        }
    }
    return flip;
    }
}