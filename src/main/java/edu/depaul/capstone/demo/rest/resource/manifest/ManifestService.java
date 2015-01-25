package edu.depaul.capstone.demo.rest.resource.manifest;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * Created by Tomislav S. Mitic on 1/25/15.
 */
public class ManifestService {

    @Autowired
    ServletContext context;

    Attributes getManifestAttributes() throws FileNotFoundException, IOException {
        InputStream resourceAsStream = context.getResourceAsStream("/META-INF/MANIFEST.MF");
        Manifest mf = new Manifest();
        mf.read(resourceAsStream);
        Attributes atts = mf.getMainAttributes();

        return atts;
    }

    ImplementationDetails getImplementationVersion() throws FileNotFoundException, IOException{
        String appServerHome = context.getRealPath("/");
        File manifestFile = new File(appServerHome, "META-INF/MANIFEST.MF");

        Manifest mf = new Manifest();

        mf.read(new FileInputStream(manifestFile));

        Attributes atts = mf.getMainAttributes();
        ImplementationDetails response = new ImplementationDetails();
        response.setImplementationTitle(atts.getValue("Implementation-Title"));
        response.setImplementationVersion(atts.getValue("Implementation-Version"));
        response.setImplementationVendorId(atts.getValue("Implementation-Vendor-Id"));

        return response;
    }
}
