import java.util.Random;

public class Driver {

	public static void main(String[] args) 
	{
		Random random = new Random();
		
		int arr[] = new int[10000];
		int arr2[] = new int[10000];
		
		for(int i = 0; i < 10000; i++)
		{
			arr[i] = random.nextInt(1000);
		}
		
		for(int i = 0; i < arr.length; i++)
		{
			arr2[i] = arr[i];
		}
		//----------------------------------------------------------------------------------------
		System.out.println("OG MergeSort");
		System.out.println("Before sort (first 100 elements): ");
		for(int i = 0; i < 100; i++)
		{
			System.out.print(arr[i] + ", ");
		}
		System.out.println(" ");
		long start = System.currentTimeMillis();
		sort(arr, 0, arr.length - 1);
		long end = System.currentTimeMillis();
		long answer = end - start;
		System.out.println("After sort (first 100 elements): ");
		for(int i = 0; i < 100; i++)
		{
			System.out.print(arr[i] + ", ");
		}
		System.out.println(" ");
		System.out.println("Runtime: " + answer + " milliseconds");
		System.out.println(" ");
		
		//-----------------------------------------------------------------------------
		
		System.out.println("Single Array MergeSort");
		System.out.println("Before sort (first 100 elements): ");
		for(int i = 0; i < 100; i++)
		{
			System.out.print(arr2[i] + ", ");
		}
		System.out.println(" ");
		long start2 = System.currentTimeMillis();
		sort2(arr2, 0, arr2.length - 1);
		long end2 = System.currentTimeMillis();
		long answer2 = end2 - start2;
		System.out.println("After sort (first 100 elements): ");
		for(int i = 0; i < 100; i++)
		{
			System.out.print(arr2[i] + ", ");
		}
		System.out.println(" ");
		System.out.println("Runtime: " + answer2 + " milliseconds");

	}
	
	
	
	
	
	
	public static void merge(int arr[], int l, int m, int r)
	    {
	        int n1 = m - l + 1;
	        int n2 = r - m;
	        int L[] = new int[n1];
	        int R[] = new int[n2];

	        for (int i = 0; i < n1; ++i)
	            L[i] = arr[l + i];
	        for (int j = 0; j < n2; ++j)
	            R[j] = arr[m + 1 + j];
	 
	        int i = 0, j = 0;

	        int k = l;
	        while (i < n1 && j < n2) {
	            if (L[i] <= R[j]) {
	                arr[k] = L[i];
	                i++;
	            }
	            else {
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }

	        while (i < n1) {
	            arr[k] = L[i];
	            i++;
	            k++;
	        }
	 
	        while (j < n2) {
	            arr[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	
	public static void sort(int arr[], int l, int r)
	    {
	        if (l < r) 
	        {
	            int m = l + (r - l) / 2;
	            sort(arr, l, m);
	            sort(arr, m + 1, r);
	            merge(arr, l, m, r);
	        }
	    }
	    
	public static void merge2(int arr[], int start, int mid, int end)
		{
			int start2 = mid + 1;
			if (arr[mid] <= arr[start2]) 
			{
				return;
			}
			while (start <= mid && start2 <= end) 
			{
			
			  if (arr[start] <= arr[start2]) 
			  {
			      start++;
			  }
			  else 
			  {
			      int value = arr[start2];
			      int index = start2;
			      while (index != start) 
			      {
			          arr[index] = arr[index - 1];
			          index--;
			      }
			      arr[start] = value;
			
			      start++;
			      mid++;
			      start2++;
			  }
			}
		}
			
	public static void sort2(int arr[], int l, int r)
			{
				if (l < r) 
				{
					int m = l + (r - l) / 2;
					sort2(arr, l, m);
					sort2(arr, m + 1, r);
					merge2(arr, l, m, r);
				}
			}


}
