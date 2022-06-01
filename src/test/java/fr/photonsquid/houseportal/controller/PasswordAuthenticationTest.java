package fr.photonsquid.houseportal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordAuthenticationTest {
    @Test
    @DisplayName("same hash for same pwd")
    void getEncryptedPassword() {
        String pwd = "PONT2000";
        PasswordAuthentication pa = new PasswordAuthentication();
        String hash1 = pa.hash(pwd.toCharArray());
        Boolean isSame = pa.authenticate(pwd.toCharArray(), hash1);
        assertEquals(isSame, true, "same hash for same pwd");
    }
}
