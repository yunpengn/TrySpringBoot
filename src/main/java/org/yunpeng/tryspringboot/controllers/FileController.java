package org.yunpeng.tryspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.yunpeng.tryspringboot.services.FileStorageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/files")
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class FileController {
    private final FileStorageService fileStorageService;

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        fileStorageService.storeFile(file);
        return "success";
    }
}
