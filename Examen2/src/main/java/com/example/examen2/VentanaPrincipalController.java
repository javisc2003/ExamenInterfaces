package com.example.examen2;

import com.example.examen2.models.Coche;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.util.StringConverter;

import java.util.Date;

public class VentanaPrincipalController
{
    @javafx.fxml.FXML
    private TextField txtMatricula;
    @javafx.fxml.FXML
    private RadioButton radioOferta;
    @javafx.fxml.FXML
    private RadioButton radioLarga;
    @javafx.fxml.FXML
    private DatePicker fechaEntrada;
    @javafx.fxml.FXML
    private DatePicker fechaSalida;
    @javafx.fxml.FXML
    private ChoiceBox<String> choiceboxCliente;
    @javafx.fxml.FXML
    private ComboBox<String> comoboxModelo;
    @javafx.fxml.FXML
    private Label labelCoste;
    @javafx.fxml.FXML
    private Button btnAñadir;
    @javafx.fxml.FXML
    private Button btnSalir;
    @javafx.fxml.FXML
    private TableView<Coche> tablaParking;
    @javafx.fxml.FXML
    private TableColumn<Coche,String> cmatricula;
    @javafx.fxml.FXML
    private TableColumn<Coche,String> cmodelo;
    @javafx.fxml.FXML
    private TableColumn<Coche,String> cfentrada;
    @javafx.fxml.FXML
    private TableColumn<Coche,String> cfsalida;
    @javafx.fxml.FXML
    private TableColumn<Coche,String> ccliente;
    @javafx.fxml.FXML
    private TableColumn<Coche,String> ctarifa;
    @javafx.fxml.FXML
    private TableColumn<Coche,String> ccoste;
    @javafx.fxml.FXML
    private Label info;
    @FXML
    private RadioButton radioStandard;

    @javafx.fxml.FXML
    public void initialize() {
        comoboxModelo.getItems().add("Seat");
        comoboxModelo.getItems().add("Citroen");
        comoboxModelo.getItems().add("Ferrari");
        comoboxModelo.getSelectionModel().selectFirst();

        choiceboxCliente.getItems().addAll("Pepe", "María", "Francisco", "Laura");
        choiceboxCliente.getSelectionModel().select(0);

        tablaParking.getSelectionModel().selectedItemProperty().addListener(
                (observable, vold, vnew)->{
                    info.setText(vnew.toString());
                    txtMatricula.setText(vnew.getMatricula());
                    comoboxModelo.setValue(vnew.getModelo());
                    choiceboxCliente.setValue(vnew.getCliente());
                    radioStandard(vnew.getCliente());
                    radioOferta(vnew.getCliente());
                    radioLarga(vnew.getCliente());
                }
        );

        cmatricula.setCellValueFactory((fila)-> {
            String nombre = fila.getValue().getMatricula();
            return new SimpleStringProperty(nombre);
        } );

        cmodelo.setCellValueFactory((fila)-> new SimpleStringProperty(fila.getValue().getModelo()));

        cfentrada.setCellValueFactory((fila)-> {
         fila.getValue().getFechaentrada();
            return new SimpleStringProperty(null);
        });

        cfsalida.setCellValueFactory((fila)-> {
            fila.getValue().getFechasalida();
            return new SimpleStringProperty(null);
        });
        ccliente.setCellValueFactory((fila)-> {
            String cliente = fila.getValue().getCliente();
            return new SimpleStringProperty(cliente);
        } );
        ctarifa.setCellValueFactory((fila)-> {
            String tarifa = fila.getValue().getTarifa();
            return new SimpleStringProperty(tarifa);
        } );
        ccoste.setCellValueFactory((fila)-> {
            String coste = String.valueOf(fila.getValue().getCoste());
            return new SimpleStringProperty(coste);
        } );

        tablaParking.getItems().add(new Coche());
        tablaParking.getItems().add(new Coche());
        tablaParking.getItems().add(new Coche());
        tablaParking.getItems().add(new Coche());
        tablaParking.getItems().add(new Coche());

    }

    private void labelcoste(String opcion) {
        int precioStandard = 8;
        int precioOferta = 6;
        int precioLargaDuracion = 2;

        int costoDiario;
        switch (opcion.toLowerCase()) {
            case "standard":
                costoDiario = precioStandard;
                break;
            case "oferta":
                costoDiario = precioOferta;
                break;
            case "larga duracion":
                costoDiario = precioLargaDuracion;
                break;
            default:
                throw new IllegalArgumentException("Opción no válida: " + opcion);
        }
    }

    private void radioLarga(String cliente) {
    }

    private void radioOferta(String cliente) {
    }

    private void radioStandard(String cliente) {
    }

    public void mostrarInformacionAlumno(ActionEvent actionEvent) {
        var alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Información del Alumno");
        alert.setContentText("Nombre: Javier\nCiclo: TuCiclo");
        alert.showAndWait();
    }


    @FXML
    public void añadir(ActionEvent actionEvent) {
        if (!txtMatricula.getText().isEmpty() && fechaEntrada.getValue() != null && fechaSalida.getValue() != null) {
            Coche coche = new Coche();
            coche.setMatricula(txtMatricula.getText());
            coche.setModelo(String.valueOf(comoboxModelo.getSelectionModel().getSelectedItem()));
            coche.setCliente(String.valueOf(choiceboxCliente.getSelectionModel().getSelectedItem()));
            coche.setTarifa(obtenerTarifaSeleccionada());
            coche.setFechaentrada(java.sql.Date.valueOf(fechaEntrada.getValue()));
            coche.setFechasalida(java.sql.Date.valueOf(fechaSalida.getValue()));
            tablaParking.getItems().add(coche);
            info.setText(coche.toString());
            limpiarCampos();
        } else {
            mostrarAlerta("Falta información", "Por favor, complete todos los campos antes de añadir un coche.");
        }
    }

    private String obtenerTarifaSeleccionada() {
        if (radioStandard.isSelected()) {
            return "standard";
        } else if (radioOferta.isSelected()) {
            return "oferta";
        } else if (radioLarga.isSelected()) {
            return "larga duracion";
        } else {
            return "";
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        txtMatricula.clear();
        comoboxModelo.getSelectionModel().selectFirst();
        choiceboxCliente.getSelectionModel().select(0);
        radioStandard.setSelected(false);
        radioOferta.setSelected(false);
        radioLarga.setSelected(false);
        fechaEntrada.setValue(null);
        fechaSalida.setValue(null);
    }
    @FXML
    public void salir(ActionEvent actionEvent) {
        System.exit(0);
    }
}