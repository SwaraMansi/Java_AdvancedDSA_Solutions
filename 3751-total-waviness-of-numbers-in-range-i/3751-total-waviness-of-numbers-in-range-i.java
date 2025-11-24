class Solution {
    public int totalWaviness(int num1, int num2) {
       int wave=0;
       for(int j=num1;j<=num2;j++){
    String s = Integer.toString(j);
    for (int i = 1; i < s.length()-1; i++) {
    if(s.charAt(i)>(s.charAt(i-1)) && (s.charAt(i))>(s.charAt(i+1))){
      wave++;
    }
    else if(s.charAt(i)<(s.charAt(i-1)) && (s.charAt(i))<(s.charAt(i+1))){
      wave++;
    }
    else{
        continue;
    }
}}
return wave;
    }
}