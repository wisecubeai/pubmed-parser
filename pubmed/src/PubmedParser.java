/*
 * Copyright (c) 1997, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package ai.wisecube.pubmed;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.StringWriter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;

import ai.wisecube.pubmed.*;

/**
 *
 *
 * @author Vishnu Vettrivel
 */
public class PubmedParser {

    private JAXBContext context;

    public PubmedParser() throws Exception {
        //String packageName = clazz.getClass().getPackage().getName();
        context =  JAXBContext.newInstance("ai.wisecube.pubmed");
    }

    public <T> T parse(StreamSource streamSource, Class<T> clazz) throws Exception {
        return parse(streamSource, clazz, false);
    }

    public <T> T parse(String xmlContent, Class<T> clazz) throws Exception {
        return parse(xmlContent, clazz, false);
    }

    public <T> T parse(StreamSource streamSource, Class<T> clazz, boolean supportDTDValidation) throws Exception {
        XMLInputFactory xif = getXmlInputFactory(supportDTDValidation);
        XMLStreamReader xsr = xif.createXMLStreamReader(streamSource);
        return unmarshallObject(context, xsr);
    }

    public <T> T parse(String xmlContent, Class<T> clazz, boolean supportDTDValidation) throws Exception {
        XMLInputFactory xif = getXmlInputFactory(supportDTDValidation);
        InputStream xmlContentStream = new ByteArrayInputStream(xmlContent.getBytes());
        XMLStreamReader xsr = xif.createXMLStreamReader(xmlContentStream);
        return unmarshallObject(context, xsr);
    }

    public <T> String stringify(T object) throws Exception{
        return stringify(object, false);
    }

    public <T> String stringify(T object, boolean supportDTDValidation) throws Exception{

        //Create Input Factory and turn off DTD Validation
        XMLInputFactory xif = getXmlInputFactory(supportDTDValidation);

        // Create Marshaller
        Marshaller m = context.createMarshaller();
        m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );

        //Marshall to a String
        StringWriter sw = new StringWriter();
        m.marshal(object, sw);
        return sw.toString();
    }


    private XMLInputFactory getXmlInputFactory(boolean supportDTDValidation) throws Exception{
        XMLInputFactory xif = XMLInputFactory.newFactory();
        xif.setProperty(XMLInputFactory.SUPPORT_DTD, supportDTDValidation);
        return xif;
    }

    private <T> T unmarshallObject(JAXBContext context, XMLStreamReader xsr) throws Exception{
        // unmarshal the stream using the contexg.
        return (T) context.createUnmarshaller().unmarshal(xsr);
    }

    private void testParserStream( String fileName ) throws Exception {
        PubmedArticleSet articleSet = parse(new StreamSource(fileName), PubmedArticleSet.class);
        System.out.println(stringify(articleSet));
    }

    private void testParserString( String fileName ) throws Exception {
        Path filePath = Path.of(fileName);
        String fileContent = Files.readString(filePath);
        PubmedArticleSet articleSet = parse(fileContent, PubmedArticleSet.class);
        System.out.println(stringify(articleSet));
    }

    public static void main(String[] args) throws Exception {
        // in this example, I skip the error check entirely
        // for the sake of simplicity. In reality, you should
        // do a better job of handling errors.
        PubmedParser parser = new PubmedParser();
        for( int i=0; i<args.length; i++ ) {
            parser.testParserStream(args[i]);
            parser.testParserString(args[i]);
        }
    }
}
