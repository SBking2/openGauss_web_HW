package openGauss.music.Dao;

import openGauss.music.Bean.Song;
import openGauss.music.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SingerDao {
    public List<Song> GetSongs(String SingerID)
    {
        List<Song> songList = new ArrayList<>();
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return null;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" select song.songid, songname, singer.singerid, singername, album.albumid, albumname " +
                " from singer, album, song, songinfo, albuminfo" +
                " where song.songid = songinfo.songid"+
                " and albuminfo.albumid = album.albumid" +
                " and album.albumid = songinfo.albumid" +
                " and albuminfo.singerid = singer.singerid" +
                " and singer.singerid ="+ "'" + SingerID+ "'");

        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            while (rs.next())
            {
                String songId = rs.getString("songid");
                String songName = rs.getString("songname");
                String singerID = rs.getString("singerid");
                String singername = rs.getString("singername");
                String albumID = rs.getString("albumid");
                String albumName = rs.getString("albumname");
                Song song = new Song(songId,songName,singerID ,singername, albumID,albumName);
                songList.add(song);
            }
            return songList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public List<Song> GetAllSinger()
    {
        List<Song> songList = new ArrayList<>();
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return null;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select singer.singerid, singer.singername"+
                " from singer;");

        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            while (rs.next())
            {
                String singerID = rs.getString("singerid");
                String singername = rs.getString("singername");
                Song song = new Song("none","none",singerID ,singername, "none","none");
                songList.add(song);
            }
            return songList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String IsExistSinger(String singerID)
    {
        List<Song> songList = new ArrayList<>();
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return "连接失败！";
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from singer where singer.singerid ='" +
                singerID +
                "' ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            if(rs.next())
            {
                return "succeed";
            }
            return "没有这个歌手!";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "error!";
    }

    public void AddSinger(String singerID,String singerName)
    {
        List<Song> songList = new ArrayList<>();
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("insert into singer values('" +
                singerID +
                "','" +
                singerName +
                "') ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void DeleteSingerInfo(String singerID)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from albuminfo where singerid='" +
                singerID +
                "' ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            AlbumDao dao = new AlbumDao();
            while (rs.next())
            {
                String albumID = rs.getString("albumid");
                dao.DeleteAlbum(albumID);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return;
    }

    public void DeleteSinger(String singerID)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null) {
            return;
        }
        DeleteSingerInfo(singerID);
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("delete from singer where singerid='" +
                singerID +
                "' ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Song> GetSingerData()
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return null;
        }
        List<Song> songList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from singer ;");

        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            while(rs.next())
            {
                String singerID = rs.getString("singerid");
                String singerName = rs.getString("singername");
                Song song = new Song(null,null, singerID, singerName,null,null);
                songList.add(song);
            }
            return songList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
