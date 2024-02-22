echo "Welcome to Batch Execution"
cd D:\SynechronBDD_19_02_2024\BDD_EclipseWS\CucumberTraining
d:
set path=%path%
set classpath=D:\SynechronBDD_19_02_2024\BDD_EclipseWS\CucumberTraining\target\*;.
mvn test -Dcucumber.filter.tags="@regression and @formy"