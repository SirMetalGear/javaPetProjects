WARNING! DO NOT CHANGE YOUR CURRENT DIRECTORY WHILE INSTALLING
JUST COPY AND PUT IN YOUR CONSOLE:
mkdir lib; cd lib; curl -O https://repo1.maven.org/maven2/com/beust/jcommander/1.78/jcommander-1.78.jar
curl -O https://repo1.maven.org/maven2/com/diogonunes/JCDP/2.0.3.1/JCDP-2.0.3.1.jar
cd ..
mkdir target; javac -d target -cp ./lib/\* ./src/java/edu/school21/printer/*/*.java
mkdir ./target/com; cp ./lib/JCDP-2.0.3.1.jar ./target; cp ./lib/jcommander-1.78.jar ./target
cd target; jar xf JCDP-2.0.3.1.jar com/; jar xf jcommander-1.78.jar com/; rm -rf JCDP-2.0.3.1.jar; rm -rf jcommander-1.78.jar; cd ..
cp -R ./src/resources ./target/
cd target; jar cfm images-to-chars-printer.jar ../src/manifest.txt .
java -jar images-to-chars-printer.jar --white=BLACK --black=RED

TO DELETE LIB AND TARGET DIRECTRORIES
cd ..; rm -rf lib target