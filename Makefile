all: build package

.PHONY: build package clean

build: src/Program.java
	javac src/Program.java -d classes

package: 
	jar --create -f Program.jar -m manifest.mf -C classes . src

clean:
	rm Program.jar
	rm -r classes
