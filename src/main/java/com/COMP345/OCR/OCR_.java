// javac -classpath "*;." .\OCR.java 
// run in imageJ with compile and run option under plugins \ new \ plugin filter
// https://imagej.nih.gov/ij/download/docs/tutorial171.pdf
// maven guide: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
// might require an underscore in name: https://imagej.nih.gov/ij/docs/menus/plugins.html#new 
// plugin reqs: underscore in name, class file in plugins, restart imageJ
// https://stackoverflow.com/questions/4955635/how-to-add-local-jar-files-to-a-maven-project

// alternative tesseract for java library https://stackoverflow.com/questions/13974645/using-tesseract-from-java

// make maven project:
// mvn archetype:generate -DgroupId=com.COMP345 -DartifactId=OCR -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
// add maven dependency:
// mvn install:install-file -DgroupId=com.stackoverflow... -DartifactId=yourartifactid... -Dversion=1.0 -Dpackaging=jar -Dfile=C:\Users\losth\Desktop\COMP345\Project\OCR\target\classes\lib

// what I'm currently doing: https://stackoverflow.com/questions/396245/add-a-dependency-in-maven
// searching on https://mvnrepository.com/artifact/org.hamcrest/hamcrest-core
// going through libs in tess4j, currently on jboss-vfs

import ij.*;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import ij.plugin.filter.*;

import java.io.File;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.awt.image.BufferedImage;

import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.util.LoadLibs;

public class OCR_ implements PlugInFilter
{
	ImagePlus imp;

	public int setup(String arg, ImagePlus imp)
	{
		if(arg.equals("about"))
		{
			showAbout();
			return DONE;
		}

		this.imp = imp;
		return DOES_ALL;
	}

	public void run(ImageProcessor ip)
	{
		IJ.showMessage("OCR", "Welcome! Hit ok to begin OCR. Images with many words may take a while!"); 
    	BufferedImage sourceImage = ip.getBufferedImage();
    	Tesseract tesseract = new Tesseract();

	    try
	    {
	    	//path is specific to my computer for now, directories can be a pain so I didn't bother yet
	     	// tesseract.setDatapath("/home/joey/Desktop/COMP345/Project/ImageJ-OCR/tess4j/src/main/resources/tessdata"); //not mobile
	     	File tessDataFolder = LoadLibs.extractTessResources("tessdata"); 
  			tesseract.setDatapath(tessDataFolder.getAbsolutePath());

	    	String resultingText = tesseract.doOCR(sourceImage);
	     	IJ.showMessage("OCR", resultingText);
	    }
	    catch (Exception e)
	    {
	    	StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			
			String stackTrace = sw.toString();
	    	String errorMessage = e.getMessage() + "\n-----\n" + stackTrace;
	    	IJ.showMessage("OCR",errorMessage);
	    }



	}

	void showAbout()
	{
		IJ.showMessage("About OCR...",
			"This plugin takes in an input image and gives " +
			"text that corresponds to words that are written " +
			"or printed in the image.");
	}

}