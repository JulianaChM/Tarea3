package controlador;

import modelo.Estudiante;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {  // configuración del lector de la consola
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese la ruta del archivo CSV: ");
            String ruta = reader.readLine();   // se lee la ruta ingresada

            ProgramaEstudiante metodos = new ProgramaEstudiante();             // Creamos una instancia de la clase programaEstudiante para acceder a sus métodos
            List<Estudiante> listaEstudiantes = metodos.leerArchivoCSV(ruta);  // Llamamos al método "leerArchivoCSV" para leer el archivo CSV y obtener una lista de estudiantes

            if (listaEstudiantes != null) {
                // Generamos una nueva ruta con extensión .json en lugar de .csv
                String rutaJson = ruta.replaceAll(".csv", ".json");

                // Llamamos al método "escribirArchivoJson" para escribir la lista de estudiantes en un archivo JSON
                metodos.escribirArchivoJson(rutaJson, listaEstudiantes);
                System.out.println("Se ha creado el archivo .json.\nSe ha guardado en la ruta: " + rutaJson);
            } else {
                System.out.println("No se pudo leer el archivo CSV. Es posible que no exista o que haya ingresado mal la ruta");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// C:\Users\julia\OneDrive\Escritorio\Semestre V\IngSoftware\Pruebas-tarea3\estudiantes.csv
