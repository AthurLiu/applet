<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>京东（JD.COM）-正品低价、品质保障、配送及时、轻松购物</title>
        <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
        <link rel="stylesheet" href="../css/jd_home.css?v=<%=System.currentTimeMillis()%>">
        <link rel="shortcut icon" type="image/x-icon" href="../picture/jd_logo.ico" />
    	<script src="../js/jd_home.js?v=<%=System.currentTimeMillis()%>" type="text/javascript"></script>
    </head>
    <body>
        <div class="head" id="head">
            <div>
                <div id="local" title="江苏" onmouseover="show_loc('loc')"  onmouseout="hide_loc('loc')">&nbsp;&nbsp;江苏&nbsp;&nbsp;</div>
                <a class="username" href="#">
                	你好，<%=session.getAttribute("user").toString()%>
                </a>
                <a class="exitlogin">退出登录</a>
                <form action="../login.do?method=order" method="post" class="orderCar">
                	<input type="submit" value="|  我的订单 |">
                </form>
                <select name="" id="">
                    <option value="">我的京东</option>
                    <option value="">消息</option>
                    <option value="">待处理订单</option>
                    <option value="">返修退换货</option>
                    <option value="">降价商品</option>
                    <option value="">我的京豆</option>
                    <option value="">我的白条</option>
                    <option value="">我的关注</option>
                    <option value="">我的问答</option>
                </select>
                <a href="#">|  &nbsp;京东会员 |</a>
                <select name="" id="">
                    <option value="">企业采购</option>
                    <option value="">企业购</option>
                    <option value="">工业品</option>
                    <option value="">礼品卡</option>
                    <option value="" style="color: gray">商品场景馆</option>
                </select>
                <a href="#" id="service" onmouseover="show_loc('ser')" onmouseout="hide_loc('ser')">客户服务ˇˇ</a>
                <a href="#" id="web" onmouseover="show_loc('wb')" onmouseout="hide_loc('wb')">网站导航ˇˇ</a>
                <a href="#" id="ph_jd" onmouseover="show_loc('phjd')" onmouseout="hide_loc('phjd')">手机京东</a>
            </div>
        </div>      
        <div class="body_top">
            <div id="location" class="location" onmousemove="show_loc('loc')" onmouseout="hide_loc('loc')">
                <table >
                    <tr>
                        <td><a href="#">北京</a></td>
                        <td><a href="#">上海</a></td>
                        <td><a href="#">天津</a></td>
                        <td><a href="#">重庆</a></td>
                        <td><a href="#">河北</a></td>
                    </tr>
                    <tr>
                        <td><a href="#">山西</a></td>
                        <td><a href="#">河南</a></td>
                        <td><a href="#">辽宁</a></td>
                        <td><a href="#">吉林</a></td>
                        <td><a href="#">黑龙江</a></td>
                    </tr>
                    <tr>
                        <td><a href="#">浙江</a></td>
                        <td><a href="#">江苏</a></td>
                        <td><a href="#">山东</a></td>
                        <td><a href="#">安徽</a></td>
                        <td><a href="#">内蒙古</a></td>
                    </tr>
                    <tr>
                        <td><a href="#">福建</a></td>
                        <td><a href="#">湖北</a></td>
                        <td><a href="#">湖南</a></td>
                        <td><a href="#">广东</a></td>
                        <td><a href="#">广西</a></td>
                    </tr>
                    <tr>
                        <td><a href="#">江西</a></td>
                        <td><a href="#">四川</a></td>
                        <td><a href="#">海南</a></td>
                        <td><a href="#">贵州</a></td>
                        <td><a href="#">云南</a></td>
                    </tr>
                    <tr>
                        <td><a href="#">西藏</a></td>
                        <td><a href="#">甘肃</a></td>
                        <td><a href="#">陕西</a></td>
                        <td><a href="#">青海</a></td>
                        <td><a href="#">宁夏</a></td>
                    </tr>
                    <tr>
                        <td><a href="#">新疆</a></td>
                        <td><a href="#">港澳</a></td>
                        <td><a href="#">台湾</a></td>
                        <td><a href="#">海外</a></td>
                        <td><a href="#">钓鱼岛</a></td>
                    </tr>
                </table>
                <br>
                <a href="#">地区专项版本</a>
                <br><br>
                <a href="#">中国港澳</a>
                <br>
                <table>
                    <tr>
                        <td><a href="#">Available Sites</a></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><a href="#">Global Site</a></td>
                        <td><a href="#">Сайт России</a></td>
                    </tr>
                    <tr>
                        <td><a href="#">Situs Indonesia</a></td>
                        <td><a href="#">Sitio de España</a></td>
                    </tr>
                    <tr>
                        <td><a href="#">เว็บไซต์ประเทศไทย</a></td>
                        <td></td>
                    </tr>
                </table>
            </div>
            <table id="website" onmousemove="show_loc('wb')" onmouseout="hide_loc('wb')">
                <tr>
                    <td>
                        <div class="location1">
                            <p>特色主题</p>
                            <table>
                                <tr>
                                    <td><a href="#">京东试用</a></td>
                                    <td><a href="#">京东主题</a></td>
                                    <td><a href="#">全球售</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">国际站</a></td>
                                    <td><a href="#">京东会员</a></td>
                                    <td><a href="#">京东预售</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">0元评测</a></td>
                                    <td><a href="#">港澳售</a></td>
                                    <td><a href="#">优惠券</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">秒杀</a></td>
                                    <td><a href="#">闪购</a></td>
                                    <td><a href="#">印尼站</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">京东金融</a></td>
                                    <td><a href="#">陪伴计划</a></td>
                                    <td><a href="#">出海招商</a></td>
                                </tr>
                            </table>
                        </div>
                    </td>
                    <td>
                        <div class="location2">
                            <p>行业频道</p>
                            <table>
                                <tr>
                                    <td><a href="#">手机</a></td>
                                    <td><a href="#">智能数码</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">家用电器</a></td>
                                    <td><a href="#">鲸鱼座智能</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">服装城</a></td>
                                    <td><a href="#">京东生鲜</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">家装城</a></td>
                                    <td><a href="#">母婴</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">食品</a></td>
                                    <td><a href="#">图书</a></td>
                                </tr>
                            </table>
                        </div>
                    </td>
                    <td>
                        <div class="location3">
                            <p>生活服务</p>
                            <table>
                                <tr>
                                    <td><a href="#">京东众筹</a></td>
                                    <td><a href="#">白条</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">京东到家</a></td>
                                    <td><a href="#">京东小金库</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">理财</a></td>
                                    <td><a href="#">话费</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">旅行</a></td>
                                    <td><a href="#">机票酒店</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">电影票</a></td>
                                    <td><a href="#">拍拍回收</a></td>
                                </tr>
                            </table>
                        </div>
                    </td>
                    <td>
                        <div class="location4">
                            <p>更多精选</p>
                            <table>
                                <tr>
                                    <td><a href="#">合作招商</a></td>
                                    <td><a href="#">京东通讯</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">京东E卡</a></td>
                                    <td><a href="#">企业采购</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">服务市场</a></td>
                                    <td><a href="#">办公生活馆</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">乡村招募</a></td>
                                    <td><a href="#">校园加盟</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">京东社区</a></td>
                                    <td><a href="#">游戏社区</a></td>
                                </tr>
                            </table>
                        </div>
                    </td>
                </tr> 
            </table>
            <table id="kefu" onmousemove="show_loc('ser')" onmouseout="hide_loc('ser')">
                <tr>
                    <td>
                        <table class="location5">
                            <tr>
                                <td>客户</td>
                            </tr>
                            <tr>
                                <td><a href="#">帮助中心</a></td>
                                <td><a href="#">售后服务</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">在线客服</a></td>
                                <td><a href="#">意见建议</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">电话客服</a></td>
                                <td><a href="#">客服邮箱</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">经融咨询</a></td>
                                <td><a href="#">全球售客服</a></td>
                            </tr>
                            <tr>
                                <td>商户</td>
                            </tr>
                            <tr>
                                <td><a href="#">合作招商</a></td>
                                <td><a href="#">成长中心</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">上架后台</a></td>
                                <td><a href="#">京麦工作台</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">商家帮助</a></td>
                                <td><a href="#">规则平台</a></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr><td> </td></tr>
            </table>
            <table class="location6" id="phjd" onmousemove="show_loc('phjd')" onmouseout="hide_loc('phjd')">
                <tr>
                    <td>
                        <img src="../picture/celephone_jd.png" alt="手机京东" title="手机京东">
                    </td>
                    <td class="phoneJD">
                        <p>手机京东</p>      
                        <p class="p1">新人专享大礼包</p>
                        <img src="../picture/apple.jpg" alt="apple" title="apple">
                        <img src="../picture/android.jpg" alt="android" title="android">
                        <img src="../picture/ipad.jpg" alt="ipad" title="ipad">
                        <p class="p2">iPhone android ipad</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <img src="../picture/wechat_jd.jpg" alt="京东微信" title="京东微信">
                    </td>
                    <td>
                        <p>关注京东微信</p>
                        <p class="p1">微信扫一扫，关注<br>京东服务号订阅更<br>多促销优惠福利</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <img src="../picture/money_jd.jpg" alt="京东金融客户端" title="京东金融客户端">
                    </td>
                    <td class="newpeople">
                        <p>京东金融客户端</p>
                        <p class="p1">新人专享大礼包</p>
                        <img src="../picture/apple.jpg" alt="apple" title="apple">
                        <img src="../picture/android.jpg" alt="android" title="android">
                        <p class="p2">iPhone android</p>
                    </td>
                </tr>
            </table>
            <img id = "jd_logo" src="../picture/jd_logo.png" alt="">
            <div id="search">
                <form action="../login.do?method=showCar" method="post">
                    <input type="text" value="请输入关键字"
                    onfocus="if(this.value == '请输入关键字'){this.value = '';this.style.color = 'black'}" onblur="if(this.value == ''){this.value = '请输入关键字';this.style.color = 'gray'}" >
                    <input type="button" value="查找">
                    <input type="submit" value="我的购物车">
                </form>
                <ul class="ul1">
                    <li>
                        <a style="color: #f40" href="#">周五鲜放假</a>
                    </li>
                    <li>
                        <a href="#">不分类纸</a>
                    </li>
                    <li>
                        <a href="#">耳机</a>
                    </li>
                    <li>
                        <a href="#">清凉空调</a>
                    </li>
                    <li>
                        <a href="#">清凉家具</a>
                    </li>
                    <li>
                        <a href="#">爱车服务</a>
                    </li>
                    <li>
                        <a href="#">清凉节</a>
                    </li>
                    <li>
                        <a href="#">全城热练</a>
                    </li>
                </ul>
                <br>
                <ul class="ul2">
                    <li>
                        <a href="#">秒杀</a>
                    </li>
                    <li>
                        <a href="#">优惠券</a>
                    </li>
                    <li>
                        <a href="#">PLUS会员</a>
                    </li>
                    <li>
                        <a href="#">品牌闪购</a>
                    </li>
                    <li>
                        <a href="#">拍卖</a>
                    </li>
                    <li>
                        <a href="#">京东时尚</a>
                    </li>
                    <li>
                        <a href="#">京东超市</a>
                    </li>
                    <li>
                        <a href="#">京东生鲜</a>
                    </li>
                </ul>
            </div>
            <img id="img" src="../picture/celephone_jd.png" alt="手机京东" title="手机京东">
        </div>
        <div class="body_middle">
            <div>
                <div class="quick_found">
                    <p>家用电器</p>
                    <ul>
                        <li>手机/</li>
                        <li>运营商/</li>
                        <li>数码</li>
                    </ul>
                    <br>
                    <ul>
                        <li>电脑/</li>
                        <li>办公</li>
                    </ul>
                    <br>
                    <ul>
                        <li>家居/</li>
                        <li>家具/</li>
                        <li>家装/</li>
                        <li>厨具</li>
                    </ul>
                    <br>
                    <ul>
                        <li>男装/</li>
                        <li>女装/</li>
                        <li>童装/</li>
                        <li>内衣</li>
                    </ul>
                    <br>
                    <ul>
                        <li>美妆/</li>
                        <li>个护清洁/</li>
                        <li>宠物</li>
                    </ul>
                    <br>
                    <ul>
                        <li>女鞋/</li>
                        <li>箱包/</li>
                        <li>钟表/</li>
                        <li>珠宝</li>
                    </ul>
                    <br>
                    <ul>
                        <li>男鞋/</li>
                        <li>运动/</li>
                        <li>户外</li>
                    </ul>
                    <br>
                    <ul>
                        <li>房产/</li>
                        <li>汽车/</li>
                        <li>汽车用品</li>
                    </ul>
                    <br>
                    <ul>
                        <li>母婴/</li>
                        <li>玩具/</li>
                        <li>乐器</li>
                    </ul>
                    <br>
                    <ul>
                        <li>美食/</li>
                        <li>酒类/</li>
                        <li>生鲜/</li>
                        <li>特产</li>
                    </ul>
                    <br>
                    <ul>
                        <li>艺术/</li>
                        <li>礼品/</li>
                        <li>鲜花/</li>
                        <li>农资绿植</li>
                    </ul>
                    <br>
                    <ul>
                        <li>医药保健/</li>
                        <li>计生情趣</li>
                    </ul>
                    <br>
                    <ul>
                        <li>图书/</li>
                        <li>文娱/</li>
                        <li>电子书</li>
                    </ul>
                    <br>
                    <ul>
                        <li>机票/</li>
                        <li>酒店/</li>
                        <li>旅游/</li>
                        <li>生活</li>
                    </ul>
                    <br>
                    <ul>
                        <li>理财/</li>
                        <li>众筹/</li>
                        <li>白条/</li>
                        <li>保险</li>
                    </ul>
                    <br>
                    <ul>
                        <li>安装/</li>
                        <li>维修/</li>
                        <li>清洗/</li>
                        <li>二手</li>
                    </ul>
                    <br>
                    <ul>
                        <li>工业品</li>
                    </ul>
                </div>
                <div id="banner">
                    <div class="pic">
                        <a href="#">
                            <img id="picture1" src="../picture/picture1.jpg" alt="">
                        </a>
                        <a href="#">
                            <img id="picture2" src="../picture/picture2.jpg" alt="">
                        </a>
                        <a href="#">
                            <img id="picture3" src="../picture/picture3.jpg" alt="">
                        </a>
                        <a href="#">
                            <img id="picture4" src="../picture/picture4.jpg" alt="">
                        </a>
                        <a href="#">
                            <img id="picture5" src="../picture/picture5.jpg" alt="">
                        </a>
                        <a href="#">
                            <img id="picture6" src="../picture/picture6.jpg" alt="">
                        </a>
                        <a href="#">
                            <img id="picture7" src="../picture/picture7.jpg" alt="">
                        </a>
                        <a href="#">
                            <img id="picture8" src="../picture/picture8.jpg" alt="">
                        </a>
                    </div>
                    <div class="btn">
                        <ul>
                            <li id="li1">1</li>
                            <li id="li2">2</li>
                            <li id="li3">3</li>
                            <li id="li4">4</li>
                            <li id="li5">5</li>
                            <li id="li6">6</li>
                            <li id="li7">7</li>
                            <li id="li8">8</li>
                        </ul>
                    </div>
                </div>
                <div class="br">
                    <table>
                        <tr>
                            <td>
                                <img src="../picture/br_1.png" alt="">
                            </td>
                            <td>
                                Hi~欢迎您！<br>
                                <a href="#" title="当前在线用户"><%=session.getAttribute("user").toString()%></a>
                            </td>
                        </tr>
                        <tr class="tr1">
                            <td>
                                <a class="a1" href="#">新人福利</a>
                            </td>
                            <td>
                                <a class="a2" href="#">PLUS会员</a>
                            </td>
                        </tr>
                    </table>
                    <div class="div1"></div>
                    <br>
                    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;京东快报</span>
                    <a href="#" class="more">更多>>></a><br>
                    <div class="div1_b">
                        <a class="div1_a" href="#">&nbsp;&nbsp;热门&nbsp;&nbsp;</a>
                        <a href="#">&nbsp;&nbsp;首批鸿蒙系统测试用...</a>
                    </div>
                    <div class="div1_b">
                        <a class="div1_a" href="#">&nbsp;&nbsp;HOT&nbsp;&nbsp;</a>
                        <a href="#">&nbsp;&nbsp;iPhone XR2提前曝...</a><br>
                    </div>
                    <div class="div1_b">
                        <a class="div1_a" href="#">&nbsp;&nbsp;最新&nbsp;&nbsp;</a>
                        <a href="#">&nbsp;&nbsp;性能远超晓龙855！...</a><br>
                    </div>
                    <div class="div1_b">
                        <a class="div1_a" href="#">&nbsp;&nbsp;推荐&nbsp;&nbsp;</a>
                        <a href="#">&nbsp;&nbsp;小米诚意之作：晓龙...</a><br>
                    </div>
                    <div class="div1"></div>
                    <table class="table1">
                        <tr>
                            <td>
                                <img src="../picture/br_2.png" alt="">
                                <p>话费</p>
                            </td>
                            <td>
                                <img src="../picture/br_4.png" alt="">
                                <p>机票</p>
                            </td>
                            <td>
                                <img src="../picture/br_6.png" alt="">
                                <p>酒店</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="../picture/br_8.png" alt="">
                                <p>游戏</p>
                            </td>
                            <td>
                                <img src="../picture/br_10.png" alt="">
                                <p>加油卡</p>
                            </td>
                            <td>
                                <img src="../picture/br_12.png" alt="">
                                <p>火车票</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="../picture/br_14.png" alt="">
                                <p>众筹</p>
                            </td>
                            <td>
                                <img src="../picture/br_16.png" alt="">
                                <p>理财</p>
                            </td>
                            <td>
                                <img src="../picture/br_18.png" alt="">
                                <p>白条</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="../picture/br_20.png" alt="">
                                <p>电影票</p>
                            </td>
                            <td>
                                <img src="../picture/br_22.png" alt="">
                                <p>企业购</p>
                            </td>
                            <td>
                                <img src="../picture/br_24.png" alt="">
                                <p>礼品卡</p>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="bm">
                    <div class="bm_miaosha">
                        <div class="div_miaosha">
                            <h2>京东秒杀</h2><br><br><br><br>
                            <a class="ms" id="time">22:00</a>
                            <a >点场 倒计时</a>
                            <div>
                                <input id="hou" type="text"> :
                                <input id="min" type="text"> :
                                <input id="sec" type="text"> 
                            </div>
                        </div>
                        <div>
                            <br>
                            <a href="pro_phone.jsp"><img src="../picture/m_HUWEI.jpg" alt=""></a>
                            <br>
                            <a href="pro_phone.jsp">华为(HUAWEI)荣耀8X...</a>
                            <div>
                                <div class="price">￥1539.00</div>
                                <p>￥1999.00</p>
                            </div>
                        </div>
                        <div>
                            <br>
                            <a href="pro_bag.jsp"><img src="../picture/m_montblanc.png" alt=""></a>
                            <br>
                            <a href="pro_bag.jsp">万宝龙MONTBLANC大班...</a>
                            <div>
                                <div class="price">￥5650.00</div>
                                <p>￥5999.00</p>
                            </div>
                        </div>
                        <div>
                            <br>
                            <a href="pro_philips.jsp"><img src="../picture/m_phli.jpg" alt=""></a>
                            <br>
                            <a href="pro_philips.jsp">飞利浦(PHILIPS)破壁料...</a>
                            <div>
                                <div class="price">￥1104.15</div>
                                <p>￥1999.00</p>
                            </div>
                        </div>
                        <div>
                            <br>
                            <a href="pro_package.jsp"><img src="../picture/m_hanke.jpg" alt=""></a>
                            <br>
                            <a href="pro_package.jsp">汉克(HANKE)拉杆箱静...</a>
                            <div>
                                <div class="price">￥199.00</div>
                                <p>￥528.00</p>
                            </div>
                        </div>
                        <marquee scrollamount="5" behavior="alternate" onmouseover="stop()" onmouseout="start()">
                        	<h2>限时特惠 限时特惠 限时特惠 </h2>
                            <img src="../picture/m_zhu.jpg" alt="ZSK专场，低至5折" title="ZSK专场，低至5折">
                            <img src="../picture/m_chu.jpg" alt="厨卫电器清凉狂欢" title="厨卫电器清凉狂欢">
                 			<p>品牌秒杀，全场最低价，仅限今天</p>
                        </marquee>
                    </div>
            
                    <div class="bm_paihang">
                        <a class="a1" href="#">排行榜</a>
                        <a class="a2" href="#">健身训练</a>
                        <a href="#">户外装备</a>
                        <a href="#">流行男鞋</a>
                        <a href="#">面部护肤</a>
                        <div>
                            <img src="../picture/top1.png" alt="">
                            <a href="#">
                                <img src="../picture/d_yaling .png" alt="">
                                <br><br>
                                <span>美国斯诺德健腹轮 自动回弹静音巨轮 收腹滚轮腹肌轮健</span>
                                <br><br>
                            </a>
                            <br>
                            <a class="a3" href="#">好物榜></a>
                            <a class="a3" href="#">折扣榜></a><br>
                            <a class="a3" href="#">店铺榜></a>
                            <a class="a3" href="#">热搜榜></a>
                        </div>
                        <div class="div2">
                            <img src="../picture/top2.png" alt="">
                            <a href="#">
                                <img src="../picture/top2_1.png" alt="">
                            </a>
                            <a href="#">杜威克 毽子大号</a>
                            <br>
                            <img src="../picture/top3.png" alt="">
                            <a href="#">
                                <img src="../picture/top3_1.png" alt="">
                            </a>
                            <a href="#">弹力带拉力绳弹力</a>
                            <br>
                            <img src="../picture/top4.png" alt="">
                            <a href="#">
                                <img src="../picture/top4_1.png" alt="">
                            </a>
                            <a href="#">SALUKO专业跳绳</a>
                        </div>
                    </div>
                    <div class="shangou">
                        <div class="div3">
                            <h1> &nbsp;&nbsp;品牌闪购</h1>
                            &nbsp;&nbsp;<img src="../picture/pinpai.png" alt="">
                        </div>
                        <table>
                            <tr>
                                <td>
                                    <a href="#"><img src="../picture/to7.png" alt=""></a><br>
                                    <a href="#">悍马军刀大牌专场</a>
                                </td>
                                <td>
                                    <a href="#"><img src="../picture/to8.png" alt=""></a><br>
                                    <a href="#">耐克运动专场</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="#"><img src="../picture/to9.png" alt=""></a><br>
                                    <a href="#">威猛先生清洁专场</a>
                                </td>
                                <td>
                                    <a href="#"><img src="../picture/to10.png" alt=""></a><br>
                                    <a href="#">金龙鱼粮油专场</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="#"><img src="../picture/to11.png" alt=""></a><br>
                                    <a href="#">迪莎衣品女装专场</a>
                                </td>
                                <td>
                                    <a href="#"><img src="../picture/to12.png" alt=""></a><br>
                                    <a href="#">宏达手机配件专场</a>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="last">
                        <a href="#">
                            <img style="padding: 5px;height:200px" src="../picture/last1.png" alt="">
                        </a>
                        <marquee scrollamount="5" behavior="alternate" onmouseover="stop()" onmouseout="start()" >
                            <a href="#">
                                <img src="../picture/last2.png" alt="" title="casio太阳能手表">
                            </a>
                            <a href="#">
                                <img src="../picture/last3.png" alt="" title="外星人吃鸡键盘">
                            </a>
                            <a href="#">
                                <img src="../picture/last4.png" alt="" title="罗技全尺寸无线鼠键">
                            </a>
                            <a href="#">  
                                <img src="../picture/last5.png" alt="" title="万向轮 密码锁 拉杆箱">
                            </a>
                            <a href="#">
                                <img src="../picture/last6.png" alt="" title="体恒建 硒麦芽 养肝片">
                            </a>
                            <a href="#">
                                <img src="../picture/last7.png" alt="" title="Apple H1">
                            </a>
                        </marquee>
                    </div>
                </div>
            </div>
        </div>
        <div class="jd_ed">
            <div class="end">
                <table>
                    <tr>
                        <td>
                            <h4>购物指南</h4>
                            <a href="#">购物流程</a><br>
                            <a href="#">会员介绍</a><br>
                            <a href="#">生活旅行</a><br>
                            <a href="#">常见问题</a><br>
                            <a href="#">大家电</a><br>
                            <a href="#">联系客服</a><br>
                        </td>
                        <td>
                            <h4>配送方法</h4>
                            <a href="#">上门自提</a><br>
                            <a href="#">211限时达</a><br>
                            <a href="#">配送服务查询</a><br>
                            <a href="#">配送费收取标准</a><br>
                            <a href="#">海外配送</a><br><br>
                        </td>
                        <td>
                            <h4>支付方法</h4>
                            <a href="#">货到付款</a><br>
                            <a href="#">在线支付</a><br>
                            <a href="#">分期付款</a><br>
                            <a href="#">邮局汇款</a><br>
                            <a href="#">公司转账</a><br><br>
                        </td>
                        <td>
                            <h4>售后服务</h4>
                            <a href="#">售后政策</a><br>
                            <a href="#">价格保护</a><br>
                            <a href="#">退款说明</a><br>
                            <a href="#">返修/退换货</a><br>
                            <a href="#">取消订单</a><br><br>
                        </td>
                        <td>
                            <h4>特色服务</h4>
                            <a href="#">夺宝岛</a><br>
                            <a href="#">DIY装机</a><br>
                            <a href="#">延保服务</a><br>
                            <a href="#">京东IE卡</a><br>
                            <a href="#">京东通讯</a><br>
                            <a href="#">鲸鱼座智能</a><br>
                        </td>
                        <td>
                            <h4>京东自营覆盖区县</h4>
                            <a>京东已向全国2661个区县提供自营配送服务，支持货到付款、POS机刷卡和售后上门服务。</a><br>
                            <a href="#">查看详情></a><br><br>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="mod_copyright_info">
                <p class="about">
                    <a href="#" target="_blank">关于我们</a><span>|</span>
                    <a href="#" target="_blank">联系我们</a><span>|</span>
                    <a href="#" target="_blank">联系客服</a><span>|</span>
                    <a href="#" target="_blank">合作招商</a><span>|</span>
                    <a href="#" target="_blank">商家帮助</a><span>|</span>
                    <a href="#" target="_blank">营销中心</a><span>|</span>
                    <a href="#" target="_blank">手机京东</a><span>|</span>
                    <a href="#" target="_blank">友情链接</a><span>|</span>
                    <a href="#" target="_blank">销售联盟</a><span>|</span>
                    <a href="#" target="_blank">京东社区</a><span>|</span>
                    <a href="#" target="_blank">风险监测</a><span>|</span>
                    <a href="#" target="_blank">隐私政策</a><span>|</span>
                    <a href="#" target="_blank">京东公益</a><span>|</span>
                    <a href="#" target="_blank">English Site</a><span>|</span>
                    <a href="#" target="_blank">Media &amp; IR</a>
                </p>
                <div>
                    <p>
                        <a href="#" target="_blank">京公网安备 11000002000088号</a><span>|</span>
                        <span>京ICP证070359号</span><span>|</span>
                        <a href="#" target="_blank">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a>
                        <span>|</span><span>新出发京零&amp;&nbsp;字第大120007号</span>
                    </p>
                    <p>
                        <span>互联网出版许可证编号新出网证(京)字150号</span><span>|</span>
                        <a href="#" target="_blank">出版物经营许可证</a><span>|</span>
                        <a href="#" target="_blank">网络文化经营许可证京网文[2014]2148-348号</a><span>|</span>
                        <span>违法和不良信息举报电话：4006561155</span>
                    </p>
                    <p>
                        <span>Copyright&nbsp;©&nbsp;2004&nbsp;-&nbsp;2019&nbsp;&nbsp;京东JD.com&nbsp;版权所有</span>
                        <span>|</span><span>消费者维权热线：4006067733</span>
                        <a href="#" target="_blank">经营证照</a><span>|</span>
                        <span>(京)网械平台备字(2018)第00003号</span><span>|</span>
                        <a href="#" target="_blank">营业执照</a>
                    </p>
                </div>
                <div>
                    <p>
                        <a href="#" target="_blank">Global Site</a><span>|</span>
                        <a href="#" target="_blank">Сайт России</a><span>|</span>
                        <a href="#" target="_blank">Situs Indonesia</a><span>|</span>
                        <a href="#" target="_blank">Sitio de España</a><span>|</span>
                        <a href="#" target="_blank"> เว็บไซต์ประเทศไทย </a>
                    </p>
                </div>
                <div>
                    <p>
                        <span>京东旗下网站：</span>
                        <a href="#" target="_blank">京东钱包</a><span>|</span>
                        <a href="#" target="_blank">京东云</a>
                    </p>
                </div>
                <p>
                    <a href="#" target="_blank">可信网站信用评估</a>
                    <a href="#" target="_blank">网络警察提醒你</a>
                    <a href="#" target="_blank">诚信网站</a>
                    <a href="#" target="_blank">中国互联网举报中心</a>
                    <a href="#" target="_blank">网络举报APP下载</a>
                </p>
            </div>
        </div>
        <a class="goto_top" href="#head">回到顶部</a>
    </body>
</html>