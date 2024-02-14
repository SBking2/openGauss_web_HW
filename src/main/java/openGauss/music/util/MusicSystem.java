package openGauss.music.util;


import openGauss.music.Bean.Song;
import openGauss.music.Bean.User;

public class MusicSystem {

    private static MusicSystem m_instance = null;
    private Song m_currentSong;
    private User m_currentUser;

    private MusicSystem(){
        m_currentSong = null;
        m_currentUser = new User("未登录","1111");
    }

    public static MusicSystem GetInstance()
    {
        if(m_instance == null)
        {
            m_instance = new MusicSystem();
        }
        return m_instance;
    }

    public void SetSong(Song song)
    {
        m_currentSong = song;
    }
    public Song GetSong() {return m_currentSong;}
    public User GetUser() { return m_currentUser;}
    public void SetUser(User user){m_currentUser = user; }
}
