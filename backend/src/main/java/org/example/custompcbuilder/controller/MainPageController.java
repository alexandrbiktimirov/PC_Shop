package org.example.custompcbuilder.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class MainPageController {

    public ResponseEntity<?> home(){
        try{
            Path mainFile = Paths.get("../frontend/build/index.html");

            Resource mainResource = new UrlResource(mainFile.toUri());

            if (mainResource.exists()){
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.TEXT_HTML)
                        .body(mainResource);
            } else{
                return ResponseEntity.notFound().build();
            }
        } catch(MalformedURLException e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Something unexpected happened :(");
        }
    }
}