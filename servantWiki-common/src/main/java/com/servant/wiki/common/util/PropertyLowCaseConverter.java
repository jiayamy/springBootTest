/**
 * ClassName: PropertyLowCaseConverter
 * CopyRight: TalkWeb
 * Date: 12-12-3
 * Version: 1.0
 */
package com.servant.wiki.common.util;

import net.sf.json.processors.PropertyNameProcessor;

/**
 * Description : 属性名小写转换器
 * User : zhanglingzhi
 */
public class PropertyLowCaseConverter implements PropertyNameProcessor {

    @Override
    public String processPropertyName(Class aClass, String s) {
        return s.toLowerCase();
    }
}
