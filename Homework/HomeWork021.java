public class HomeWork021 {
    public static void main(String[] args) {
        String content = "hsp34@qq.com";
        String regstr = "[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+";
        if (content.matches(regstr)){
            System.out.println("匹配成功");
        }else {
            System.out.println("匹配失败");
        }
    }
}
