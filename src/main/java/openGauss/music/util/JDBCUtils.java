package openGauss.music.util;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

//这是一个单例模式类
public class JDBCUtils {

    private Connection connection;

    private static JDBCUtils m_instance = null;

    public static JDBCUtils GetInstance(){
        if(m_instance==null)
        {
            m_instance = new JDBCUtils();
        }
        return  m_instance;
    }

    //构造函数
    private JDBCUtils(){
        Properties properties = new Properties();
        //读取配置文件
        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("DBconf.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String userName = properties.getProperty("username");
        String password = properties.getProperty("password");
        String DBurl = properties.getProperty("url");
        String DBdriver = properties.getProperty("driver");

        System.out.println(userName+ "\n"+password+"\n"+DBurl+"\n"+DBdriver+"\n");

        try {
            Class.forName(DBdriver);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DBurl, userName, password);
            System.out.println("Connect succeed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection GetConnection()
    {
        return connection;
    }
}
