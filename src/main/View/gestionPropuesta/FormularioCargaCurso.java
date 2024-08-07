package main.View.gestionPropuesta;

// importar base
import main.View.gestionBases.*;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FormularioCargaCurso extends VistaBase {  
    private JText nombre;
    private JComboBox<String> unidadResponsableDeTramite;
    private JText denominacion;
    private JText duracion;
    private JText fundamentacion;
    private JText pathPerfilParticipantes;
    private JText pathPerfilDocente;
    private JText pathCurriculoCompetencias;
    private JText pathEstrategiasEvaluacion;
    private JText pathExigenciasMaterialesYServicios;
    private JButton botonEnviar;
    
    public FormularioCargaCurso() {  
        super("Proponente | Cargar formulación", 800, 800);

        JPanel panelCentral = crearPanel(false, 0, 0);

        JPanel panelAdjuntos = crearPanel(true, 10, 1);
        this.nombre = agregarRecuadroTexto(panelAdjuntos, "Nombre", "Ingrese nombre");
        this.unidadResponsableDeTramite = agregarCombo(panelAdjuntos, "Unidad responsable", "DEU", "CEF");
        this.denominacion = agregarRecuadroTexto(panelAdjuntos, "Denominación", "Ingrese denominación");
        this.fundamentacion = agregarRecuadroTexto(panelAdjuntos, "Fundamentación", "Ingrese fundamentación");
        this.duracion = agregarRecuadroTexto(panelAdjuntos, "Duración", "Ingrese duración");
        this.pathPerfilParticipantes = agregarBotonAdjunto(panelAdjuntos, "Perfiles de participantes", "Adjuntar archivo");
        this.pathPerfilDocente = agregarBotonAdjunto(panelAdjuntos, "Perfil de docente", "Adjuntar archivo");
        this.pathCurriculoCompetencias = agregarBotonAdjunto(panelAdjuntos, "Estructura curricular", "Adjuntar archivo");
        this.pathEstrategiasEvaluacion = agregarBotonAdjunto(panelAdjuntos, "Estrategias de evaluación", "Adjuntar archivo");
        this.pathExigenciasMaterialesYServicios = agregarBotonAdjunto(panelAdjuntos, "Exigencias", "Adjuntar archivo");

        JPanel panelBoton = crearPanel(false, 0 , 0);
        this.botonEnviar = agregarBoton(panelBoton, "Enviar");

        panelCentral.add(panelAdjuntos, BorderLayout.CENTER);
        panelCentral.add(panelBoton, BorderLayout.SOUTH);

        agregarPanelCentral(panelCentral, BorderLayout.CENTER);
    }

    public String getNombre() {
        return nombre.getText();
    }

    public String getUnidadResponsableDeTramite() {
        return (String) unidadResponsableDeTramite.getSelectedItem();
    }

    public String getDenominacion() {
        return denominacion.getText();
    }

    public String getDuracion() {
        return duracion.getText();
    }

    public String getPathPerfilParticipantes() {
        return pathPerfilParticipantes.getText();
    }

    public String getPathPerfilDocente() {
        return pathPerfilDocente.getText();
    }

    public String getPathCurriculoCompetencias() {
        return pathCurriculoCompetencias.getText();
    }

    public String getPathEstrategiasEvaluacion() {
        return pathEstrategiasEvaluacion.getText();
    }

    public String getPathExigenciasMaterialesYServicios() {
        return pathExigenciasMaterialesYServicios.getText();
    }

    public String getFundamentacion() {
        return fundamentacion.getText();
    }

    // setear controlador
    public void setControlador(ActionListener controlador) {
        botonEnviar.addActionListener(controlador);
    }

    // verificar completitud
    public Boolean esDatosRecaudosCompletos(){
        JText[] recuadrosTexto = {this.nombre, this.denominacion, this.duracion, this.fundamentacion};
        if(esDatosCompletos(recuadrosTexto))
           return true;
        return false;
    }

    public static void main(String[] args) { 
        FormularioCargaCurso form = new FormularioCargaCurso();  
        form.setVisible(true);  
    }  
}  
