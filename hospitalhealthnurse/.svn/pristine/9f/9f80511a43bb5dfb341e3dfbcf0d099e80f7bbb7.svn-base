package com.elink.hospitalhealthnurse.common.utils;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class RandomFileRenamePolicy implements FileRenamePolicy {
	public File rename(File file1) {		
		String fileSaveName = StringUtils.join(new String[] { IdGen.uuid(), ".",
				FilenameUtils.getExtension(file1.getName()) });
		File result = new File(file1.getParentFile(), fileSaveName);
		return result;
	}
}
