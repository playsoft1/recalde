/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rnegocio.funciones;

import acceso.Conexion;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import rnegocio.clases.Usuario;
import validaciones.ValidaCedula;

/**
 *
 * @author jorgeskoll
 */
public class FUsuario {
    
     public static boolean f_inserta_usuario(Usuario u)
     {
         ValidaCedula valida=new ValidaCedula();
         boolean respuesta = false, val=false;
        ArrayList <Parametro> lstpar = new ArrayList<Parametro>();
        lstpar.add(new Parametro(1,u.getCedulausuario()));
        lstpar.add(new Parametro(2,u.getNombreusuario()));
        lstpar.add(new Parametro(3,u.getClave()));
        lstpar.add(new Parametro(4,u.getTipo()));
        val= valida.validadorDeCedula(u.getCedulausuario());
        if(val==true)
        {
            String sql = "INSERT INTO usuario(cedula, nombre, contrasenia, tipo) VALUES (?, ?, ?, ?);";
            try {
                respuesta = AccesoDatos.ejecutaComando1(sql, lstpar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
             
        }
        else
                {
                    System.out.println("Cédula incorrecta");
                }  
        return  respuesta;
        }
    public static Usuario f_consulta_usuario(String cedulausuario){
    Usuario u = null;
    ArrayList <Parametro> lstpar = new ArrayList<Parametro>();  
    String sql = "SELECT cedula, nombre, contrasenia, tipo  FROM usuario where cedula= cedulausuario";
     lstpar.add(new Parametro(1,cedulausuario));
    
    
    try {
            ConjuntoResultado cjres = AccesoDatos.ejecutaQuery(sql,lstpar);
            while  (cjres.next()){
                u= new Usuario();
                u.setCedulausuario(cjres.getString(1));
                u.setNombreusuario(cjres.getString("nombre"));
                u.setClave(cjres.getString("contrasenia"));
                u.setTipo(cjres.getString("tipo"));
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        
        return  u;
    }
    
     public static boolean f_eliminar_usuario(String cedulausuario) {
         boolean respuesta = false;
        ArrayList<Parametro> lstparame = new ArrayList<Parametro>();
        lstparame.add(new Parametro(1, cedulausuario));
        String sql = "SELECT f_eliminar_usuario(?);";
        try {
            respuesta = AccesoDatos.ejecutaComando(sql, lstparame);
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
  }
     
     public static boolean ModificarUsuario(Usuario u){
        boolean respuesta = false;
        ArrayList <Parametro> lstpar = new ArrayList<Parametro>();
        lstpar.add(new Parametro(1,u.getCedulausuario()));
        lstpar.add(new Parametro(2,u.getNombreusuario()));
        lstpar.add(new Parametro(3,u.getClave()));
        lstpar.add(new Parametro(4,u.getTipo()));

        String sql = " SELECT f_modificar_usuario(?, ?, ?, ?)";
            try {
                respuesta = AccesoDatos.ejecutaComando(sql, lstpar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return  respuesta;
        }
      
  public static ArrayList<Usuario> obtenerUsuario()
  {
    Usuario est;
         est = null;
    ArrayList<Usuario> lstEstudiante = new ArrayList<Usuario>();
       String sql="SELECT cedula,nombre,contrasenia,tipo From public.usuario;";
    try{
            ConjuntoResultado cjres = AccesoDatos.ejecutaQuery(sql);
            while(cjres.next()){
            est = new Usuario();
            est.setCedulausuario(cjres.getString(0));
            est.setNombreusuario(cjres.getString(1));
            est.setClave(cjres.getString(2));
            est.setTipo(cjres.getString(3));
            lstEstudiante.add(est);
            }
            
        }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
    return lstEstudiante;
 
}
  public static Usuario obtener(String pcedula) throws Exception
    {    
        try {
            Conexion con = new Conexion();
            try {
                String sql = "SELECT cedula, nombre, contrasenia, tipo  FROM usuario where cedula='"+pcedula+"'; ";
                PreparedStatement pmst = con.creaPreparedSmt(sql);
                pmst.setString(1, pcedula);
                ResultSet rset = con.ejecutaPrepared(pmst);
                Usuario user = null;
                if(rset.next()){
                    user = new Usuario();
                    user.setCedulausuario(rset.getString(1));
                    user.setNombreusuario(rset.getString(2));
                    user.setClave(rset.getString(3));
                    user.setTipo(rset.getString(4));
                    
                }
                return user;
            } catch (Exception ex) {
                throw ex;
            }
        
        } catch (Exception ex) {
            throw ex;
        }
        
    }
        public static Usuario obtenerEstudianteCedula(String pcedula) throws Exception{
        Usuario est = null;
        Conexion con=null;
        try {
            //proceso de obtener estudiante
            con= new Conexion();
            String sql = "SELECT cedula, nombre, contrasenia, tipo FROM public.usuario where cedula='"+pcedula+"';";
            ResultSet rst = con.ejecutaQuery(sql);
            while(rst.next()){
                est= new Usuario();
                
                est.setCedulausuario(rst.getString("cedula"));
                est.setNombreusuario(rst.getString("nombre"));
                est.setClave(rst.getString("contrasenia"));
                est.setTipo(rst.getString("tipo"));   
                con.desconectar();
            }            
        } catch (Exception ex) {
            throw new Exception(ex);
        }
        return est;
    }
public static boolean validadorDeCedula(String cedula) {
boolean cedulaCorrecta = false;
 
try {
 
if (cedula.length() == 10) // ConstantesApp.LongitudCedula
{
int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
if (tercerDigito < 6) {
// Coeficientes de validación cédula
// El decimo digito se lo considera dígito verificador
 int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
 int verificador = Integer.parseInt(cedula.substring(9,10));
 int suma = 0;
 int digito = 0;
for (int i = 0; i < (cedula.length() - 1); i++) {
 digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
 suma += ((digito % 10) + (digito / 10));
}
 
if ((suma % 10 == 0) && (suma % 10 == verificador)) {
 cedulaCorrecta = true;
}
else if ((10 - (suma % 10)) == verificador) {
 cedulaCorrecta = true;
} else {
 cedulaCorrecta = false;
}
} else {
cedulaCorrecta = false;
}
} else {
cedulaCorrecta = false;
}
} catch (NumberFormatException nfe) {
cedulaCorrecta = false;
} catch (Exception err) {
System.out.println("Una excepcion ocurrió en el proceso de validadción");
cedulaCorrecta = false;
}
 
if (!cedulaCorrecta) {
System.out.println("La cédula ingresada es Incorrecta");
}
return cedulaCorrecta;
}  
    
  }
