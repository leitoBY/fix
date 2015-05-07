# fix
fixed mix

there's test project (spring MVC+Hibernate) to manage departments and workers in small company. Using web interface you can: -add new departments and workers -edit or delete existing ones -control average department salary

to build project:
mvn clean install

to deploy on Tomcat server:
copy fix-service.jar and fix-service.war to :\Tomcat {version}\webapps\

after running server u can test application at http://localhost:8080/fix-webapp/
