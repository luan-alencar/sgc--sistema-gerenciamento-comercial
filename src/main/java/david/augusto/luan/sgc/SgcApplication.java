package david.augusto.luan.sgc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ LiquibaseProperties.class })
@RequiredArgsConstructor
@Slf4j
@EntityScan(basePackages = {"david.augusto.luan.sgc"})
public class SgcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgcApplication.class, args);
    }

}
