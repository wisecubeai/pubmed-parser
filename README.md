# Pubmed XML Parser 

Jakarta XML Binding (JAXB) gives Java developers an efficient and standard way of mapping between XML and Java code.
Java developers using Jakarta XML Binding are more productive because they can write less code themselves
and do not have to be experts in XML. Jakarta XML Binding makes it easier for developers to extend
their applications with XML and Web Services technologies.

The Pubmed XML Parser enables developers to perform the following operations:
- Unmarshal Pubmed XML content into a Java representation
- Access and update the Java representation
- Marshal the Java representation of the Pubmed XML content back into XML content

This project is an attempt to parse the Pubmed XML as defined by the Pubmed DTD (https://dtd.nlm.nih.gov/ncbi/pubmed/out/pubmed_190101.dtd)

# Build Instructions

This project has the JAXB libraries it needs included since they do not come bundled with the JDK anymore
The sample pubmed xml and dtd are in the pubmed/ folder 
Once you cd into pubmed/ folder, run the following command to kick off a build

./build.sh 


# Sample Usage

Refer to the pubmed/src/DTDSample.java file for instructions on how to use the parser


# Limitations of the parser

- Currently the DTD that is used to generate JAXB bindings and classes does not include the MathML related parts of the original Pubmed DTD
- The sample pubmed.xml included to test the marshalling and unmarshalling omits the Doctype line to avoid JAXB trying to load the DTD 
- which means that you will have to modify the pubmed xml files you want to parse to omit the DOCTYPE line as well

## License

Pubmed XML Parser is is licensed under a license - [EDL 1.0](LICENSE.md).


## Contributing

We use [contribution policy](CONTRIBUTING.md), which means we can only accept contributions under
the terms of [Eclipse Contributor Agreement](http://www.eclipse.org/legal/ECA.php).

