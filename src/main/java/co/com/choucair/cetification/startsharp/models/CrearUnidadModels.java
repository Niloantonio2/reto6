package co.com.choucair.cetification.startsharp.models;



import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrearUnidadModels {

    private String strNombreUnidad, strUnidadPadre ;

    public String getStrNombreUnidad() {
        return strNombreUnidad;
    }

    public void setStrNombreUnidad(String strNombreUnidad) {
        this.strNombreUnidad = strNombreUnidad;
    }

    public String getStrUnidadPadre() {
        return strUnidadPadre;
    }

    public void setStrUnidadPadre(String strUnidadPadre) {
        this.strUnidadPadre = strUnidadPadre;
    }

    public static List<CrearUnidadModels> escribirData(DataTable dataTable) {

        List<CrearUnidadModels> data = new ArrayList<>();
        List<Map<String, String>> mapIfo = dataTable.asMaps();
        for (Map<String, String> map : mapIfo) {
            data.add(new ObjectMapper().convertValue(map, CrearUnidadModels.class));
        }
        return data;
    }
}
