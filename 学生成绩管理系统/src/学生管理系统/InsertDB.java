package ѧ������ϵͳ;
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

                System.out.println("�������ӵ����ݿ⣺" + con.getCatalog());

            }

        } catch (Exception e) {

            System.out.println("�������ݿ�ʧ�ܣ�");

            e.printStackTrace();

        }

        return con;

    } 

    public boolean insertDB(String ѧ��, String ����, String �༶,

            String ��ѧ , String ����, String Ӣ��, String ����,

            String �ܷ�) {

        Connection con = null;

        Statement stm = null;

        boolean flag = false;

        String sql = "insert into t_FltPsgInfo values('" + ѧ�� + "','"

                + ���� + "','" + �༶ + "','" + ��ѧ + "','" + ����

                + "','" + Ӣ�� + "','" + ���� + "','" + �ܷ� + "')";

        try {

            con = getCon();

            stm = con.createStatement();

            int i = stm.executeUpdate(sql);

            if (i > 0) {

                flag = true;

                System.out.println(flag + "�������ݳɹ���");

            }

        } catch (Exception e) {

            flag = false;

            e.printStackTrace();

        } finally {

            close(null, stm, con);

        }

        return flag;

    }

    //�ر��������

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
