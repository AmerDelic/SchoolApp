# SchoolApp
A school management app -- student project


Konfigurisanje WildFly 23.0.2. servera

1) Napraviti 'management user' nalog na serveru kako bi mogli pristupiti server konzoli.
	- Unutar "WILDFLY_HOME/bin" pokrenuti "add-user.bat" i dodati novog management usera. 

2) Dodati MySql driver module:

	- Unutar "WILDFLY_HOME/modules/system/layers/base" kreirati "com/mysql/main" direktorij  
	- Unutar "main" foldera dodati 2 fajla, "module.xml" deskriptor i mysql .jar (ja sam koristio mysql-connector-java-8.0.25.jar)
		
		Ukoliko koristite istu verziju mysql drivera kao i ja, module.xml bi trebao izgledati ovako:
		
		<module xmlns="urn:jboss:module:1.5" name="com.mysql">
			<resources>
				<resource-root path="mysql-connector-java-8.0.25.jar" />
			</resources>
			<dependencies>
				<module name="javax.api"/>
				<module name="javax.transaction.api"/>
		</dependencies>
		</module>
		
3) Pokrenuti server i otvorit admin konzolu sa prethodno registrovanim management user nalogom.
	
	- pod Configuration -> Subsystems -> Datasource & Drivers -> JDBC Drivers -> kliknuti na '+' kako bi dodali driver
		
		U prozoru koji se otvori popuniti sljedece:
			Driver Name: mysql
			Driver Module Name: com.mysql
			Driver Class Name: com.mysql.cj.jdbc.Driver
			Driver Datasource Class Name: com.mysql.cj.jdbc.MysqlDataSource
			
			i klik na 'add'
			
	Sada bi u Datasource & Drivers -> JDBC Drivers trebao da bude i novi mysql driver.
	
4) Jos samo treba dodati i podesiti novi Datasource. 
	
	- pod Configuration -> Subsystems -> Datasource & Drivers -> Datasources, trenutno bi samo trebao biti default datasource po imenu 'ExampleDS'
		
		kliknuti '+', izabrat 'Add Datasource'
		
		u wizzardu izabrati i popuniti:
		
		1) TEMPLATE: 
			MySql
			
		2) ATTRIBUTES: 	
			Name: "SchoolAppDb" 
			JNDI Name: "java:/school" 
			
		3) JDBC DRIVER: 
			Driver Name: "mysql" 
			Driver Module Name: "com.myql" 
			Driver Class Name: "com.mysql.cj.jdbc.Driver"
		
		4) CONNECTION: 
			Connection URL: "jdbc:mysql://localhost:3306/school?useSSL=false"
			Username & password
			
		Nakon toga, konekcija ce biti testirana i novi Datasource po imenu 'SchoolAppDb' bi se trebao pojaviti ispod 'ExampleDS'
		
5) Potrebno je podesiti jos par stvari na samom Datasource-u.

	- Selektovati novi datasource i kliknuti 'View'
	
		Pod 'Atributes' tabom provjeriti da li su ispunjena polja za 'Datasource Class' i 'Driver Class'. 
		Pod 'Driver Class' bi trebalo da stoji "com.mysql.cj.jdbc.Driver", dok Datasource Class vjerovatno nece biti ispunjen, pa tu treba dodati "com.mysql.cj.jdbc.MysqlDataSource".
		
		Pod 'Connection' tabom provjeriti da li je URL "jdbc:mysql://localhost:3306/school?useSSL=false"
			- provjeriti da li je JTA = true
			- ovdje treba dodati jedan 'Connection property', naime "databaseName=school", samo klik na 'edit' i unijeti spomenuti property.
			
	To bi trebalo biti sve. Nakon sto restartujete server, otvorite njegov config file "standalone-full.xml" (wWILDFLY_HOME\standalone\configuration)
	i provjerite da li je novi datasource tu i konfigurisan kako treba.
	
	Unutar elementa <datasources> .. </datasources> trebao bi biti i sljedeci datasource, naravno sa vasim username i passwordom:
	
				<datasource jndi-name="java:/school" pool-name="SchoolAppDb" spy="true">
                    <connection-url>jdbc:mysql://localhost:3306/school?useSSL=false</connection-url>
                    <driver-class>com.mysql.cj.jdbc.Driver</driver-class>
                    <datasource-class>com.mysql.cj.jdbc.MysqlDataSource</datasource-class>
                    <connection-property name="databaseName">
                        school
                    </connection-property>
                    <driver>mysql</driver>
                    <security>
                        <user-name> ... </user-name>
                        <password> ... </password>
                    </security>
                    <validation>
                        <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"/>
                        <validate-on-match>true</validate-on-match>
                        <background-validation>false</background-validation>
                        <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter"/>
                    </validation>
                </datasource>

		
	
	
