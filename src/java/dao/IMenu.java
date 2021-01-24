package dao;

import entity.Menu;
import java.util.List;

/**
 *
 * @author hoang
 */
public interface IMenu {
    public List<Menu> getAll() throws Exception;
    public List<Menu> getAllByPage(List<Menu> list, int start, int end) throws Exception;
}
