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

import info.track_mate.templating.Template;

/**
 * Template implementation specific to the FreemarkerEngine.
 * @author Gareth Smith <gareth@track-mate.info>
 */
public class FreemarkerTemplate implements Template {

  private freemarker.template.Template template;

  public FreemarkerTemplate(freemarker.template.Template template) {
    this.template = template;
  }

  /**
   * @return the template
   */
  public freemarker.template.Template getTemplate() {
    return template;
  }

  /**
   * @param template the template to set
   */
  public void setTemplate(freemarker.template.Template template) {
    this.template = template;
  }
}
