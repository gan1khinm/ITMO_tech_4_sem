package is.technologies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        /*
        BrandRepositoryHibernate repoHibernate = new BrandRepositoryHibernate();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++){
            BrandEntity entity = new BrandEntity();
            entity.setId(i);
            entity.setName("brand");
            entity.setDateOfFounding(new Date(0001, 01, 01));
            repoHibernate.save(entity);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Saving 100 entities Hibernate:");
        System.out.println(finish - start);

        start = System.currentTimeMillis();
        List<BrandEntity> entities = repoHibernate.getAll();
        finish = System.currentTimeMillis();
        System.out.println("Get all by Hibernate:");
        System.out.println(finish - start);
        System.out.println("\n");

        repoHibernate.deleteAll();

        start = System.currentTimeMillis();
        BrandRepositoryJDBC repoJDBC = new BrandRepositoryJDBC();
        for (int i = 0; i < 100; i++){
            BrandEntity entity = new BrandEntity();
            entity.setId(i);
            entity.setName("brand");
            entity.setDateOfFounding(new Date(0001, 01, 01));
            repoJDBC.save(entity);
        }
        finish = System.currentTimeMillis();
        System.out.println("Saving 100 entities by JDBC:");
        System.out.println(finish - start);

        start = System.currentTimeMillis();
        List<BrandEntity> entities1 = repoJDBC.getAll();
        finish = System.currentTimeMillis();
        System.out.println("Get all by JDBC:");
        System.out.println(finish - start);
        System.out.println("\n");

        repoJDBC.deleteAll();

        start = System.currentTimeMillis();
        BrandRepositoryMyBatis repoMyBatis = new BrandRepositoryMyBatis();
        for (int i = 0; i < 100; i++){
            BrandEntity entity = new BrandEntity();
            entity.setId(i);
            entity.setName("brand");
            entity.setDateOfFounding(new Date(0001, 01, 01));
            repoMyBatis.save(entity);
        }
        finish = System.currentTimeMillis();
        System.out.println("Saving 100 entities by MyBatis:");
        System.out.println(finish - start);

        start = System.currentTimeMillis();
        List<BrandEntity> entities2 = repoMyBatis.getAll();
        finish = System.currentTimeMillis();
        System.out.println("Get all by MyBatis:");
        System.out.println(finish - start);

        repoMyBatis.deleteAll();
        */

        /*
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/lab2", "postgres", "1234")
                .locations("classpath:db/migration")
                .load();
        flyway.baseline();
        flyway.migrate();
        */

        /*
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(4);
        brandEntity.setName("brand");
        brandEntity.setDateOfFounding(new Date(2002, 10, 21));

        ModelEntity modelEntity = new ModelEntity();
        modelEntity.setId(2);
        modelEntity.setName("model");
        modelEntity.setLength(2);
        modelEntity.setWidth(3);
        modelEntity.setBrand(brandEntity);
        modelEntity.setBodyType("седан");
        modelEntity.setHeight(2);

        EngineEntity engineEntity = new EngineEntity();
        engineEntity.setId(4);
        engineEntity.setName("dada");
        engineEntity.setVolume(5);
        engineEntity.setCylindersAmount(8);
        engineEntity.setHeight(1);
        engineEntity.setModel(modelEntity);

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        BrandRepositorySD brandRepositorySD = applicationContext.getBean("brandRepositorySD", BrandRepositorySD.class);
        ModelRepositorySD modelRepositorySD = applicationContext.getBean("modelRepositorySD", ModelRepositorySD.class);
        EngineRepositorySD engineRepositorySD = applicationContext.getBean("engineRepositorySD", EngineRepositorySD.class);
        //brandRepositorySD.save(brandEntity);
        //modelRepositorySD.save(modelEntity);
        //engineRepositorySD.save(engineEntity);

        brandRepositorySD.getAllByName(brandEntity.getName());

        modelRepositorySD.getAllByVId(brandEntity.getId());
        modelRepositorySD.getAllByName(modelEntity.getName());

        engineRepositorySD.getAllByVId(modelEntity.getId());
        engineRepositorySD.getAllByName(engineEntity.getName());
        */
        //AnnotationConfigApplicationContext applicationContext =
        //        new AnnotationConfigApplicationContext(SpringConfig.class);


        SpringApplication.run(Main.class, args);
    }
}