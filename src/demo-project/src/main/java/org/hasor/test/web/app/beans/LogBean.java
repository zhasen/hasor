package org.hasor.test.web.app.beans;
import java.io.IOException;
import net.hasor.core.context.AnnoAppContext;
import net.hasor.core.gift.bean.Bean;
import org.hasor.test.web.plugin.log.OutLog;
/**
 * 
 * @version : 2013-7-25
 * @author ������ (zyc@hasor.net)
 */
@Bean("LogBean")
public class LogBean {
    @OutLog
    public void print() {
        System.out.println("�ڴ�֮ǰ�����־!");
    }
    //
    //
    public static void main(String[] args) throws IOException {
        AnnoAppContext aac = new AnnoAppContext();
        aac.start();
        //
        LogBean logBean = (LogBean) aac.getBean("LogBean");
        logBean.print();
        //
    }
}