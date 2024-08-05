package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Base64FileDto {

        private String file;
        private String fileName;

        // Constructor sin argumentos
        public Base64FileDto() {
        }

        // Constructor con argumentos
        @JsonCreator
        public Base64FileDto(@JsonProperty("file") String file, @JsonProperty("fileName") String fileName) {
                this.file = file;
                this.fileName = fileName;
        }

        // Getters y Setters
       /* public String getFile() {
                return file;
        }

        public void setFile(String file) {
                this.file = file;
        }

        public String getFileName() {
                return fileName;
        }

        public void setFileName(String fileName) {
                this.fileName = fileName;
        }*/
}
