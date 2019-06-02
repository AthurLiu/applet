package ClientView;

import java.io.File;

/**
 * 	由于页面采用的布局方式为null，所以各个控件的位置需要我们自己设定
 *  固定参数，不要随意改动
 * @author 幽竹
 * 
 */
public interface CardInitPos {	
	File FIlENAME = new File("picture");	
	
	//左边第一张牌的x位置
	int LX = 50;
	//右边第一张牌的x位置
	int RX = 880;
	//左、右边第一张牌的y位置
	int Y = 650;
	
	//下面第一张牌的x位置
	int BX = 750;
	//下面第一张牌的y位置
	int BY = 750;
	
	//发牌位置的x位置
	int FX = 500;
	//发牌位置的y位置
	int FY = 100;
	//出牌位置(下面)
	int CX_B = 500;
	//出牌位置左，右
	int CX_R = 700;
	int CY_R = 300;
	int CX_L = 200;
	int CY_L = 300;
	
	//发牌速度
	int SPEED = 5;
	
	//牌数
	int CARDNUM = 54;
	                
	//button的位置
	int QUXIAO_X = 350;
	int QUXIAO_Y = 670;
	int CHUPAI_X = 600;
	int CHUPAI_Y = 670;
	
	//窗口大小
	int MAIN_X = 1088;
	int MAIN_Y = 999;
	
	//头像位置
	int TL_X = 65;
	int TR_X = 895;
	int T_Y = 30;
}
