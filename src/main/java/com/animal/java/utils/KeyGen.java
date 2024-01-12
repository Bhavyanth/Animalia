package com.animal.java.utils;

import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.*;
import java.util.Base64;

public class KeyGen {

    static private Base64.Encoder encoder = Base64.getEncoder();

    static private void writeBase64(Writer out, Key key)
            throws java.io.IOException
    {
        byte[] buf = key.getEncoded();
        out.write(encoder.encodeToString(buf));
        out.write("\n");
    }

    static public void main(String[] args) throws Exception
    {
        int keySize = 2048;
        String outFile = "app";
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");

        kpg.initialize(keySize);
        KeyPair kp = kpg.generateKeyPair();

        Writer out = null;
        try {
            if ( outFile != null ) out = new FileWriter(outFile + ".key");
            else out = new OutputStreamWriter(System.out);

            System.err.println("Private key format: " +
                    kp.getPrivate().getFormat());
            out.write("-----BEGIN RSA PRIVATE KEY-----\n");
            writeBase64(out, kp.getPrivate());
            out.write("-----END RSA PRIVATE KEY-----\n");

            if ( outFile != null ) {
                out.close();
                out = new FileWriter(outFile + ".pub");
            }

            System.err.println("Public key format: " +
                    kp.getPublic().getFormat());
            out.write("-----BEGIN RSA PUBLIC KEY-----\n");
            writeBase64(out, kp.getPublic());
            out.write("-----END RSA PUBLIC KEY-----\n");
        } finally {
            if ( out != null ) out.close();
        }
    }
}
