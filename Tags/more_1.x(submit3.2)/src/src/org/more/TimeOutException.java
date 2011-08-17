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
package org.more;
/**
 * ��ʱ�쳣��
 * @version 2009-7-7
 * @author ������ (zyc@byshell.org)
 */
public class TimeOutException extends RuntimeException {
    /**  */
    private static final long serialVersionUID = 6489409968925378968L;
    /**
     * ��ʱ�쳣��
     * @param string �쳣��������Ϣ
     */
    public TimeOutException(String string) {
        super(string);
    }
    /**
     * ��ʱ�쳣��
     * @param error �쳣��������Ϣ
     */
    public TimeOutException(Throwable error) {
        super(error);
    }
    /**
     * ��ʱ�쳣��
     * @param string �쳣��������Ϣ��
     * @param error �нӵ���һ���쳣����
     */
    public TimeOutException(String string, Throwable error) {
        super(string, error);
    }
}