package top.neusoftware.learn.algorithm;

public class Sort {
	public static void main(String[] args) {
		int[] data= {1,5,8,7,4};
		countingSort(data);
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
	}
	public static void bucketSort(int[] data) {
		
	}
	public static void countingSort(int[] data) {
		int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		for(int i=0;i<data.length;i++) {
			if(data[i]>max) {
				max=data[i];
			}
			if(data[i]<min) {
				min=data[i];
			}
		}
		int countingLength=max-min+1;	//计数数组的长度
		int[] counting=new int[countingLength];
		for(int i=0;i<data.length;i++) {	//计数
			int index=data[i]-min;
			counting[index]++;
		}
		int resultIndex=0;
		for(int i=0;i<countingLength;i++) {
			int frequency=counting[i];
			for(int j=0;j<frequency;j++) {
				//System.out.print((i+min)+" ");
				data[resultIndex++]=i+min;
			}
		}
	}
}
