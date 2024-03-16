package com.proyecto.tienda.domain.service;

import com.proyecto.tienda.domain.usecase.IUploadFileUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements IUploadFileUseCase {
    private final static String DIRECTORY_UPLOAD = "uploads";
    private final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);

    /**
     * @param fileName
     * @return
     * @throws MalformedURLException
     */
    @Override
    public Resource load(String fileName) throws MalformedURLException {
        // se crea la ruta con el nombre de la foto que se encuentra en la carpeta
        // uploads
        Path path = getPath(fileName);
        // se inicializa el resource en null
        Resource resource = null;
        // se crea el resource enviar
        resource = new UrlResource(path.toUri());
        // se comprueba que el resource sea manejable
        if (!resource.exists() && !resource.isReadable()) {
            path = Paths.get("src/main/resources/static/images").resolve("no_product.png").toAbsolutePath();
            resource = new UrlResource(path.toUri());
            System.out.println("======================LLEGO====================");
        }
        return resource;
    }

    /**
     * @param file
     * @param annexeName
     * @return
     * @throws IOException
     */
    @Override
    public String copy(MultipartFile file, String annexeName) throws IOException {
        // separa el string en tokens a partir del caracter .
        int index = file.getOriginalFilename().indexOf(".");
        // obtengo la extension del archivo
        String extension = "." + file.getOriginalFilename().substring(index + 1);
        // se crea la composicion del nombre del archivo
        String newName = UUID.randomUUID().toString() + "_" + annexeName + extension;
        // se crea la ruta absoluta de la carpeta y el archivo
        Path path = getPath(newName);
        log.info(path.toString());
        // se copia el archvo en la ruta
        Files.copy(file.getInputStream(), path);
        return newName;
    }

    /**
     * @param fileName
     * @return
     */
    @Override
    public boolean delete(String fileName) {
        if (fileName != null) {
            if (!fileName.isEmpty()) {
                Path previusPath = getPath(fileName);
                File previusFile = previusPath.toFile();
                if (previusFile.exists() && previusFile.canRead()) {
                    previusFile.delete();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param fileName
     * @return
     */
    @Override
    public Path getPath(String fileName) {
        return Paths.get(DIRECTORY_UPLOAD).resolve(fileName).toAbsolutePath();
    }
}
