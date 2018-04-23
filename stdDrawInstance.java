import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class stdDrawInstance{
    public static void main(String[] args){
        //1.1���ƺ���
        /*
        {
            int N = 100;
            StdDraw.setXscale(0, N);
            StdDraw.setYscale(0, N*N);
            StdDraw.setPenRadius(.01);
            for(int i = 0; i<=N; i++){
                StdDraw.point(i, i);
                StdDraw.point(i, i*i);
                StdDraw.point(i, i*Math.log(i));
            }
        }*/
        //1.2�����������
        /*
        {
            int N=50;
            double[] a = new double[N];
            for(int i = 0; i<N; i++)
                a[i] = StdRandom.random();
            for(int i = 0; i<N; i++)
            {
                double x = 1.0*i/N;
                double y = a[i]/2.0;
                double rw = 0.5/N;
                double rh = a[i]/2.0;
                StdDraw.filledRectangle(x, y, rw, rh); //���ĵ�x,y,�����һ��
            }
        }*/
        //1.3 ��������������
        {
            int N=50;
            double[] a = new double[N];
            for(int i = 0; i<N; i++)
                a[i] = StdRandom.uniform();
            Arrays.sort(a);
            for(int i = 0; i<N; i++)
            {
                double x = 1.0*i/N;
                double y = a[i]/2.0;
                double rw = 0.5/N;
                double rh = a[i]/2.0;
                StdDraw.filledRectangle(x, y, rw, rh); //���ĵ�x,y,�����һ��
            }
        }
            
            
        
    }
}