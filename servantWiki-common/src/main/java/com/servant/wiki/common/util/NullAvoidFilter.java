/**
 * ClassName: NullAvoidFilter
 * CopyRight: TalkWeb
 * Date: 13-1-15
 * Version: 1.0
 */
package com.servant.wiki.common.util;

import net.sf.json.util.PropertyFilter;

/**
 * Description :
 *
 * @author : zhanglingzhi
 */
public class NullAvoidFilter implements PropertyFilter {
    @Override
    public boolean apply(Object o, String s, Object o2) {
        return o2 == null;
    }
}
