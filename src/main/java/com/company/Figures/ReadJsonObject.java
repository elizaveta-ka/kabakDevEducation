package com.company.Figures;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadJsonObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("JsonForExample.json"));
        ObjectMapper mapper = new ObjectMapper();
        String  json = br.readLine();
        System.out.println(json);
        br.close();
    }
}
