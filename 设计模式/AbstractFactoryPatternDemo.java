import java.util.Collections;

/**
 * @author ZOE
 * @date 2019/8/22 20:22
 */
//为形状创建一个接口。
interface Shape{
    void draw();
}
//创建实现接口的实体类。
class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

//为颜色创建一个接口。
interface Color{
    void fill();
}
//创建实现接口的实体类。
class Red implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}

class Green  implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}

class Blue implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Blue ::fill() method.");
    }
}

//    为 Color 和 Shape 对象创建抽象类来获取工厂。

abstract class AbstractFactory2{
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}

//    创建扩展了 AbstractFactory 的工厂类，基于给定的信息生成实体类的对象。

class ShapeFactory extends AbstractFactory2{

    @Override
    public Shape getShape(String shape) {
        if (shape==null){
            return null;
        }
        if (shape.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if (shape.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if (shape.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
    @Override
    public Color getColor(String color) {
        return null;
    }
}

class ColorFactory extends AbstractFactory2{

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if (color.equalsIgnoreCase("RED")){
            return new Red();
        }else if (color.equalsIgnoreCase("GREEN")){
            return new Green();
        }else if (color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}

//创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
class FactoryProducer{
    public static AbstractFactory2 getFactory(String choice){
        if (choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        }else if (choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
//    使用 FactoryProducer 来获取 AbstractFactory，通过传递类型信息来获取实体类的对象。
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory2 shapeFactory=FactoryProducer.getFactory("Shape");
        Shape shape1=shapeFactory.getShape("CIRCLE");//获取形状为 Circle 的对象
        shape1.draw();//调用 Circle 的 draw 方法

        Shape shape2=shapeFactory.getShape("RECTANGLE");//获取形状为 Rectangle  的对象
        shape2.draw();

        //获取颜色工厂
        AbstractFactory2 colorFactory=FactoryProducer.getFactory("COLOR");
        Color color1=colorFactory.getColor("RED");//获取颜色为 Red 的对象
        color1.fill();
        Color color2=colorFactory.getColor("RED");//获取颜色为 Green  的对象
        color2.fill();

    }
}
