/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0013
 * The Sushi Restaurant
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 24-1-2021                    1.0            King Wisdom                  First Implement
 */

package dao.impl;

import dao.IView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng View
 * Các phương thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có bất cứ lỗi nào xảy ra trong quá trình truy vấn
 * <p>Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public class ViewDAO extends DBContext implements IView{
    
//    public static void main(String[] args) throws Exception {
//        ViewDAO c = new ViewDAO();
//        c.updateView();
//        System.out.println(c.getViewed());;
//    }

    @Override
    public int getViewed() throws Exception {
        Connection con = getConnection();
        String sql = "SELECT * FROM [View]";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
               return rs.getInt("viewed");
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            closeRS(rs);
            closePS(st);
            closeCon(con);
        }
        return 0;
    }

    @Override
    public int updateView() throws Exception {
        Connection con = getConnection();
        String sql = "UPDATE [View]\n" +
                        "SET viewed = viewed + 1";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            int rowAffected = st.executeUpdate();
            return rowAffected;
        } catch (Exception e) {
            throw e;
        }
        finally{
            closeRS(rs);
            closePS(st);
            closeCon(con);
        }
    }
}
