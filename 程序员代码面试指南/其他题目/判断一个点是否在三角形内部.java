package 其他题目;

public class 判断一个点是否在三角形内部 {
	//以O点为向三个顶点连线，计算分块的面积，然后与本来的大三角形面积进行对比
	//存在面积算不准的风险
	public static boolean isInside1(double x1,double y1,double x2,double y2,
									double x3,double y3,double x,double y) {
		double area1=getArea(x1, y1, x2, y2, x, y);
		double area2=getArea(x1, y1, x3, y3, x, y);
		double area3=getArea(x2, y2, x3, y3, x, y);
		double area=getArea(x1, y1, x2, y2, x3, y3);
		return area1+area2+area3>=area?true:false;
		
	}
	public static double getArea(double x1,double y1,double x2,double y2,double x3,double y3) {
		double side1Len=getSideLength(x1, y1, x2, y2);
		double side2Len=getSideLength(x1, y1, x3, y3);
		double side3Len=getSideLength(x2, y2, x3, y3);
		double p=(side1Len+side2Len+side3Len)/2;
		//利用海伦公式求解s=sqrt(p*(p-a)*(p-b)*(p-c))
		return Math.sqrt((p-side1Len)*(p-side2Len)*(p-side3Len)*p); 
	}
	//获得边长，两点间的距离
	public static double getSideLength(double x1,double y1,double x2,double y2) {
		double a=Math.abs(x1-x2);
		double b=Math.abs(y1-y2);
		return Math.sqrt(a*a+b*b);
	}
	//如果三角形的点按照逆时针依次输入，O点在三角形内部的话，那么沿着逆时针行走，O点始终处于左手方向。
	public static boolean isInside2(double x1,double y1,double x2,double y2,
			double x3,double y3,double x,double y) {
		//判断三角形的点是否按照逆时针依次输入
		if (crossProduct(x3-x1, y3-y1, x2-x1, y2-y1)>=0) { //不是,则改变点顺序
			double tmpx=x2;
			double tmpy=y2;
			x2=x3;
			y2=y3;
			x3=tmpx;
			y3=tmpy;
			
		}
		if (crossProduct(x2-x1, y2-y2, x-x1, y-y1)<0) {
			return false;
		}
		if (crossProduct(x3-x2, y3-y2, x-x2, y-y2)<0) {
			return false;
		}
		if (crossProduct(x1-x3, y1-y3, x-x3, y-y3)<0) {
			return false;
		}
		
		return true;
	}
	//叉乘。
	public static double crossProduct(double x1,double y1,double x2,double y2) {
		return x1*y2-x2*y1; //交叉相乘
	}
	

}
