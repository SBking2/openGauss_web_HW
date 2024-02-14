package openGauss.music.Bean;

public class User {
    private String m_name;
    private String m_password;

    public User(String name, String password)
    {
        m_name = name;
        m_password = password;
    }

    public void SetName(String name)
    {
        m_name = name;
    }
    public void SetPassword(String password) { m_password = password; }
    public String GetName() { return m_name; }
    public String GetPassword() { return m_password; }
}
