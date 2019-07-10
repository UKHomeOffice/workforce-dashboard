package gov.homeoffice.workforceDashboard.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class UploadServiceImpl implements UploadService {

    private String fileName;

    @Override
    public void uploadFile(MultipartFile file) {

        try {
            fileName = file.getOriginalFilename();
            InputStream fis = file.getInputStream();

            Files.copy(fis, Paths.get(fileName),
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getResourceName() {

        try {

            Paths.get(fileName);
            if (fileName.isEmpty()) {
                return "";
            } else {
                return fileName;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } return fileName;

    }
}
