package main.Model.gestionEvaluacionAval;

import main.Model.gestionBases.Base;
import main.Model.gestionPropuesta.*;

public class AvalTecnico extends Base {
    private Propuesta propuesta; //FIX:smellcode
    private String estado; //aprobado, rechazado, enEvaluacion
    private String observaciones;

    public AvalTecnico(Propuesta propuesta){
        this.estado = "enEvaluacion";
        this.propuesta = propuesta;
        this.observaciones = "";
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
    }
    // obtener array con todos los datos que se deben actualizar en el txt
    public String[] getDatos (){
        String[] datos = {
            this.propuesta.getNombre(),
            this.estado,
            this.observaciones,};
        return datos;
    }

    public void guardarAval(){
        guardarDatos("Aval.txt", getDatos(), ",", true);
    }

    public void actualizarDatos(){
        String nombreArch = "Aval.txt";
        actualizarDatos(nombreArch, getDatos(), "\n", this.propuesta.getNombre());
    }
}
