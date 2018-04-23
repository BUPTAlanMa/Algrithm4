import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.util.*;
import java.lang.*;
import java.io.*;

import edu.princeton.cs.algs4.StdOut;

public class practice1_1 {
	
	// 1.1 计算绝对值
    public static int abs(int x)
    {
        if (x>0)
            return x;
        else
            return -x;
    }
    
// 1.2 判断一个数是否是素数
    public static boolean isPrime(int N)
    {
        if(N < 2)
            return false;
        for(int i = 2; i*i < N; i++)
        {
            if(N % i == 0)
                return false;                    
        }
        return true;  
    }
// 1.3 计算平方根
    public static double sqrt(double x)
    {
        if(x < 0)
            return Double.NaN;
        double err = 1e-15;
        double t = x;
        while(Math.abs(t-x/t) > err*t)
        {
            t = (x/t + t) / 2.0;
        }
        return t;
    }
// 1.4 计算三角形的斜边
    public static double hypotnuse(double a, double b)
    {
         return sqrt(a*a + b*b);
    }
    // 1.4 计算调和级数
    public static double H(int N)
    {
        double sum = 0.0;
        for(int i = 1; i <= N; i++)
        {
            sum += 1.0/i;
        }
        return sum;
    }
    // 1.5 二分查找，数组为有序数组
    public static int BinarySearch(int key, int[] a)
    {
        int low = 0;
        int up = a.length - 1;
        while(low <= up)
        {
            int middle = low + (up - low) / 2;
            if(key == a[middle])
            {
                return middle;
            }
            else if(key >  a[middle])
            {
                low = middle + 1;
            }
            else
            {
                up = middle -1;
            }
        }
        return -1;
    }
    // 1.5.1 二分查找，数组为有序数组, 递归版本
    public static int Ordered_BinarySearch(int key, int[] a, int lo, int hi)
    {
        if(lo > hi)
            return -1;
        else{
            int mid = lo + (hi - lo) / 2;
            if(key > a[mid])
                return Ordered_BinarySearch(key, a, mid + 1, hi);
            else if(key < a[mid])
                return Ordered_BinarySearch(key, a, lo, mid - 1);
            else
                return mid;
        }
    }
    public static int Ordered_BinarySearch(int key, int[] a)
    {
        return Ordered_BinarySearch(key, a, 0, a.length -1);
    }
	
	/// 课后练习 1.1.5
	public static boolean checkdouble(double x, double y)
	{
        if(0 < x &&  x < 1 && 0 < y && y < 1)
        	return true;
        else
        	return false;
	}
	// 习题1.1.14 编写静态log方法，返回不大于log2N的最大整数
	public static int lg(int N)
	{   int a = 0; 
        for(int n = N; n > 1; n /= 2)
        	a += 1;
        return a;
	}
	// 习题1.1.18 效果相当于a*b
	public static int mystery(int a, int b)
	{   if(b == 0)
			return 0;
	    if(b % 2 ==0)
	    	return mystery(a+a, b/2);
	    return mystery(a+a, b/2) + a;
        
	}
	// 习题1.1.18 效果相当于-a.^b
	public static int mystery_(int a, int b)
	{   if(b == 0)
			return -1;
	    if(b % 2 ==0)
	    	return mystery(a+a, b/2);
	    return mystery(a+a, b/2) * a;
        
	}
	// 习题1.1.24 Euclidean Algorithm求最大公约数
	// 原理：http://blog.csdn.net/pqqqan/article/details/78482152
	// 代码：https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;   
        return gcd(b%a, a);
    }
    // 习题1.1.24 二项分布
    public static double binomial(int N, int k, double p)
    {
    	double  midResult[] = new double[N];
    	if(N==0 && k==0)
    	{
    		return 1.0;
    	}
    	if(N<0 || k<0)
    	{
    		return 0.0;
    	}
    	//midResult[N - 1] = ;
    	return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
    }
    // 习题1.1.28 已排序数组删除重复元素
    public static int[] Deduplication (int[] arr)
    {
    	//空数组最好是 int[] zero = new int[0];而不是 int[] zero = null;
    	//前者的好处是返回的是长度为0的数组，数组时真实存在的。而后者是指向了null.后者往往要进行null的检查。
    	
    	if(arr.length > 0)
    	{
    		int[] _unique_arr = new int[arr.length];
    		_unique_arr[0] = arr[0];
        	int index = 0;

    		for(int i= 1; i < arr.length; i++)
    		{
    			if(arr[i] != _unique_arr[index])
    			{
    				index += 1;
    				_unique_arr[index] = arr[i];
    			} 			
    		}
    		
    		//
    		int[] unique_arr = new int[index + 1];
    		for(int i = 0; i < index + 1; i++)
    		{
    			unique_arr[i] = _unique_arr[i];
    		}
    		
    		return unique_arr;
    	}
    	else
    		return new int[0]; //返回空数组
    	
    }   
    
    
    // 习题 1.1.29 等键值
    /**
     * 返回已排序（升序）数组中小于该键的元素数量
     * @param a the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return 数组中小于该键的元素数量
     */
    public static int rank(int[] arr, int key) {
    	//两种情况，case1:数组不存在等于该键的数值，case2,数组存在等于该键的数值，并可能有多个
    	int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < arr[mid]) hi = mid - 1;
            else if (key > arr[mid]) lo = mid + 1;
            else{
            	// case2
            	mid -= 1;
            	while(arr[mid] >= key && mid >= 0)
            	{
            		mid -= 1;
            	}
            	return mid + 1;
            }
        }
        // case1        
        return hi + 1;
    	
    }
    
    /**
     * 返回已排序（升序）数组中等于该键的元素数量
     * @param a
     * @param key
     * @return 数组中等于该键的元素数量
     */
    public static int count(int[] arr, int key) {
    	int index = rank(arr, key); //从小于该键的索引的下一个元素开始检测
    	int count = 0;
    	while(index < arr.length && arr[index] <= key)
    	{
    		if(arr[index] == key)
    			count += 1;
    		index += 1;
    	}
    	return count;
    	
    }  
    
    //习题1.1.29 判断元素是否互质
    /**  两个元素互质，即最大公约数为1.所以实际上是利用欧几里得算法计算最大公约数
     *   温习求最大公约数，辗转相除法
     * @param a a需大于0
     * @param b b需大于0
     * @return boolean结果
     */
    public static boolean IsRelativePrime(int a, int b)
    {  		
		if(a <=0 || b <= 0)
		{
			throw new IllegalArgumentException("a, b must be greater than 0");
		}	
		if(a == 1 || b == 1)
			return false;
		if(gcd(a, b) == 1)
			return false;
		else
			return true;
    	
    }
    

	/** 由下标i,j是否互质给出新的矩阵。易知，结果a(i,j) = a(j,i)
     * @param mat
     * @return
     */
    public static boolean[][] MagicMatrix(int[][] mat)
    {
    	boolean[][] boolMat = new boolean[mat.length][mat[0].length];
    	for(int i = 0; i < mat.length; i++)
    	{
    		for(int j = 0; j <= i; j++)
    		{
    			boolMat[i][j] = boolMat[j][i] = IsRelativePrime(i+1, j+1);
    		}
    	}
    	return boolMat;
    	
    }

    //习题1.1.29 随机连接
    // 画圆    
    /**
     * @param x 圆心x坐标
     * @param y 圆心y坐标
     * @param r 圆半径
     */
    public static void drawCircle(double x, double y, double r) {
    	StdDraw.setXscale(0, 2 * x);
    	StdDraw.setYscale(0, 2 * y);
    	StdDraw.setPenRadius(0.003);
    	StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
    	StdDraw.circle(x, y, r);
    }
    // 画圆上的点，等间隔取N个点
    /**
     * @param x 圆心x坐标
     * @param y 圆心y坐标
     * @param r 圆半径
     * @param N 点的个数
     */
    public static double[][] drawCirclePoints(double x, double y, double r, int N)
    {
    	double[][] CirclePoints = new double[N][2];
    	StdDraw.setPenRadius(0.005);
    	StdDraw.setPenColor(StdDraw.BOOK_RED);
    	double deltaTheta = 2 * Math.PI / N;
    	for(int i = 0; i < N; i++)
    	{
    		CirclePoints[i][0] = x + r * Math.cos(i * deltaTheta);
    		CirclePoints[i][1] = y + r * Math.sin(i * deltaTheta);
    		StdDraw.point(CirclePoints[i][0], CirclePoints[i][1]);
    	}
    	
    	return CirclePoints;
    	
    }
    //每对点按照概率P用灰线连接
    public static void RandomLink(double[][] CirclePoints, double p)
    {
    	if(p < 0 || p > 1)
    		throw new IllegalArgumentException("p must be in the [0, 1]");
    	
    	StdDraw.setPenRadius(0.002);
    	StdDraw.setPenColor(StdDraw.LIGHT_GRAY); 
    	
    	// 每对点
    	/*
    	for(int i = 0; i < CirclePoints.length; i++)
    	{
    		for(int j = 0; j < CirclePoints.length; j++)
    		{
    			if(i != j && StdRandom.bernoulli(p))
    			{
    				StdDraw.line(CirclePoints[i][0], CirclePoints[i][1], CirclePoints[j][0], CirclePoints[j][1]);  
    			}
    		}
    	}
    	*/
    	// 每对点，不含重复
    	for(int i = 0; i < CirclePoints.length; i++)
    	{
    		for(int j = i + 1; j < CirclePoints.length; j++)
    		{
    			if(StdRandom.bernoulli(p))
    			{
    				StdDraw.line(CirclePoints[i][0], CirclePoints[i][1], CirclePoints[j][0], CirclePoints[j][1]);  
    			}
    		}
    	}   	
    		
    }
    
    //习题1.1.32 直方图
    public static void Histgram(double[] input, double l, double r, int N)
    {
    	double minValue, maxValue;
    	if(l == r)
    		throw new IllegalArgumentException("l must be not equal with r");
    	if(l < r)
    	{
    		minValue = l;
    		maxValue = r;
    	}
    	else
    	{
    		minValue = r;
    		maxValue = l;
    	}
    	double deltaValue = (maxValue- minValue) / N;
    	
    	// 构造等差数组
    	double[] binScale = new double[N+1];
    	for (int i = 0; i < binScale.length; i++) {
    		binScale[i] = minValue + i * deltaValue;
		}
    	
    	// 将输入落入对应区间， 原始想法：问题转换为给定key值，找bins中小于该key的
    	// 更好的想法， (key - minValue) / deltaValue 
    	double[] bins = new double[N];
    	for (int i = 0; i < input.length; i++) {
			if(input[i] >= minValue && input[i] <= maxValue)
			{
				// 强制类型转换是截断取整，相当于floor
				bins[(int)((input[i] - minValue) / deltaValue)] += 1; 
			}
    		
		}
    	// 绘制直方图
    	for (int i = 0; i < N; i++) {
			double x = 1.0 * i / N;
			double y = bins[i] / 2.0;
			double rw = 0.5 / N;
			double rh = bins[i] / 2.0;			
			StdDraw.filledRectangle(x, y, rw, rh);			
		}
    	
    		
    		
    }
    
    
    public static void main(String[] args) { 
        System.out.println(abs(-4));
        System.out.println("Binary Search.....");
        int[] a = {0, 3, 5, 7, 8};
        System.out.println(BinarySearch(4, a));
        System.out.println("Hello, World");
        System.out.println(2.0e-6*100000000.1);
        System.out.println(true && false || true && true);
        
        /// 课后练习 1.1.3,判断输入的三个整数是否相等
        /*
        int int3[] = {0, 0, 0};
        Scanner sc1 = new Scanner(System.in);
        for(int i = 0; i < 3 && sc1.hasNextInt(); i++)
        {
        	int3[i] = sc1.nextInt();
        }
        if(int3[0]==int3[1] && int3[1] == int3[2])
        	StdOut.println("equal");
        else
        	StdOut.println("not equal");
        */
        /// 课后练习 1.1.5， 判断输入的两个double是否都在0到1之间
        /*
        double double2[] = {0, 0};
        Scanner sc2 = new Scanner(System.in);
        for(int i = 0; i < 2 && sc2.hasNextDouble(); i++)
        {
        	double2[i] = sc2.nextDouble();
        }
        System.out.println(checkdouble(double2[0], double2[1]));
        */
        // 习题1.1.8，注意'a'与"a"的区别
        System.out.println((char)('a' + 4));
        // 习题1.1.9 将一个正整数用二进制表示并转换为一个String
        /*
        int N = 331;
        String s = "";
        for(int n = N; n>0; n/=2)
        	s= (n % 2) + s;
        System.out.println(s);
        */
        // 习题1.1.14 编写静态log方法，返回不大于log2N的最大整数
        System.out.println(lg(21));
        // 习题1.1.14
        System.out.println(mystery(2, 25));
        // 习题1.1.28 已排序数组删除重复元素
        int[] arr = {1,2,3,3,3,4};
        Deduplication (arr);
        // 习题1.1.29，测试rank, count
    	int[] arr_ = {1,3,5,5,5,6,12,14};
    	int _key = 5;
    	StdOut.println(rank(arr_, _key));
    	StdOut.println(count(arr_, _key));
        //习题1.1.30 
    	//StdOut.println(IsRelativePrime(1, 2));
    	//int[][] mat = {{1,3,5,5},{5,6,12,14},{1,1,1,1},{1,1,1,1}};
    	//MagicMatrix(mat);
    	//习题1.1.31
    	/*
    	drawCircle(10,10,5);
    	double[][] CirclePoints = drawCirclePoints(10, 10, 5, 10);
    	RandomLink(CirclePoints, 0.5);
    	*/
    	
    	/*
    	//习题1.1.32
    	double[] input = {1.1,3.2,5.7,5.2,5.5,6.1,12.2,14.6};
    	Histgram(input, 1, 15, 100);
    	*/
        
                
    }
}