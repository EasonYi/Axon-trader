package org.axonframework.samples.trader.app.eventstore.mongo;

import com.mongodb.Mongo;
import com.mongodb.ServerAddress;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Jettro Coenradie
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/spring/persistence-infrastructure-context.xml"})
public class MongoFactoryTest {

    @Autowired
    private ApplicationContext context;

    @Ignore
    public void checkMongoFactory() {
        Mongo mongoDb = (Mongo) context.getBean("mongoDb");
        for (ServerAddress server : mongoDb.getAllAddress()) {
            System.out.println(server.getPort());
        }

    }

    @BeforeClass
    public static void checkProductionMongoFactory() {
        System.setProperty("test.context","true");
    }
}
