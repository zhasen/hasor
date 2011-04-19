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
package org.more.hypha.define.aop;
import org.more.core.classcode.AopBeforeListener;
import org.more.core.classcode.AopReturningListener;
import org.more.core.classcode.AopThrowingListener;
import org.more.core.classcode.AopInvokeFilter;
/**
 * aop���涨�����͡�
 * @version 2010-9-27
 * @author ������ (zyc@byshell.org)
 */
public enum PointcutType {
    /**����beanʵ�ֵĽӿ��Զ�ѡ�������ͣ����ȼ�ΪFilter��Before��Returning��Throwing*/
    Auto,
    /**bean����ʵ����{@link AopBeforeListener}�ӿڣ���������Ϊmethod���ò��ܱ�ʶ��ΪBefore���͡�*/
    Before,
    /**bean����ʵ����{@link AopReturningListener}�ӿڣ���������Ϊmethod���ò��ܱ�ʶ��ΪReturning���͡�*/
    Returning,
    /**bean����ʵ����{@link AopThrowingListener}�ӿڣ���������Ϊmethod���ò��ܱ�ʶ��ΪThrowing���͡�*/
    Throwing,
    /**bean����ʵ����{@link AopInvokeFilter}�ӿڲ��ܱ�ʶ��ΪFilter���͡�*/
    Filter
}