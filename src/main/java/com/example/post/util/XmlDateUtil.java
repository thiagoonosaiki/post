package com.example.post.util;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;

/**
 * Utilitário responsável por converter datas do Java Time API
 * (LocalDateTime) para XMLGregorianCalendar.
 *
 * Essa conversão é necessaria para integração com serviços SOAP
 * que utilizam tipos XML (xsd:dateTime).
 */
public class XmlDateUtil {
    /**
     * Construtor privado para impedir instanciação.
     * Esta classe deve ser utilizada apenas de forma estática.
     */
    private XmlDateUtil() {

    }

    /**
     * Converte um {@link LocalDateTime} para {@link XMLGregorianCalendar}
     *
     * A conversão considera o fuso horário padrão do sistema.
     *
     * @param dateTime data/hora a ser convertida
     * @return data no formato XMLGregorianCalendar
     * @throws RuntimeException caso ocorra erro na conversão
     */
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
