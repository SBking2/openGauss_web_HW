package openGauss.music.Dao;

import openGauss.music.Bean.Song;
import openGauss.music.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    //输入用户名，返回密码
    public String SearchPasswd(String userName)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return null;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from userinfo where username = ?");

        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setObject(1,userName);
            rs = ps.executeQuery();
            if(rs.next())
            {
                String name = rs.getString("username");
                String pwd = rs.getString("userpassword");
                return pwd;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void SetUserName(String userName, String updateName)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" update userinfo set username = '"+updateName+"' where username='"+userName+"'");

        try {
            ps = conn.prepareStatement(sb.toString());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String IsExistUser(String userName)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return "连接失败！";
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from userinfo where username ='" +
                userName +
                "' ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            if(rs.next())
            {
                return "succeed";
            }
            return "没有这个用户!";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "error!";
    }

    public void SetUserPassword(String userName, String password)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" update userinfo set userpassword = '"+password+"' where username='"+userName+"'");

        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String Register(String userName, String password)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return "connect failed!";
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from userinfo where username ="+"'"+userName+"';");
        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            if(rs.next())
            {
                return "User is already exist!";
            }else
            {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("insert into userinfo values('"+userName+"','"+password+"');");
                ps = conn.prepareStatement(sb2.toString());
                ps.execute();
                return "succeed";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean DeleteUser(String username, String passwd)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return false;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from userinfo where username ="+"'"+username+"'" +
                " and userpassword = '"+passwd+"' ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            if(rs.next())
            {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("delete from userinfo where username = '"+username+"' ;");
                ps = conn.prepareStatement(sb2.toString());
                ps.execute();
                return true;
            }else
            {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
