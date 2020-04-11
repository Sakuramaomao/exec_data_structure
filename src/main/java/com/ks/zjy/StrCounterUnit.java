package com.ks.zjy;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author zhujingya
 * @Date 2020/3/2 17:58
 */
public class StrCounterUnit {
    private static final Map<String, Integer> container = new HashMap<>();

    public static void main(String[] args) throws Exception {
        new StrCounterUnit().countLog(args[0], args[1], args[2]);
    }

    public void countLog(String srcFilePath, String tagFilePath, String moduleType) throws Exception {
        BufferedReader reader = readFile(srcFilePath);
        Map<String, Integer> resMap = count(reader, moduleType);
        writeCountResToFile(resMap, tagFilePath);
    }

    private void writeCountResToFile(Map<String, Integer> resMap, String tagFilePath) throws Exception {
        File tagFile = new File(tagFilePath);
        if (tagFile.exists()) {
            tagFile.delete();
            System.out.println("已删除旧的文件：" + tagFilePath);
        }

        FileWriter fw = new FileWriter(tagFilePath, true);
        try {
            String line = System.getProperty("line.separator");
            StringBuffer str = new StringBuffer();
            Set set = resMap.entrySet();
            Iterator iter = set.iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                str.append(entry.getKey() + " : " + entry.getValue()).append(line);
            }
            fw.write(str.toString());
            fw.close();
            System.out.println("统计结果写入完成。" + tagFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fw.close();
        }
    }

    private Map<String, Integer> count(BufferedReader reader, String moduleType) throws IOException {
        String line;
        long startTime = System.currentTimeMillis();
        System.out.println("开始统计...");
        if ("pc".equals(moduleType)) {
            while ((line = reader.readLine()) != null) {
                String[] strs = line.split("\t");
                if (strs.length > 1) {
                    addUp(strs[18]);
                } else {
                    System.out.println("非法line：" + line);
                }
            }
        } else {
            while ((line = reader.readLine()) != null) {
                String[] strs = line.split("\"_did\":\"");
                if (strs.length > 1) {
                    addUp(strs[1].substring(0, 32));
                } else {
                    System.out.println("非法line：" + line);
                }
            }
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("统计结束。 耗时：" + (endTime - startTime) + "ms");
        System.out.println("统计的总行数为：" + container.size());
        return container;
    }

    private void addUp(String key) {
        if (container.containsKey(key)) {
            Integer val = container.get(key);
            container.put(key, val + 1);
        } else {
            container.put(key, 1);
        }
    }

    private BufferedReader readFile(String srcFileName) throws Exception {
        BufferedReader bfReader;
        File srcFile = new File(srcFileName);
        if (srcFile.isFile() && srcFile.exists()) {
            FileReader fileReader = new FileReader(srcFileName);
            bfReader = new BufferedReader(fileReader);
        } else {
            throw new Exception("待处理的src文件不存在, srcFileName:" + srcFileName);
        }
        return bfReader;
    }
}
