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
package org.hasor.context.core;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.hasor.Hasor;
import org.hasor.context.Environment;
import org.hasor.context.EventManager;
import org.hasor.context.InitContext;
import org.hasor.context.Lifecycle;
import org.hasor.context.Settings;
import org.hasor.context.WorkSpace;
import org.hasor.context.environment.StandardEnvironment;
import org.hasor.context.event.StandardAdvancedEventManager;
import org.hasor.context.setting.HasorSettings;
import org.hasor.context.workspace.StandardWorkSpace;
import org.more.util.ClassUtils;
/**
 * {@link InitContext}接口实现类。
 * @version : 2013-4-9
 * @author 赵永春 (zyc@byshell.org)
 */
public class StandardInitContext implements InitContext {
    private long                startTime;   //系统启动时间
    private String              mainConfig;
    private String[]            spanPackage;
    private Settings            settings;
    private WorkSpace           workSpace;
    private Environment         environment;
    private EventManager        eventManager;
    private Map<String, Object> attributeMap;
    private Object              context;
    //
    public StandardInitContext() throws IOException {
        this("hasor-config.xml");
    }
    public StandardInitContext(String mainConfig) throws IOException {
        this.mainConfig = mainConfig;
        this.initContext();
    }
    /**初始化方法*/
    protected void initContext() throws IOException {
        this.startTime = System.currentTimeMillis();
        this.attributeMap = this.createAttributeMap();
        this.settings = this.createSettings();
        this.workSpace = this.createWorkSpace();
        this.environment = this.createEnvironment();
        this.eventManager = this.createEventManager();
        //
        String spanPackages = this.getSettings().getString("framework.loadPackages");
        this.spanPackage = spanPackages.split(",");
        Hasor.info("loadPackages : " + Hasor.logString(this.spanPackage));
        //
        ((Lifecycle) this.settings).start();
    }
    /**创建{@link Settings}接口对象*/
    protected Settings createSettings() throws IOException {
        return new HasorSettings(this.getMainConfig());
    }
    /**创建{@link WorkSpace}接口对象*/
    protected WorkSpace createWorkSpace() {
        return new StandardWorkSpace(this.getSettings());
    }
    /**创建{@link Environment}接口对象*/
    protected Environment createEnvironment() {
        return new StandardEnvironment(this.getWorkSpace());
    }
    /**创建{@link EventManager}接口对象*/
    protected EventManager createEventManager() {
        return new StandardAdvancedEventManager(this.getSettings());
    }
    /**创建属性容器*/
    protected Map<String, Object> createAttributeMap() {
        return new HashMap<String, Object>();
    }
    //
    @Override
    public long getAppStartTime() {
        return this.startTime;
    }
    public Object getContext() {
        return context;
    }
    /**获取主配置文件*/
    public String getMainConfig() {
        return mainConfig;
    }
    /**设置上下文*/
    public void setContext(Object context) {
        this.context = context;
    }
    @Override
    public Settings getSettings() {
        return this.settings;
    }
    @Override
    public WorkSpace getWorkSpace() {
        return this.workSpace;
    }
    @Override
    public Environment getEnvironment() {
        return this.environment;
    }
    @Override
    public EventManager getEventManager() {
        return this.eventManager;
    }
    /**获取属性接口*/
    public Map<String, Object> getAttributeMap() {
        return attributeMap;
    }
    @Override
    public Set<Class<?>> getClassSet(Class<?> featureType) {
        return ClassUtils.getClassSet(this.spanPackage, featureType);
    }
    @Override
    protected void finalize() throws Throwable {
        ((Lifecycle) this.settings).stop();
        super.finalize();
    }
}