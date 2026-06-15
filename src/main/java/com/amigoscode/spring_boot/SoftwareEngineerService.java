package com.amigoscode.spring_boot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository){
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getSoftwareEngineers(){
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
         softwareEngineerRepository.save(softwareEngineer);
    }
}
