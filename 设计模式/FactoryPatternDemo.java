import java.awt.Shape;

/**
 * @author ZOE
 * @date 2019/8/22 19:38
 */
//抽象产品：提供了产品的接口
interface Shape1{
    public void show();
}

//具体产品1：实现抽象产品中的抽象方法
class Square1  implements Shape1{
    public void show(){
        System.out.println("Inside Square::draw() method.");
    }
}

//具体产品2：实现抽象产品中的抽象方法
class Circle1  implements Shape1{
    public void show(){
        System.out.println("Inside Circle::draw() method.");
    }
}

//抽象工厂：提供了厂品的生成方法
class ShapeFactory1{
    //使用 getShape 方法获取形状类型的对象
    public Shape1 getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle1();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square1();
        }
        return null;
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory1 ShapeFactory=new ShapeFactory1();
        
    }
}
