package test;
class Animal {
  private int n;
  Animal(){  ////必须要写这个构造函数，不然子类的代码会出错。即父类存在其他构造函数时，父类中必须有默认构造函数
    System.out.println("Animal()");
  }
  Animal(int n) {
    System.out.println("Animal(int n)");
    this.n = n;
  }
  void go() {
	  System.out.println("animal go");
  }
}
// SubClass 类继承
class Dog extends Animal{
  private int n;
    //子类是不继承父类的构造器（构造方法或者构造函数）的，它只是调用（隐式或显式）。
	//  如果父类的构造器带有参数，则必须在子类的构造器中显式地通过 super 关键字调用父类的构造器并配以适当的参数列表。
	//如果父类构造器没有参数，则在子类的构造器中不需要使用 super 关键字调用父类构造器，系统会自动调用父类的无参构造器。
  Dog(){ // 自动调用父类的无参数构造器
    System.out.println("Dog");
  }  
  
  public Dog(int n){ 
    super(300);  // 调用父类中带有参数的构造器
    System.out.println("Dog(int n):"+n);
    this.n = n;
  }
  void go() {
	  super.go(); //若要在子类调用父类的方法，需使用关键字super。
  }

}
// SubClas2 类继承
class Duck extends Animal{
  private int n;
  
  Duck(){
    super(300);  // 调用父类中带有参数的构造器
    System.out.println("Duck");
  }  
  
  public Duck(int n){ // 自动调用父类的无参数构造器
    System.out.println("Duck(int n):"+n);
    this.n = n;
  }
}
public class class_extends{
  public static void main (String args[]){
    System.out.println("------Dog 类继承------");
    Dog sc1 = new Dog();
    Dog sc2 = new Dog(100); 
    sc1.go();
    System.out.println("------Duck 类继承------");
    Duck sc3 = new Duck();
    Duck sc4 = new Duck(200); 
  }
}