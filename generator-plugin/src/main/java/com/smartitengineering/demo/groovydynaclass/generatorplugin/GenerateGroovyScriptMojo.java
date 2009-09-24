package com.smartitengineering.demo.groovydynaclass.generatorplugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Hello world!
 * @goal generate
 */
public class GenerateGroovyScriptMojo
				extends AbstractMojo {

		/**
		 * Output Dir
		 *
		 * @parameter
		 */
		private File outputDir;

		public void execute()
						throws MojoExecutionException,
									 MojoFailureException {
				FileOutputStream fos = null;
				try {
						if (getOutputDir() == null) {
								throw new MojoFailureException("Parameter outputDir must be set");
						}
						if(!getOutputDir().exists()) {
								getOutputDir().mkdirs();
						}
						File productGroovyFile =
								 new File(getOutputDir(), "Product.groovy");
						fos = new FileOutputStream(productGroovyFile);
						Writer writer = new OutputStreamWriter(fos);
						writer.write(
								"package com.smartitengineering.demo.dyna;\n" +
								"class Product{int getProductId() {return 0}\n" +
								"public String toString() {return \"CompileTime\"}}\n");
						writer.flush();
				}
				catch (Exception ex) {
						throw new MojoExecutionException(ex.getMessage(), ex);
				}
				finally {
						try {
								if (fos != null) {
										fos.close();
								}
						}
						catch (IOException ex) {
								ex.printStackTrace();
						}
				}
		}

		public File getOutputDir() {
				return outputDir;
		}

		public void setOutputDir(File outputDir) {
				this.outputDir = outputDir;
		}
}
