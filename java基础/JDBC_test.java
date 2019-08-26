/**
 * @author ZOE
 * @date 2019/8/14 12:55
 */
import java.sql.*; //导入java.sql包

public class JDBC_test {
//    定义记录的类（可选）
    static class Product {
        private String prod_id ;
        private int vend_id;
        private String prod_name;
        private double prod_price;
        private String prod_desc;

        Product(String prod_id,int vend_id, String prod_name, double prod_price,String prod_desc) {
            this.prod_id = prod_id; //default
            this.vend_id = vend_id;
            this.prod_name = prod_name;
            this.prod_price = prod_price;
            this.prod_desc=prod_desc;
        }

        public String getProd_id() {
            return prod_id;
        }
        public void setProd_id(String Id) {
            this.prod_id = Id;
        }

        public int getVend_id() {
            return vend_id;
        }
        public void setVend_id(int Id) {
            this.vend_id = Id;
        }

        public String getProd_name() {
            return prod_name;
        }
        public void setProd_name(String Name) {
            this.prod_name = Name;
        }

        public double getProd_price() {
            return prod_price;
        }
        public void setProd_price(int price) {
            this.prod_price = price;
        }

        public String getProd_desc() {
            return prod_desc;
        }
        public void setProd_desc(String desc) {
            this.prod_desc = desc;
        }
    }


//    连接的获取
    public static Connection getConn() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/mysql_scripts?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
        String user="root";
        String password="121245";
        Connection conn=null;
        try{
            Class.forName(driver);  //加载驱动程序
            //建立连接
            conn=DriverManager.getConnection(url,user,password); //通过getConnection建立连接。
            System.out.println("数据库连接成功");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;

    }
//    insert
    public static int insert(Product product) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into products (prod_id,vend_id ,prod_name,prod_price,prod_desc) values(?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);

//            第一个参数是该参数在语句中的索引。参数标记具有从 1 开始的编号。 通常指的是第一个“？”
//            第二个参数是要对第一个参数设置的值。
            pstmt.setString(1, product.getProd_id()); //给第一个问号设置的值为product.getProd_id()
            pstmt.setInt(2, product.getVend_id());
            pstmt.setString(3, product.getProd_name());
            pstmt.setDouble(4, product.getProd_price());
            pstmt.setString(5, product.getProd_desc());

            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

//    update
    private static int update(Product product) {
        Connection conn = getConn();
        int i = 0;
        String sql = "update products set prod_price='" + product.getProd_price() + "' where prod_name='" + product.getProd_name() + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

//    delete
    private static int delete(String prod_id) {
        Connection conn = getConn();
        int i = 0;
        String sql = "delete from products where prod_id='" + prod_id + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }


//    select
    private static Integer getAll() {
        Connection conn = getConn();
        String sql = "select * from products";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {

        insert(new Product("TNT3",1003,"TNT (7 sticks)",15.00,"TNT, red, pack of 15 sticks"));
        getAll();
        update(new Product(null,0,"TNT (7 sticks)", 14.24,""));
        getAll();
        delete("TNT3");
        getAll();

    }

}
