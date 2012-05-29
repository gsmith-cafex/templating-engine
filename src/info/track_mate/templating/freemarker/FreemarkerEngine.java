/**
 * Copyright 2000-2012 TrackMate
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package info.track_mate.templating.freemarker;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import info.track_mate.templating.Template;
import info.track_mate.templating.TemplateEngine;
import info.track_mate.util.FileUtils;
import java.io.File;
import java.io.StringWriter;
import java.util.Map;

/**
 * TemplateEngine implementation utilising the Freemarker project.
 * @author Gareth Smith <gareth@track-mate.info>
 */
public class FreemarkerEngine implements TemplateEngine {

  /** The root directory for getting all template files*/
  private String templateRootDir = null;

  /**
   * Creates a new FreemarkerEngine.
   */
  public FreemarkerEngine() {
  }

  /**
   * Creates a new FreemarkerEngine.
   * @param templateRootDir The root directory for getting all template files.
   */
  public FreemarkerEngine(String templateRootDir) {
    this.templateRootDir = templateRootDir;
  }

  @Override
  public Template getTemplate(String templateFileName) throws Exception {
    Configuration configuration = new Configuration();

    String pathToTemplate = templateRootDir;
    if (templateRootDir == null) {
      pathToTemplate = FileUtils.getClasspathFileLocationFromName(templateFileName);
    }
		FileTemplateLoader extraLoader = new FileTemplateLoader(new File(pathToTemplate));
    configuration.setTemplateLoader(extraLoader);

    freemarker.template.Template template = configuration.getTemplate(templateFileName);
    return new FreemarkerTemplate(template);
  }

  @Override
  public String processTemplate(Template template, Map<String, Object> parameters) throws Exception {
    if (!(template instanceof FreemarkerTemplate)) {
      throw new Exception("FreemarkerEngine only handles FreemarkerTemplates");
    }
    freemarker.template.Template freemarkerTemplate = ((FreemarkerTemplate)template).getTemplate();
    StringWriter templateOutput = new StringWriter();
    freemarkerTemplate.process(parameters, templateOutput);
    StringBuffer outputStringBuffer = templateOutput.getBuffer();
    String templateOutputString = outputStringBuffer.toString();
    return templateOutputString;
  }

}
