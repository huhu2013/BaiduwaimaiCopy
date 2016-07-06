package com.jikexueyuan.baiduwaimaicopy;


/**
 * 我的页ListView列表项的数据，模拟网络加载效果
 */
public class MineItemData {
    //数据项的个数
    public static int length = 13;
    //不需要显示的数据项个数
    public static int tagLength = 4;
    //不需要显示的数据项索引
    public static int[] tagIndex = new int[]{3, 7, 10, 12};
    //左图图标资源
    public static int[] imageLeftResource = new int[]{
            R.drawable.icon_mine_address, R.drawable.icon_mine_daijinquan, R.drawable.icon_mine_refund,
            R.drawable.icon_mine_message, R.drawable.icon_mine_soucang, R.drawable.icon_mine_pinglun,
            R.drawable.icon_mine_wallet, R.drawable.icon_mine_nuomi,
            R.drawable.icon_mine_problem};
    //中间文本资源
    public static String[] text = new String[]{"我的送餐地址", "我的代金券", "我的退款",
            "我的消息", "我的收藏", "我的评论",
            "百度钱包", "百度糯米",
            "常见问题"};
    //右图图标资源
    public static int imageRightResource = R.drawable.icon_mine_right;
}
