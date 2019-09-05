/**
 * @author ZOE
 * @date 2019/9/5 15:30
 */

//1. 创建模型
class Student{
    private String rollNo;
    private String name;
    public  String getRollNo(){
        return rollNo;
    }
    public void setRollNo(String rollNo){
        this.rollNo=rollNo;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
//2. 创建视图
class StudentView{
    public void printStudentDetails(String studentName,String studentRollNo){
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}

//3. 创建控制器。
class StudentController{
    private Student model;
    private StudentView view;
    public StudentController(Student model,StudentView  view){
        this.model=model;
        this.view=view;
    }
    public void setStudentName(String name){
        model.setName(name);
    }
    public String getStudentName(){
        return model.getName();
    }
    public void setStudentRollNo(String rollNo){
        model.setRollNo(rollNo);
    }
    public String getStudentRollNo(){
        return model.getRollNo();
    }

    public void updateView(){
        view.printStudentDetails(model.getName(),model.getRollNo());
    }
}

//4. 演示 MVC 设计模式的用法。
public class MVCPatternDemo {
    public static void main(String[] args) {
        Student model=retrieveStudentFromDatabase();//从数据库获取学生记录
        StudentView view=new StudentView();//创建一个视图：把学生详细信息输出到控制台
        StudentController controller=new StudentController(model,view);
        controller.updateView();

        //更新模型数据
        controller.setStudentName("John");
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase(){
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }

}
