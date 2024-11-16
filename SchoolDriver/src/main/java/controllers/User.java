package controllers;

public class User {
	
			private int ID;
			private String FIRST_NAME;
			private String LAST_NAME;
			private int AGE;
			private String ADRESS;
			private String NUMBER;
			private String MAIL_ADRESS;
			private String LOGIN;
			private String PASSWORD;
			
			public User() {}
			public User( String FIRST_NAME, String LAST_NAME,int AGE, String ADRESS, String NUMBER, String MAIL_ADRESS,String LOGIN,String PASSWORD) {
				super();
				
				this.FIRST_NAME = FIRST_NAME;
				this.LAST_NAME = LAST_NAME;
				this.AGE = AGE;
				this.ADRESS=ADRESS;
				this.NUMBER=NUMBER;
				this.MAIL_ADRESS=MAIL_ADRESS;
				this.LOGIN=LOGIN;
				this.PASSWORD=PASSWORD;
			}
			public User(int AGE, String ADRESS, String NUMBER, String MAIL_ADRESS,String PASSWORD) {
				super();
				
			
				this.AGE = AGE;
				this.ADRESS=ADRESS;
				this.NUMBER=NUMBER;
				this.MAIL_ADRESS=MAIL_ADRESS;
				
				this.PASSWORD=PASSWORD;
			}


			public int getID() {
				return ID;
			}


		


			public String getFIRST_NAME() {
				return FIRST_NAME;
			}


			public void setFIRST_NAME(String fIRST_NAME) {
				FIRST_NAME = fIRST_NAME;
			}


			public String getLAST_NAME() {
				return LAST_NAME;
			}


			public void setLAST_NAME(String lAST_NAME) {
				LAST_NAME = lAST_NAME;
			}


			public int getAGE() {
				return AGE;
			}


			public void setAGE(int aGE) {
				AGE = aGE;
			}


			public String getADRESS() {
				return ADRESS;
			}


			public void setADRESS(String aDRESS) {
				ADRESS = aDRESS;
			}

			public void setId(int ID) {
				this.ID=ID;
			}
			public String getNUMBER() {
				return NUMBER;
			}


			public void setNUMBER(String nUMBER) {
				NUMBER = nUMBER;
			}


			public String getMAIL_ADRESS() {
				return MAIL_ADRESS;
			}


			public void setMAIL_ADRESS(String mAIL_ADRESS) {
				MAIL_ADRESS = mAIL_ADRESS;
			}


			public String getLOGIN() {
				return LOGIN;
			}


			public void setLOGIN(String lOGIN) {
				LOGIN = lOGIN;
			}


			public String getPASSWORD() {
				return PASSWORD;
			}


			public void setPASSWORD(String pASSWORD) {
				PASSWORD = pASSWORD;
			}

}
