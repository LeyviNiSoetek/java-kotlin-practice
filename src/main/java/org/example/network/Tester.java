package org.example.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Tester {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://datacenter.taichung.gov.tw/swagger/OpenData/61253e8f-d94e-48b3-9ce8-dfd4f02b99ed");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            // or maybe ...
            //InputStream is = url.openStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // either ...
            /*
            br.lines().forEach((line) -> {
                System.out.println(line);
            });
            */
            // ... or
            // TODO: what is `::` operator? Looks like C++ one
            br.lines().forEach(System.out::println);

            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
