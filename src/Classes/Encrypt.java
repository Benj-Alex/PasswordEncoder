/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Benjamin Alexander
 */
public class Encrypt {
    
    // Encrypter le mot de passe
    public String EncryptPassword(String password){        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);      
        return encodedPassword;
    }
    
    // Encrypter le mot de passe
    public boolean Compare(String hash, String mdpBrut){         
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean isMatch = encoder.matches(mdpBrut, hash);   
        return isMatch;
    }
}
