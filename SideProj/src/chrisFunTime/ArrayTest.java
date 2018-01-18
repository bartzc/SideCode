package chrisFunTime;

public class ArrayTest {
	public static void main(String[]args) {
		int[] arr = {};
		int count = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]==0) {
				count++;
			}
			if(arr[i]!=0) {
				break;
			}
		}
		System.out.println(count+"\n");
		int[] arr2 = new int[arr.length-count];
		for(int i=0; i<arr2.length; i++) {
			arr2[i]=arr[i+count];
			System.out.println(arr2[i]);
		}
		
		
			
	}
	
}
