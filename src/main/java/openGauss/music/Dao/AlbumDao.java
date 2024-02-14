package openGauss.music.Dao;

import openGauss.music.util.JDBCUtils;

import openGauss.music.Bean.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AlbumDao {
    //根据专辑ID获取所有歌曲信息
    public List<Song> GetSongs(String AlbumID)
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
                " and album.albumid ="+ "'" + AlbumID+ "'");

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
    public List<Song> GetAllAlbums()
    {
        List<Song> songList = new ArrayList<>();
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return null;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select singer.singerid, singer.singername, album.albumid, albumname " +
                "from album " +
                "join albuminfo on albuminfo.albumid = album.albumid " +
                "join singer on singer.singerid = albuminfo.singerid;");

        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            while (rs.next())
            {
                String singerID = rs.getString("singerid");
                String singername = rs.getString("singername");
                String albumID = rs.getString("albumid");
                String albumName = rs.getString("albumname");
                Song song = new Song("none","none",singerID ,singername, albumID,albumName);
                songList.add(song);
            }
            return songList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public String IsExistAlbum(String albumID)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return "连接失败！";
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from album where album.albumid ='" +
                albumID +
                "' ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            if(rs.next())
            {
                return "succeed";
            }
            return "没有这个专辑!";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "error!";
    }

    public void AddAlbum(String albumID,String albumName, String singerID)
    {
        List<Song> songList = new ArrayList<>();
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("insert into album values('" +
                albumID +
                "','" +
                albumName +
                "') ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.execute();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("insert into albuminfo values('" +
                    albumID +
                    "','" +
                    singerID +
                    "') ;");
            ps = conn.prepareStatement(sb2.toString());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //删除歌曲引用,还要删除歌曲
    private void DeleteAlbumSongInfo(String albumID)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from songinfo where albumid='" +
                albumID +
                "' ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            SongDao dao = new SongDao();
            while (rs.next())
            {
                String songID = rs.getString("songid");
                dao.DeleteSong(songID);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return;
    }
    //删除歌手引用
    private void DeleteAlbumSingerInfo(String albumID)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("delete from albuminfo where albumid='" +
                albumID +
                "' ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void DeleteAlbum(String albumID)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return;
        }
        DeleteAlbumSongInfo(albumID);
        DeleteAlbumSingerInfo(albumID);
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("delete from album where albumid='" +
                albumID +
                "' ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Song> GetAlbumData()
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return null;
        }
        List<Song> songList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from album ;");

        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            while(rs.next())
            {
                String albumID = rs.getString("albumid");
                String albumName = rs.getString("albumname");
                Song song = new Song(null,null,null,null, albumID, albumName);
                songList.add(song);
            }
            return songList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
