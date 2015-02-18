
public class test {
	public static void main (String args []){
		int [] a = new int [5];
		for (int i=0; i < 5; i++)
			a[i]=i;
		da1(a,0,4);
		
		da2(a,0,4);
	}
	public static void da1(int[] a, int first, int last) {
	    System.out.print(a[first] + " ");
	    if(first < last) {
	        da1(a, first + 1, last);
	    }}

	public static void da2(int[] a, int first, int last) {
	    if(first < last) {
	        da2(a, first + 1, last);
	    }
	    System.out.print(a[first] + " ");
	}
	}

