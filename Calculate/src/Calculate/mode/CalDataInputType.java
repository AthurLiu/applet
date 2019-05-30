package Calculate.mode;

/**
 * 运算牵扯到的各种规则
 * @author 13600
 *
 */
public class CalDataInputType {
	//计算类型,默认为0
	//calType为1表示Text框为空,为2表示已经存在一个数再输入数字
	//为3表示第一个数字输完，可以输运算符了,为4表示运算符输入结束，可以进行第二个数值的输入了
	//为5表示第二个数值输入完毕，开始进行整个表达式的结果计算,为6表示在计算结果的基础上面再进行运算符计算
	//7表示按完=号再按等号   8表示进行一个数值的运算后，再输入数值进行各种运算
	private String calType = "1";
	//机制转换标志符,2为2进制，8为8进制，10为10进制，16为16进制
	private String changeType = "10";
	//输入的用于计算的第一个数
	private StringBuffer strNum1 = new StringBuffer();
	//输入用于计算的运算符
	private String strOper = "";
	//输入的用于计算的第二个数
	private StringBuffer strNum2 = new StringBuffer();
	//计算结果
	private String result = "";
	//两个整数，小数输入的标志,一个整数只能输入一个小数点
	private boolean flag1 = true;
	private boolean flag2 = true;
	
	public String getCalType() {
		return calType;
	}

	public void setCalType(String calType) {
		this.calType = calType;
	}	
	//得到当前进制类型
	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}	
	//得到运算结果
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 参与运算的数值的录入
	 * @param i
	 * @return
	 */
	public String jTextNumInput(String i) {
		String str = "";
		if((calType.equals("1") || calType.equals("2") && !strOper.equals(""))) {
			str = strOper + String.valueOf(strNum1.append(i));
		} else if (calType.equals("1") || calType.equals("2")){
			str = String.valueOf(strNum1.append(i));
		} else if (calType == "4") {
			strNum2.append(i);
			str = strNum1 + strOper +strNum2;
		} 
		return str;
	}
	
	/**
	 * 参与运算的运算符的录入--------类型<a运算符b>
	 * @param i
	 * @return
	 */
	public String jTextOperInput(String i) {
		String str = "";
		if (calType == "3") {
			strOper =  i;
			str = strNum1 + i;
		} else if (calType == "4") {
			result = CalResultCount.equalsCal(strNum1,strNum2,strOper);
			str = result + strOper;
			strNum1.replace(0, strNum1.length(), result);
			strNum2.delete(0, strNum2.length());
			strOper = i;
		}else {
			strNum1.replace(0, strNum1.length(), result);
			strOper =  i;
			str = strNum1 + i;
			strNum2.delete(0, strNum2.length());
			flag1 = true;
			flag2 = true;
		}
		return str;
	}
	
	/**
	 * 计算结果
	 * @param i
	 * @return
	 */
	public String equalsInput(String i) {	
		String str = "";
		if (calType.equals("5")) {
			result = CalResultCount.equalsCal(strNum1,strNum2,strOper);
			str = strNum1 + strOper + strNum2 + i + result;
		} else if (calType.equals("2") && !strOper.equals("")) {
			result = CalResultCount.equalsOneNum(strNum1, strOper);
			str = strOper + strNum1 + "=" + result;
			clear();
		} else if (calType.equals("7")){
			strNum1.replace(0, strNum1.length(), result);
			result = CalResultCount.equalsCal(strNum1,strNum2,strOper);
			str = strNum1 + strOper + strNum2 + i + result;
		}
		return str;
	}
	

	/**
	 *   参与运算的运算符的录入--------类型<a运算符>
	 * @param i
	 * @return
	 */
	public String equalsInput2(String i) {	
		String str = "";
		strOper = i;
		if (calType == "8") {
			result = CalResultCount.equalsOneNum(strNum1, strOper);
			str = result;
			strNum1.replace(0, strNum1.length(), result);
		} else {
			strNum1.replace(0, strNum1.length(), result);
			result = CalResultCount.equalsOneNum(strNum1, strOper);
			str = result;
			strNum1.replace(0, strNum1.length(), result);
		}
		return str;
	}
	
	/**
	 * 参与运算的运算符的录入--------类型<运算符a>
	 * @param i
	 * @return
	 */
	public String equalsInput1(String i) {	
		String str = "";
		if (calType == "1") {
			strOper = i;
			str = strOper;
		} 
		return str;
	}
	
	 /* 小数的输入
	 * @param i
	 * @return
	 */
	public String pointInput(String i) {
		String str = "";
		if (calType.equals("2") && flag1 == true && !strOper.equals("")) {
			strNum1.append(i);
			flag1 = false;
			str = strOper + strNum1;
		} else if ((calType == "2") && (flag1 == true)) {
			strNum1.append(i);
			flag1 = false;
			str = strNum1.toString();
		} else if ((calType == "4") && (flag2 == true)){
			strNum2.append(i);
			flag2 = false;
			str = strNum1 + strOper + strNum2;
		} else {
			if(calType == "2")
				str = strNum1.toString();
			else
				str = strNum1 + strOper + strNum2;
		}
		return str;
	}
	
	/**
	 * 清零
	 */
	public String clear(){
		calType = "1";
		//输入的用于计算的第一个数
		strNum1 = new StringBuffer();
		//输入用于计算的运算符
		strOper = "";
		//输入的用于计算的第二个数
		strNum2 = new StringBuffer();
		flag1 = true;
		flag2 = true;
		return "";
	}
	
	/**
	 * 按位删除
	 * @return
	 */
	public String del(){
		String str = "";
		if((calType == "2")&&(strNum1.length() != 0)){
			strNum1.delete(strNum1.length()-1, strNum1.length());
			str = strNum1.toString();
		} else if ((calType == "3")&&(strOper != "")) {
			strOper = "";
			calType = "2";
			str = strNum1.toString();
		} else if(calType == "4"){
			if(strNum2.length() != 0) {
				strNum2.delete(strNum2.length()-1, strNum2.length());
				str = strNum1 + strOper + strNum2;
				if (strNum2.length() == 0){
					calType = "3";
				}
			}			
		}
		return str;
	}
	
	/**
	 *   进制之间的转换
	 * @param i
	 * @return
	 */
	public String changeType(String i) {
		String str = "请输入正整数";
		String reg = "^[0-9]*$";
		if(strNum1.toString().matches(reg) || changeType.equals("16")) {
			if(i.equals("2") && changeType.equals("10")) {
				str = Integer.toBinaryString(Integer.parseInt(strNum1.toString()));
				strNum1.replace(0, strNum1.length(), str);
				changeType = "2";
		    } else if(i.equals("2") && changeType.equals("16")) {
		    	str = Integer.valueOf(strNum1.toString(), 16).toString();
		    	strNum1.replace(0, strNum1.length(), str);
				str = Integer.toBinaryString(Integer.parseInt(strNum1.toString()));
				strNum1.replace(0, strNum1.length(), str);
				changeType = "2";
		    } else if(i.equals("2") && changeType.equals("8")) {
		    	str = Integer.valueOf(strNum1.toString(), 8).toString();
		    	strNum1.replace(0, strNum1.length(), str);
				str = Integer.toBinaryString(Integer.parseInt(strNum1.toString()));
				strNum1.replace(0, strNum1.length(), str);
				changeType = "2";
		    } else if(i.equals("10") && changeType.equals("2"))	{
		    	str = Integer.valueOf(strNum1.toString(), 2).toString();
		    	strNum1.replace(0, strNum1.length(), str);
		    	changeType = "10";
		    } else if(i.equals("10") && changeType.equals("8"))	{
		    	str = Integer.valueOf(strNum1.toString(), 8).toString();
		    	strNum1.replace(0, strNum1.length(), str);
		    	changeType = "10";
		    } else if(i.equals("10") && changeType.equals("16"))	{
		    	str = Integer.valueOf(strNum1.toString(), 16).toString();
		    	strNum1.replace(0, strNum1.length(), str);
		    	changeType = "10";
		    } else if(i.equals("8") && changeType.equals("2"))	{
		    	str = Integer.valueOf(strNum1.toString(), 2).toString();
		    	strNum1.replace(0, strNum1.length(), str);
		    	str = Integer.toOctalString(Integer.parseInt(strNum1.toString()));
		    	strNum1.replace(0, strNum1.length(), str);
		    	changeType = "8";
		    } else if(i.equals("8") && changeType.equals("10"))	{
		    	str = Integer.toOctalString(Integer.parseInt(strNum1.toString()));
		    	strNum1.replace(0, strNum1.length(), str);
		    	changeType = "8";
		    } else if(i.equals("8") && changeType.equals("16"))	{
		    	str = Integer.valueOf(strNum1.toString(), 16).toString();
		    	strNum1.replace(0, strNum1.length(), str);
		    	str = Integer.toOctalString(Integer.parseInt(strNum1.toString()));
		    	strNum1.replace(0, strNum1.length(), str);
		    	changeType = "8";
		    } else if(i.equals("16") && changeType.equals("2"))	{
		    	str = Integer.valueOf(strNum1.toString(), 2).toString();
		    	strNum1.replace(0, strNum1.length(), str);
		    	str = Integer.toHexString(Integer.parseInt(strNum1.toString()));
		    	strNum1.replace(0, strNum1.length(), str);
		    	changeType = "16";
		    } else if(i.equals("16") && changeType.equals("10"))	{
		    	str = Integer.toHexString(Integer.parseInt(strNum1.toString()));
		    	strNum1.replace(0, strNum1.length(), str);
		    	changeType = "16";
		    } else if(i.equals("16") && changeType.equals("8"))	{
		    	str = Integer.valueOf(strNum1.toString(), 8).toString();
		    	strNum1.replace(0, strNum1.length(), str);
		    	str = Integer.toHexString(Integer.parseInt(strNum1.toString()));
		    	strNum1.replace(0, strNum1.length(), str);
		    	changeType = "16";
		    } 						
		}
		return str;
	}
}
