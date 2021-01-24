package dao;

import entity.SocialNetwork;
import java.util.List;

/**
 *
 * @author hoang
 */
public interface ISocialNetwork {
    public List<SocialNetwork> getAll() throws Exception;
}
