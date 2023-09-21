package controlador;


import modelo.Estudiante;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProgramaEstudiante {

    /** Método que lee archivos CSV a partir de una ruta */
    public List<Estudiante> leerArchivoCSV(String rutaCarpeta) {
        List<Estudiante> listaEstudiantes = new ArrayList<>(); // Se crea una lista vacía para almacenar objetos de tipo Estudiante.

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaCarpeta))) { // Abrimos y leemos el archivo CSV
            String linea;
            while ((linea = reader.readLine()) != null) {     // Recorremos linea por línea
                String[] datos = linea.split(",");      // Separamos la línea cada vez que haya una coma
                if (datos.length == 3) {                     // Verificamos que la línea tenga una longitud de 3
                    String id = datos[0];                   // Asignamos el campo al dato que corresponde
                    String nombre = datos[1];
                    String apellido = datos[2];
                    listaEstudiantes.add(new Estudiante(id, nombre, apellido)); // Se crea el objeto Estudiante a partir de esos datos y se agregan a la lista
                }
            }
        } catch (IOException e) {   // Manejo de errores y excepciones
            e.printStackTrace();
            return null;
        }

        return listaEstudiantes;  // Retorna la lista de los estudiantes son sus datos ya separados
    }

    /** Método que organiza la lista de estudiantes en un archivo .json */
    public void escribirArchivoJson (String rutaCarpeta, List<Estudiante> listaEstudiantes) {
        JSONArray jsonArray = new JSONArray();  // Se crea un objeto Json Array para almacenar los datos de los estudiantes
        for (Estudiante estudiante : listaEstudiantes) {    // Se recorre la lista de estudiantes convirtiendo a cada uno en un objeto Json
            JSONObject datos = new JSONObject();
            datos.put("id", estudiante.getId());            // Se pasan los datos respectivos
            datos.put("nombre", estudiante.getNombre());
            datos.put("apellido", estudiante.getApellido());
            jsonArray.put(datos);
        }

        try (FileWriter fileWriter = new FileWriter(rutaCarpeta)) { // Escribimos el Json en un archivo
            fileWriter.write(jsonArray.toString());
        } catch (IOException e) { // Manejo de errores y excepciones
            e.printStackTrace();
        }
    }
}



