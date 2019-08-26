package test;

public class class_A {
	int age;
	public class_A (String name) {
		 //这个构造器仅有一个参数：name
	      System.out.println("小狗的名字是 : " + name ); 
	}

	public void setage(int a) {
		age=a;
		
	}
	public int getage() {
		System.out.println("小狗的年龄是 : " + age ); 
		return age;
	}
   public static void main(String[] args){
	     
	   class_A myclass = new class_A("tl");  //创建对象,实例化对象
	   myclass.setage(4);  //设定age
	   myclass.getage();  //获取age
	   System.out.println("变量值 : " + myclass.age );  //也可以这样访问成员变量
	   }
}
