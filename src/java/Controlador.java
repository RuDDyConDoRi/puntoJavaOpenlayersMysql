
import com.conexion.MyBaseDatosGIS;
import com.modelos.Dato;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ruddy.condori
 */
@WebServlet(urlPatterns = {"/Controlador"})
public class Controlador
        extends HttpServlet {

    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("application/json");
        
        try {
            PrintWriter out = response.getWriter();
            Throwable localThrowable3 = null;
            
            try {
                MyBaseDatosGIS db = new MyBaseDatosGIS();
                Connection con = db.getCon();
                Dato dato = new Dato();
                dato.setLatitud(request.getParameter("latitud"));
                dato.setLongitud(request.getParameter("longitud"));

                Logger.getLogger(Controlador.class.getName())
                        .log(Level.INFO,
                             null, 
                             "La latitud es: " + dato.getLatitud() 
                                               + "\nLa longitud es: " 
                                               + dato.getLongitud());

                Statement stmt = con.createStatement();
                stmt.executeUpdate(
                        "INSERT INTO dato(latitud, longitud) VALUES('" 
                                + dato.getLatitud() 
                                + "', '" 
                                + dato.getLongitud() 
                        + "')");

                stmt.close();
                con.close();
            } catch (Throwable localThrowable1) {
                localThrowable3 = localThrowable1;
                throw localThrowable1;
            } finally {
                if (out != null) {
                    if (localThrowable3 != null) {
                        try {
                            out.close();
                        } catch (Throwable localThrowable2) {
                            localThrowable3.addSuppressed(localThrowable2);
                        }
                    } else {
                        out.close();
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName())
                  .log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Servlet para realizar la captura de puntos";
    }
}



