package co.com.choucair.cetification.startsharp.models;


import io.cucumber.datatable.DataTable;
import org.gradle.internal.impldep.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrearReunionModels {
    private String strNombreNegocio, strUnidadPadre,    strNombreReunion,  strTipo,dateFechaInicio,strHoraInicio,dateFechaFin;
    private String strHoraFin,    strUbicacion ,   strOrganizador ,  strReportero ,   strAsistentes , intNumeroReunion  ;

    public String getStrNombreNegocio() {
        return strNombreNegocio;
    }

    public void setStrNombreNegocio(String strNombreNegocio) {
        this.strNombreNegocio = strNombreNegocio;
    }

    public String getStrUnidadPadre() {
        return strUnidadPadre;
    }

    public void setStrUnidadPadre(String strUnidadPadre) {
        this.strUnidadPadre = strUnidadPadre;
    }

    public String getStrNombreReunion() {
        return strNombreReunion;
    }

    public void setStrNombreReunion(String strNombreReunion) {
        this.strNombreReunion = strNombreReunion;
    }

    public String getStrTipo() {
        return strTipo;
    }

    public void setStrTipo(String strTipo) {
        this.strTipo = strTipo;
    }

    public String getDateFechaInicio() {
        return dateFechaInicio;
    }

    public void setDateFechaInicio(String dateFechaInicio) {
        this.dateFechaInicio = dateFechaInicio;
    }

    public String getStrHoraInicio() {
        return strHoraInicio;
    }

    public void setStrHoraInicio(String strHoraInicio) {
        this.strHoraInicio = strHoraInicio;
    }

    public String getDateFechaFin() {
        return dateFechaFin;
    }

    public void setDateFechaFin(String dateFechaFin) {
        this.dateFechaFin = dateFechaFin;
    }

    public String getStrHoraFin() {
        return strHoraFin;
    }

    public void setStrHoraFin(String strHoraFin) {
        this.strHoraFin = strHoraFin;
    }

    public String getStrUbicacion() {
        return strUbicacion;
    }

    public void setStrUbicacion(String strUbicacion) {
        this.strUbicacion = strUbicacion;
    }

    public String getStrOrganizador() {
        return strOrganizador;
    }

    public void setStrOrganizador(String strOrganizador) {
        this.strOrganizador = strOrganizador;
    }

    public String getStrReportero() {
        return strReportero;
    }

    public void setStrReportero(String strReportero) {
        this.strReportero = strReportero;
    }

    public String getStrAsistentes() {
        return strAsistentes;
    }

    public void setStrAsistentes(String strAsistentes) {
        this.strAsistentes = strAsistentes;
    }

    public String getIntNumeroReunion() {
        return intNumeroReunion;
    }

    public void setIntNumeroReunion(String intNumeroReunion) {
        this.intNumeroReunion = intNumeroReunion;
    }

    public static List<CrearReunionModels> escribirData(DataTable dataTable) {

        List<CrearReunionModels> data = new ArrayList<>();
        List<Map<String, String>> mapIfo = dataTable.asMaps();
        for (Map<String, String> map : mapIfo) {
            data.add(new ObjectMapper().convertValue(map, CrearReunionModels.class));
        }
        return data;
    }
}
