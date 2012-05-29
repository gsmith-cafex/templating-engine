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

import java.util.Map;

/**
 * Interface that all templating engines should implement.
 * @author Gareth Smith <gareth@track-mate.info>
 */
public interface TemplateEngine {

  Template getTemplate(String templateFileName) throws Exception;

  String processTemplate(Template template, Map<String, Object> parameters) throws Exception;
}
