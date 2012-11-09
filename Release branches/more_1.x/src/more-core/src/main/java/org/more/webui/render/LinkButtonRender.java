/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
package org.more.webui.render;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import org.more.webui.component.UIButton;
import org.more.webui.context.ViewContext;
import org.more.webui.render.support.AbstractRender;
import org.more.webui.tag.TemplateBody;
import freemarker.template.TemplateException;
/**
 * ����ť�齨��Ⱦ��a��ǩ��
 * <br><b>�ͻ���ģ��</b>��UILinkButton��UILinkButton.js��
 * @version : 2012-5-18
 * @author ������ (zyc@byshell.org)
 */
public class LinkButtonRender<T extends UIButton> extends AbstractRender<T> {
    @Override
    public String getClientType() {
        return "UILinkButton";
    }
    @Override
    public String tagName(ViewContext viewContext, T component) {
        return "a";
    }
    @Override
    public Map<String, Object> tagAttributes(ViewContext viewContext, T component) {
        //----���Ƕ��������
        Map<String, Object> hashMap = super.tagAttributes(viewContext, component);
        if (hashMap.containsKey("onclick") == false)
            hashMap.put("href", "javascript:void(0);");//writer.write("<a href='javascript:void(0);'");
        else
            hashMap.put("href", "#");//writer.write("<a href='javascript:void(0);'");
        return hashMap;
    }
    @Override
    public void render(ViewContext viewContext, T component, TemplateBody arg3, Writer writer) throws IOException, TemplateException {
        Object val = component.getValue();
        if (val != null)
            writer.write(String.valueOf(val));
        if (arg3 != null)
            arg3.render(writer);
    }
}