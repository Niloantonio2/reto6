package co.com.choucair.cetification.startsharp.models;


import io.cucumber.datatable.DataTable;
import org.gradle.internal.impldep.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CredencialesModels {

    private String strUsuario, strClave;

    public String getStrUsuario() {
        return strUsuario;
    }

    public String getStrClave() {
        return strClave;
    }

    public void setStrUsuario(String strUsuario) {
        this.strUsuario = strUsuario;
    }

    public void setStrClave(String strClave) {
        this.strClave = strClave;
    }

    public static List<CredencialesModels> escribirData(DataTable dataTable) {

        List<CredencialesModels> data = new ArrayList<>();
        List<Map<String, String>> mapIfo = dataTable.asMaps();
        for (Map<String, String> map : mapIfo) {
            data.add(new ObjectMapper().convertValue(map, CredencialesModels.class));
        }
        return data;
    }
}
