package com.api.book.bootrestbook.controllers;

import com.api.book.bootrestbook.helper.fileUploadhelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {

    @Autowired
    private fileUploadhelper fileUploadhelper;

    @PostMapping("/uploadfile")
    public ResponseEntity<String> upoloadFile(@RequestParam("file") MultipartFile file){
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        // System.out.println(file.getName());
        try {
            if(file.isEmpty()){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }
            if(!file.getContentType().equals("image/jpeg")){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg files are allowed");
            }
            
            boolean f = fileUploadhelper.upoloadFile(file);
            if(f){
                 return ResponseEntity.ok("file upload successful");
                //return ResponseEntity.ok(ServletUriComponentsBuilder.fromContextPath("/image/").path(file.getOriginalFilename()).toUriString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");

    }
}
