package top.neusoftware.learn.algorithm;

public class Sort {
	public static void main(String[] args) {
		int[] data= {10,5,8,7,4,1,3,6};
		int[] temp=new int[data.length];
		quickSort(data,0,7);
		//mergeSort(data,0,7,temp);
		//insertSort(data);
		//selectSort(data);
		//shellSort(data);
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
	}

	//冒泡排序
	public static void bubbleSort(int[] data){
		int length=data.length;
		for(int i=0;i<length;i++){
			for(int j=1;j<length-i;j++){
				if(data[j]<data[j-1]){
					int temp=data[j];
					data[j]=data[j-1];
					data[j-1]=temp;
				}
			}
		}
	}

	//插入排序
	public static void insertSort(int[] data){
		int size=data.length;
		for(int i=1;i<size;i++){
			int temp=data[i];
			int leftIndex=i;
			while(leftIndex-1>=0&&temp<data[leftIndex-1]){
				data[leftIndex]=data[leftIndex-1];
				leftIndex--;
			}
			data[leftIndex]=temp;
		}
	}

	//希尔排序
	public static void shellSort(int[] a){
		for(int step=a.length/2;step>0;step/=2){
			for(int i=step;i<a.length;i++){
				int j=i;
				int temp=a[j];
				while(j-step>=0&&a[j-step]>temp){
					a[j]=a[j-step];
					j-=step;
				}
				a[j]=temp;
			}
		}
	}

	//选择排序
	public static void selectSort(int[] data){
		for(int i=0;i<data.length;i++){
			int index=i;
			for(int j=i+1;j<data.length;j++){
				if(data[j]<data[index])
					index=j;
			}
			if(index!=i) {
				int temp = data[i];
				data[i] = data[index];
				data[index] = temp;
			}
		}
	}



	//计数排序
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
				data[resultIndex++]=i+min;
			}
		}
	}



	//快速排序
	public static int[] quickSort(int[] a,int low,int high) {
		if(low>high)
			return null;
		int i=low,j=high;
		int k=a[i];
		while(i<j) {
			while(i<j&&a[j]>k) {	//从后往前找到第一个比k小的值
				j--;
			}
			while(i<j&&a[i]<=k) {	//从前往后找到第一个比k大的值
				i++;
			}
			if(i<j) {
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		//此时i==j，一轮结束，交换i指向的元素与首元素
		k=a[i];
		a[i]=a[low];
		a[low]=k;
		quickSort(a,low,i-1);
		quickSort(a,i+1,high);
		return a;
	}

	//归并排序
	public static void mergeSort(int[] a,int low,int high,int[] temp){
		if(low<high){
			int mid=(low+high)/2;
			mergeSort(a,low,mid,temp);	//对左侧分治并排序
			mergeSort(a,mid+1,high,temp);	//对右侧分治并排序
			merge(a,low,mid,high,temp);	//合并左右侧
		}
	}
	private static void merge(int[] a,int low,int mid,int high,int[] temp){
		int i=0,j=low,k=mid+1;
		while(j<=mid&&k<=high){
			if(a[j]<=a[k]){
				temp[i++]=a[j++];
			}
			else{
				temp[i++]=a[k++];
			}
		}
		while(j<=mid){
			temp[i++]=a[j++];
		}
		while(k<=high){
			temp[i++]=a[k++];
		}
		for(int t=0;t<i;t++){
			a[low+t]=temp[t];
		}
	}
}
