package com.elink.hospitalhealthnurse.common.log;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarConflictHandle {
	public static void main(String[] args) throws IOException {
		File file = new File("D:\\workspace_report\\oldhospital\\src\\main\\webapp\\WEB-INF\\lib");
		Map<String, HashSet<String>> jarMap = new HashMap<String, HashSet<String>>();
		if (null != file && file.exists() && file.isDirectory()) {
			File[] jarFile = file.listFiles();
			for (File f : jarFile) {
				if (f.isFile() && f.getName().endsWith(".jar")) {
					JarFile jar = new JarFile(f);
					Enumeration<JarEntry> enumJar = jar.entries();
					while (enumJar.hasMoreElements()) {
						JarEntry je = enumJar.nextElement();
						if (je.getName().endsWith(".class")) {
							if (jarMap.containsKey(je.getName())) {
								jarMap.get(je.getName()).add(f.getName());
							} else {
								HashSet<String> set = new HashSet<String>();
								set.add(f.getName());
								jarMap.put(je.getName(), set);
							}
						}
					}
				}
			}
		}

		Map<String,HashSet<String>> samMap = new HashMap<String, HashSet<String>>();		
		for (String s : jarMap.keySet()) {
			if (jarMap.get(s).size() > 1) { // 存在反复
				HashSet<String> hsfile = jarMap.get(s);
				String sfiles = "";
				for (String sf : hsfile) {
					sfiles = sfiles + sf + ",";
				}
				if (sfiles.length() > 1) {
					sfiles = sfiles.substring(0, sfiles.length() - 1);
				}
			
				if (samMap.containsKey(sfiles)) {
					samMap.get(sfiles).add(s);
				} else {
					HashSet<String> set = new HashSet<String>();
					set.add(s);
					samMap.put(sfiles, set);
				}
			}	
		}
		for (String s : samMap.keySet()) {
			if (samMap.get(s).size() > 1) { // 存在反复
				HashSet<String> hsfile = samMap.get(s);
				String sfiles = "";
				for (String sf : hsfile) {
					sfiles = sfiles + sf + ",";
				}
				System.out.println(s + "有反复类：" + sfiles);
			}
		}
	}

}
