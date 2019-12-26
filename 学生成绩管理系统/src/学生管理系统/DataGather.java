package 学生管理系统;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException; 
public class DataGather {
	 private static final String path = "src/resource/test";

	    public static final String openFileStyle = "r";

	    public static final String fieldLimitChar = ",";

	    public static final int fieldAllCount = 9;

	    private int count;

	    private String 学号;

	    private String 姓名;

	    private String 班级;

	    private String 语文;

	    private String 英语;

	    private String 数学;

	    private String 理综;

	    private String 总分;


	    /*

	     * 功能：解析文本文件

	     */

	    public void loadFile() {

	        try {

	            RandomAccessFile raf = new RandomAccessFile(path, openFileStyle);

	            String line_record = raf.readLine();

	            while (line_record != null) {

	                // 解析每一条记录

	                parseRecord(line_record);

	                line_record = raf.readLine();

	            }

	            System.out.println("共有合法的记录" + count + "条");

	        } catch (Exception e) {

	            e.printStackTrace();

	        }

	    }

	 

	    /*

	 * 功能：具体解析每一条记录，这里可以增加很多对记录的解析判断条件，如是否为字母、

	* 数字、email等。

	     */

	    private void parseRecord(String line_record) throws Exception {

	     //拆分记录

	        String[] fields = line_record.split(fieldLimitChar);

	        if (fields.length == fieldAllCount) {

	        	学号 = tranStr(fields[0]);

	            姓名 = tranStr(fields[1]);

	            班级  = tranStr(fields[2]);

	            数学= tranStr(fields[3]);

	            语文 = tranStr(fields[4]);

	            英语 = tranStr(fields[5]);

	            理综 = tranStr(fields[6]);

	            总分 = tranStr(fields[7]);

	            System.out.println(学号+ " " + 姓名 + " " + 班级+ " "

	                    + 数学 + " " + 语文+ " " + 英语 + " " + 理综

	                    + " " + 总分 );

	            InsertDB db = new InsertDB();

	            db.insertDB(学号, 姓名, 班级, 数学, 语文, 英语,

	                   理综, 总分);

	            count++;

	        }

	    }

	 

	    private String tranStr(String oldstr) {

	        String newstr = "";

	        try {

	            newstr = new String(oldstr.getBytes("ISO-8859-1"), "GBK");

	        } catch (UnsupportedEncodingException e) {

	            e.printStackTrace();

	        }

	        return newstr;

	    }
}
