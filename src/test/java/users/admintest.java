package users;

import static org.junit.Assert.assertTrue;

import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;

import java.io.File;
import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class admintest {

    @Test
    public void testParallel() {
        Results results = Runner.path("classpath:some/package").tags("~@ignore").parallel(5);
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }
}





/*
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.jayway.jsonpath.Configuration;
import net.masterthought.cucumber.generators.OverviewReport;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class admintest {
    @Test
    void testParallel() {
        Results results = Runner.path("classpath:users")
                //.outputCucumberJson(true)
                .tags("@ignore").parallel(4);
        //4 scenarios al mismo tiempo
        generateReport(results.getReportDir());
    }

}
    /*public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[]{"json"}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("build"), "proy_karate1_2");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        //ReportBuilder.generateReport();
    }*/