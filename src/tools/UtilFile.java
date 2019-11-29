package tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UtilFile {

    public static void replaceFileAline(File file, String oldLine, String newLine) {
        String fileConte = getFileContent(file);
        if (fileConte != null) {
            fileConte = fileConte.replaceAll(oldLine, newLine);
            writeStringToFile(file, fileConte);
        }
    }

    public static void replaceFileLines(File file, String[] oldLine, String[] newLine) {
        String fileConte = getFileContent(file);
        if (fileConte != null) {
            for (int i = 0; i < oldLine.length; i++) {
                if (!fileConte.contains(newLine[i]))
                    fileConte = fileConte.replace(oldLine[i], oldLine[i] + "\n\n" + newLine[i]);
            }
            writeStringToFile(file, fileConte);
        }
    }

    public static List<String> getContainStringLine(File file, String containString) {
        List<String> resultList = new ArrayList<>();
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String aLine = "";
            while ((aLine = bufferedReader.readLine()) != null) {
                if (aLine.contains(containString)) {
                    resultList.add(aLine);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    if (bufferedReader != null) {
                        bufferedReader = null;
                    }
                }
            }

            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    if (inputStreamReader != null) {
                        inputStreamReader = null;
                    }
                }
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    if (fileInputStream != null) {
                        fileInputStream = null;
                    }
                }
            }
        }
        return resultList;
    }

    public static String getFileContent(File file) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String aLine = "";
            while ((aLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(aLine + "\n");
            }
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    if (bufferedReader != null) {
                        bufferedReader = null;
                    }
                }
            }

            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    if (inputStreamReader != null) {
                        inputStreamReader = null;
                    }
                }
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    if (fileInputStream != null) {
                        fileInputStream = null;
                    }
                }
            }
        }
        return null;
    }

    public static void writeStringToFile(File file, String content) {
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileOutputStream = new FileOutputStream(file, false);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(content);
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    if (bufferedWriter != null) {
                        bufferedWriter = null;
                    }
                }
            }

            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    if (outputStreamWriter != null) {
                        outputStreamWriter = null;
                    }
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    if (fileOutputStream != null) {
                        fileOutputStream = null;
                    }
                }
            }
        }
    }

    public static void appendStringToFile(File file, String appendContent) {
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileOutputStream = new FileOutputStream(file, true);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(appendContent);
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    if (bufferedWriter != null) {
                        bufferedWriter = null;
                    }
                }
            }

            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    if (outputStreamWriter != null) {
                        outputStreamWriter = null;
                    }
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    if (fileOutputStream != null) {
                        fileOutputStream = null;
                    }
                }
            }
        }

    }

    public static List<String> getFileContentList(File file) {
        List<String> result = new ArrayList<>();
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String aLine = "";
            while ((aLine = bufferedReader.readLine()) != null) {
                if (!"".equals(aLine.trim()))
                    result.add(aLine);
            }
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    if (bufferedReader != null) {
                        bufferedReader = null;
                    }
                }
            }

            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    if (inputStreamReader != null) {
                        inputStreamReader = null;
                    }
                }
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    if (fileInputStream != null) {
                        fileInputStream = null;
                    }
                }
            }
        }
        return null;
    }


}
