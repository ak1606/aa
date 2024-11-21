package daa;
import java.util.Scanner;
public class Quicksort {
	public static int partition(int[] arr,int low,int high) {
		int pivot = arr[low];
		int i= low +1;
		int j= high;
		while(i<=j) {
			while(i<=high && arr[i]<= pivot) {
				i++;
			}
			while(j>=low && arr[j]>pivot) {
				j--;
			}
			if(i<j) {
				swap(arr,i,j);
			}
		}
		swap(arr,low,j);
		return j;
	}
	public static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}
	public static void qs(int[] arr,int low,int high) {
		if(low<high) {
			int partitionindex= partition(arr,low,high);
			
			qs(arr,low,partitionindex-1);
			qs(arr,partitionindex+1,high);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Enter the Size of Array");
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter the Elements of Array");
		for(int i = 0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		System.out.println("Input Array");
		for(int num:arr) {
			System.out.print(num+" ");
		}
		System.out.println();
		
		qs(arr,0,n-1);
		
		System.out.println("Sorted Array");
		for(int num:arr) {
			System.out.print(num+" ");
		}
		
	}
}
