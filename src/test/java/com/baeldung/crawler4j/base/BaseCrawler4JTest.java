package com.baeldung.crawler4j.base;

import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.baeldung.common.config.CommonConfig;
import com.baeldung.common.config.MyApplicationContextInitializer;
import com.baeldung.crawler4j.config.CrawlerMainCofig;
import com.baeldung.crawler4j.controller.TutorialsRepoCrawlerController;

@ContextConfiguration(classes = { CommonConfig.class, CrawlerMainCofig.class }, initializers = MyApplicationContextInitializer.class)
@ExtendWith(SpringExtension.class)
public class BaseCrawler4JTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());        
    
    @Autowired
    protected TutorialsRepoCrawlerController tutorialsRepoCrawlerController;    

}
