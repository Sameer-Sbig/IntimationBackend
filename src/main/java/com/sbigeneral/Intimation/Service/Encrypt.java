package com.sbigeneral.Intimation.Service;

import org.springframework.stereotype.Service;

@Service
public interface Encrypt {
    String encrypt(Object response, String base64Key, String base64Iv) throws Exception;
    
    String aes256cbcEncrypt(Object response) throws Exception;
    
}
