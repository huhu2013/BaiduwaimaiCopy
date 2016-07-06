package com.jikexueyuan.baiduwaimaicopy;


/**
 * 首页ListView列表项的数据，模拟网络加载效果
 */
public class HomeItemData {
    //数据项的个数
    public static int listNum = 6;
    //最左边的图片资源
    public static int[] leftResResource = new int[]{R.drawable.icon_shopone,
            R.drawable.icon_shoptwo,
            R.drawable.icon_shopthree,
            R.drawable.icon_shopone,
            R.drawable.icon_shoptwo,
            R.drawable.icon_shopthree};
    //店铺名称资源
    public static String[] textShopName = new String[]{"重庆麻辣烫（上海华联店）",
            "一洋码头（上海华联店）",
            "乐兹鲜花（上海华联店）",
            "重庆麻辣烫（上海华联店）",
            "一洋码头（上海华联店）",
            "乐兹鲜花（上海华联店）"};
    //亮星、半星、暗星个数
    public static int[] brightStarNum = new int[]{5, 4, 3, 5, 4, 3};
    public static int[] selfStarNum = new int[]{0, 1, 1, 0, 1, 1};
    public static int[] dimStarNum = new int[]{0, 0, 1, 0, 0, 1};
    //销售数量
    public static String[] saleNum = new String[]{"566", "960", "1745", "566", "960", "1745"};
    //运送情况
    public static String[] startPrice = new String[]{"20", "15", "20", "20", "15", "20"};
    public static String[] transPortPrice = new String[]{"5", "5", "6", "5", "5", "6"};
    public static String[] transPortTime = new String[]{"35", "45", "45", "35", "45", "45"};
    //是否高亮显示减、券、免
    public static boolean[] isListJian = new boolean[]{true, true, false, true, true, false};
    public static boolean[] isListQuan = new boolean[]{true, false, true, true, false, true};
    public static boolean[] isListMian = new boolean[]{false, true, true, false, true, true};
    //运送的路程
    public static String[] distance = new String[]{"934m", "1.5km", "2.34km", "934m", "1.5km", "2.34km"};

}
