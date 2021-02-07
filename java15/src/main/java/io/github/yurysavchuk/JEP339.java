package io.github.yurysavchuk;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

public class JEP339 {

  public static void main(String[] args)
    throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
    KeyPair kp = kpg.generateKeyPair();

    byte[] msg = "abc".getBytes(StandardCharsets.UTF_8);

    Signature sig = Signature.getInstance("Ed25519");
    sig.initSign(kp.getPrivate());
    sig.update(msg);
    byte[] s = sig.sign();

    System.out.println(Base64.getEncoder().encodeToString(s));
  }

}
