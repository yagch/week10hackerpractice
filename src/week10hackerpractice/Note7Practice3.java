package week10hackerpractice;

public class Note7Practice3 {
	public static void main(String[] arg) {
		double h = 1;
		double deltat = 1;
		double D = 1;
		double[] n = {0,10,0};
		double k1 = 1 / deltat + 2 * D / (h * h);
		double k2 = - D / (h * h);
		double[][] A = {{k1,k2,0},{k2,k1,k2},{0,k2,k1}};
		double[][] B = new double[3][3];
		for(int i = 0; i < 3; i++) {
		    for(int j = 0; j < 3; j++) {
		    	    if(i == j) {
		    	    	    B[i][j] = 1;
		    	    }
		    	    else {
		    	    	    B[i][j] = 0;
		    	    }
		    }
		}
		FullMatrix mat = new FullMatrix();
		Solver sol = new Solver();
		System.out.println("When use Dirichlet boundary");
		double[] pro = mat.product(B, n);
		double[] n1 = sol.solution(A, pro);
		for(int i = 0; i < 3; i++) {
			n[i] = n1[i];
		}
		for(int t = 2; t <= 5; t++) {
			pro = mat.product(B, n);
			n1 = sol.solution(A, pro);
			System.out.println("When t = " + t);
			for(int i = 0; i < 3; i++) {
				n[i] = n1[i];
				System.out.println("n(x = " + (i + 1) + ") = " + n[i]);
			}
		}
		 /*Change the boundary condition to zero-slope Neumann*/
		A[0][0] = A[2][2] = 1 / deltat + D / (h * h);
		n[0] = 0;
		n[1] = 10;
		n[2] = 0;
		System.out.println("When use Neumann boundary");
		pro = mat.product(B, n);
		n1 = sol.solution(A, pro);
		for(int i = 0; i < 3; i++) {
			n[i] = n1[i];
		}
		for(int t = 2; t <= 5; t++) {
			pro = mat.product(B, n);
			n1 = sol.solution(A, pro);
			System.out.println("When t = " + t);
			for(int i = 0; i < 3; i++) {
				n[i] = n1[i];
				System.out.println("n(x = " + (i + 1) + ") = " + n[i]);
			}
		}
	}
}
