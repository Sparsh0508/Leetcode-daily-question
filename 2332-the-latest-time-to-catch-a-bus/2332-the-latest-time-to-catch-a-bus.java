class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] pass, int cap) {
        Arrays.sort(pass);
        Arrays.sort(buses);

        if(pass[0] > buses[buses.length - 1]){
            return buses[buses.length - 1];
        }
        int result = pass[0] - 1;
        int i = 0, j = 0;
        while(i < buses.length){
            int occ = 0;
            while(occ < cap && j < pass.length && pass[j] <= buses[i]){
                if(j > 0 && pass[j] - pass[j-1] != 1){
                    result = pass[j] - 1;
                }
                j++;
                occ++;
            }
            if(j > 0 && occ < cap && buses[i] != pass[j-1]){
                result = buses[i];
            }
            i++;
        }
        return result;
    }
}
