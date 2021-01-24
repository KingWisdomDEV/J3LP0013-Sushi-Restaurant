package dao;

import entity.Home;
import java.util.List;

/**
 *
 * @author hoang
 */
public interface IHome {
    public List<Home> getAll() throws Exception;
}
