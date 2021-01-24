package listener;

import dao.impl.ViewDAO;
import dao.IView;
import javax.servlet.http.*;

/**
 * Listener that keeps track of the number of sessions that the Web application
 * is currently using and has ever used in its life cycle.
 */
/**
 *
 * @author hoang
 */
public class SessionCounter implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        IView dbView = new ViewDAO();
        try {
            dbView.updateView();
            HttpSession session = (HttpSession) event.getSession();
            session.setAttribute("views", String.format("%06d", dbView.getViewed()));
        } catch (Exception ex) {
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
    }

}
