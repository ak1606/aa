package daa;

public class MM {
	static int[][] A= {
			{1,2,3},
			{4,5,6},
			{7,8,9}
	};
	static int[][] B= {
			{7,8,9},
			{4,5,6},
			{1,2,3}
	};
	
	static int[][] C= new int[A.length][B[0].length];
	public static void multir(int rowindex) {
		for(int j=0;j<B[0].length;j++) {
			C[rowindex][j]=0;
			for(int k =0;k<A.length;k++) {
				C[rowindex][j] += A[rowindex][k]*B[k][j];
			}
		}
	}
	public static void printmatrix(int[][] matrix) {
		for(int i =0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}	
	}
	public static void main(String[] args) throws InterruptedException{
		Thread[] threads = new Thread[A.length];
		
		for(int i =0;i<A.length;i++) {
			int rowindex=i;
			threads[i]=new Thread(()-> multir(rowindex));
			threads[i].start();
		}
		
		for(int i =0;i<A.length;i++) {
			threads[i].join();
		}
		
		printmatrix(C);
	}

}
