package aux_swing;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Set;

import tp_repositorio.dtos.JugadorDTO;
import tp_repositorio.interfaces.InterfaceJugador;

public class ClientePruebas {
    
	InterfaceJugador manejoJugador;
	JugadorDTO jugador;
	
	public static void main(String[] args)
	{
		new ClientePruebas();
	}
	
    public boolean getStub() {
    	
    	try {
			manejoJugador = (InterfaceJugador)Naming.lookup ("//localhost/GestionJugadores");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public ClientePruebas(){
    	if(getStub()) 
    	{
    		try {
    			
    			jugador = manejoJugador.obtengoJugador(1);
    			System.out.println(jugador.getNombre());
    			
    			/*Listo todos los Jugadores*/
    			System.out.println("\nListo Todos los Jugadores");
    			Set<JugadorDTO> jugador = manejoJugador.obtengoJugador();
    			for(Iterator<JugadorDTO> i=jugador.iterator();i.hasNext();)
    			{
    				System.out.println(i.next().toString());
    			}
    			
    			/*Agrego un alumno*/
    			//System.out.println("\nAgrego un alumno");
    			//alumno = new Alumno(11, "Claudio");
    			//manejoAlumnos.envioAlumno(alumno);
    			/*Listo todos los alumnos con el agregado*/
    			//System.out.println("\nListo Todos los Alumnos");
    			//alumnos = manejoAlumnos.obtengoAlumnos();
    			//for(Iterator<Alumno> i=alumnos.iterator();i.hasNext();)
    			//{
//    				System.out.println(i.next().toString());
    			//}
    			/*Obtengo la cantidad de alumnos*/
    			//System.out.println("\nCantidad de Alumnos " + manejoAlumnos.cantidadAlumnos());
    		} catch (RemoteException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	} 
    }

}