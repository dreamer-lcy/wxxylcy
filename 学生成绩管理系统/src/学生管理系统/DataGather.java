package ѧ������ϵͳ;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException; 
public class DataGather {
	 private static final String path = "src/resource/test";

	    public static final String openFileStyle = "r";

	    public static final String fieldLimitChar = ",";

	    public static final int fieldAllCount = 9;

	    private int count;

	    private String ѧ��;

	    private String ����;

	    private String �༶;

	    private String ����;

	    private String Ӣ��;

	    private String ��ѧ;

	    private String ����;

	    private String �ܷ�;


	    /*

	     * ���ܣ������ı��ļ�

	     */

	    public void loadFile() {

	        try {

	            RandomAccessFile raf = new RandomAccessFile(path, openFileStyle);

	            String line_record = raf.readLine();

	            while (line_record != null) {

	                // ����ÿһ����¼

	                parseRecord(line_record);

	                line_record = raf.readLine();

	            }

	            System.out.println("���кϷ��ļ�¼" + count + "��");

	        } catch (Exception e) {

	            e.printStackTrace();

	        }

	    }

	 

	    /*

	 * ���ܣ��������ÿһ����¼������������Ӻܶ�Լ�¼�Ľ����ж����������Ƿ�Ϊ��ĸ��

	* ���֡�email�ȡ�

	     */

	    private void parseRecord(String line_record) throws Exception {

	     //��ּ�¼

	        String[] fields = line_record.split(fieldLimitChar);

	        if (fields.length == fieldAllCount) {

	        	ѧ�� = tranStr(fields[0]);

	            ���� = tranStr(fields[1]);

	            �༶  = tranStr(fields[2]);

	            ��ѧ= tranStr(fields[3]);

	            ���� = tranStr(fields[4]);

	            Ӣ�� = tranStr(fields[5]);

	            ���� = tranStr(fields[6]);

	            �ܷ� = tranStr(fields[7]);

	            System.out.println(ѧ��+ " " + ���� + " " + �༶+ " "

	                    + ��ѧ + " " + ����+ " " + Ӣ�� + " " + ����

	                    + " " + �ܷ� );

	            InsertDB db = new InsertDB();

	            db.insertDB(ѧ��, ����, �༶, ��ѧ, ����, Ӣ��,

	                   ����, �ܷ�);

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
