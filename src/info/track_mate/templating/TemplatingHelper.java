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
package info.track_mate.templating;

import info.track_mate.templating.freemarker.FreemarkerEngine;

/**
 * Helper for TemplatingEngine project.
 * @author Gareth Smith <gareth@track-mate.info>
 */
public class TemplatingHelper {

  /**
   * The available templating engines.
   */
  public enum TemplatingEngine {
    FREEMARKER;
  }

  /**
   * Get the relevant implementation of TemplateEngine given the instance of the TemplatingHelper enum.
   * @param templatingEngine The representation of the desired engine.
   * @return The instance of the desired engine.
   */
  public static TemplateEngine getTemplateEngine(TemplatingEngine templatingEngine) {
    return getTemplateEngine(templatingEngine, null);
  }

  /**
   * Get the relevant implementation of TemplateEngine given the instance of the TemplatingHelper enum.
   * @param templatingEngine The representation of the desired engine.
   * @param templateRootDir The root path to look for template files.
   * @return The instance of the desired engine.
   */
  public static TemplateEngine getTemplateEngine(TemplatingEngine templatingEngine, String templateRootDir) {
    TemplateEngine toReturn;
    switch (templatingEngine) {
      case FREEMARKER:
        toReturn = new FreemarkerEngine(templateRootDir);
        break;
      default:
        toReturn = null;
    }
    return toReturn;
  }
}
