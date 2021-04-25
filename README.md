# Pubmed Parser 

This project is an attempt to create a Java parser for the Pubmed XML as defined by the [Pubmed DTD](https://dtd.nlm.nih.gov/ncbi/pubmed/out/pubmed_190101.dtd)

The Pubmed Parser gives Java developers an efficient and standard way of mapping between Pubmed XML and Java code.
Java developers using the Pubmed Parser are more productive because they can write less code themselves
and do not have to be experts in parsing Pubmed XML. 

The Pubmed Parser enables developers to perform the following operations:
- Unmarshal Pubmed XML content into a Java representation
- Access and update the Java representation
- Marshal the Java representation of the Pubmed XML content back into XML content


# Requirements

- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Apache Ant](https://ant.apache.org/manual/install.html)
- Ensure JAVA_HOME and ANT_HOME variables are set in the environment and are also in the PATH


# Build Instructions

This project has the JAXB libraries it needs included since they do not come bundled with the JDK anymore
The sample pubmed.xml and pubmed.dtd are located in the schema/ folder 
The distribution jar is a unified/shaded/fat jar called `pubmed-parser.jar` created in the 'dist' folder

Run the following command to kick off a build, test, docs and assembly of the Pubmed Parser.

`./build.sh` 


# Java Docs
All Javadocs for the generated classes will be found under the `docs` folder


# Java Class Usage


	//Get XML File Content as a String
	Path filePath = Path.of("pubmed.xml");
 	String fileContent = Files.readString(filePath);
        
	//Create Pubmed Parser
	//The PubmedParser is built to be thread-safe and should not need to be created more than once per Application
	PubmedParser parser = new PubmedParser();

	//Parse XML String Content into Java Object
	PubmedArticleSet articleSet = parser.parse(fileContent, PubmedArticleSet.class);
        

	//Stringify Java object back into a XML String
	String xmlContent = parser.stringify(articleSet);


# Shaded Jar Usage

Running the following command should validate the shaded jar against the sample pubmed.xml included

`java -jar dist/pubmed-parser.jar schema/pubmed.xml`



# Current Limitations of the parser

- Currently the DTD that is used to generate JAXB bindings and classes does not include the MathML related parts of the original Pubmed DTD
- DTD Validation will be turned off by default in the Parser. You can turn it back on if needed by calling the right parameter in the parser method. However we have not tested it with being on.

## License

Pubmed XML Parser is is licensed under a license - [BSD 3](LICENSE.txt).


## Contributing

We use [contribution policy](contributing.md), so please read it first before contributing 

