package za.ac.cput;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@Slf4j
@SpringBootApplication
public class GraduateRecruitmentPortalAPI {

    private static File appDirectory = null;

    public static String getAppDirectory()
    {
        return appDirectory.getAbsolutePath();
    }

    public static String getUserDirectory(Long username)
    {
        return getAppDirectory() + "users" + "//" + username;
    }

    public static String getUserDocumentsDirectory(Long username)
    {
        return getUserDirectory(username) + "documents" + "//";
    }

    public static void main(String[] args)
    {
        createAppDirectory();
        SpringApplication.run(GraduateRecruitmentPortalAPI.class, args);
    }


    private static void createAppDirectory()
    {
        try{
            appDirectory = new File(System.getenv("APPDATA")
                    + "\\" + "Graduate " + "Recruitment Portal" + "\\");

            if(!appDirectory.exists())
            {
                if (((appDirectory.mkdirs())))
                {
                    log.info("App Directory Creation:{}", appDirectory);
                } else
                {
                    log.error("App Directory Creation:{}", appDirectory);
                }
            }
        }catch (Exception exception)
        {
            log.info("App Directory Creation:{}", exception);
        }

    }

}
