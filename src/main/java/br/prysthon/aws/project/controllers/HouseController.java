package br.prysthon.aws.project.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping(value = "houses")
public class HouseController {

    @PostMapping("")
    public void saveHouse(
        @RequestBody List<MultipartFile> files
    ) {
        System.out.println(files);

    }
}
