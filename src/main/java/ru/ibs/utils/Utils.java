package ru.ibs.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.ibs.utils.cmd.CmdCommandRunner;

import java.util.List;

import static ru.ibs.utils.cmd.CmdCommandRunner.isWindows;

public class Utils {
    private static final Logger LOG = LogManager.getLogger(Utils.class);

    public static String getQSPid() {
        String command;
        List<String> resultList;
        String qsPID;
        if (isWindows()) {
            qsPID = "нет команды для windows";
//            TODO:Написать реализацию для windows
        } else {
            command = "lsof -t -i:8080";
            resultList = CmdCommandRunner.runCommand(command);
            qsPID = resultList.get(resultList.size() - 1);
        }
        LOG.info("Получили PID процесса qualit-sandbox: " + qsPID);
        return qsPID;
    }
}