package openGauss.music.Service;

import openGauss.music.Bean.Song;
import openGauss.music.Dao.AlbumDao;
import openGauss.music.Dao.SingerDao;
import openGauss.music.Dao.SongDao;
import openGauss.music.Dao.UserDao;

import java.util.List;

public class MusicService {
    public static List<Song> GetAllSong()
    {
        SongDao dao = new SongDao();
        List<Song> songList = dao.GetAllSong();
        if(songList!=null &&songList.size()==0)
        {
            return null;
        }
        return songList;
    }

    public static Song GetSong(String songID)
    {
        SongDao dao = new SongDao();
        return dao.GetSong(songID);
    }

    //根据专辑ID收集歌曲
    public static List<Song> GetSongs(String albumID)
    {
        AlbumDao dao =new AlbumDao();
        return dao.GetSongs(albumID);
    }

    public static List<Song> GetSingerSongs(String singerID)
    {
        SingerDao dao =new SingerDao();
        return dao.GetSongs(singerID);
    }
    public static List<Song> GetAllAlbums()
    {
        AlbumDao dao =new AlbumDao();
        return dao.GetAllAlbums();
    }
    public static List<Song> GetAllSingers()
    {
        SingerDao dao = new SingerDao();
        return dao.GetAllSinger();
    }
    public static List<Song> GetLikeSongs(String name)
    {
        SongDao dao = new SongDao();
        return dao.GetLikeSong(name);
    }

    public static String AddSong(String songID, String songName, String albumID)
    {
        AlbumDao adao = new AlbumDao();
        SongDao sdao = new SongDao();
        String result = adao.IsExistAlbum(albumID);
        String result2 = sdao.IsExistSong(songID);
        if(!result.equals("succeed"))
        {
            return result;
        }
        if(result2.equals("succeed"))
        {
            return "已经有该歌曲!";
        }
        sdao.AddSong(songID, songName, albumID);
        return "succeed";
    }
    public static String AddAlbum(String albumID, String albumName, String singerID)
    {
        AlbumDao adao = new AlbumDao();
        SingerDao sdao = new SingerDao();
        String result = adao.IsExistAlbum(albumID);
        String result2 = sdao.IsExistSinger(singerID);
        if(result.equals("succeed"))
        {
            return "已经有该专辑！";
        }
        if(!result2.equals("succeed"))
        {
            return result2;
        }
        adao.AddAlbum(albumID, albumName, singerID);
        return "succeed";
    }

    public static String AddSinger(String singerID, String singerName)
    {
        SingerDao sdao = new SingerDao();
        String result = sdao.IsExistSinger(singerID);
        if(result.equals("succeed"))
        {
            return "已经有该歌手！";
        }
        sdao.AddSinger(singerID, singerName);
        return "succeed";
    }
    public static String DeleteSong(String songID)
    {
        SongDao dao = new SongDao();
        String result = dao.IsExistSong(songID);
        if(!result.equals("succeed"))
        {
            return "该歌曲不存在!";
        }
        dao.DeleteSong(songID);
        return "succeed";
    }
    public static String DeleteAlbum(String albumID)
    {
        AlbumDao dao = new AlbumDao();
        String result = dao.IsExistAlbum(albumID);
        if(!result.equals("succeed"))
        {
            return "该专辑不存在!";
        }
        dao.DeleteAlbum(albumID);
        return "succeed";
    }
    public static String DeleteSinger(String singerID)
    {
        SingerDao dao = new SingerDao();
        String result = dao.IsExistSinger(singerID);
        if(!result.equals("succeed"))
        {
            return "该歌手不存在!";
        }
        dao.DeleteSinger(singerID);
        return "succeed";
    }
    public static List<Song> GetSongData()
    {
        SongDao dao = new SongDao();
        return dao.GetSongData();
    }
    public static List<Song> GetAlbumData()
    {
        AlbumDao dao = new AlbumDao();
        return dao.GetAlbumData();
    }
    public static List<Song> GetSingerData()
    {
        SingerDao dao = new SingerDao();
        return dao.GetSingerData();
    }
    public static List<Song> GetSelectedSong(List<String> la, List<String> st)
    {
        SongDao dao = new SongDao();
        return dao.GetSelectedSong(la, st);
    }
}
