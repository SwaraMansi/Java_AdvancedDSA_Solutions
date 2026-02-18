class Solution {
public:
    int bestClosingTime(string customers) {
        int n = customers.size(); 
        int totalY = 0;
        for(char c : customers){
            if(c == 'Y'){
                totalY++;
            }
        }
        int penality= totalY;
        int min_penality= penality;
        int besthour=0;
        for(int i = 0 ; i<n ; i++){
            if(customers[i]=='Y'){
                penality--;
            }
            else{
                penality++;
            }
            if(min_penality>penality){
            min_penality = penality;
            besthour=i+1;
            }
        }
        
        return besthour;
    }
};