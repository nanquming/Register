package com.entity;

public class STAFF {

			private String NUMBER;
			private String PASSWORD;
			private String DESK;
			private String SEX;
			private String MOBILE;
			
			public STAFF(String nUMBER, String pASSWORD, String dESK, String sEX, String mOBILE) {
				super();
				NUMBER = nUMBER;
				PASSWORD = pASSWORD;
				DESK = dESK;
				SEX = sEX;
				MOBILE = mOBILE;
			}

			public String getNUMBER() {
				return NUMBER;
			}

			public void setNUMBER(String nUMBER) {
				NUMBER = nUMBER;
			}

			public String getPASSWORD() {
				return PASSWORD;
			}

			public void setPASSWORD(String pASSWORD) {
				PASSWORD = pASSWORD;
			}

			public String getDESK() {
				return DESK;
			}

			public void setDESK(String dESK) {
				DESK = dESK;
			}

			public String getSEX() {
				return SEX;
			}

			public void setSEX(String sEX) {
				SEX = sEX;
			}

			public String getMOBILE() {
				return MOBILE;
			}

			public void setMOBILE(String mOBILE) {
				MOBILE = mOBILE;
			}
			
}
