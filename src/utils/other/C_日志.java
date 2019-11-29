package utils.other;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C_日志 {
    public static void m_打印(String 日志) {
//        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm" + 日志).format(new Date())); //这行会报错。
        System.out.println(日志);
    }

}
