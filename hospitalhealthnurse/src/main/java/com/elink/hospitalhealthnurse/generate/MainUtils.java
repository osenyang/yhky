package com.elink.hospitalhealthnurse.generate;

import com.elink.hospitalhealthnurse.common.utils.IdGen;

public class MainUtils {

	public static void main(String[] args) {
		for (int i = 0; i <4; i++) {
			System.out.println(IdGen.uuid());
		}
	}
	
}
