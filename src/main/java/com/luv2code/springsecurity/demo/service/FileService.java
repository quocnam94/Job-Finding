package com.luv2code.springsecurity.demo.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.luv2code.springsecurity.demo.dao.FileDAO;
import com.luv2code.springsecurity.demo.entity.CV;

@Service
@Transactional
public class FileService {

    @Autowired
    private FileDAO fileDAO;

    public void save(MultipartFile file, int userId) {
        try {
            CV fileModel = new CV(file.getOriginalFilename(), file.getContentType(), userId, file.getBytes());
            fileDAO.save(fileModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CV get(int id) {
        return fileDAO.get(id);
    }

    public List<CV> list() {
        return fileDAO.list();
    }

    public CV findByUserId(int userId) {
        return fileDAO.findByUserId(userId);
    }
}

