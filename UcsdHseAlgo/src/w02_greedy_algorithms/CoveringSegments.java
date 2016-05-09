package w02_greedy_algorithms;
import java.util.*;

public class CoveringSegments {

    private static Integer[] optimalPoints(Segment[] segments) {
        //write your code here
    	Comparator <Segment> comp = new Comparator<Segment> (){
			@Override
			public int compare(Segment arg0, Segment arg1) {
				// TODO Auto-generated method stub
				return arg0.start > arg1.start?1:-1;
			}};
    	Arrays.sort(segments,comp);
    	
    	ArrayList<Integer> points = new ArrayList<>();
    	//find no. of segments within the first segment
    	for (int i=0;i<segments.length;i++)
    	{
    		Segment seg=segments[i];
    		if(seg.visited==0)
    		{
    			int start=seg.start;
    			int end=seg.end;
    			seg.visited=1;
    			for (int j=i+1;j<segments.length && segments[j].start<=end ; j++)
    			{
    				Segment next=segments[j];
    				next.visited=1;
    				start=next.start;
    				if(next.end < end)
    					end=next.end;
    			}
    			points.add(end);
    		}
    	}
    	/*
        int[] points = new int[2 * segments.length];
        for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }*/
    	Integer arr[]=new Integer[points.size()];
        return points.toArray(arr);
    }

    private static class Segment {
        int start, end;
        int visited;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
            this.visited=0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        Integer[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
