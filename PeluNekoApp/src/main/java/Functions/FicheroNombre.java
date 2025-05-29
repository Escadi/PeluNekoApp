package Functions;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FicheroNombre {

    public String getNombreAnimal() {
        List<String> nombres = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/TextNameAnimals/NameAnimals.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    nombres.add(linea.trim());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        Random rand = new Random();
        return nombres.get(rand.nextInt(nombres.size()));
    }
}
