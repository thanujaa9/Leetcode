class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res=new ArrayList<>();

        
        int newstart=newInterval[0];
        int newend=newInterval[1];
        int i=0,n=intervals.length;
        while(i<n){
            int start=intervals[i][0];
            int end=intervals[i][1];
            
            if(end<newstart){
                res.add(new int[]{start,end});
                
            }else if(start> newend){
                res.add(new int[]{newstart,newend});

                while(i<n){
                    res.add(intervals[i]);
                    i++;
                }
                return res.toArray(new int[res.size()][]);
            }else{
                newstart=Math.min(start,newstart);
                newend=Math.max(end,newend);

                
            }
            i++;
        }

    
        res.add(new int[]{newstart,newend});
        return res.toArray(new int[res.size()][]);
    }
}