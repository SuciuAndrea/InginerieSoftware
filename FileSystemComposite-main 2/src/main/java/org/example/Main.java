package org.example;

import org.example.htmlbuilder.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // HTML
        HtmlElement html = new HtmlElement("html");
        HtmlElement body = new HtmlElement("body");

        HtmlLeaf h1 = new HtmlLeaf("h1", "Bine ai venit la generatorul HTML!");
        HtmlLeaf p = new HtmlLeaf("p", "Acesta este un paragraf generat automat.");
        HtmlLeaf img = new HtmlLeaf("img", "");

        img.setAttribute("src", "imagine.jpg");
        img.setAttribute("alt", "O imagine exemplu");

        body.add(h1);
        body.add(p);
        body.add(img);

        html.add(body);

        // generare fișier
        String content = "<!DOCTYPE html>\n" + html.render(0);
        Files.writeString(Path.of("output.html"), content);

        System.out.println("Fisierul 'output.html' a fost generat cu succes!");
    }
}
