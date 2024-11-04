package webvistas;

import datos.PersonaDaoJDBC;
import dominio.Persona;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author tonym
 */
@WebServlet(name = "ServerControlador", urlPatterns = {"/ServerControlador"})
public class ServerControlador extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        if(accion != null){
        switch(accion){
            case "editar":
                this.editarPersona(request, response);break;
            case "eliminar":
                this.eliminarPersona(request, response);break;
            default:
                this.accionDefault(request, response);
        }
        }else{
        this.accionDefault(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        if(accion != null){
        switch(accion){
            case "insertar":
                this.insertarPersona(request, response);break;
            case "modificar":
                this.modificarPersona(request, response);break;
            case "eliminar":
                this.eliminarPersona(request, response);break;
            default:
                this.accionDefault(request, response);
        }
        }else{
        this.accionDefault(request, response);
        }
    }
     
    protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Persona> personas = new PersonaDaoJDBC().listar();
        System.out.println("persona = "+ personas);// para ver en consola 
        HttpSession sesion=request.getSession();
        
        sesion.setAttribute("personas", personas);
        sesion.setAttribute("TotalPersonas", personas);
        //sesion.setAttribute("SaldoTotal", this.calcularSaldoP(personas));
        
        response.sendRedirect("persona.jsp");
    }
    
    protected void editarPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPersona = Integer.parseInt(request.getParameter("idPersona"));
        Persona persona = new PersonaDaoJDBC().buscar(new Persona(idPersona));
        request.setAttribute("persona", persona);
        String jspEditar="WEB-INF/paginas/clientes/editarPersona.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    protected void modificarPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPersona = Integer.parseInt(request.getParameter("idPersona"));
        String nombre= request.getParameter("nombre");
        Persona persona = new Persona(idPersona, nombre);
        int resgistroModificados = new PersonaDaoJDBC().update(persona);
        this.accionDefault(request, response);
        //double saldo = 0;
        //String saldoString = request.getParameter("saldo");
        //if(saldoString != null && !"".equals(saldoString))
        //saldo = Double.parseDouble(saldoString);   
    }
    
    protected void insertarPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //int idPersona = Integer.parseInt(request.getParameter("idPersona"));
        String nombre= request.getParameter("nombre");
        Persona persona = new Persona(nombre);
        int resgistroModificados = new PersonaDaoJDBC().insert(persona);
        this.accionDefault(request, response);
        //double saldo = 0;
        //String saldoString = request.getParameter("saldo");
        //if(saldoString != null && !"".equals(saldoString))
        //saldo = Double.parseDouble(saldoString);   
    }
    
    protected void eliminarPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPersona = Integer.parseInt(request.getParameter("idPersona"));
        Persona persona = new Persona(idPersona);
        int registroModificado = new PersonaDaoJDBC().delete(persona);
        this.accionDefault(request, response);
        
    }
   /*private double calcularSaldoTotalP(){
    double saldoTotal = 0;
    for(Persona persona: personas){
    saldoTotal+=persona.getSaldo();
        }
    return saldoTotal;
    }*/

}
