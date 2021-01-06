# ImageJ-OCR

An imageJ plugin that performs OCR using in imageJ. Through the tess4J library, the tesseract OCR engine is used.

## Installation

To install the plugin, download OCR.zip and place it into your imageJ's plugin folder and extract it. Ensure that once it is extracted that inside the OCR folder are 2 files and a folder and that it is **NOT** in a duplicate folder. Thus it should be:

`/wherever/ImageJ/plugins/OCR/ImageJ-OCR.jar`
and not
`/wherever/ImageJ/plugins/OCR/OCR/ImageJ-OCR.jar`

After you place the files in the right spot, restart ImageJ and the plugin should be installed.

## Usage

To use the plugin, first open the image you wish to perform OCR on. Then perform any preprocessing necessary to improve results. Finally, open the plugins menu and select OCR. Click 'ok' on the welcome message and await your results. Large images may take some time to fully scan, but once it is complete, results will be displayed in another pop-up window.

## Compilation
This project is currently set up to use gradle to compile. To compile try the following:

`gradle build`

Note that due to a dependency in Tess4J, the code cannot be compiled *easily* on a Windows 64 bit OS. This is due to the JAI imageio dependency within Tess4J. Read more about why this is the case on [this StackOverflow question](https://stackoverflow.com/a/20832583). 
