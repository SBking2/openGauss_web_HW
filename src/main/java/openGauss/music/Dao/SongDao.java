package openGauss.music.Dao;

import openGauss.music.Bean.Song;
import openGauss.music.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SongDao {
    //获取所有歌曲信息
    public List<Song> GetAllSong(){
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return null;
        }
        List<Song> songList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" select song.songlanguage, song.songstyle, song.songid, songname, singer.singerid, singername, album.albumid, albumname " +
                  " from singer, album, song, songinfo, albuminfo" +
                  " where song.songid = songinfo.songid"+
                  " and albuminfo.albumid = album.albumid" +
                  " and album.albumid = songinfo.albumid" +
                  " and albuminfo.singerid = singer.singerid");

        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            while(rs.next())
            {
                String songID = rs.getString("songid");
                String songName = rs.getString("songname");
                String las = rs.getString("songlanguage");
                String sts = rs.getString("songstyle");
                String singerID = rs.getString("singerid");
                String singername = rs.getString("singername");
                String albumID = rs.getString("albumid");
                String albumName = rs.getString("albumname");
                Song song = new Song(songID,songName, singerID,singername, albumID,albumName);
                song.SetSongLa(las);
                song.SetSongSt(sts);
                songList.add(song);
            }
            return songList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //根据歌曲ID查找歌曲信息
    public Song GetSong(String songID)
    {
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
                " and song.songid ="+ "'" + songID+ "'");

        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            if(rs.next())
            {
                String songId = rs.getString("songid");
                String songName = rs.getString("songname");
                String singerID = rs.getString("singerid");
                String singername = rs.getString("singername");
                String albumID = rs.getString("albumid");
                String albumName = rs.getString("albumname");
                Song song = new Song(songId,songName,singerID ,singername, albumID,albumName);
                return song;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public List<Song> GetLikeSong(String name)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return null;
        }
        List<Song> songList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" select song.songid, songname, singer.singerid, singername, album.albumid, albumname " +
                " from singer, album, song, songinfo, albuminfo" +
                " where song.songid = songinfo.songid"+
                " and albuminfo.albumid = album.albumid" +
                " and album.albumid = songinfo.albumid" +
                " and albuminfo.singerid = singer.singerid" +
                " and (song.songname like '%" +
                name+"%' " +
                "or singer.singername like '%"+
                name+"%'"+
                "or album.albumname like '%"+
                name+"%' );");

        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            while(rs.next())
            {
                String songID = rs.getString("songid");
                String songName = rs.getString("songname");
                String singerID = rs.getString("singerid");
                String singername = rs.getString("singername");
                String albumID = rs.getString("albumid");
                String albumName = rs.getString("albumname");
                Song song = new Song(songID,songName, singerID,singername, albumID,albumName);
                songList.add(song);
            }
            return songList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String IsExistSong(String songID)
    {
        List<Song> songList = new ArrayList<>();
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return "连接失败！";
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from song where song.songid ='" +
                songID +
                "' ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            if(rs.next())
            {
                return "succeed";
            }
            return "没有这个歌曲!";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "error!";
    }
    public void AddSong(String songID,String songName, String albumID)
    {
        List<Song> songList = new ArrayList<>();
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("insert into song values('" +
                songID +
                "','" +
                songName +
                "') ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.execute();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("insert into songinfo values('" +
                    songID +
                    "','" +
                    albumID +
                    "') ;");
            ps = conn.prepareStatement(sb2.toString());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void DeleteSongInfo(String songID)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("delete from songinfo where songid='" +
                songID +
                "' ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void DeleteSong(String songID)
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return;
        }
        DeleteSongInfo(songID);
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("delete from song where songid='" +
                songID +
                "' ;");
        try {
            ps = conn.prepareStatement(sb.toString());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Song> GetSongData()
    {
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return null;
        }
        List<Song> songList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from song ;");

        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            while(rs.next())
            {
                String songID = rs.getString("songid");
                String songName = rs.getString("songname");
                Song song = new Song(songID,songName, null,null, null,null);
                songList.add(song);
            }
            return songList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Song> GetSelectedSong(List<String> la, List<String> st){
        Connection conn = JDBCUtils.GetInstance().GetConnection();
        if( conn == null){
            return null;
        }
        List<Song> songList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        String task = "select song.songlanguage, song.songstyle, song.songid, songname, singer.singerid, singername, album.albumid, albumname"+
                " from singer, album, song, songinfo, albuminfo" +
                " where song.songid = songinfo.songid"+
                " and albuminfo.albumid = album.albumid" +
                " and album.albumid = songinfo.albumid" +
                " and albuminfo.singerid = singer.singerid ";
        if(la.size() == 0 && st.size() == 0)
        {
            task = task + " ;";
        }else if(la.size()+st.size()==1)
        {
            task = task + " and ";
            if (la.size()==1)
            {
                task = task + " song.songlanguage='" +
                        la.get(0) +
                        "' ;";
            }else
            {
                task = task + " song.songstyle='" +
                        st.get(0) +
                        "' ;";
            }
        }else
        {
            boolean flag = false;
            task = task + " and (";
            for(int i = 0; i < la.size();i++)
            {
                if(i!=0)
                {
                    task = task + " or ";
                }
                flag = true;
                task = task + " song.songlanguage='" +
                        la.get(i) +
                        "' ";
            }
            for(int i = 0;i<st.size();i++)
            {
                if(i==0 && !flag)
                {

                }else
                {
                    task = task + " or ";
                }
                flag = true;
                task = task + " song.songstyle='" +
                        st.get(i) +
                        "' ";
            }
            task = task + ") ;";
        }
        sb.append(task);

        try {
            ps = conn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            while(rs.next())
            {
                String songID = rs.getString("songid");
                String songName = rs.getString("songname");
                String las = rs.getString("songlanguage");
                String sts = rs.getString("songstyle");
                String singerID = rs.getString("singerid");
                String singername = rs.getString("singername");
                String albumID = rs.getString("albumid");
                String albumName = rs.getString("albumname");
                Song song = new Song(songID,songName, singerID,singername, albumID,albumName);
                song.SetSongLa(las);
                song.SetSongSt(sts);
                songList.add(song);
            }
            return songList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
