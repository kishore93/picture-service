package com.random.pictureservice.util;

import com.random.pictureservice.entity.PicsumInfoEntity;

public class PictureUtils {

    private static String htmlTemplate =
            "<html>\n" +
                    "<head>\n" +
                    "\t<title>Random Picture | {{Width}}x{{Height}}</title>\n" +
                    "\t<style>\n" +
                    "\t\tbody { \n" +
                    "\t\t  background: url({{PicsumUrl}}) no-repeat center center fixed; \n" +
                    "\t\t  -webkit-background-size: cover;\n" +
                    "\t\t  -moz-background-size: cover;\n" +
                    "\t\t  -o-background-size: cover;\n" +
                    "\t\t  background-size: cover;\n" +
                    "\t\t}\n" +
                    "\t</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "</body>\n" +
                    "</html>";


    public synchronized static String seedDataIntoTemplate(PicsumInfoEntity entity) {
        String html = htmlTemplate.replace("{{Width}}", entity.getWidth());
        html = html.replace("{{Height}}", entity.getHeight());
        html = html.replace("{{PicsumUrl}}", entity.getDownloadUrl());

        return html;
    }

}
