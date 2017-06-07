package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     * 
     * 返す値の型をUserDataDTO→UserDataDTO型のArrayListに変更。
     * 検索結果のレコードが複数の場合に対応するため。
     * また、検索条件に空欄があっても検索できるように修正。
     */
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        ArrayList<UserDataDTO> uddArray = new ArrayList<UserDataDTO>(); // 検索結果データの配列
        try{
            con = DBManager.getConnection();
            
            //
            String sql = "SELECT * FROM user_t";
            boolean flagName = false; // 名前が入力されていたか
            boolean flagYear = false; // 年が入力されていたか
            boolean flagType = false; // 業種が入力されていたか
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flagName = true;
            }
            if (ud.getBirthday()!=null) {
                if(!flagName){ // 名前が入力されていなければ
                    sql += " WHERE birthday like ?";
                }else{
                    sql += " AND birthday like ?";
                }
                flagYear = true;
            }
            if (ud.getType()!=0) {
                if(!flagName && !flagYear){ // 名前も年も入力されていなければ
                    sql += " WHERE type like ?";
                }else{
                    sql += " AND type like ?";
                }
                flagType = true;
            }
            st = con.prepareStatement(sql);
            // 検索方式修正部分
            if(flagName){
                st.setString(1, "%"+ud.getName()+"%");
            } 
            if(flagYear){
                if(flagName){
                    st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                }else{
                    st.setString(1, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                }
            }
            if(flagType){
                if(flagName && flagYear){
                    st.setInt(3, ud.getType());
                }else if(flagName || flagYear){
                    st.setInt(2, ud.getType());
                }else{
                    st.setInt(1,ud.getType());
                }
            }
            // 修正部分ここまで
            
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                resultUd.setBirthday(rs.getDate(3));
                resultUd.setTell(rs.getString(4));
                resultUd.setType(rs.getInt(5));
                resultUd.setComment(rs.getString(6));
                resultUd.setNewDate(rs.getTimestamp(7));
                uddArray.add(resultUd);
            }
            
            System.out.println("search completed");

            return uddArray;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public void update(UserDataDTO ud) throws SQLException,Exception{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            //
            st = con.prepareStatement("UPDATE user_t SET name = ?,birthday = ?,tell = ?,type = ?,comment = ?,newDate = ? WHERE userID = ?");
            st.setString(1,ud.getName());
            Date d = ud.getBirthday();
            System.out.println("ダミープリント");
            st.setDate(2,new java.sql.Date(ud.getBirthday().getTime())); // utilのDateからsqlのDateへ変換する
            st.setString(3,ud.getTell());
            st.setInt(4,ud.getType());
            st.setString(5,ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7,ud.getUserID());
            
            int i = st.executeUpdate();
            if(i == 0){ // 何らかの理由で更新に失敗した場合
                throw new Exception("なんらかの理由で更新にエラーが発生し、更新できませんでした。<br>更新元のデータが削除されている可能性があります。");
            }
            
            System.out.println("update completed");
        }catch(SQLException e_sql){
            System.out.println(e_sql.getMessage());
            throw new SQLException(e_sql);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * ユーザーIDによる1件のデータの削除処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public void delete(UserDataDTO ud) throws SQLException,Exception{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            //
            st = con.prepareStatement("DELETE FROM user_t WHERE userID = ?");
            st.setInt(1,ud.getUserID());
            int n = ud.getUserID();
            
            int i = st.executeUpdate();
            if(i == 0){ // 何らかの理由で削除に失敗した場合
                throw new Exception("削除できませんでした。このデータは既に削除されている可能性があります");
            }
            
            System.out.println("delete completed");
        }catch(SQLException e_sql){
            System.out.println(e_sql.getMessage());
            throw new SQLException(e_sql);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    // 削除データ参照などの時に発生するエラーに対応
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        UserDataDTO resultUd = new UserDataDTO();
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                resultUd.setBirthday(rs.getDate(3));
                resultUd.setTell(rs.getString(4));
                resultUd.setType(rs.getInt(5));
                resultUd.setComment(rs.getString(6));
                resultUd.setNewDate(rs.getTimestamp(7));
            }else{ // 何らかの理由(削除されたデータの参照など)でデータが参照できなかった場合
                throw new SQLException("データが参照できませんでした。該当のデータが削除されている可能性があります。");
            }
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * 個人データの更新を1件行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
}
