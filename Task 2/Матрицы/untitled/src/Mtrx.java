import java.util.Arrays;
public class Mtrx{
	public static void main(String[] args) {
	    Matrix m1 = new Matrix();
        int[][] mat1 = {{4, 3, 1}, {6, 6, 6}, {7, 6, 10}};
        int[][] mat2 = {{2, 3, 5}, {0, 0, 0}, {-1, 0, -4}};
    	m1.st = mat1;
    	m1.Pr();
		m1.Plus(mat2);
		m1.Minus(mat2);
		m1.IncOnNum(0);
		m1.IncOnMat(mat2);
		m1.Transp();
		m1.Ext(5);
	}
}

class Matrix{
    static int[][] st;
    static int[][] result;
    public static int Pr(){
        for (int i = 0; i < st.length; i++){
            System.out.println(Arrays.toString(st[i]));
	    }
	    return 0;
    }
    public static int[][] Plus(int[][] a){
        result = new int[st.length][st[0].length];
        for (int i = 0; i < st.length; i++){
            for (int j = 0; j < st[i].length; j++){
                result[i][j] = st[i][j] + a[i][j];
            }
            System.out.println(Arrays.toString(result[i]));
        }
        return result;
    }
    public static int[][] Minus(int[][] a){
        result = new int[st.length][st[0].length];
        for (int i = 0; i < st.length; i++){
            for (int j = 0; j < st[i].length; j++){
                result[i][j] = st[i][j] - a[i][j];
            }
            System.out.println(Arrays.toString(result[i]));
        }
        return result;
    }
    public static int[][] IncOnNum(int a){
        result = new int[st.length][st[0].length];
        for (int i = 0; i < st.length; i++){
            for (int j = 0; j < st[i].length; j++){
                result[i][j] = st[i][j] * a;
            }
            System.out.println(Arrays.toString(result[i]));
        }
        return result;
    }
    public static int[][] IncOnMat(int[][] a){
        int cnt = 0;
        result = new int[st.length][st[0].length];
        for (int i = 0; i < st.length; i++){
            for (int j = 0; j < st[i].length; j++){
                cnt = 0;
                for (int z = 0; z < st[i].length; z++){
                    cnt += st[i][z] * a[z][j];
                }
                result[i][j] = cnt;
            }
            System.out.println(Arrays.toString(result[i]));
        }
        return result;
    }
    public static int[][] Transp(){
        result = new int[st[0].length][st.length];
        for (int i = 0; i < st[0].length; i++){
            for (int j = 0; j < st.length; j++){
                result[i][j] = st[j][i];
            }
            System.out.println(Arrays.toString(result[i]));
        }
        return result;
    }
    public static int[][] Ext(int a){
        int cnt = 0;
        result = st.clone();
        for (int v = 0; v < a-1; v++){
            int[][] m_result = new int[st.length][st[0].length];
            for (int i = 0; i < st.length; i++){
                for (int j = 0; j < st[i].length; j++){
                    cnt = 0;
                    for (int z = 0; z < st[i].length; z++){
                        cnt += result[i][z] * st[z][j];
                    }
                    m_result[i][j] = cnt;
                }
                if (v == a-2){
                    System.out.println(Arrays.toString(m_result[i]));
                }
            }
            result = m_result.clone();
        }
        return result;
    }
}