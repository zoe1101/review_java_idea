package test;

public class Number_Math_String {
public static void main(String[] args) {
	Integer x = 5;
    Integer y =Integer.valueOf(9);  //����һ�� Number ����ָ����������������
	System.out.println(x.longValue()); //�� Number ����ת��Ϊxxx�������͵�ֵ�����ء�
	System.out.println(x.compareTo(3)); //��number����������Ƚϡ�
	System.out.println(x.equals(3)); // �ж�number�����Ƿ��������ȡ�
	
	System.out.println(y); 
	System.out.println(Math.sin(Math.PI/2));
	System.out.println(Math.min(4,7)); 
	System.out.println(Math.max(4,7)); 
	System.out.println(Math.round(3.8)); 
	System.out.println(Math.floor(3.8)); 
	System.out.println(Math.ceil(3.8)); 
	
    char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
    String helloString = new String(helloArray);  
    System.out.println( helloString );
    System.out.println( "�ҵ������� ".concat("Runoob"));  //�ַ���ƴ��
    System.out.println( "�ҵ������� "+"Runoob"); //�Ӻ�ƴ����ʽ�ĸ�д�� stringbuilder��Ҳ����˵������ʱ�üӺ�ƴ���ַ���û���κ�������ʧ��
    
    String str1="�ҵ������� ";
    int res=str1.compareTo("Runoob");  //compareTo(String)��������ʵ�Ǵ�ͷ��ʼ��һ��һ���ַ��ıȶ�ԭ�ַ����Ͳ����ַ����е��ַ��������ͬ����һ����ֱ���ַ����ֲ�ͬ������ĳһ���ַ��������ˣ��ͼ�����������ͬ�ַ���ASCII��Ĳ��Ϊ����ֵ��������ֱ�������ͬ�ͷ���0��
    System.out.println(res);
	
}
}
