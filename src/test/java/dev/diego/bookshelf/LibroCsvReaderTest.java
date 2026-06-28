package dev.diego.bookshelf;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LibroCsvReaderTest {

    @Test
    void lee_dos_libros_del_csv(@TempDir Path dir) throws IOException {
        Path csv = dir.resolve("libros.csv");
        Files.writeString(csv,
                "Cien anos de soledad;Garcia Marquez;1967;978-0307474728\n" +
                        "La sombra del viento;Carlos Ruiz Zafon;2001;978-8408172178\n",
                StandardCharsets.UTF_8);

        List<Libro> libros = new LibroCsvReader().leer(csv);

        assertThat(libros).hasSize(2);
        assertThat(libros.get(0)).isEqualTo(
                new Libro("Cien anos de soledad", "Garcia Marquez", 1967, "978-0307474728"));
        assertThat(libros.get(1).titulo()).isEqualTo("La sombra del viento");
    }
}