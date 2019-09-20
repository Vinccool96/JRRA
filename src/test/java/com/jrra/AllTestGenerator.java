package com.jrra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AllTestGenerator {

    private static final String DIRECTORY = ".\\src\\test\\java\\com\\jrra";
    private static final String BLANK = "";
    private static final String PKG_STR = "package com.jrra;";
    private static final String[] J_UNIT_IMPORTS = {"import org.junit.runner.RunWith;",
            "import org.junit.runners.Suite;", "import org.junit.runners.Suite.SuiteClasses;"};
    private static final String RUN_STR = "@RunWith(Suite.class)";
    private static final String CLASS = ".class";
    private static final String[] CLASS_STR = {"public class AllTests {", "", "}"};
    private static final ArrayList<String> EXTENSIONS = new ArrayList<String>() {{
        add(".java");
        add(".kt");
    }};

    public static void main(String[] args) {
        File directory = new File("./src/test/java/com/jrra");
        System.out.println(directory);
        deleteAllTests();
        writeAllTests(directory);
        System.out.println(directory);
    }

    private static void packages(ArrayList<File> packages, File directory) {
        if (!directory.toString().equals(DIRECTORY) && hasFiles(directory)) {
            packages.add(directory);
        }
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                packages(packages, file);
            }
        }
    }

    private static boolean hasFiles(File directory) {
        boolean result = false;
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static ArrayList<File> classFiles(ArrayList<File> packages) {
        ArrayList<File> classFiles = new ArrayList<>();
        for (File directory : packages) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    if (isTestFile(file)) {
                        classFiles.add(file);
                    }
                }
            }
        }
        return classFiles;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void deleteAllTests() {
        File allTests = new File("./src/test/java/com/jrra/AllTests.java");
        allTests.delete();
    }

    private static void writeAllTests(File directory) {
        ArrayList<File> packages = new ArrayList<>();
        packages(packages, directory);
        ArrayList<File> classFiles = classFiles(packages);
        ArrayList<String> importStrings = importStrings(classFiles);
        ArrayList<String> suiteClassesStrings = suiteClassesStrings(classFiles);
        String suiteString = suiteString(suiteClassesStrings);

        File allTests = createAllTests();
        PrintWriter allTestsWriter = createAllTestsWriter(allTests);
        allTestsWriter.println(PKG_STR);
        allTestsWriter.println(BLANK);
        for (String importString : importStrings) {
            allTestsWriter.println(importString);
        }
        allTestsWriter.println(BLANK);
        for (String jUnitImport : J_UNIT_IMPORTS) {
            allTestsWriter.println(jUnitImport);
        }
        allTestsWriter.println(BLANK);
        allTestsWriter.println(RUN_STR);
        allTestsWriter.println(suiteString);
        for (String classStr : CLASS_STR) {
            allTestsWriter.println(classStr);
        }
        allTestsWriter.close();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static File createAllTests() {
        File allTests = new File("./src/test/java/com/jrra/AllTests.java");
        try {
            allTests.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allTests;
    }

    private static PrintWriter createAllTestsWriter(File allTests) {
        PrintWriter allTestsWriter = null;
        try {
            allTestsWriter = new PrintWriter(allTests);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return allTestsWriter;
    }

    private static ArrayList<String> importStrings(ArrayList<File> classFiles) {
        ArrayList<String> importStrings = new ArrayList<>();
        for (File classFile : classFiles) {
            String importString = "import " + classFileImportString(classFile) + ";";
            importStrings.add(importString);
        }
        return importStrings;
    }

    private static ArrayList<String> suiteClassesStrings(ArrayList<File> classFiles) {
        ArrayList<String> suiteClassesStrings = new ArrayList<>();
        for (File file : classFiles) {
            suiteClassesStrings.add(classString(file));
        }
        return suiteClassesStrings;
    }

    private static String classString(File file) {
        String str = file.getName();
        return StringUtil.INSTANCE.replaceAll(str, EXTENSIONS, CLASS);
    }

    private static String classFileImportString(File classFile) {
        String start = ".\\src\\test\\java\\";
        String str = StringUtil.INSTANCE.replaceAll(classFile.toString(), EXTENSIONS, BLANK);
        return str.replace(start, "").replace("\\", ".");
    }

    private static String suiteString(ArrayList<String> suiteClassesStrings) {
        StringBuilder suiteString = new StringBuilder("@SuiteClasses({");
        for (int index = 0; index < suiteClassesStrings.size(); index++) {
            suiteString.append(suiteClassesStrings.get(index));
            if (index != suiteClassesStrings.size() - 1) {
                suiteString.append(", ");
            }
        }
        suiteString.append("})");
        return suiteString.toString();
    }

    private static boolean isTestFile(File file) {
        boolean result = false;
        for (String extension : EXTENSIONS) {
            String suffix = "Test" + extension;
            if (file.getName().endsWith(suffix)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
