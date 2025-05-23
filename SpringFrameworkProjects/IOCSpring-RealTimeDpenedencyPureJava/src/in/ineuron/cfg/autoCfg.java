package in.ineuron.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource(value="in/ineuron/commons/application.properties")
@ComponentScan(value ="in.ineuron")
public class autoCfg {
	
    public autoCfg() {
		System.out.println("This is autoCfg class");
	}
	@Autowired
	private Environment environment;
	@Bean(name = "datasource")
	public DataSource getDataSource() {
		System.out.println("Implementation class name of Environment is :: "+environment.getClass().getName());
		HikariDataSource dataSource=new HikariDataSource();
		dataSource.setDriverClassName(environment.getProperty("dao.info.driverClassName"));
		dataSource.setUsername(environment.getProperty("dao.info.username"));
		dataSource.setPassword(environment.getProperty("dao.info.password"));
		dataSource.setJdbcUrl(environment.getProperty("dao.info.jdbcUrl"));
		dataSource.setMinimumIdle(Integer.parseInt(environment.getProperty("dao.info.minidle")));
		dataSource.setMaximumPoolSize(Integer.parseInt(environment.getProperty("dao.info.maxpoolsize")));
		dataSource.setConnectionTimeout(Integer.parseInt(environment.getProperty("dao.info.connectiontimeout")));
		return dataSource;
	}
}
