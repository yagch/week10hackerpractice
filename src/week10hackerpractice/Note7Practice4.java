package week10hackerpractice;

public class Note7Practice4 {
	public static void main(String[] arg) {
		double deltax = 1;
		double deltat = 1;
		double v = 1;
		double[][] A = new double[5][5];
		double[][] B = new double[5][5];
		double k1 = deltat + v / deltax;
		double k2 = -v / deltax;
		double[] u = {0,10,0,0,0};
		
		for(int i = 0; i < 5; i++) {
		    for(int j = 0; j < 5; j++) {
		    	    if(i == j) {
		    	    	    A[i][j] = 1 / deltat;
		    	    }
		    	    else {
		    	    	    A[i][j] = 0;
		    	    }
		    }
		}
		for(int i = 0; i < 5; i++) {
		    for(int j = 0; j < 5; j++) {
		    	    if(i == j) {
		    	    	    B[i][j] = k1;
		    	    	    if(i > 0) {
		    	    	    	    B[i][i - 1] = k2;
		    	    	    }
		    	    }
		    	    else {
		    	    	    B[i][j] = 0;
		    	    }
		    }
		}
		FullMatrix mat = new FullMatrix();
		Solver sol = new Solver();
		double[] pro = mat.product(B, u);
		double[] u1 = sol.solution(A, pro);
		for(int i = 0; i < 5; i++) {
			u[i] = u1[i];
		}
		for(int t = 2; t <= 5; t++) {
			pro = mat.product(B, u);
			u1 = sol.solution(A, pro);
			System.out.println("When t = " + t);
			for(int i = 0; i < 5; i++) {
				u[i] = u1[i];
				System.out.println("u(x = " + (i + 1) + ") = " + u[i]);
			}
		}
	}
}
