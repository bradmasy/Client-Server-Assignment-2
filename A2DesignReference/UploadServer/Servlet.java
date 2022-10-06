/** Author: Brad Masciotra
  * Date: 2022-10-05
  */

import java.io.IOException;
import java.lang.Object;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Servlet Abstract Class
 * Servlet extends HttpServlet as our abstract class for future servlets.
 */
public abstract class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{};
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {};
}
