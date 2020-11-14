package com.ithillel;

import com.ithillel.config.AppConfig;
import com.ithillel.persistence.entity.AccountEntity;
import com.ithillel.persistence.entity.ClientCommonInfo;
import com.ithillel.persistence.entity.ClientEntity;
import com.ithillel.persistence.entity.ClientType;
import com.ithillel.persistence.entity.dao.ClientDao;
import com.ithillel.persistence.entity.service.AccountService;
import com.ithillel.service.PropertiesApplicationContext;
import com.ithillel.service.TextProcessor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {


    //private ApplicationContext applicationContext = new PropertiesApplicationContext();
    private TextProcessor textProcessor;

    public Application() {
        //textProcessor = (TextProcessor) applicationContext.getBean("textProcessor");
    }

    public void save(String key, final String text) {
        textProcessor.save(key, text);
    }

    public String getByKey(String key) {
       return textProcessor.getByKey(key);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/default-beans.xml");
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        /*ClientDao clientDao = applicationContext.getBean(ClientDao.class);
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFullname("test full name");
        clientEntity.setHaveAccess(true);
        clientEntity.setUpdateDate(System.currentTimeMillis());
        ClientCommonInfo clientCommonInfo = new ClientCommonInfo();
        clientCommonInfo.setClientType(ClientType.USER);
        clientCommonInfo.setDescription("sim[pldfddf");
        clientEntity.setClientCommonInfo(clientCommonInfo);
        clientDao.createClient(clientEntity);
        System.out.println(clientEntity.getId());
        System.out.println(clientEntity.getUpdateDate());*/
        ClientDao clientDao = applicationContext.getBean(ClientDao.class);

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFullname("test full name");
        clientEntity.setHaveAccess(true);
        clientEntity.setUpdateDate(System.currentTimeMillis());
        ClientCommonInfo clientCommonInfo = new ClientCommonInfo();
        clientCommonInfo.setClientType(ClientType.USER);
        clientCommonInfo.setDescription("sim[pldfddf");
        clientEntity.setClientCommonInfo(clientCommonInfo);

        AccountService accountService = applicationContext.getBean(AccountService.class);
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName("test name");
        accountEntity.getClients().add(clientEntity);
        accountService.create(accountEntity);
        System.out.println(accountEntity.getId());
        System.out.println(accountService.getById(accountEntity.getId()).getClients().size());

    }

}
