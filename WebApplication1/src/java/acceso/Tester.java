/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import java.sql.*;


/**
 *
 * @author sistemas
 */
public class Tester { 
    public static void main(String[] args){
        
                 final String DRIVER="org.postgresql.Driver";   
                 final String URL= "jdbc:postgresql://localhost:5432/proyectofinal";
                 final String USER="adminjuego";
                 final String PASS="123456";
                 Connection con;
                 try{
                    Class.forName(DRIVER);
                    System.out.println("Carga del driver");
                    con=DriverManager.getConnection(URL,USER,PASS);
                    System.out.println("Conexiòn exitosa");
                    //Statement instruccion = con.createStatement();        
                    String sql="INSERT into materia values(?,?)";
                    PreparedStatement instruccion= 
                            con.prepareStatement(sql);
                    instruccion.setInt(1, 10);
                    instruccion.setString(2, "Computación");
                    int conta=instruccion.executeUpdate();
                    System.out.println("Total modificado:"+conta);
                    /*ResultSet rs = instruccion.executeQuery();
                    while(rs.next())
                    {
                        System.out.println(rs.getInt(1));
                        System.out.println(rs.getString("nombres"));
                        System.out.println(rs.getString(3));
                    }*/
                    con.close();
                    System.out.println("Cierre de la conexión");
                 }catch(Exception e){
                     System.out.println(e);
                 }
                    
                    
                    //****Prueba de la clase Conexion
//         try{
//        ExperienciaDirectiva expd=new ExperienciaDirectiva();
//        expd.setIdexperienciadirectiva(1);
//        //expd.setCi("15422");
//        expd.setCargodirectiva("guidf");
//        expd.setInstituciondirectiva("guidgdf");
//        expd.setDemesaniodirectiva("fdg");
//        expd.setAmesaniodirectiva("ghfg");
//
//        }catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
    
        
        
//        try{
//        ExperienciaVinculacion vin=new ExperienciaVinculacion();
//        //vin.setId_experienciavinculacion(1);
//        vin.setCi("15422");
//        vin.setCi("guidf");
//        vin.setActividadvinculacion("guidgdf");
//        vin.setEventovinculacion("fdg");
//        vin.setDuracionvinculacion(5);
//
//        }catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//        
        
        
        
        
         }
    }

