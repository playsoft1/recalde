/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rnegocio.testers;

import accesodatos.AccesoDatos;
import accesodatos.Parametro;
import java.util.ArrayList;
import rnegocio.clases.Usuario;
import rnegocio.funciones.FUsuario;
import validaciones.ValidaCedula;

/**
 *
 * @author DISMAGIC0985043396
 */
public class TestUsuario {
    public static void main(String[] args) {
        ValidaCedula valida=new ValidaCedula();
         boolean respuesta = false, val=false;
        ArrayList <Parametro> lstpar = new ArrayList<Parametro>();
        lstpar.add(new Parametro(1,"0600209787"));
        lstpar.add(new Parametro(2,"Uli"));
        lstpar.add(new Parametro(3,"asdf"));
        lstpar.add(new Parametro(4,"estudiante"));
        val= valida.validadorDeCedula("0600209787");
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
//        return  respuesta;
//       Rol_proceso pst= new Rol_proceso();
//       
//        
//        pst.getRol().setId_rol(2);
//        pst.getProceso().setId_proceso(2);
//        
//       if(!FRol_proceso.insertarRolProceso(pst))
//            System.out.println("Insertada Correctamente");
//        else
//          System.out.println("Error de Ingreso");
       
//  ****************************************************************************        
//  **********************   LISTADO DE ROL PROCESO   ***********************
//  ****************************************************************************        
        
//          
//            for (Usuario pst : FUsuario.obtenerUsuario()) {
//            System.out.println("El id de presenta es:         -->"+ pst.getCedulausuario());
//            System.out.println("El id de empresa es:        -->"+ pst.getNombreusuario());
//            System.out.println("El id de unidad es:        -->"+ pst.getClave());
//            System.out.println("La descipcion es:        -->"+ pst.getTipo());
//            }
//  
//  ****************************************************************************        
//  **********************   MODIFICAR UNA FORMA DE PAGO   *********************
//  ****************************************************************************        
        
//        Rol_proceso rolproceso= new Rol_proceso();
//        rolproceso.getRol().setId_rol(1);
//        rolproceso.getProceso().setId_proceso(2);
//        
//        if(!FRol_proceso.modificarRolproceso(rolproceso))
//            System.out.println("Forma de Pago Modificada Correctamente");
//        else
//          System.out.println("Error en Modificar");  
        
    /*
    private static void testEliminar_Rolproceso() {
        Scanner ingreso = new Scanner(System.in);
        boolean respuesta = false;
        System.out.println("INGRESE EL CODIGO DEL ROL Y PROCESO A ELIMINAR:");
        int rolBuscar = ingreso.nextInt();
        int procesoBuscar= ingreso.nextInt();
        try {
            respuesta = new FRol_proceso().eliminarRolproceso(rolBuscar ,procesoBuscar);
            if (respuesta) {
                System.out.println("SE ELIMINO EL ROL PROCESO");
            } else {
                System.out.println("ROL PROCESO NO ENCONTRADO");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
/*
    
        boolean respuesta = false;
        Rol_proceso pstactuales = new Rol_proceso();
        
        Rol_proceso pstnuevos = new Rol_proceso();
        
        pstactuales.getRol().setId_rol(1); 
        pstactuales.getProceso().setId_proceso(2);
        
        pstnuevos.getRol().setId_rol(2); 
        pstnuevos.getProceso().setId_proceso(7);

        try {
            respuesta = new FRol_proceso().modificarRolproceso(pstactuales,pstnuevos);
            if (respuesta) {
                System.out.println("ROL PROCESO MODIFICADO CORRECTAMENTE");
            } else {
                System.out.println("ERROR  AL MODIFICAR EL ROL PROCESO");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
       /*   ArrayList<Rol_proceso> lsp = FRol_proceso.obtenerRoles_procesos();
           int i=0;
           for(Rol_proceso rolpro : lsp)
              {  
              System.out.println("Codigo: "+rolpro.getId_rol());
              System.out.println("Numero: "+rolpro.getId_proceso());
              
              
              }*/
     /*       System.out.println("\tLISTADO rol proceso:");
            
                        for(Rol_proceso oPais: FRol_proceso.obtenerRoles_procesos())
                        {
                            System.out.println("\tRol: "+oPais.getId_rol()+ " - Procesp: " +oPais.getId_proceso() );
                        }*/
            
    }
    
    
}
