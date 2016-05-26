package com.javarush.test.level33.lesson10.bonus01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringWriter;

/* Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тэгом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

Пример вызова:  toXmlWithComment(firstSecondObject, "second", "it's a comment")
Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second><![CDATA[need CDATA because of < and >]]></second>
    <!--it's a comment-->
    <second/>
</first>
*/
public class Solution {

    public static void main(String[] args) throws JAXBException
    {
        toXmlWithComment(new First(), "second", "testset");
    }
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException
    {
        StringWriter stringWriter = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, stringWriter);
        String result = stringWriter.toString();
        System.out.println(result);

        return null;
    }

    @XmlType(name = "first")
    @XmlRootElement
    static class First {
        public String name = "testName";
        public int age;
    }
}
