package com.test.web3labs;

import java.util.*;

public class SaddamTask {

    private static final String CD_COMMAND_START_WITH = "cd ";
    private static final String SLASH = "/";
    private static final String REVERSE_DIR = "..";
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";


    public static String changeDirectoryString(String currentDirectory, String command) {
        if (Objects.isNull(currentDirectory) || currentDirectory.isEmpty()
                || Objects.isNull(command) || command.isEmpty())
            throw new IllegalArgumentException();
        if (!currentDirectory.startsWith(SLASH) || !command.startsWith(CD_COMMAND_START_WITH))
            throw new IllegalStateException();

        Deque<String> resultDir = new LinkedList<>();
        String[] currentDirSplit = currentDirectory.split(SLASH);
        int currentForwardCounter = 0;
        String operationDir = command.replaceFirst(CD_COMMAND_START_WITH, "");
        String[] commandOperationDirSplit = operationDir.split(SLASH);
        if (operationDir.startsWith(SLASH)) {
            resultDir.addFirst(commandOperationDirSplit.length == 0 ? "" : commandOperationDirSplit[0]);
        } else {
            Arrays.stream(currentDirSplit, 0, currentDirSplit.length).forEach(
                    resultDir::addLast);
        }
        for (String newDir : commandOperationDirSplit) {
            if (newDir.equals(REVERSE_DIR)) {
                resultDir.removeLast();
                if (currentForwardCounter >= 0) {
                    currentForwardCounter--;
                } else {
                    break;
                }
            } else {
                resultDir.addLast(newDir);
                currentForwardCounter++;
            }
        }
        resultDir.removeAll(Arrays.asList(EMPTY_STRING, SPACE));
        StringBuilder resultantPath = new StringBuilder();
        resultDir.forEach(v -> resultantPath.append("/").append(v));
        return resultDir.isEmpty() ? SLASH : resultantPath.toString();
    }

    public static void main(String[] args) {
        System.out.println(changeDirectoryString("/dev/test", "cd /etc/ejhge/dgdk"));



























    }
}
