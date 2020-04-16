package com.norbo.projects.progj18edzesnaplo.data.log;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Loggoláskor használt kimeneti formázás, HTML formátumban egy táblázatot készít
 * @author igloi
 */
public class HTMLFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return "<tr><td>"+Instant.ofEpochMilli(record.getMillis()).toString()+"</td>"+
                "<td>"+ record.getMessage()+"</td></tr>";
    }

    @Override
    public String getTail(Handler h) {
        return "\t</tbody>\n\t</table>\n</body>\n</html>";
    }

    @Override
    public String getHead(Handler h) {
        return "<!DOCTYPE html>\n<html>\t<head>" + 
               "\t\t<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\n" + 
               "\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" + 
               "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
               "\t\t<title>Edzésnapló Log</title></head>\n<body>"+
                "\t<table border=1><thead>\n" + 
                "\t\t<tr><th>Idő</th><th>Üzenet</th></thead>\n" + 
                "\t<tbody>\n";
    }
}
