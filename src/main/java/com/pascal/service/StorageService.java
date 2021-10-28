package com.pascal.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class StorageService {

    @Autowired
    AccountService accountService;

    public void saveFileTo(MultipartFile multipartFile, String id) throws IOException {
        accountService.getById(id);
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        String destination = "/home/dell/Academy/pascal-7/upload/"+id+"."+extension;
        File fileTemp = new File(destination);
        multipartFile.transferTo(fileTemp);
    }
}
