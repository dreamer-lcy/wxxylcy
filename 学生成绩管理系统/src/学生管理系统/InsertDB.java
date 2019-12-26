package 学生管理系统;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; 
public class InsertDB {
	private static final String user = "root";

    private static final String pwd = "123456";

    private static final String url = "jdbc:mysql://localhost:3306/xuesheng?serverTimezone=UTC";

    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection getCon() {

        Connection con = null;

        try {

            Class.forName(driver).newInstance();

            con = DriverManager.getConnection(url, user, pwd);

            if (con != null) {

                System.out.println("你已连接到数据库：" + con.getCatalog());

            }

        } catch (Exception e) {

            System.out.println("连接数据库失败！");

            e.printStackTrace();

        }

        return con;

    } 

    public boolean insertDB(String 学号, String 姓名, String 班级,

            String 数学 , String 语文, String 英语, String 理综,

            String 总分) {

        Connection con = null;

        Statement stm = null;

        boolean flag = false;

        String sql = "insert into t_FltPsgInfo values('" + 学号 + "','"

                + 姓名 + "','" + 班级 + "','" + 数学 + "','" + 语文

                + "','" + 英语 + "','" + 理综 + "','" + 总分 + "')";

        try {

            con = getCon();

            stm = con.createStatement();

            int i = stm.executeUpdate(sql);

            if (i > 0) {

                flag = true;

                System.out.println(flag + "插入数据成功！");

            }

        } catch (Exception e) {

            flag = false;

            e.printStackTrace();

        } finally {

            close(null, stm, con);

        }

        return flag;

    }

    //关闭相关连接

    public void close(ResultSet rs, Statement stm, Connection con) {

        if (rs != null)

            try {

                rs.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

        if (stm != null)

            try {

                stm.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

        if (con != null)

            try {

                con.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

    }
}
