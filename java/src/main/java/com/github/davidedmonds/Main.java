package com.github.davidedmonds;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.nio.charset.Charset;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class Main {
    public static void main(String[] args) throws Exception {
        final String json = IOUtils.toString(Main.class.getClassLoader().getResource("cheeses.json"), Charset.forName("UTF-8"));
        final Gson gson = new Gson();
        final JsonArray array = gson.fromJson(json, JsonArray.class);
        StreamSupport.stream(Spliterators.spliteratorUnknownSize(array.iterator(), Spliterator.IMMUTABLE), false)
                .map(cheese -> cheese.getAsJsonObject().get("itemLabel").getAsString())
                .filter(cheese -> !cheese.matches("^Q\\d+"))
                .sorted()
                .forEach(System.out::println);
    }
}