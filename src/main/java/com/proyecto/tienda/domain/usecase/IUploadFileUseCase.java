package com.proyecto.tienda.domain.usecase;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

public interface IUploadFileUseCase {
    public Resource load(String fileName) throws MalformedURLException;
    public String copy(MultipartFile file, String annexeName) throws IOException;
    public boolean delete(String fileName);
    public Path getPath(String fileName);
}
