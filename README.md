# ImageJ-OCR

An imageJ plugin that performs OCR using tesseract OCR engine. Tesseract usage is done through tess4j.

## Compilation
This project is currently set up to use Maven to compile. To compile try the following:

`mvn package`

## Running in ImageJ
Take OCR_.class and *all* .jar files and place them in a folder called OCR within the ImageJ plugins folder. 

## Current Issues
As of now, the code fails in imageJ stating that you "need to install jai image-io" and offers a dead link to install. Some possibilities are the jar is incorrect (despite being supplied by tess4j), the dependency isn't being handled correctly (I haven't used maven much), or something completely different.

Previously a somewhat similar issue occured involved the tesseract library itself which was solved after moving the tess4j.jar into the OCR plugin folder.
