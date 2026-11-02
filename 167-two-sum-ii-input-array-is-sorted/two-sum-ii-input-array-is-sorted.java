class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int[] result=new int[2];

        for(int i=0;i<numbers.length;i++){
            int sum=target-numbers[i];
            if(mp.containsKey(sum)){
                result[0]=mp.get(sum);
                result[1]=i+1;
            }
            mp.put(numbers[i],i+1);

        }
        return result;
    }
}