package com.yang.absence.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/22 0:25
 */
public interface ProcessService {

    void deployProcess(MultipartFile file, String companyId) throws IOException ;
}
