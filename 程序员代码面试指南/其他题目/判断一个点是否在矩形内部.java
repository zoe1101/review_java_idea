package 其他题目;

public class 判断一个点是否在矩形内部 {
	/*
	 一个矩形可以由4个点来表示，
	 (x1,y1)为最左的点，即x1在x轴最小
	 (x2,y2)为最上的点，即y2在y轴最大
	 (x3,y3)为最下的点，即y3在y轴最小
	 (x4,y4)为最右的点，即x4在x轴最大
	 */
	public static boolean isInside(double x1,double y1,double x2,double y2,double x3,double y3,
									double x4,double y4,double x,double y) {
		//矩形边平行于x轴或y轴
		if (y1==y2) {
			return isInside(x1, y1, x2, x4, y4, x, y);
		}
		//坐标变换，把矩形转成平行，所有点跟着动
		double l=Math.abs(y4-y3);
		double k=Math.abs(x4-x3);
		double s=Math.sqrt(k*k+l*l);
		double sin=l/s;
		double cos=k/s;
		double x1R=cos*x1+sin*y1;
		double y1R=-sin*x1+cos*y1;
		double x4R=cos*x4+sin*y4;
		double y4R=-sin*x4+cos*y4;
		double xR=cos*x+sin*y;
		double yR=-sin*x+cos*y;
		 //旋转完成，变成平行的情况
		return isInside(x1R, y1R, x2, x4R, y4R, xR, yR);
	}
	//矩阵是平行于坐标轴（x或y）的
	 //默认:1点在左上,4点在右下
	public static boolean isInside(double x1,double y1,double x2,double x4,double y4,double x,double y) {
		if (x<=x1) { //在矩形下侧
			return false;
		}
		if (x>=x4) { //在矩形上侧
			return false;
		}
		if (y>=y1) { //在矩形上侧
			return false;
		}
		if (y<=y4) { //在矩形下侧
			return false;
		}
		return true;
	}

}
