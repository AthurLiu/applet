package Calculate.mode;
/**
 * 具体的运算方法
 * @author 13600
 *
 */
public class CalResultCount {
	public static String equalsCal(StringBuffer num11, StringBuffer num21,String oper) {
		double num1 = Double.parseDouble(num11.toString());
		double num2 = Double.parseDouble(num21.toString());	
		double result = 0;
		int result1 = 0;
		
		switch(oper) {
		case "+":			
			result = num1 + num2;
			break;
		case "-":			
			result = num1 - num2;
			break;
		case "*":			
			result = num1 * num2;
			break;
		case "/":			
			result = num1 / num2;
			break;
		case "%":			
			result = num1 % num2;
			break;
		case "x^n":			
			result = Math.pow(num1, num2);
			break;
		case "n√":			
			result = Math.pow(num1, 1.0/num2);
			break;
		default:
			return "运算符输入不正确！";
		}
		if (result %1 == 0) {
			result1 = (int)result;
			return String.valueOf(result1);
		}
		return String.valueOf(result);
	}
	/**
	 * 单个数值的计算
	 * @return
	 */
	public static String equalsOneNum(StringBuffer num11,String oper) {
		String num1 = num11.toString();
		double temp = Double.parseDouble(num1);
		double result = 0;	
		int result1 = 0;
		
		switch(oper) {
		case "1/x":			
			result = 1 / temp;
			break;
		case "x^2":			
			result = temp * temp;
			break;
		case "x^3":		
			result = Math.pow(temp, 3);		
			break;
		case "+/-":		
			result = -temp;	
			break;
		case "sin":		
			result = Math.sin(temp* Math.PI/180);
			break;
		case "cos":		
			result = Math.cos(temp * Math.PI/180);
			if (temp % 90 == 0) {
				result = 0;
				break;
			}
			break;
		case "tan":	
			if (temp % 90 != 0) {
				result = Math.tan(temp * Math.PI/180);
				break;
			}  else {
				return "不存在";
			}
		case "asin":		
			result = Math.asin(temp) * 180/Math.PI;	
			break;
		case "acos":	
			if (temp > 1) {
				return "不存在";
			}
			result = Math.cos(temp) * 180/Math.PI;	
			break;
		case "atan":		
			result = Math.atan(temp) * 180/Math.PI;
			break;
		case "ln":		
			result = Math.log(temp);
			break;
		case "√":		
			result = Math.sqrt(temp);
			break;
		case "3√":		
			result = Math.pow(temp, 1.0/3);
			break;
		case "!":				
			result = CalResultCount.jiecheng((int)temp);
			break;
		case "log":		
			result = Math.log10(temp);
			break;
		default:
			return "运算符输入不正确！";
		}
		if (result %1 == 0) {
			result1 = (int)result;
			return String.valueOf(result1);
		}
		return String.valueOf(result);
	}
	
	/**
	 * n!
	 */
	public static int jiecheng(int x) {
		if((x == 0) || (x == 1)) {
			return 1;
		} else {
			return x*jiecheng(x - 1);
		}
	}
}
