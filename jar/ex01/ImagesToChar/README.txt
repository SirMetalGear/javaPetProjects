TO COMPILE:
mkdir target; javac -d target src/java/edu/school21/printer/*/*.java
TO MAKE JAR FILE
cd target; jar cfm images-to-chars-printer.jar ../src/manifest.txt .; cp -R ./../src/resources .
TO RUN PROGRAM:
java -jar images-to-chars-printer.jar .0 ./resources/image.bmp