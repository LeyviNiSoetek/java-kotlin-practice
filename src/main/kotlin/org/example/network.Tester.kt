package org.example

import java.net.HttpURLConnection
import java.net.URL

fun main() {
    val url = URL("https://datacenter.taichung.gov.tw/swagger/OpenData/61253e8f-d94e-48b3-9ce8-dfd4f02b99ed")
    url.openStream()

    /*
    with(url.openConnection() as HttpURLConnection) {
        *//*connection.*//*inputStream.bufferedReader().lines().forEach(System.out::println)
    }
    */
    // ... or
    println(url.readText())
    // ... or maybe more
}