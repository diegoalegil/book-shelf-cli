package dev.diego.bookshelf;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibroCsvReader {

    public List<Libro> leer(Path csv) throws IOException {
        List<String> lineas = Files.readAllLines(csv, StandardCharsets.UTF_8);
        List<Libro> libros = new ArrayList<>();
        for (String linea : lineas) {
            String[] campos = linea.split(";");
            Libro libro = new Libro(campos[0], campos[1], Integer.parseInt(campos[2]), campos[3]);
            libros.add(libro);
        }
        return libros;
    }
}