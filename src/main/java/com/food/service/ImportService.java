package com.food.service;

import com.food.common.Common;
import com.food.exception.ExceptionForm;
import com.food.model.Import;
import com.food.repository.ImportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Hue on 11/16/2016.
 */
@Service
public class ImportService {

    @Autowired
    private ImportRepository importRepository;


    public Iterable<Import> findAll(){
        return importRepository.findAll();
    }


    public Import findOne(int id){
        if(!importRepository.exists(id)){
            throw new ExceptionForm("import", ExceptionForm.ERROR_CODE.EXIST, "Import is not found");
        }
        return importRepository.findOne(id);
    }

    public Import save(){
        Date date = new Date();
        String dateName = Common.dateTimeToString(date);
        Import importS = new Import(dateName);
        return importRepository.save(importS);
    }


    public ResponseEntity delete(int id){
        importRepository.delete(id);
        return ResponseEntity.ok("success");
    }


}
