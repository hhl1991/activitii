/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.activiti.demo.resource;

import org.activiti.engine.ActivitiException;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Tijs Rademakers
 */
@RestController
@RequestMapping(value = "/service")
public class StencilsetRestResource {
  
  @RequestMapping(value="/editor/stencilset", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
  @ResponseBody
  public String getStencilset() {
    // 加载配置文件 stencilset.json
    InputStream stencilsetStream = this.getClass().getClassLoader().getResourceAsStream("stencilset.json");
    try {
      String str =IOUtils.toString(stencilsetStream, "utf-8");
      return str;
    } catch (Exception e) {
      throw new ActivitiException("Error while loading stencil set", e);
    }
  }
}
