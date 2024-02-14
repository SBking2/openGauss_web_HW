package openGauss.music.Bean;

public class Song {
    private String m_songID;
    private String m_songName;
    private String m_singerID;
    private String m_singerName;
    private String m_albumID;
    private String m_albumName;
    private String m_songlanguage;
    private String m_songstyle;

    public Song(String songID, String songName,
                String singerID, String singerName,
                String albumID, String albumName)
    {
        m_songID = songID;
        m_songName = songName;
        m_singerID = singerID;
        m_singerName = singerName;
        m_albumID = albumID;
        m_albumName = albumName;
        m_songlanguage = null;
        m_songstyle = null;
    }
    public String GetSongID(){return m_songID; }
    public String GetSongName(){ return m_songName; }
    public String GetSingerID(){return m_singerID; }
    public String GetSingerName(){ return m_singerName; }
    public String GetAlbumID(){return m_albumID; }
    public String GetAlbumName(){ return m_albumName; }
    public String GetSongLa(){ return m_songlanguage; }
    public String GetSongSt(){return m_songstyle; }
    public void SetSongLa(String la){m_songlanguage=la; }
    public void SetSongSt(String st){m_songstyle=st; }
}
