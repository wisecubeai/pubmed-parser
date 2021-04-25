# Pubmed Parser 

The Pubmed Parser gives Java developers an efficient and standard way of mapping between Pubmed XML and Java code.
Java developers using the Pubmed Parser more productive because they can write less code themselves
and do not have to be experts in XML. Pubmed Parser makes it easier for developers to extend
their applications with XML and Web Services technologies.

The Pubmed Parser enables developers to perform the following operations:
- Unmarshal Pubmed XML content into a Java representation
- Access and update the Java representation
- Marshal the Java representation of the Pubmed XML content back into XML content

This project is an attempt to parse the Pubmed XML as defined by the Pubmed DTD (https://dtd.nlm.nih.gov/ncbi/pubmed/out/pubmed_190101.dtd)


# Requirements

The Pubmed parser was tested on JDK 11


# Build Instructions

This project has the JAXB libraries it needs included since they do not come bundled with the JDK anymore
The sample pubmed xml and dtd are in the pubmed/ folder 
Once you cd into pubmed/ folder, run the following command to kick off a build

./build.sh 


# Sample Usage

Refer to the [DTDSample.java](pubmed/src/DTDSample.java) file for instructions on how to use the parser


# Current Limitations of the parser

- Currently the DTD that is used to generate JAXB bindings and classes does not include the MathML related parts of the original Pubmed DTD
- DTD Validation has to be turned off in the unmarshalling code for the pubmed parser to work with raw Pubmed XML files, Refer to the [DTDSample.java](pubmed/src/DTDSample.java) file on how to do this

## License

Pubmed XML Parser is is licensed under a license - [BSD 3](LICENSE.txt).


## Contributing

We use [contribution policy](contributing.md), so please read it first before contributing 

