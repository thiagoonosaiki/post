package com.example.post.logicadeconversao;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;

public class XmlDataUtil {

    private XmlDataUtil() {

    }

    public static XMLGregorianCalendar toXmlDate(LocalDateTime dateTime) {
        try{
            GregorianCalendar gc = GregorianCalendar.from(
                    dateTime.atZone(ZoneId.systemDefault())
            );

            return DatatypeFactory
                    .newInstance()
                    .newXMLGregorianCalendar(gc);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter data para XMLGregorianCalendar", e);
        }
    }
}
