package com.api.book.bootrestbook.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHepler {
    public final String Upload_Dir = "C:\\Users\\Charry\\Desktop\\bootAPI\\bootrestbook\\src\\main\\resources\\static\\images";

    public boolean uploadFile(MultipartFile fileData) {
        boolean f = false;

        try {
            // // Read the data ============
            // InputStream is = fileData.getInputStream();
            // byte data[] = new byte[is.available()];
            // is.read(data);

            // // Write the data ============
            // // "file seperator or \\"
            // FileOutputStream fos = new FileOutputStream(Upload_Dir + File.separator +
            // fileData.getOriginalFilename());
            // fos.write(data);

            // fos.flush();
            // fos.close();

            Files.copy(fileData.getInputStream(),Paths.get(Upload_Dir + File.separator + fileData.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);

            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }
}
