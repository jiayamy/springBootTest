/**
 * ClassName: NullDefaultValueProcessor
 * CopyRight: TalkWeb
 * Date: 13-1-14
 * Version: 1.0
 */
package com.servant.wiki.common.util;

import net.sf.json.JSONNull;
import net.sf.json.processors.DefaultValueProcessor;

/**
 * Description :
 *
 * @author : zhanglingzhi
 */
public class NullDefaultValueProcessor implements DefaultValueProcessor {
    @Override
    public Object getDefaultValue(Class aClass) {
        return JSONNull.getInstance();
    }
}
