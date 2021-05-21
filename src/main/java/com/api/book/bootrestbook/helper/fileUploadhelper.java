package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.api.book.bootrestbook.services.bookService;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileUploadhelper {
    // public final String  UPLOAD_DIR="G:\\workspace for vs code projects\\bootrestbook\\src\\main\\resources\\static";
    public final String  UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public fileUploadhelper() throws IOException{
        
    }
    
    public boolean upoloadFile(MultipartFile mf){
        boolean f = false;
        try {
        //    InputStream is =  mf.getInputStream();
        //    byte data[] = new byte(is.available());
        //    is.read(data);

        //    FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+mf.getOriginalFilename());
        //    fos.write(data);
        //    fos.flush();
        //    fos.close();
        //    f=true;
            Files.copy(mf.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+mf.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
