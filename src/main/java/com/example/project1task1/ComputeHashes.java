package com.example.project1task1;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import javax.xml.bind.DatatypeConverter;
/*
* Author: Aditi Gupta - argupta
* Last Modified: September 22, 2023
Explanation:
This is a Java Servlet (ComputeHashes) that computes cryptographic hashes (e.g., MD5, SHA-1) for a given input text.
The doGet method is invoked when a client sends an HTTP GET request to the specified URL (/ComputeHashes).
It retrieves the text and hashType parameters from the request, which represent the text to be hashed and the hash algorithm to use.
The computeHash method is called to calculate the hash value based on the selected hash type.
The computed hash is then displayed in an HTML response, along with the original text and hash type.
Two representations of the hash are shown: hexadecimal and Base64-encoded.
The code handles potential exceptions, such as when the specified hash algorithm is not available (NoSuchAlgorithmException).
* */

@WebServlet(name = "ComputeHashes", value = "/ComputeHashes")
public class ComputeHashes extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the text and hashType parameters from the request
        String text = request.getParameter("text");
        String hashType = request.getParameter("hashType");

        // Compute the hash for the provided text and hash type
        String hashResult = computeHash(text, hashType);

        // Generate an HTML response to display the hash result
        out.println("<html><head><title>Hash Result</title></head><body>");
        out.println("<h1>Hash Result</h1>");
        out.println("<p>Original Text: " + text + "</p>");
        out.println("<p>Selected Hash Type: " + hashType + "</p>");
        out.println("<p>Hexadecimal Hash: " + hashResult + "</p>");
        out.println("<p>Base64 Hash: " + DatatypeConverter.printBase64Binary(hashResult.getBytes()) + "</p>");
        out.println("</body></html>");
    }

    // This method computes a hash of the provided text using the specified hash type
    private String computeHash(String text, String hashType) {
        try {
            // Create a MessageDigest instance for the specified hash type
            MessageDigest md = MessageDigest.getInstance(hashType);

            // Compute the hash of the text as bytes
            byte[] hashBytes = md.digest(text.getBytes());

            // Convert the hash bytes to a hexadecimal string
            return DatatypeConverter.printHexBinary(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "Hashing Failed";
        }
    }
}
