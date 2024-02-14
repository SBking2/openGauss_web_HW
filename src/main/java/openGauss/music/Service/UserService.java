package openGauss.music.Service;

import openGauss.music.Bean.User;
import openGauss.music.Dao.UserDao;
import openGauss.music.util.MusicSystem;

public class UserService {
    public static boolean CheckLogin(User user)
    {
        UserDao dao = new UserDao();
        String paswd = dao.SearchPasswd(user.GetName());
        if(paswd != null && user.GetPassword().equals(paswd))
        {
            return true;
        }
        return false;
    }
    //修改用户
    public static String SetUserName(String name)
    {
        UserDao dao = new UserDao();
        if(!dao.IsExistUser(name).equals("succeed"))
        {
            dao.SetUserName(MusicSystem.GetInstance().GetUser().GetName(), name);
            return "succeed";
        }
        return "禁止和其他用户同名!";
    }
    public static void SetUserPassword(String passwd)
    {
        UserDao dao = new UserDao();
        dao.SetUserPassword(MusicSystem.GetInstance().GetUser().GetName(), passwd);
    }

    public static String RegisterUser(User user)
    {
        UserDao dao = new UserDao();
        String result = dao.Register(user.GetName(), user.GetPassword());
        return result;
    }
    public static boolean DeleteUser(String passwd)
    {
        UserDao dao = new UserDao();
        return dao.DeleteUser(MusicSystem.GetInstance().GetUser().GetName(), passwd);
    }
}
