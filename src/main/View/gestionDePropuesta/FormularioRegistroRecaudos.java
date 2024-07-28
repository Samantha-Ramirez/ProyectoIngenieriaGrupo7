package main.View.gestionDePropuesta;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import main.View.abstractas.*;

public class FormularioRegistroRecaudos extends VentanaPrincipal {
    private JText nombre;
    private JText persona;
    private JComboBox<String> esComunidad;
    private JText RIF;
    private JText CI;
    private JButton archivoISLR;
    private JButton archivoCurriculum;
    private JButton archivoTitulo;
    private JButton archivoRegistroMercantil;
    private JButton botonContinuar;
    private VistaError error;

    public FormularioRegistroRecaudos() {  
        super("Proponente | Registrar recaudos");

        JPanel panelCentral = crearPanel(false, 0, 0);
        
        // panel de datos
        JPanel panelDatos = crearPanel(true, 3, 2);
        agregarLabel(panelCentral, "Datos personales", true);
        // recuadros de texto
        this.nombre = agregarRecuadroTexto(panelDatos, "Nombre", "Ingrese su nombre");
        this.persona = agregarRecuadroTexto(panelDatos, "Persona", "Natural/Juridica");
        this.esComunidad = agregarCombo(panelDatos, "Es de la comunidad","Sí", "No");
        this.RIF = agregarRecuadroTexto(panelDatos, "RIF", "Ingrese su RIF");
        this.CI = agregarRecuadroTexto(panelDatos, "CI", "Ingrese su CI");
        
        // panel de recaudos
        JPanel panelRecaudos = crearPanel(true, 2, 2);
        agregarLabel(panelCentral, "Recaudos", true);
        // botones de adjuntar
        this.archivoISLR = agregarBotonAdjunto(panelRecaudos, "Certificado de ISLR", "Adjuntar archivo");
        this.archivoCurriculum = agregarBotonAdjunto(panelRecaudos, "Curriculum", "Adjuntar archivo");
        this.archivoTitulo = agregarBotonAdjunto(panelRecaudos, "Título universitario", "Adjuntar archivo");
        this.archivoRegistroMercantil = agregarBotonAdjunto(panelRecaudos, "Registro mercantil", "Adjuntar archivo");

        // panel de boton continuar
        JPanel panelBoton = crearPanel(false, 0 , 0);
        this.botonContinuar = agregarBoton(panelBoton, "Continuar");

        // agregar paneles a panel central
        panelCentral.add(panelDatos, BorderLayout.NORTH);
        panelCentral.add(panelRecaudos, BorderLayout.CENTER);
        panelCentral.add(panelBoton, BorderLayout.SOUTH);
        agregarPanelCentral(panelCentral, BorderLayout.CENTER);
    }
    
    public String getNombre() {
        return nombre.getText();
    }

    public String getPersona() {
        return persona.getText();
    }

    public String getRIF() {
        return RIF.getText();
    }

    public String getCI() {
        return CI.getText();
    }

    public String getEsComunidad() {
        return (String) esComunidad.getSelectedItem();
    }

    public void setControlador(ActionListener controlador) {
        botonContinuar.addActionListener(controlador);
    }

    public Boolean esDatosRecaudosCompletos(){
        JText[] recuadrosTexto = {this.nombre, this.persona, this.RIF, this.CI};
        if(esDatosCompletos(recuadrosTexto))
           return true;
        return false;
    }

    public static void main(String[] args) {  
        FormularioRegistroRecaudos form = new FormularioRegistroRecaudos();  
        form.setVisible(true);  
    }  
}  