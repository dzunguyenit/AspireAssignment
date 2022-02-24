package common;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

public class ManageEnviroment {
	@Sources({ "file:data/${env}.properties" })
	public interface Enviroment extends Config {

		String url();

		String username();

		String password();

		@Key("db.hostname")
		String getDBHostname();

		@Key("db.port")
		int getDBPort();

		@Key("db.username")
		String getDBUsername();

		@Key("db.password")
		String getDBPassword();
	}
}
